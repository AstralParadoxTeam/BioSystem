package org.stellarlight.bio.game.blocks;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.stellarlight.bio.game.entities.MidtorsoNerveCableEntity;

import javax.annotation.Nullable;

public class MidtorsoNerveCable extends BioBlock implements ITileEntityProvider {
    @Override
    public String getName() {
        return "midtorso_nerve_cable";
    }

    @Override
    public void register() {
        super.register();
        GameRegistry.registerTileEntity(MidtorsoNerveCableEntity.class, this.getRegistryName());
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new MidtorsoNerveCableEntity();
    }
}
