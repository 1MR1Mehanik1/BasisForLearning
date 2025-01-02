package basis_for_learning.init;

import basis_for_learning.*;
import net.minecraft.block.*;
import net.minecraft.tileentity.*;
import net.minecraftforge.fml.common.registry.*;
import net.minecraftforge.fml.relauncher.*;

import java.util.*;

public class BlocksInit {
    public static final List<Block> BLOCKS = new ArrayList<Block>();



    public static void tileReg() {}
    @SideOnly(Side.CLIENT) public static void tileRenderReg() {}

    private static void registerTile(Class<? extends TileEntity> clazz, Block key) {
        GameRegistry.registerTileEntity(clazz, Main.MOD_ID + ":" + key.getUnlocalizedName().toString());
    }
}
