package com.drullkus.StuffsAndThings.Renderer;

import com.drullkus.StuffsAndThings.Blocks.TileBlockTest;
import com.drullkus.StuffsAndThings.StuffsAndThings;
import com.drullkus.StuffsAndThings.Tile.TETest;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RendererTESRTest extends TileEntitySpecialRenderer {

    public PortalGenerator modelObj;
    public final ResourceLocation modelTexture = new ResourceLocation(StuffsAndThings.MOD_ID, "textures/model/portalGenerator.png");

    public RendererTESRTest()
    {
        modelObj = new PortalGenerator();

    }

    public void renderTileEntityAt(TETest tileEntity, double x, double y, double z, float partialTick)
    {
        GL11.glPushMatrix();

        this.bindTexture(modelTexture);
        GL11.glTranslated(x, y, z);
        this.modelObj.render(0.0625F);

        GL11.glPopMatrix();
    }

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float partialTick)
    {
        this.renderTileEntityAt( ((TETest)tileEntity), x, y, z, partialTick );
    }
}
