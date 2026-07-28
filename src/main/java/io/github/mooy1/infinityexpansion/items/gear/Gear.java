package io.github.mooy1.infinityexpansion.items.gear;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;

import lombok.experimental.UtilityClass;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import io.github.mooy1.infinityexpansion.InfinityExpansion;
import io.github.mooy1.infinityexpansion.categories.Groups;
import io.github.mooy1.infinityexpansion.items.blocks.InfinityWorkbench;
import io.github.mooy1.infinityexpansion.items.materials.Materials;
import io.github.mooy1.infinityexpansion.utils.Util;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;

@UtilityClass
public final class Gear {

    public static final SlimefunItemStack ENDER_FLAME = new SlimefunItemStack(
            "ENDER_FLAME",
            Material.ENCHANTED_BOOK,
            "&cNgọn lửa Ender"
    );
    public static final SlimefunItemStack CROWN = new SlimefunItemStack(
            "INFINITY_CROWN",
            Material.NETHERITE_HELMET,
            "&bMũ vô tận",
            "&7Nhìn đêm I",
            "&7Sức mạnh thủy triều I",
            "&7Miễn nhiễm động năng khiên cánh"
    );
    public static final SlimefunItemStack CHESTPLATE = new SlimefunItemStack(
            "INFINITY_CHESTPLATE",
            Material.NETHERITE_CHESTPLATE,
            "&bGiáp ngực vô tận",
            "&7Sức mạnh II",
            "&7Tăng sinh lực I",
            "&7Kháng lửa I",
            "&7Bảo vệ khỏi nọc ong"
    );
    public static final SlimefunItemStack LEGGINGS = new SlimefunItemStack(
            "INFINITY_LEGGINGS",
            Material.NETHERITE_LEGGINGS,
            "&bQuần vô tận",
            "&7Hối hả III",
            "&7Hồi phục I",
            "&7No bụng I",
            "&7Kháng phóng xạ"
    );
    public static final SlimefunItemStack BOOTS = new SlimefunItemStack(
            "INFINITY_BOOTS",
            Material.NETHERITE_BOOTS,
            "&bỦng vô tận",
            "&7Tốc độ III",
            "&7Ân huệ của cá heo I"
    );
    public static final SlimefunItemStack INFINITY_MATRIX = new SlimefunItemStack(
            "INFINITY_MATRIX",
            Material.NETHER_STAR,
            "&fCánh bay vô tận",
            "&6Cho bạn khả năng bay như chế độ sáng tạo",
            "&7Nhấp chuột phải để bật/tắt bay và tự ràng buộc",
            "&7Nhấp chuột phải khi ngồi để gỡ ràng buộc",
            "&bRàng buộc linh hồn"
    );
    public static final SlimefunItemStack SHIELD = new SlimefunItemStack(
            "INFINITY_SHIELD",
            Material.SHIELD,
            "&bKhiên vũ trụ"
    );
    public static final SlimefunItemStack BLADE = new SlimefunItemStack(
            "INFINITY_BLADE",
            Material.NETHERITE_SWORD,
            "&bKiếm thống trị hoàn vũ"
    );
    public static final SlimefunItemStack PICKAXE = new SlimefunItemStack(
            "INFINITY_PICKAXE",
            Material.NETHERITE_PICKAXE,
            "&9Cúp phá hủy thế giới"
    );
    public static final SlimefunItemStack AXE = new SlimefunItemStack(
            "INFINITY_AXE",
            Material.NETHERITE_AXE,
            "&4Rìu hoang phế tự nhiên"
    );
    public static final SlimefunItemStack SHOVEL = new SlimefunItemStack(
            "INFINITY_SHOVEL",
            Material.NETHERITE_SHOVEL,
            "&aXẻng nuốt chửng hành tinh"
    );
    public static final SlimefunItemStack BOW = new SlimefunItemStack(
            "INFINITY_BOW",
            Material.BOW,
            "&6Cung sa ngã thiên đường"
    );
    public static final SlimefunItemStack VEIN_MINER_RUNE = new SlimefunItemStack(
            "VEIN_MINER_RUNE",
            Material.DIAMOND,
            "&bBùa mạch quặng",
            "&7Nâng cấp công cụ để khai thác một số vật liệu",
            "&7Kết hợp bùa này với công cụ"
    );

