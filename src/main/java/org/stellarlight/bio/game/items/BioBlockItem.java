package org.stellarlight.bio.game.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class BioBlockItem extends ItemBlock {
    public BioBlockItem(Block block) {
        super(block);
        setUnlocalizedName(block.getUnlocalizedName());
        setRegistryName(block.getRegistryName());
    }
}
