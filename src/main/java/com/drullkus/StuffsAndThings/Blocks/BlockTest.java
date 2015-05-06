package com.drullkus.StuffsAndThings.Blocks;

import com.drullkus.StuffsAndThings.Proxy.ClientProxy;
import com.drullkus.StuffsAndThings.StuffsAndThings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockTest extends Block {

    private String glowTexturePath;
    private String texturePath;
    private IIcon glowTexture;
    private IIcon texture;

    protected BlockTest(Material material, String texture, String backGround) {
        super(material);
        texturePath = texture;
        glowTexturePath = backGround;
    }

    public IIcon getGlowTexture()
    {
        return glowTexture;
    }

    @Override
    public int getRenderType()
    {
        return ClientProxy.testRenderID;
    }

    @Override
    public IIcon getIcon(int side, int meta)
    {
        if (side == 1)
        {
            return blockIcon;
        }
        return glowTexture;
    }

    @Override
    public void registerBlockIcons(IIconRegister icon)
    {
        texture = icon.registerIcon(StuffsAndThings.MOD_ID + ":" + texturePath);

        glowTexture = ClientProxy.testFX;

        this.blockIcon = texture;
    }
}
