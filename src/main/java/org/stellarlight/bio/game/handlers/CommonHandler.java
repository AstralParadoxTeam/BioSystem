package org.stellarlight.bio.game.handlers;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.stellarlight.bio.game.blocks.BioBlock;
import org.stellarlight.bio.game.init.ModBlocks;
import org.stellarlight.bio.game.init.ModItems;
import org.stellarlight.bio.game.items.BioItem;

@Mod.EventBusSubscriber
public class CommonHandler {
    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
    }

    @SubscribeEvent
    public static void onModelRegistration(ModelRegistryEvent event) {
        ModBlocks.BLOCKS.forEach(block -> {
            if (block instanceof BioBlock) {
                ((BioBlock) block).register();
            }
        });

        ModItems.ITEMS.forEach(item -> {
            if (item instanceof BioItem) {
                ((BioItem) item).registerModel();
            }
        });
    }
}
