package com.drullkus.StuffsAndThings.Blocks;

import com.drullkus.StuffsAndThings.Proxy.ClientProxy;
import com.drullkus.StuffsAndThings.StuffsAndThings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockGlow extends Block {

    protected String texturePath;
    protected String glowTexturePath;
    protected IIcon glowTexture;
    protected IIcon texture;

    protected BlockGlow(Material material, String texture, IIcon backGround) {
        super(material);
        texturePath = texture;
        glowTexture = backGround;
        setHardness(50);
        setResistance(9001);
    }

    protected BlockGlow(Material material, String texture, String backGround) {
        super(material);
        texturePath = texture;
        glowTexturePath = backGround;
        setHardness(50);
        setResistance(9001);
    }

    public IIcon getGlowTexture()
    {
        return glowTexture;
    }

    @Override
    public int getRenderType()
    {
        return ClientProxy.renderBlockGlow;
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

        glowTexture = icon.registerIcon(StuffsAndThings.MOD_ID + ":" + glowTexturePath);

        this.blockIcon = texture;
    }


}
