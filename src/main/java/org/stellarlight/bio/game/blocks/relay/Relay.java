package org.stellarlight.bio.game.blocks.relay;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.stellarlight.bio.BioSystem;
import org.stellarlight.bio.game.blocks.BioBlock;
import org.stellarlight.bio.game.entities.RelayEntity;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

public abstract class Relay extends BioBlock implements ITileEntityProvider {
    @Override
    public abstract String getName();

    public abstract int getGuiID();

    @Override
    public void register() {
        super.register();
        GameRegistry.registerTileEntity(RelayEntity.class, this.getRegistryName());
    }

    public abstract int getMaxTransmitDistance();

    public abstract int getMaxBindableBumps();

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new RelayEntity();
    }

    @ParametersAreNonnullByDefault
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        TileEntity entity = worldIn.getTileEntity(pos);

        if (entity instanceof RelayEntity) {
            ((RelayEntity) entity).refreshBumps();
        }

        playerIn.openGui(BioSystem.instance, getGuiID(), worldIn, pos.getX(), pos.getY(), pos.getZ());
        return true;
    }
}
