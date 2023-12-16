package org.stellarlight.bio.game.entities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import org.stellarlight.bio.game.util.GridMapper;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.List;

public class BumpsEntity extends TileEntity implements ITickable {
    protected final List<NerveCableEntity> cables = new ArrayList<>();

    protected String code;

    public String getCode() {
        return code;
    }

    @Override
    @Nonnull
    @ParametersAreNonnullByDefault
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setString("code", code);
        return super.writeToNBT(compound);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        code = compound.getString("code");
        super.readFromNBT(compound);
    }

    public void setRelay(RelayEntity relay) {
        code = relay.getCode();
        markDirty();
    }

    @Override
    public void update() {
        new GridMapper(world, pos, entity -> {
            if (entity instanceof NerveCableEntity) {
                NerveCableEntity cableEntity = (NerveCableEntity) entity;

                if (!cables.contains(cableEntity)) {
                    cables.add(cableEntity);
                    return true;
                }

                return true;
            }

            return false;
        }).scan();
    }
}
