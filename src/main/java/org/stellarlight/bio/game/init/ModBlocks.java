package org.stellarlight.bio.game.init;

import net.minecraft.block.Block;
import org.stellarlight.bio.game.blocks.*;
import org.stellarlight.bio.game.blocks.controller.Controller_1;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {
    public static final List<Block> BLOCKS = new ArrayList<>();

    public static final Controller_1 BLOCK_CONTROLLER_1 = new Controller_1();
    public static final Relay BLOCK_RELAY = new Relay();
    public static final Bumps BLOCK_BUMPS = new Bumps();
    public static final MidtorsoNerveCable BLOCK_MIDTORSO_NERVE_CABLE = new MidtorsoNerveCable();
    public static final NerveCable BLOCK_NERVE_CABLE = new NerveCable();
}
