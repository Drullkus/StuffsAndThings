package com.drullkus.StuffsAndThings.Proxy;

import com.drullkus.StuffsAndThings.Renderer.RendererPlayerDetector;
import com.drullkus.StuffsAndThings.Renderer.RendererGlowingBlock;
import com.drullkus.StuffsAndThings.Tile.TileEntityPlayerDetector;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ClientProxy extends CommonProxy {

    public static int renderBlockGlow;

    @Override
    public void registerTileEntities() {

    }

    @Override
    public void preInit()
    {
        registerRenderers();
    }

    @Override
    public void init() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPlayerDetector.class, new RendererPlayerDetector());
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
        renderBlockGlow = RenderingRegistry.getNextAvailableRenderId();

        RenderingRegistry.registerBlockHandler(renderBlockGlow, new RendererGlowingBlock());
    }
}
