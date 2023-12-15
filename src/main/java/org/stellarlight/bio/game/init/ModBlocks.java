package org.stellarlight.bio.game.init;

import net.minecraft.block.Block;
import org.stellarlight.bio.game.blocks.Bumps;
import org.stellarlight.bio.game.blocks.MidtorsoNerveCable;
import org.stellarlight.bio.game.blocks.NerveCable;
import org.stellarlight.bio.game.blocks.controller.Controller_1;
import org.stellarlight.bio.game.blocks.relay.Relay;
import org.stellarlight.bio.game.blocks.relay.Relay_1;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {
    public static final List<Block> BLOCKS = new ArrayList<>();

    public static final Controller_1 BLOCK_CONTROLLER_1 = new Controller_1();
    public static final Relay BLOCK_RELAY_1 = new Relay_1();
    public static final Bumps BLOCK_BUMPS = new Bumps();
    public static final MidtorsoNerveCable BLOCK_MIDTORSO_NERVE_CABLE = new MidtorsoNerveCable();
    public static final NerveCable BLOCK_NERVE_CABLE = new NerveCable();
}
