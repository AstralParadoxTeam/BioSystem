package org.stellarlight.bio.game.util;

import com.google.common.base.Function;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class GridMapper {
    protected World world;
    protected BlockPos currentPos;
    protected Function<TileEntity, Boolean> callback;

    List<TileEntity> scannedEntities = new ArrayList<>();

    public GridMapper(World world, BlockPos startPos, Function<TileEntity, Boolean> callback) {
        this.world = world;
        this.currentPos = startPos;
        this.callback = callback;
    }

    public void scan() {
        scan(currentPos);
    }

    public void scan(BlockPos pos) {
        for (EnumFacing facing : EnumFacing.values()) {
            BlockPos neighborPos = pos.offset(facing);
            TileEntity neighborEntity = world.getTileEntity(neighborPos);

            if (scannedEntities.contains(neighborEntity)) {
                continue;
            }

            if (neighborEntity != null && callback.apply(neighborEntity)) {
                scannedEntities.add(neighborEntity);
                scan(neighborPos);
            }
        }
    }
}
