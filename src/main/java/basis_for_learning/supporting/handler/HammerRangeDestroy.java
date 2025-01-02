package basis_for_learning.supporting.handler;

import net.minecraft.block.*;
import net.minecraft.block.state.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.math.*;
import net.minecraft.world.World;
import net.minecraftforge.common.*;

import java.util.function.*;

public class HammerRangeDestroy {
    public static void removeBlocksInIteration(EntityPlayer ep, ItemStack is, World w, BlockPos p, Vec3i startDelta, Vec3i endDelta, Predicate<IBlockState> filter, boolean dispose) {
        for (BlockPos iterPos : BlockPos.getAllInBox(p.add(startDelta), p.add(endDelta))) {
            if (iterPos.equals(p)) continue;
            removeBlockWithDrops(ep, is, w, iterPos, filter, dispose);
        }
    }

    public static void removeBlockWithDrops(EntityPlayer ep, ItemStack s, World w, BlockPos p, Predicate<IBlockState> filter, boolean dispose) {
        removeBlockWithDrops(ep, s, w, p, filter, dispose, true);
    }

    public static void removeBlockWithDrops(EntityPlayer ep, ItemStack s, World w, BlockPos p, Predicate<IBlockState> filter, boolean dispose, boolean particles) {
        if (!w.isBlockLoaded(p)) return;

        IBlockState state = w.getBlockState(p);
        Block block = state.getBlock();

        if (!w.isRemote && filter.test(state)
                && !block.isAir(state, w, p) && state.getPlayerRelativeBlockHardness(ep, w, p) > 0
                && block.canHarvestBlock(ep.world, p, ep)) {
            int exp = ForgeHooks.onBlockBreakEvent(w, ((EntityPlayerMP) ep).interactionManager.getGameType(), (EntityPlayerMP) ep, p);
            if (exp == -1) return;
            if (!ep.capabilities.isCreativeMode) {
                TileEntity tile = w.getTileEntity(p);
                if (block.removedByPlayer(state, w, p, ep, true)) {
                    block.onBlockDestroyedByPlayer(w, p, state);
                    if (!dispose) {
                        block.harvestBlock(w, ep, p, state, tile, s);
                        block.dropXpOnBlockBreak(w, p, exp);
                    }
                }
                s.damageItem(1, ep);
            } else w.setBlockToAir(p);
        }
    }

    public static RayTraceResult raytraceFromEntity(World w, Entity ep, boolean useLiquids, double range) {
        float f = ep.rotationPitch;
        float f1 = ep.rotationYaw;
        double d0 = ep.posX;
        double d1 = ep.posY + (double) ep.getEyeHeight();
        double d2 = ep.posZ;
        Vec3d vec3d = new Vec3d(d0, d1, d2);
        float f2 = MathHelper.cos(-f1 * 0.017453292F - (float)Math.PI);
        float f3 = MathHelper.sin(-f1 * 0.017453292F - (float)Math.PI);
        float f4 = -MathHelper.cos(-f * 0.017453292F);
        float f5 = MathHelper.sin(-f * 0.017453292F);
        float f6 = f3 * f4;
        float f7 = f2 * f4;
        Vec3d vec3d1 = vec3d.add(new Vec3d((double) f6 * range, (double) f5 * range, (double) f7 * range));
        return w.rayTraceBlocks(vec3d, vec3d1, useLiquids, !useLiquids, false);
    }
}
