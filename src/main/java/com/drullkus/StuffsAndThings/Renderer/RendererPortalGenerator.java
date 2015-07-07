package com.drullkus.StuffsAndThings.Renderer;

import com.drullkus.StuffsAndThings.StuffsAndThings;
import com.drullkus.StuffsAndThings.Tile.TileEntityProvocateur;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import thaumcraft.api.nodes.NodeType;
import thaumcraft.client.lib.UtilsFX;

public class RendererPortalGenerator extends TileEntitySpecialRenderer {

    public PortalGenerator modelObj;
    public final ResourceLocation modelTexture = new ResourceLocation(StuffsAndThings.MOD_ID, "textures/models/PortalGenerator.png");
    public final String bubbleTexture = "textures/models/bubbleAnim5.png";

    public RendererPortalGenerator()
    {
        modelObj = new PortalGenerator();
    }

    public void renderTileEntityAt(TileEntityProvocateur tile, double x, double y, double z, float partialTicks)
    {
        GL11.glPushMatrix();

        this.bindTexture(modelTexture);
        GL11.glTranslated(x + 0.5, y + 1.5, z + 0.5);
        GL11.glScaled(1, -1, -1);
        this.modelObj.render(0.0625F);
        GL11.glPopMatrix();

        if (tile.hasNode())
        {
            GL11.glPushMatrix();
            GL11.glAlphaFunc(516, 0.003921569F);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 1);
            long nt = System.nanoTime();
            UtilsFX.bindTexture(StuffsAndThings.MOD_ID, bubbleTexture);
            int frames = 24;
            int i = (int)(((double)(nt / 40000000L) + x) % (double)frames);

            // x, y, z, Angle, Scale, Alpha, Frame Count, Current Frame, Partial Tick, Color
            UtilsFX.renderFacingQuad((double)tile.xCoord + 0.5D, (double)tile.yCoord + 1.5D, (double)tile.zCoord + 0.5D, 0.0F, 1.2F, 1.4F, frames, i, partialTicks, 16777215);

            GL11.glDisable(3042);
            GL11.glAlphaFunc(516, 0.1F);
            GL11.glPopMatrix();
        }
    }

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float partialTick)
    {
        this.renderTileEntityAt(((TileEntityProvocateur) tileEntity), x, y, z, partialTick);
    }
}
