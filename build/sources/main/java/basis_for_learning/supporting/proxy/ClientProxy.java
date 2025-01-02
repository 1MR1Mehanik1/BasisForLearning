package basis_for_learning.supporting.proxy;

import net.minecraft.client.renderer.block.model.*;
import net.minecraft.item.*;
import net.minecraftforge.client.model.*;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.relauncher.*;

public class ClientProxy extends CommonProxy {
    @Override public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
    }
    @Override public void init(FMLInitializationEvent e) {
        super.init(e);
    }
    @Override public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
    }

    @Override public void registerItemRenderer(Item item, int meta, String id) { ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id)); }

    @SideOnly(Side.CLIENT) public void regEvent() {
        super.regEvent();
    }
}
