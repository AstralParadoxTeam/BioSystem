package org.stellarlight.bio.game.gui;

import net.minecraft.block.Block;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;
import org.stellarlight.bio.game.blocks.controller.Controller;
import org.stellarlight.bio.game.entities.ControllerEntity;

import javax.annotation.ParametersAreNonnullByDefault;

public class ControllerGui extends GuiContainer {
    protected final Controller block;
    protected final ControllerEntity entity;

    public ControllerGui(Block block, TileEntity entity) {
        super(new Container() {
            @ParametersAreNonnullByDefault
            @Override
            public boolean canInteractWith(EntityPlayer playerIn) {
                return block instanceof Controller && entity instanceof ControllerEntity;
            }
        });

        this.block = (Controller) block;
        this.entity = (ControllerEntity) entity;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        int baseX = width / 2;
        int width = 200;
        int baseY = height / 2;
        int height = 100;

        drawDefaultBackground();
        drawRect(baseX - width, baseY - height, baseX + width, baseY + height, 0x2c3e50ff);
        drawString(fontRenderer, String.format("已存储 Bio: %d/%d", entity.getStoredBio(), block.getMaxBioCapacity()), baseX - width + 10, baseY - height + fontRenderer.FONT_HEIGHT + 2, 0xffffffff);
        drawString(fontRenderer, String.format("最大传输: %d", block.getMaxBioTransmit()), baseX - width + 10, baseY - height + (fontRenderer.FONT_HEIGHT * 2) + 2, 0xffffffff);
        drawString(fontRenderer, String.format("已绑定中继器: %d/%d", entity.getNetwork().getRelays().size(), block.getMaxBindableRelay()), baseX - width + 10, baseY - height + (fontRenderer.FONT_HEIGHT * 3) + 2, 0xffffffff);
    }
}
