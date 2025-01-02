package basis_for_learning.init.basis.blocks;

import basis_for_learning.Main;
import basis_for_learning.init.*;
import basis_for_learning.supporting.handler.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.item.*;

public class BasicBlock extends Block implements IHasModel {
    public BasicBlock(final String name, final Material material, float hardness, float resistanse, String hravLevel, int level, SoundType soundtype) {
        super(material);
        setRegistryName(name);
        setUnlocalizedName(name);
        setSoundType(soundtype);
        setHardness(hardness);
        setResistance(resistanse);
        setHarvestLevel(hravLevel, level);
        setCreativeTab(Main.CT_MOD_BASIC);

        BlocksInit.BLOCKS.add(this);
        ItemsInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }
    @Override public void registerModels() { Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory"); }
}
