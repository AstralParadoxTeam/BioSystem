package org.stellarlight.bio.game.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.stellarlight.bio.game.entities.BumpsEntity;
import org.stellarlight.bio.game.entities.RelayEntity;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

public class Transmitters extends BioItem {
    @Override
    public String getName() {
        return "transmitters";
    }

    @Override
    @Nonnull
    @ParametersAreNonnullByDefault
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ActionResult<ItemStack> result = super.onItemRightClick(worldIn, playerIn, handIn);
        ItemStack stack = result.getResult();

        RayTraceResult target = playerIn.rayTrace(100, 1);
        NBTTagCompound compound = stack.hasTagCompound() ? stack.getTagCompound() : new NBTTagCompound();

        if (target != null && compound != null && target.typeOfHit == RayTraceResult.Type.BLOCK) {
            BlockPos blockPos = target.getBlockPos();
            TileEntity targetEntity = worldIn.getTileEntity(blockPos);

            if (compound.hasKey("relay")) {
                int[] relayPos = compound.getIntArray("relay");

                if (relayPos.length == 3 && targetEntity instanceof BumpsEntity) {
                    TileEntity storedEntity = worldIn.getTileEntity(new BlockPos(relayPos[0], relayPos[1], relayPos[2]));

                    if (storedEntity instanceof RelayEntity) {
                        RelayEntity relayEntity = (RelayEntity) storedEntity;
                        BumpsEntity bumpsEntity = (BumpsEntity) targetEntity;

                        bumpsEntity.setRelay(relayEntity);
                    }
                }
            }

            if (targetEntity instanceof RelayEntity) {
                compound.setIntArray("relay", new int[]{
                        blockPos.getX(),
                        blockPos.getY(),
                        blockPos.getZ()
                });
            }
        }

        stack.setTagCompound(compound);
        return result;
    }
}
