package org.stellarlight.bio.game.entities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import org.stellarlight.bio.game.blocks.relay.Relay;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RelayEntity extends TileEntity implements ITickable {
    protected final List<BumpsEntity> bumps = new ArrayList<>();
    protected String code = UUID.randomUUID().toString();

    public String getCode() {
        return code;
    }

    @Override
    @Nonnull
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setString("code", code);
        return super.writeToNBT(compound);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        code = compound.getString("code");
        super.readFromNBT(compound);
    }

    public int getBoundBumpsCount() {
        return bumps.size();
    }

    @Override
    public void update() {
        Relay block = (Relay) world.getBlockState(pos).getBlock();
        int distance = block.getMaxTransmitDistance();

        bumps.removeIf(TileEntity::isInvalid);
        for (int x = pos.getX() - distance; x <= pos.getX() + distance; x++) {
            for (int y = pos.getY() - distance; y <= pos.getY() + distance; y++) {
                for (int z = pos.getZ() - distance; z <= pos.getZ() + distance; z++) {
                    BlockPos blockPos = new BlockPos(x, y, z);
                    TileEntity tileEntity = world.getTileEntity(blockPos);

                    if (bumps.size() >= block.getMaxBindableBumps()) {
                        break;
                    }

                    if (tileEntity instanceof BumpsEntity) {
                        BumpsEntity bumpsEntity = (BumpsEntity) tileEntity;
                        String bumpsCode = bumpsEntity.getCode();

                        if (!bumps.contains(bumpsEntity)) {
                            if (code.equals(bumpsCode)) {
                                bumps.add(bumpsEntity);
                            }
                        }
                    }
                }
            }
        }
    }
}
