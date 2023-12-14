package org.stellarlight.bio.game.entities;

import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import org.stellarlight.bio.game.blocks.controller.Controller;
import org.stellarlight.bio.game.network.BioNetwork;
import org.stellarlight.bio.game.util.GridMapper;

import javax.annotation.Nonnull;
import java.util.List;

public class ControllerEntity extends TileEntity implements ITickable {
    protected BioNetwork network = new BioNetwork();

    protected String color = "255,255,255";
    protected int storedBio;

    public int getStoredBio() {
        return storedBio;
    }

    public String getColor() {
        return color;
    }

    public BioNetwork getNetwork() {
        return network;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        color = compound.getString("color");
        storedBio = compound.getInteger("storedBio");
        super.readFromNBT(compound);
    }

    @Override
    public void update() {
        int maxBindableRelayCount;
        Block block = world.getBlockState(pos).getBlock();

        if (block instanceof Controller) {
            Controller controller = (Controller) block;
            maxBindableRelayCount = controller.getMaxBindableRelay();
        } else {
            maxBindableRelayCount = 0;
        }

        network.clear();

        new GridMapper(world, pos, entity -> {
            if (entity instanceof ControllerEntity) {
                List<ControllerEntity> controllers = network.getControllers();
                controllers.add((ControllerEntity) entity);
                return true;
            }

            if (entity instanceof MidtorsoNerveCableEntity) {
                return true;
            }

            if (entity instanceof RelayEntity) {
                List<RelayEntity> relays = network.getRelays();

                if (relays.size() < maxBindableRelayCount) {
                    relays.add((RelayEntity) entity);
                }

                return true;
            }

            return false;
        }).scan();
    }

    @Override
    public void onChunkUnload() {
        network.getControllers().remove(this);
    }

    @Nonnull
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setString("color", color);
        compound.setInteger("storedBio", storedBio);
        return super.writeToNBT(compound);
    }
}
