package dev.prangellplays.plushies;

import dev.prangellplays.plushies.init.PlushiesBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class PlushiesClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(PlushiesBlocks.PLUSHIE_BASEPLATE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(PlushiesBlocks.PLUSHIE_PRANGELLPLAYS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(PlushiesBlocks.PLUSHIE_CREEPER, RenderLayer.getCutout());
    }
}