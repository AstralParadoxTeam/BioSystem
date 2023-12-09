package org.stellarlight.bio.game.items;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import org.stellarlight.bio.game.init.ModCreativeTabs;
import org.stellarlight.bio.game.init.ModItems;

public abstract class BioItem extends Item {
    public BioItem() {
        super();
        String name = getName();

        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(ModCreativeTabs.BIO_SYSTEM);
        ModItems.ITEMS.add(this);
    }

    public void registerModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    public abstract String getName();
}
