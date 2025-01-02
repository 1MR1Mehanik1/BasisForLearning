package basis_for_learning.init.basis.items;

import basis_for_learning.Main;
import basis_for_learning.init.*;
import basis_for_learning.supporting.handler.*;
import net.minecraft.item.*;

public class BasicSword extends ItemSword implements IHasModel {
    public BasicSword(String name, ToolMaterial material) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.CT_MOD_BASIC);

        ItemsInit.ITEMS.add(this);
    }
    @Override public void registerModels() { Main.proxy.registerItemRenderer(this, 0, "inventory"); }
}