    public static void setup(InfinityExpansion plugin) {
        addInfinityEnchants(plugin,
                CROWN, CHESTPLATE, LEGGINGS, BOOTS,
                AXE, BLADE, PICKAXE,
                SHIELD, SHOVEL, BOW
        );
        EnchantmentStorageMeta storageMeta = (EnchantmentStorageMeta) ENDER_FLAME.getItemMeta();
        Objects.requireNonNull(storageMeta).addStoredEnchant(Enchantment.FIRE_ASPECT, 10, true);
        ENDER_FLAME.setItemMeta(storageMeta);
        new SlimefunItem(Groups.MAIN_MATERIALS, ENDER_FLAME, RecipeType.MAGIC_WORKBENCH, new ItemStack[] {
                Materials.ENDER_ESSENCE, Materials.ENDER_ESSENCE, Materials.ENDER_ESSENCE,
                Materials.ENDER_ESSENCE, new ItemStack(Material.BOOK), Materials.ENDER_ESSENCE,
                Materials.ENDER_ESSENCE, Materials.ENDER_ESSENCE, Materials.ENDER_ESSENCE
        }).register(plugin);
        new InfinityArmor(CROWN, new PotionEffect[] {
                new PotionEffect(PotionEffectType.NIGHT_VISION, 600, 0, false, false, false),
                new PotionEffect(PotionEffectType.CONDUIT_POWER, 600, 0, false, false, false),
        }, new ItemStack[] {
                null, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, null,
                Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT,
                Materials.INFINITE_INGOT, Materials.VOID_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, Materials.VOID_INGOT, Materials.INFINITE_INGOT,
                null, Materials.INFINITE_INGOT, null, null, Materials.INFINITE_INGOT, null,
                null, null, null, null, null, null,
                null, null, null, null, null, null
        }).register(plugin);
        new InfinityArmor(CHESTPLATE, new PotionEffect[] {
                new PotionEffect(PotionEffectType.RESISTANCE, 600, 0, false, false, false),
                new PotionEffect(PotionEffectType.STRENGTH, 600, 1, false, false, false),
                new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 600, 0, false, false, false)
        }, new ItemStack[] {
                null, Materials.INFINITE_INGOT, null, null, Materials.INFINITE_INGOT, null,
                Materials.INFINITE_INGOT, Materials.VOID_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, Materials.VOID_INGOT, Materials.INFINITE_INGOT,
                Materials.VOID_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, Materials.VOID_INGOT,
                Materials.VOID_INGOT, Materials.INFINITE_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.INFINITE_INGOT, Materials.VOID_INGOT,
                null, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, null,
                null, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, null
        }).register(plugin);
        new InfinityArmor(LEGGINGS, new PotionEffect[] {
                new PotionEffect(PotionEffectType.HASTE, 600, 2, false, false, false),
                new PotionEffect(PotionEffectType.REGENERATION, 600, 0, false, false, false),
                new PotionEffect(PotionEffectType.SATURATION, 600, 0, false, false, false),
        }, new ItemStack[] {
                null, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, null,
                Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT,
                Materials.VOID_INGOT, Materials.INFINITE_INGOT, null, null, Materials.INFINITE_INGOT, Materials.VOID_INGOT,
                Materials.VOID_INGOT, Materials.INFINITE_INGOT, null, null, Materials.INFINITE_INGOT, Materials.VOID_INGOT,
                Materials.VOID_INGOT, Materials.INFINITE_INGOT, null, null, Materials.INFINITE_INGOT, Materials.VOID_INGOT,
                null, Materials.INFINITE_INGOT, null, null, Materials.INFINITE_INGOT, null
        }).register(plugin);
        new InfinityArmor(BOOTS, new PotionEffect[] {
                new PotionEffect(PotionEffectType.SPEED, 600, 2, false, false, false),
                new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 600, 0, false, false, false),
        }, new ItemStack[] {
                null, null, null, null, null, null,
                Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, null, null, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT,
                Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, null, null, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT,
                Materials.VOID_INGOT, Materials.VOID_INGOT, null, null, Materials.VOID_INGOT, Materials.VOID_INGOT,
                Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, null, null, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT,
                Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, null, null, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT
        }).register(plugin);
        new InfinityTool(SHIELD, new ItemStack[] {
                Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, null, null, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT,
                Materials.INFINITE_INGOT, Materials.VOID_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, Materials.VOID_INGOT, Materials.INFINITE_INGOT,
                Materials.INFINITE_INGOT, Materials.VOID_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, Materials.VOID_INGOT, Materials.INFINITE_INGOT,
                Materials.INFINITE_INGOT, Materials.VOID_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, Materials.VOID_INGOT, Materials.INFINITE_INGOT,
                null, Materials.INFINITE_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.INFINITE_INGOT, null,
                null, Materials.INFINITE_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.INFINITE_INGOT, null
        }).register(plugin);
        new InfinityBow(Groups.INFINITY_CHEAT, BOW, InfinityWorkbench.TYPE, new ItemStack[] {
                null, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, Materials.VOID_INGOT, null, null,
                Materials.INFINITE_INGOT, null, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, Materials.VOID_INGOT, null,
                Materials.VOID_INGOT, null, null, ENDER_FLAME, Materials.INFINITE_INGOT, Materials.VOID_INGOT,
                null, Materials.VOID_INGOT, null, null, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT,
                null, null, Materials.VOID_INGOT, null, null, Materials.INFINITE_INGOT,
                null, null, null, Materials.VOID_INGOT, Materials.INFINITE_INGOT, null
        }).register(plugin);
        new InfinityTool(AXE, new ItemStack[] {
                null, Materials.VOID_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, null, null,
                Materials.VOID_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, Materials.VOID_INGOT, null,
                null, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, Materials.VOID_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT,
                null, null, Materials.VOID_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT,
                null, Materials.VOID_INGOT, null, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, Materials.VOID_INGOT,
                Materials.VOID_INGOT, null, null, null, Materials.VOID_INGOT, null
        }).register(plugin);
        new InfinityTool(BLADE, new ItemStack[] {
                null, null, null, null, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT,
                null, null, null, Materials.INFINITE_INGOT, Materials.VOID_INGOT, Materials.INFINITE_INGOT,
                null, null, Materials.INFINITE_INGOT, Materials.VOID_INGOT, Materials.INFINITE_INGOT, null,
                Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, Materials.VOID_INGOT, Materials.INFINITE_INGOT, null, null,
                null, Materials.VOID_INGOT, Materials.INFINITE_INGOT, null, null, null,
                Materials.VOID_INGOT, null, Materials.INFINITE_INGOT, null, null, null
        }).register(plugin);
        new InfinityTool(SHOVEL, new ItemStack[] {
                null, null, null, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT,
                null, null, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT,
                null, null, Materials.INFINITE_INGOT, Materials.VOID_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT,
                null, null, Materials.VOID_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, null,
                null, Materials.VOID_INGOT, null, null, null, null,
                Materials.VOID_INGOT, null, null, null, null, null
        }).register(plugin);
        new InfinityTool(PICKAXE, new ItemStack[] {
                null, Materials.VOID_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, null,
                null, null, null, Materials.INFINITE_INGOT, Materials.VOID_INGOT, Materials.INFINITE_INGOT,
                null, null, null, Materials.VOID_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT,
                null, null, Materials.VOID_INGOT, null, null, Materials.INFINITE_INGOT,
                null, Materials.VOID_INGOT, null, null, null, Materials.VOID_INGOT,
                Materials.VOID_INGOT, null, null, null, null, null
        }).register(plugin);
        new InfinityMatrix(Groups.INFINITY_CHEAT, INFINITY_MATRIX, InfinityWorkbench.TYPE, new ItemStack[] {
                Materials.INFINITE_INGOT, null, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, null, Materials.INFINITE_INGOT,
                Materials.INFINITE_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.INFINITE_INGOT,
                Materials.VOID_INGOT, Materials.VOID_INGOT, new ItemStack(Material.ELYTRA), new ItemStack(Material.ELYTRA), Materials.VOID_INGOT, Materials.VOID_INGOT,
                Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT,
                Materials.INFINITE_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.VOID_INGOT, Materials.INFINITE_INGOT,
                Materials.INFINITE_INGOT, null, Materials.INFINITE_INGOT, Materials.INFINITE_INGOT, null, Materials.INFINITE_INGOT
        }).register(plugin);
        new VeinMinerRune(Groups.MAIN_MATERIALS, VEIN_MINER_RUNE, RecipeType.MAGIC_WORKBENCH, new ItemStack[] {
                Materials.MAGSTEEL_PLATE, SlimefunItems.PICKAXE_OF_VEIN_MINING, Materials.MAGSTEEL_PLATE,
                Materials.ENDER_ESSENCE, SlimefunItems.BLANK_RUNE, Materials.ENDER_ESSENCE,
                Materials.MAGSTEEL_PLATE, SlimefunItems.PICKAXE_OF_VEIN_MINING, Materials.MAGSTEEL_PLATE,
        }).register(plugin);
    }

    private static void addInfinityEnchants(InfinityExpansion plugin, SlimefunItemStack... items) {
        ConfigurationSection typeSection = plugin.getConfig().getConfigurationSection("infinity-enchant-levels");

        if (typeSection == null) {
            InfinityExpansion.log(Level.SEVERE, "Config section \"infinity-enchant-levels\" missing, Check your config and report this!");
            return;
        }

        for (SlimefunItemStack item : items) {
            ItemMeta meta = item.getItemMeta();

            // lore
            List<String> lore;
            if (meta.hasLore()) {
                lore = meta.getLore();
            }
            else {
                lore = new ArrayList<>();
            }
            lore.add(ChatColor.AQUA + "Ràng buộc linh hồn");
            meta.setLore(lore);

            // find path
            String itemPath = item.getItemId().replace("INFINITY_", "").toLowerCase();
            ConfigurationSection itemSection = typeSection.getConfigurationSection(itemPath);

            // unbreakable and enchants
            meta.setUnbreakable(Objects.requireNonNull(itemSection).getBoolean("unbreakable"));
            for (Map.Entry<Enchantment, Integer> entry : Util.getEnchants(itemSection).entrySet()) {
                meta.addEnchant(entry.getKey(), entry.getValue(), true);
            }

            item.setItemMeta(meta);
        }
    }

}
