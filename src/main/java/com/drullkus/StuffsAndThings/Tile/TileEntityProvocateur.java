package com.drullkus.StuffsAndThings.Tile;

import com.drullkus.StuffsAndThings.Blocks.ModBlocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import thaumcraft.api.nodes.INode;
import thaumcraft.api.nodes.NodeType;

public class TileEntityProvocateur extends TileEntity {

    int origin;

    @Override
    public void updateEntity()
    {
    }

    @Override
    public void readFromNBT(NBTTagCompound tag)
    {
        super.readFromNBT(tag);
        origin = tag.getInteger("OriginType");
    }

    @Override
    public void writeToNBT(NBTTagCompound tag)
    {
        super.writeToNBT(tag);
        tag.setInteger("OriginType", origin);
    }

    public void setOriginType(NodeType type)
    {
        origin = type.ordinal();
    }

    public NodeType getOriginType()
    {
        return NodeType.values()[origin];
    }

    public boolean hasNode()
    {
        return worldObj.getTileEntity(xCoord, yCoord+1, zCoord) instanceof INode;
    }
}
