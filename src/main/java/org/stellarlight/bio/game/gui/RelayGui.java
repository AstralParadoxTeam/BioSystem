package org.stellarlight.bio.game.gui;

import net.minecraft.block.Block;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;
import org.stellarlight.bio.game.blocks.relay.Relay;
import org.stellarlight.bio.game.entities.RelayEntity;

import javax.annotation.ParametersAreNonnullByDefault;

public class RelayGui extends GuiContainer {
    protected final Relay relay;
    protected final RelayEntity relayEntity;

    public RelayGui(Block block, TileEntity entity) {
        super(new Container() {
            @Override
            @ParametersAreNonnullByDefault
            public boolean canInteractWith(EntityPlayer playerIn) {
                return block instanceof Relay && entity instanceof RelayEntity;
            }
        });

        relay = (Relay) block;
        relayEntity = (RelayEntity) entity;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        int baseX = width / 2;
        int width = 100;
        int baseY = height / 2;
        int height = 50;

        drawDefaultBackground();
        drawRect(baseX - width, baseY - height, baseX + width, baseY + height, 0x2c3e50ff);
        drawString(fontRenderer, String.format("已绑定突触: %d/%d", relayEntity.getBoundBumpsCount(), relay.getMaxBindableBumps()), baseX - width + 10, baseY - height + fontRenderer.FONT_HEIGHT + 2, 0xffffffff);
        drawString(fontRenderer, String.format("最远传输: %d", relay.getMaxTransmitDistance()), baseX - width + 10, baseY - height + (fontRenderer.FONT_HEIGHT * 2) + 2, 0xffffffff);
    }
}
