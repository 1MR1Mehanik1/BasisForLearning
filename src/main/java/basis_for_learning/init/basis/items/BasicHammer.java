package basis_for_learning.init.basis.items;

import basis_for_learning.supporting.handler.*;
import net.minecraft.block.material.*;
import net.minecraft.enchantment.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

import java.util.*;

public class BasicHammer extends BasicPickaxe {
    private static final List<Material> MATERIALS = Arrays.asList(Material.ROCK, Material.IRON, Material.ICE, Material.GLASS, Material.PISTON, Material.ANVIL);

    public BasicHammer(String name, ToolMaterial material) { super(name, material); }

    @Override public boolean onBlockStartBreak(ItemStack is, BlockPos pos, EntityPlayer ep) {
        RayTraceResult raycast = HammerRangeDestroy.raytraceFromEntity(ep.world, ep, true, 10);
        if(!ep.world.isRemote && raycast != null && !ep.isSneaking()) { breakOtherBlock(ep, is, pos, 1, raycast.sideHit); }
        return false;
    }

    public void breakOtherBlock(EntityPlayer player, ItemStack stack, BlockPos pos, int level, EnumFacing side) {
        World w = player.world;
        Material mat = w.getBlockState(pos).getMaterial();
        if(!MATERIALS.contains(mat)) return;
        if(w.isAirBlock(pos)) return;

        int fortune = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, stack);
        boolean silk = EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, stack) > 0;

        boolean doX = side.getFrontOffsetX() == 0;
        boolean doY = side.getFrontOffsetY() == 0;
        boolean doZ = side.getFrontOffsetZ() == 0;

        int range = level;
        int rangeY = Math.max(1, range);

        Vec3i beginDiff = new Vec3i(doX ? -range : 0, doY ? -1 : 0, doZ ? -range : 0);
        Vec3i endDiff = new Vec3i(doX ? range : 0, doY ? rangeY * 2 - 1 : 0, doZ ? range : 0);

        HammerRangeDestroy.removeBlocksInIteration(player, stack, w, pos, beginDiff, endDiff, state -> MATERIALS.contains(state.getMaterial()), false);
    }
}
