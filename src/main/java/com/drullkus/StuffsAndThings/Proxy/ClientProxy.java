package com.drullkus.StuffsAndThings.Proxy;

import com.drullkus.StuffsAndThings.Renderer.CloudAnimFX;
import com.drullkus.StuffsAndThings.Renderer.RendererTestBlock;
import com.drullkus.StuffsAndThings.Renderer.TestingAnimFX;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ClientProxy extends CommonProxy {

    public static int testRenderID;

    /*@SideOnly(Side.CLIENT)
    public static IIcon cloudFX;*/

    @SideOnly(Side.CLIENT)
    public static IIcon testFX;

    @Override
    public void registerTileEntities() {

    }

    public void preInit()
    {
        //cloudFX = new CloudAnimFX(128).texture;
        testFX = new TestingAnimFX(64).texture;
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
