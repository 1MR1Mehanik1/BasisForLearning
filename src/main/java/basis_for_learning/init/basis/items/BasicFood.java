package basis_for_learning.init.basis.items;

import basis_for_learning.Main;
import basis_for_learning.init.*;
import basis_for_learning.supporting.handler.*;
import net.minecraft.item.*;

public class BasicFood extends ItemFood implements IHasModel {
    public BasicFood(String name, int maxStackSize, int amount, float saturation, boolean isWolf) {
        super(amount, saturation, isWolf);
        setUnlocalizedName(name);
        setRegistryName(name);
        setMaxStackSize(maxStackSize);
        setCreativeTab(Main.CT_MOD_BASIC);

        ItemsInit.ITEMS.add(this);
    }
    @Override public void registerModels() { Main.proxy.registerItemRenderer(this, 0, "inventory"); }
}
