package org.stellarlight.bio.game.blocks.controller;

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
import org.stellarlight.bio.game.entities.ControllerEntity;

import javax.annotation.ParametersAreNonnullByDefault;

public abstract class Controller extends BioBlock implements ITileEntityProvider {
    abstract int getGuiID();

    abstract public long getMaxBioCapacity();

    abstract public long getMaxBioTransmit();

    abstract public int getMaxBindableRelay();

    @ParametersAreNonnullByDefault
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new ControllerEntity();
    }

    @Override
    public void register() {
        super.register();
        GameRegistry.registerTileEntity(ControllerEntity.class, this.getRegistryName());
    }

    @ParametersAreNonnullByDefault
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        playerIn.openGui(BioSystem.instance, getGuiID(), worldIn, pos.getX(), pos.getY(), pos.getZ());
        return true;
    }
}
