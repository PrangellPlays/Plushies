package dev.prangellplays.plushies.block.plushies;

import dev.prangellplays.plushies.block.PlushieBlock;
import dev.prangellplays.plushies.init.PlushiesBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PlushieBaseplateBlock extends PlushieBlock {

    public PlushieBaseplateBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        tooltip.add(Text.translatable("block.plushies.plushie_baseplate.type").formatted(Formatting.DARK_GRAY));
        super.appendTooltip(stack, world, tooltip, options);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (player.getMainHandStack().isOf(Items.PURPLE_DYE)) {
            world.addParticle(ParticleTypes.EXPLOSION, true, pos.getX(), pos.getY(), pos.getZ(), 0, 0, 0);
            world.playSound(player, pos, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.BLOCKS, 100, 1.0f);
            world.setBlockState(pos, PlushiesBlocks.PLUSHIE_PRANGELLPLAYS.getDefaultState());
        }

        return super.onUse(state, world, pos, player, hand, hit);
    }
}
