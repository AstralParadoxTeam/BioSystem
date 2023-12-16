package org.stellarlight.bio.game.creativeTabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import org.stellarlight.bio.BioSystem;
import org.stellarlight.bio.game.init.ModBlocks;

import javax.annotation.Nonnull;

public class BioSystemTab extends CreativeTabs {
    public BioSystemTab() {
        super(BioSystem.NAME);
    }

    @Override
    @Nonnull
    public ItemStack getTabIconItem() {
        return new ItemStack(ModBlocks.BLOCK_CONTROLLER_1);
    }
}
