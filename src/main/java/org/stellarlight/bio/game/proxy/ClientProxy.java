package org.stellarlight.bio.game.proxy;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import org.stellarlight.bio.BioSystem;
import org.stellarlight.bio.game.handlers.GuiHandler;

public class ClientProxy extends CommonProxy {
    @Override
    public void preInit() {
        NetworkRegistry.INSTANCE.registerGuiHandler(BioSystem.instance, new GuiHandler());
    }
}
