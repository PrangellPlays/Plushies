package dev.prangellplays.plushies.init;

import dev.prangellplays.plushies.Plushies;
import dev.prangellplays.plushies.block.plushies.PlushieBaseplateBlock;
import dev.prangellplays.plushies.block.plushies.PlushieCreeperBlock;
import dev.prangellplays.plushies.block.plushies.PlushiePrangellPlaysBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class PlushiesBlocks {
    public static final Block PLUSHIE_BASEPLATE = registerBlock("plushie_baseplate", new PlushieBaseplateBlock(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).strength(0.8f).luminance(1).nonOpaque().notSolid().sounds(BlockSoundGroup.WOOL)));
    public static final Block PLUSHIE_PRANGELLPLAYS = registerBlock("plushie_prangellplays", new PlushiePrangellPlaysBlock(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).strength(0.8f).luminance(1).nonOpaque().notSolid().sounds(BlockSoundGroup.WOOL)));
    public static final Block PLUSHIE_CREEPER = registerBlock("plushie_creeper", new PlushieCreeperBlock(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).strength(0.8f).luminance(1).nonOpaque().notSolid().sounds(BlockSoundGroup.WOOL)));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Plushies.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        Item item = Registry.register(Registries.ITEM, new Identifier(Plushies.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        return item;
    }

    public static void init() {
        Plushies.LOGGER.info("Registering ModBlocks for " + Plushies.MOD_ID);
    }
}