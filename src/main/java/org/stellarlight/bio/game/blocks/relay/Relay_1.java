package org.stellarlight.bio.game.blocks.relay;

public class Relay_1 extends Relay {
    @Override
    public String getName() {
        return "relay_1";
    }

    @Override
    public int getGuiID() {
        return 1;
    }

    @Override
    public int getMaxTransmitDistance() {
        return 32;
    }

    @Override
    public int getMaxBindableBumps() {
        return 2;
    }
}
