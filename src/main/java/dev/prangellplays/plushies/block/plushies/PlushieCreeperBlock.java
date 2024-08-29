package dev.prangellplays.plushies.block.plushies;

import dev.prangellplays.plushies.PlushiesConfig;
import dev.prangellplays.plushies.block.PlushieBlock;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PlushieCreeperBlock extends PlushieBlock {
    public PlushieCreeperBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (PlushiesConfig.creeperPlushieExplosion) {
            if (player.getMainHandStack().isOf(Items.FLINT_AND_STEEL)) {
                world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 5, World.ExplosionSourceType.BLOCK);
                if (!player.isCreative()) {
                    player.getMainHandStack().damage(1, player, p -> p.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
                }
            }
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        tooltip.add(Text.translatable("block.plushies.plushie_creeper.type").formatted(Formatting.DARK_GRAY));
        super.appendTooltip(stack, world, tooltip, options);
    }
}
