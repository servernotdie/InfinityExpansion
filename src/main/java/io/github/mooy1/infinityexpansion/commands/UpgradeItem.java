package io.github.mooy1.infinityexpansion.commands;

import java.util.List;
import java.util.UUID;

import javax.annotation.Nonnull;

import io.github.mooy1.infinitylib.common.PersistentType;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import io.github.mooy1.infinityexpansion.InfinityExpansion;
import io.github.mooy1.infinityexpansion.items.storage.StorageUnit;
import io.github.mooy1.infinitylib.commands.SubCommand;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;

import net.guizhanss.guizhanlib.common.Cooldown;

import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public final class UpgradeItem extends SubCommand {

    private final Cooldown<UUID> cooldown = new Cooldown<>();

    public UpgradeItem() {
        super("upgradeitem", "Nâng cấp vật phẩm trên tay", false);
    }

    @Override
    protected void execute(@Nonnull CommandSender commandSender, @Nonnull String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage(ChatColor.RED + "Chỉ người chơi mới có thể thực thi lệnh này!");
            return;
        }

        Player p = (Player) commandSender;

        // Giới hạn tần suất sử dụng
        if (!cooldown.check(p.getUniqueId())) {
            p.sendMessage(ChatColor.RED + "Lệnh được sử dụng quá thường xuyên, vui lòng thử lại sau!");
            return;
        }
        cooldown.set(p.getUniqueId(), 5000);

        ItemStack item = p.getInventory().getItemInMainHand();

        if (item.getType() == Material.AIR) {
            p.sendMessage(ChatColor.RED + "Bạn phải cầm một vật phẩm trên tay!");
            return;
        }

        // Kiểm tra vật phẩm InfinityExpansion
        SlimefunItem sfItem = SlimefunItem.getByItem(item);
        if (sfItem == null || !(sfItem.getAddon() instanceof InfinityExpansion)) {
            p.sendMessage(ChatColor.RED + "Vật phẩm trên tay bạn không phải của InfinityExpansion!");
            return;
        }

        if (sfItem instanceof StorageUnit) {
            upgradeItem(p, item, sfItem);

            ItemMeta meta = item.getItemMeta();
            PersistentDataContainer pdc = meta.getPersistentDataContainer();
            int amount = pdc.getOrDefault(StorageUnit.AMOUNT_KEY(), PersistentDataType.INTEGER, 0);
            if (amount > 0) {
                ItemStack displayItem = pdc.get(StorageUnit.ITEM_KEY(), PersistentType.ITEM_STACK_OLD);
                SlimefunItem displaySfItem = SlimefunItem.getByItem(displayItem);
                if (displaySfItem == null || !(sfItem.getAddon() instanceof InfinityExpansion)) {
                    p.sendMessage(ChatColor.RED + "Vật phẩm trong storage unit không phải của InfinityExpansion, không cần cập nhật!");
                    return;
                }
                p.sendMessage(ChatColor.YELLOW + "Đang kiểm tra vật phẩm trong storage unit...");
                upgradeItem(p, displayItem, displaySfItem);

                ItemMeta newMeta = sfItem.getItem().getItemMeta();
                // Cập nhật storage unit
                StorageUnit.saveToStack(newMeta, displayItem, displaySfItem.getItemName(), amount);
                item.setItemMeta(newMeta);
                p.sendMessage(ChatColor.GREEN + "Đã cập nhật vật phẩm trong storage unit");
            }
        } else {
            upgradeItem(p, item, sfItem);
        }
    }

    @Override
    protected void complete(@Nonnull CommandSender commandSender, @Nonnull String[] strings, @Nonnull List<String> list) {

    }

    public static void upgradeItem(Player p, ItemStack item, SlimefunItem sfItem) {
        ItemMeta meta = item.getItemMeta();
        ItemMeta newMeta = sfItem.getItem().getItemMeta();

        if (meta.getDisplayName().equals(sfItem.getItemName())) {
            if (newMeta.hasLore()) {
                if (meta.getLore().equals(newMeta.getLore())) {
                    p.sendMessage(ChatColor.RED + "Tên và mô tả vật phẩm không cần cập nhật!");
                    return;
                }
            } else {
                p.sendMessage(ChatColor.RED + "Tên và mô tả vật phẩm không cần cập nhật!");
                return;
            }
        }

        meta.setDisplayName(newMeta.getDisplayName());
        if (newMeta.hasLore()) {
            meta.setLore(newMeta.getLore());
        }

        item.setItemMeta(meta);
        p.sendMessage(ChatColor.GREEN + "Đã cập nhật tên và mô tả vật phẩm!");
    }
}
