package org.stellarlight.bio.game.blocks;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.stellarlight.bio.game.entities.BumpsEntity;
import org.stellarlight.bio.game.items.Transmitters;

import javax.annotation.Nullable;

public class Bumps extends BioBlock implements ITileEntityProvider {
    @Override
    public String getName() {
        return "bumps";
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        return playerIn.getHeldItem(hand).getItem() instanceof Transmitters;
    }

    @Override
    public void register() {
        super.register();
        GameRegistry.registerTileEntity(BumpsEntity.class, getRegistryName());
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new BumpsEntity();
    }
}
