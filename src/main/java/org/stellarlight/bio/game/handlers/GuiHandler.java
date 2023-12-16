package org.stellarlight.bio.game.handlers;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import org.stellarlight.bio.game.gui.ControllerGui;
import org.stellarlight.bio.game.gui.RelayGui;

import javax.annotation.Nullable;

public class GuiHandler implements IGuiHandler {
    @Override
    @Nullable
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return null;
    }

    @Override
    @Nullable
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);

        Block block = world.getBlockState(pos).getBlock();
        TileEntity entity = world.getTileEntity(pos);

        switch (ID) {
            case 0:
                return new ControllerGui(block, entity);
            case 1:
                return new RelayGui(block, entity);
        }

        return null;
    }
}
