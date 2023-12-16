package org.stellarlight.bio.game.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import org.stellarlight.bio.game.init.ModBlocks;
import org.stellarlight.bio.game.init.ModCreativeTabs;
import org.stellarlight.bio.game.init.ModItems;
import org.stellarlight.bio.game.items.BioBlockItem;

public abstract class BioBlock extends Block {
    protected final BioBlockItem item;

    public BioBlock() {
        super(Material.IRON);
        String name = getName();

        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(ModCreativeTabs.BIO_SYSTEM);
        ModBlocks.BLOCKS.add(this);

        item = new BioBlockItem(this);
        ModItems.ITEMS.add(item);
    }

    public void register() {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }

    public abstract String getName();
}
