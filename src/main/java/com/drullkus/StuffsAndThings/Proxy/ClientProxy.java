package com.drullkus.StuffsAndThings.Proxy;

import com.drullkus.StuffsAndThings.Renderer.RendererTestBlock;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ClientProxy extends CommonProxy {

    public static int testRenderID;

    @Override
    public void registerTileEntities() {

    }

    public void preInit()
    {

    }

    @Override
    public void init() {

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
