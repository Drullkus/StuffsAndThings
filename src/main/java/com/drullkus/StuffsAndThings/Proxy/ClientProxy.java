package com.drullkus.StuffsAndThings.Proxy;

import com.drullkus.StuffsAndThings.Blocks.TileBlockTest;
import com.drullkus.StuffsAndThings.Renderer.RendererTESRTest;
import com.drullkus.StuffsAndThings.Renderer.RendererTestBlock;
import com.drullkus.StuffsAndThings.Tile.TETest;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ClientProxy extends CommonProxy {

    public static int testRenderID;

    @Override
    public void registerTileEntities() {

    }

    @Override
    public void preInit()
    {

    }

    @Override
    public void init() {
        ClientRegistry.bindTileEntitySpecialRenderer(TETest.class, new RendererTESRTest());
    }

    @Override
    public EntityPlayer getClientPlayer() {
        return null;
    }

    @Override
    public World getClientWorld() {
        return null;
    }

    public void registerRenderers() {
        testRenderID = RenderingRegistry.getNextAvailableRenderId();

        RenderingRegistry.registerBlockHandler(testRenderID, new RendererTestBlock());
    }
}
