package basis_for_learning.init.basis.items;

import basis_for_learning.Main;
import basis_for_learning.init.*;
import basis_for_learning.supporting.handler.*;
import net.minecraft.item.*;

public class BasicAxe extends ItemAxe implements IHasModel {
    public BasicAxe(String name, ToolMaterial material, float damage, float speed) {
        super(material, damage, speed);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.CT_MOD_BASIC);

        ItemsInit.ITEMS.add(this);
    }
    @Override public void registerModels() { Main.proxy.registerItemRenderer(this, 0, "inventory"); }
}
