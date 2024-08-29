package dev.prangellplays.plushies.init;

import dev.prangellplays.plushies.Plushies;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class PlushiesItemGroups {
    public static final ItemGroup PLUSHIES_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Plushies.MOD_ID, "plushies"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.plushies.items")).icon(() -> new ItemStack(PlushiesBlocks.PLUSHIE_BASEPLATE)).entries((displayContext, entries) -> {
                entries.add(PlushiesBlocks.PLUSHIE_BASEPLATE);
                entries.add(PlushiesBlocks.PLUSHIE_PRANGELLPLAYS);
                entries.add(PlushiesBlocks.PLUSHIE_CREEPER);
            }).build());


    public static void init() {
        Plushies.LOGGER.info("Registering Item Groups for " + Plushies.MOD_ID);
    }
}
