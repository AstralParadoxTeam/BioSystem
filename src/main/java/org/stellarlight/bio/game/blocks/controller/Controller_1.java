package org.stellarlight.bio.game.blocks.controller;

public class Controller_1 extends Controller {
    @Override
    public String getName() {
        return "controller_1";
    }

    @Override
    public int getGuiID() {
        return 0;
    }

    @Override
    public long getMaxBioCapacity() {
        return 204800000000L;
    }

    @Override
    public long getMaxBioTransmit() {
        return 102400000000L;
    }

    @Override
    public int getMaxBindableRelay() {
        return 1;
    }
}
