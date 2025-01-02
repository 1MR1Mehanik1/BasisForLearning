package basis_for_learning.init.basis.items;

import basis_for_learning.Main;
import basis_for_learning.init.*;
import basis_for_learning.supporting.handler.*;
import net.minecraft.item.*;

public class BasicItem extends Item implements IHasModel {
    public BasicItem(String name, int maxStack) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setMaxStackSize(maxStack);
        setCreativeTab(Main.CT_MOD_BASIC);

        ItemsInit.ITEMS.add(this);
    }
    @Override public void registerModels() { Main.proxy.registerItemRenderer(this, 0, "inventory"); }
}
