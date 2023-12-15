package org.stellarlight.bio.game.entities;

import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import org.stellarlight.bio.game.blocks.relay.Relay;

import java.util.HashSet;
import java.util.Set;

public class RelayEntity extends TileEntity {
    protected Set<BumpsEntity> bindingBumps = new HashSet<>();
    protected int maxBindableBumps = 0;

    public Set<BumpsEntity> getBindingBumps() {
        return bindingBumps;
    }

    @Override
    public void onLoad() {
        Block block = world.getBlockState(pos).getBlock();

        if (block instanceof Relay) {
            Relay relay = (Relay) block;
            maxBindableBumps = relay.getMaxBindableBumps();
        }
    }

    public void refreshBumps() {
        // TODO: 刷新突触数量
        markDirty();
    }

    protected void update(NBTTagCompound compound) {
        for (int i = 0; i < maxBindableBumps; i++) {
            String key = "binding_bump_" + (i + 1);

            if (!compound.hasKey(key)) {
                continue;
            }

            int[] pos = compound.getIntArray(key);

            if (pos.length != 3) {
                continue;
            }

            TileEntity entity = world.getTileEntity(new BlockPos(pos[0], pos[1], pos[2]));

            if (entity instanceof BumpsEntity && !bindingBumps.contains(entity)) {
                bindingBumps.add((BumpsEntity) entity);
            }
        }

        for (int i = 0; i < bindingBumps.size(); i++) {
            BumpsEntity bumps = bindingBumps.get(i);
            BlockPos bumpsPos = bumps.getPos();

            if (i + 1 >= maxBindableBumps) {
                continue;
            }

            compound.setIntArray("binding_bump_" + (i + 1), new int[]{bumpsPos.getX(), bumpsPos.getY(), bumpsPos.getZ()});
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        update(compound);
        return super.writeToNBT(compound);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        update(compound);
        super.readFromNBT(compound);
    }
}
