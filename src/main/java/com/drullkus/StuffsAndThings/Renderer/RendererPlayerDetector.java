package com.drullkus.StuffsAndThings.Renderer;

import com.drullkus.StuffsAndThings.StuffsAndThings;
import com.drullkus.StuffsAndThings.Tile.TileEntityPlayerDetector;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RendererPlayerDetector extends TileEntitySpecialRenderer {

    public PortalGenerator modelObj;
    public final ResourceLocation modelTexture = new ResourceLocation(StuffsAndThings.MOD_ID, "textures/models/PortalGenerator.png");

    public RendererPlayerDetector()
    {
        modelObj = new PortalGenerator();

    }

    public void renderTileEntityAt(TileEntityPlayerDetector tileEntity, double x, double y, double z, float partialTick)
    {
        GL11.glPushMatrix();

        this.bindTexture(modelTexture);
        GL11.glTranslated(x + 0.5, y + 1.5, z + 0.5);
        GL11.glScaled(1, -1, -1);
        this.modelObj.render(0.0625F);

        GL11.glPopMatrix();
    }

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float partialTick)
    {
        this.renderTileEntityAt( ((TileEntityPlayerDetector)tileEntity), x, y, z, partialTick );
    }
}
