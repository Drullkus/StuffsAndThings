package com.drullkus.StuffsAndThings.Blocks;

import com.drullkus.StuffsAndThings.Tile.TileEntityPlayerDetector;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPlayerDetector extends BlockTest implements ITileEntityProvider {

    protected BlockPlayerDetector(Material material, String texture, IIcon backGround) {
        super(material, texture, backGround);
    }

    protected BlockPlayerDetector(Material material, String texture, String backGround) {
        super(material, texture, backGround);
    }

    @Override
    public boolean hasTileEntity(int metadata)
    {
        return true;
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack)
    {
        TileEntityPlayerDetector te = (TileEntityPlayerDetector)world.getTileEntity(x, y, z);
        if (entity instanceof EntityPlayer)
        {
            te.setPlayerName(entity.getCommandSenderName());
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
        TileEntity te = blockAccess.getTileEntity(x, y, z);

        System.out.println(x + ", " + y + ", " + z + " is being checked!");

        if (te instanceof TileEntityPlayerDetector)
        {
            if (((TileEntityPlayerDetector)te).getRSState())
            {
                return 10;
            }
        }

        return 0;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {
        return new TileEntityPlayerDetector();
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
