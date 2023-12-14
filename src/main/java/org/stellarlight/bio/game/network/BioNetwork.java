package org.stellarlight.bio.game.network;

import org.stellarlight.bio.game.entities.ControllerEntity;
import org.stellarlight.bio.game.entities.RelayEntity;

import java.util.ArrayList;
import java.util.List;

public class BioNetwork {
    protected List<ControllerEntity> controllers = new ArrayList<>();
    protected List<RelayEntity> relays = new ArrayList<>();

    public List<ControllerEntity> getControllers() {
        return controllers;
    }

    public List<RelayEntity> getRelays() {
        return relays;
    }

    public void clear() {
        controllers.clear();
        relays.clear();
    }
}
