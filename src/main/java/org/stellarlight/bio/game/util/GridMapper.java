package org.stellarlight.bio.game.util;

import com.google.common.base.Function;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class GridMapper {
    protected final World currentWorld;
    protected final BlockPos currentPos;
    protected final Function<TileEntity, Boolean> checker;

    final List<TileEntity> scannedEntities = new ArrayList<>();

    public GridMapper(World world, BlockPos startPos, Function<TileEntity, Boolean> callback) {
        currentWorld = world;
        currentPos = startPos;
        checker = callback;
    }

    public void scan() {
        scan(currentPos);
    }

    public void scan(BlockPos pos) {
        for (EnumFacing facing : EnumFacing.values()) {
            BlockPos neighborPos = pos.offset(facing);
            TileEntity neighborEntity = currentWorld.getTileEntity(neighborPos);

            if (scannedEntities.contains(neighborEntity)) {
                continue;
            }

            if (neighborEntity != null && checker.apply(neighborEntity)) {
                scannedEntities.add(neighborEntity);
                scan(neighborPos);
            }
        }
    }
}
