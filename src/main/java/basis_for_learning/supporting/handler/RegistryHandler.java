package basis_for_learning.supporting.handler;

import basis_for_learning.init.*;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraftforge.client.event.*;
import net.minecraftforge.event.*;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.common.eventhandler.*;
import net.minecraftforge.fml.relauncher.*;

@Mod.EventBusSubscriber
public class RegistryHandler {
    @SubscribeEvent public static void onItemRegister(RegistryEvent.Register<Item> e) {
        e.getRegistry().registerAll(ItemsInit.ITEMS.toArray(new Item[0]));
    }
    @SubscribeEvent public static void onBlockRegister(RegistryEvent.Register<Block> e) {
        e.getRegistry().registerAll(BlocksInit.BLOCKS.toArray(new Block[0]));
        BlocksInit.tileReg();
    }
    @SubscribeEvent @SideOnly(Side.CLIENT) public static void onModelRegister(ModelRegistryEvent e) {
        for (Item item : ItemsInit.ITEMS) if (item instanceof IHasModel) ((IHasModel) item).registerModels();
        for (Block block : BlocksInit.BLOCKS) if (block instanceof IHasModel) ((IHasModel) block).registerModels();
    }
}
