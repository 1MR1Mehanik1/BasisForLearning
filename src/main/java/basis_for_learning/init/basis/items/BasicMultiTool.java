package basis_for_learning.init.basis.items;

import basis_for_learning.Main;
import basis_for_learning.init.*;
import basis_for_learning.supporting.handler.*;
import com.google.common.collect.*;
import net.minecraft.block.state.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

public class BasicMultiTool extends ItemTool implements IHasModel {
    public BasicMultiTool(String name, ToolMaterial material) {
        super(1.0F, -2.8F, material, Sets.newHashSet());
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.CT_MOD_BASIC);

        this.setHarvestLevel("pickaxe", toolMaterial.getHarvestLevel());
        this.setHarvestLevel("shovel", toolMaterial.getHarvestLevel());
        this.setHarvestLevel("axe", toolMaterial.getHarvestLevel());

        this.setMaxDamage(toolMaterial.getMaxUses());

        ItemsInit.ITEMS.add(this);
    }
    @Override public void registerModels() { Main.proxy.registerItemRenderer(this, 0, "inventory"); }

    public boolean canHarvestBlock(IBlockState blockIn) {
        return blockIn.getBlock().getHarvestLevel(blockIn) <= toolMaterial.getHarvestLevel();
    }
    @Override public EnumActionResult onItemUse(EntityPlayer ep, World w, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        Item itemToUse;
        if (!ep.isSneaking()) itemToUse = Items.DIAMOND_HOE;
        else itemToUse = Items.DIAMOND_SHOVEL;
        return itemToUse.onItemUse(ep, w, pos, hand, facing, hitX, hitY, hitZ);
    }
    public float getDestroySpeed(ItemStack stack, IBlockState state) {
        if (state.getBlock().getHarvestLevel(state) <= toolMaterial.getHarvestLevel()) return this.efficiency;
        return super.getDestroySpeed(stack, state);
    }
    @Override public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        stack.damageItem(1, attacker);
        return true;
    }
    @Override public boolean isEnchantable(ItemStack stack) {
        return this.getItemStackLimit(stack) == 1 && (stack.getMaxDamage() < 0 || this.getItemStackLimit(stack) == 1);
    }
}
