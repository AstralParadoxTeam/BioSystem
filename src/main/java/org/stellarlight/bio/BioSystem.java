package org.stellarlight.bio;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.stellarlight.bio.game.proxy.CommonProxy;

@Mod(modid = BioSystem.ID, name = BioSystem.NAME, version = BioSystem.VERSION)
public class BioSystem {
    public static final String ID = "bio";
    public static final String NAME = "Bio";
    public static final String VERSION = "1.0";

    @SidedProxy(clientSide = "org.stellarlight.bio.game.proxy.ClientProxy", serverSide = "org.stellarlight.bio.game.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static BioSystem instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init();
    }
}
