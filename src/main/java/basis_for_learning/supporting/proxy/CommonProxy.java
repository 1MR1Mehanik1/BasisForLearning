package basis_for_learning.supporting.proxy;

import net.minecraft.item.*;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.common.event.*;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent e) {
        regEvent();
    }
    public void init(FMLInitializationEvent e) {}
    public void postInit(FMLPostInitializationEvent e) {}

    public void registerItemRenderer(Item item, int meta, String id) {}

    @Mod.EventHandler public void regEvent() {}
}
