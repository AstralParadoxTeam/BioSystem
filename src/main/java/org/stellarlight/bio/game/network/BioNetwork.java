package org.stellarlight.bio.game.network;

import org.stellarlight.bio.game.blocks.controller.Controller;
import org.stellarlight.bio.game.blocks.Relay;

import java.util.ArrayList;
import java.util.List;

public class BioNetwork {
    protected List<Controller> controllers = new ArrayList<>();
    protected List<Relay> relays = new ArrayList<>();

    public List<Controller> getControllers() {
        return controllers;
    }

    public List<Relay> getRelays() {
        return relays;
    }
}
