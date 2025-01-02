package basis_for_learning.supporting.events;

import basis_for_learning.Main;
import net.minecraft.client.renderer.texture.*;
import net.minecraftforge.client.event.*;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.common.eventhandler.*;
import net.minecraftforge.fml.relauncher.*;

@SideOnly(Side.CLIENT)
@Mod.EventBusSubscriber(modid = Main.MOD_ID, value = Side.CLIENT)
public class RegCustomTexture {
    @SubscribeEvent
    public static void pre(TextureStitchEvent.Pre e) {
        TextureMap map = e.getMap();
    }
}
