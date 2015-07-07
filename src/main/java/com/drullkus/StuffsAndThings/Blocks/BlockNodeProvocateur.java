package com.drullkus.StuffsAndThings.Blocks;

import com.drullkus.StuffsAndThings.Tile.TileEntityProvocateur;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import thaumcraft.api.nodes.INode;
import thaumcraft.api.nodes.NodeType;
import thaumcraft.common.tiles.TileNode;

public class BlockNodeProvocateur extends BlockGlow implements ITileEntityProvider {

    protected BlockNodeProvocateur(Material material, String texture, IIcon background) {
        super(material, texture, background);
    }

    protected BlockNodeProvocateur(Material material, String texture, String background) {
        super(material, texture, background);
    }

    @Override
    public boolean hasTileEntity(int metadata)
    {
        return true;
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack)
    {
        if (y < 255)
        {
            if (world.getTileEntity(x, y+1, z) instanceof TileNode)
            {
                TileNode nodeTE = (TileNode)world.getTileEntity(x, y+1, z);
                TileEntityProvocateur nodeManipulator = (TileEntityProvocateur)world.getTileEntity(x, y, z);

                nodeManipulator.setOriginType(nodeTE.getNodeType());

                nodeTE.setNodeType(NodeType.HUNGRY);
            }
        }
    }

    /*@Override
    public void breakBlock(World world, int x, int y, int z, Block blockBroken, int meta)
    {
        if (y < 255)
        {
            if (world.getTileEntity(x, y+1, z) instanceof TileNode)
            {
                TileNode nodeTE = (TileNode)world.getTileEntity(x, y+1, z);
                TileEntityProvocateur nodeManipulator = (TileEntityProvocateur)world.getTileEntity(x, y, z);

                nodeTE.setNodeType(nodeManipulator.getOriginType());
            }
        }
    }*/

    @Override
    public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer player)
    {
        if (y < 255)
        {
            if (world.getTileEntity(x, y+1, z) instanceof TileNode)
            {
                TileNode nodeTE = (TileNode)world.getTileEntity(x, y+1, z);
                TileEntityProvocateur nodeManipulator = (TileEntityProvocateur)world.getTileEntity(x, y, z);

                nodeTE.setNodeType(nodeManipulator.getOriginType());
            }
        }
    }

    @Override
    public boolean canProvidePower()
    {
        return true;
    }

    @Override
    public int isProvidingStrongPower(IBlockAccess blockAccess, int x, int y, int z, int side)
    {
        return isProvidingWeakPower(blockAccess, x, y, z, side);
    }

    @Override
    public int isProvidingWeakPower(IBlockAccess blockAccess, int x, int y, int z, int side)
    {
        return 0;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {
        return new TileEntityProvocateur();
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public int getRenderType()
    {
        return -1;
    }
}
