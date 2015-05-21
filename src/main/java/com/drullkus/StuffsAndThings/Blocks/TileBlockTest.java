package com.drullkus.StuffsAndThings.Blocks;

import com.drullkus.StuffsAndThings.Proxy.ClientProxy;
import com.drullkus.StuffsAndThings.StuffsAndThings;
import com.drullkus.StuffsAndThings.TETest;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class TileBlockTest extends BlockTest {


    protected TileBlockTest(Material material, String texture, IIcon backGround) {
        super(material, texture, backGround);
    }

    protected TileBlockTest(Material material, String texture, String backGround) {
        super(material, texture, backGround);
    }

    @Override
    public TileEntity createTileEntity(World world, int metadata)
    {
        return new TETest();
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack)
    {

    }
}
