package org.stellarlight.bio.game.entities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

import javax.annotation.Nonnull;

public class ControllerEntity extends TileEntity {
    protected String color = "255,255,255";
    protected int storedBio;

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        color = compound.getString("color");
        storedBio = compound.getInteger("storedBio");
        super.readFromNBT(compound);
    }

    @Nonnull
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setString("color", color);
        compound.setInteger("storedBio", storedBio);
        return super.writeToNBT(compound);
    }
}
