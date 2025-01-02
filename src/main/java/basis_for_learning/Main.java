package basis_for_learning;

import basis_for_learning.supporting.proxy.*;
import net.minecraft.creativetab.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraftforge.fluids.*;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.common.event.*;

@Mod(modid = Main.MOD_ID, name = Main.NAME, version = Main.VERSION, acceptedMinecraftVersions = Main.MC_VERSION)
public class Main {
    public static final String MOD_ID = "basis_for_learning";
    public static final String NAME = "BasisForLearning";
    public static final String VERSION = "0.1";
    public static final String MC_VERSION = "[1.12.2]";

    public static final String CLIENT = MOD_ID + ".supporting.proxy.ClientProxy";
    public static final String SERVER = MOD_ID + ".supporting.proxy.CommonProxy";

    public static final CreativeTabs CT_MOD_BASIC = new CreativeTabs(Main.MOD_ID + ".basic") {
        @Override public ItemStack getTabIconItem() { return new ItemStack(Items.BOOK); }
    };

    static { FluidRegistry.enableUniversalBucket(); }

    @Mod.Instance public static Main instance;
    @SidedProxy(clientSide = CLIENT, serverSide = SERVER) public static CommonProxy proxy;

    @Mod.EventHandler public static void preInit(FMLPreInitializationEvent e) {	proxy.preInit(e); }
    @Mod.EventHandler public static void init(FMLInitializationEvent e) { proxy.init(e); }
    @Mod.EventHandler public static void postInit(FMLPostInitializationEvent e) { proxy.postInit(e); }
}
