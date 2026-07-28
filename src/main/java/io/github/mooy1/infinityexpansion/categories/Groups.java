package io.github.mooy1.infinityexpansion.categories;

import org.bukkit.Material;

import io.github.mooy1.infinityexpansion.InfinityExpansion;
import io.github.mooy1.infinitylib.groups.MultiGroup;
import io.github.mooy1.infinitylib.groups.SubGroup;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;

/**
 * Categories for this addon
 *
 * @author Mooy1
 */
public final class Groups {

    public static final ItemGroup INFINITY = new InfinityGroup(InfinityExpansion.createKey("infinity_recipes"),
            new CustomItemStack(Material.RESPAWN_ANCHOR, "&bVô Tận&7 vật phẩm"), 3);
    public static final ItemGroup MAIN_MATERIALS = new SubGroup("main_materials",
            new CustomItemStack(Material.NETHER_STAR, "&bVô Tận&7 vật liệu cơ bản"));
    public static final ItemGroup BASIC_MACHINES = new SubGroup("basic_machines",
            new CustomItemStack(Material.LOOM, "&9Vô Tận&7 máy móc cơ bản"));
    public static final ItemGroup ADVANCED_MACHINES = new SubGroup("advanced_machines",
            new CustomItemStack(Material.BLAST_FURNACE, "&cVô Tận&7 máy móc cao cấp"));
    public static final ItemGroup STORAGE = new SubGroup("storage",
            new CustomItemStack(Material.BEEHIVE, "&6Vô Tận&7 lưu trữ"));
    public static final ItemGroup MOB_SIMULATION = new SubGroup("mob_simulation",
            new CustomItemStack(Material.BEACON, "&bMô phỏng sinh vật"));
    public static final ItemGroup INFINITY_MATERIALS = new SubGroup("infinity_materials",
            new CustomItemStack(Material.NETHERITE_BLOCK, "&bVô Tận&a vật liệu"));
    public static final ItemGroup MAIN_CATEGORY = new MultiGroup("main",
            new CustomItemStack(Material.NETHER_STAR, "&kl&bVô Tận&4 Tham Lam&kl"), 3,
            MAIN_MATERIALS, BASIC_MACHINES, ADVANCED_MACHINES, STORAGE, MOB_SIMULATION, INFINITY_MATERIALS, INFINITY);
    public static final ItemGroup INFINITY_CHEAT = new SubGroup("infinity_cheat",
            new CustomItemStack(Material.RESPAWN_ANCHOR, "&bVô Tận&7 vật phẩm &c- Công thức sai, hãy xem công thức đúng từ bàn chế tạo vô tận"));

    public static void setup(InfinityExpansion inst) {
        INFINITY.register(inst);
        MAIN_CATEGORY.register(inst);
        MOB_SIMULATION.setCrossAddonItemGroup(true);
        INFINITY_CHEAT.register(inst);
    }

}
