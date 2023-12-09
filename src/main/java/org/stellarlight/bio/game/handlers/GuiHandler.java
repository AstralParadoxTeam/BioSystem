package org.stellarlight.bio.game.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import org.stellarlight.bio.game.gui.ControllerGui;

import javax.annotation.Nullable;

public class GuiHandler implements IGuiHandler {
    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return null;
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == 0) {
            RayTraceResult target = player.rayTrace(100, 1);

            if (target != null && target.typeOfHit == RayTraceResult.Type.BLOCK) {
                return new ControllerGui(world.getBlockState(target.getBlockPos()).getBlock());
            }
        }

        return null;
    }
}
