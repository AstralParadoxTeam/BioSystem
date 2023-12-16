package org.stellarlight.bio.game.blocks;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.stellarlight.bio.game.entities.NerveCableEntity;

import javax.annotation.Nullable;

public class NerveCable extends BioBlock implements ITileEntityProvider {
    @Override
    public String getName() {
        return "nerve_cable";
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new NerveCableEntity();
    }

    @Override
    public void register() {
        super.register();
        GameRegistry.registerTileEntity(NerveCableEntity.class, getRegistryName());
    }
}
