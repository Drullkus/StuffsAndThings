package com.drullkus.StuffsAndThings;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TETest extends TileEntity {

    public String playerName = "";

    @Override
    public void updateEntity()
    {
        if (worldObj.getPlayerEntityByName(this.getPlayerName()).getCommandSenderName() != null)
        {
            if (worldObj.getPlayerEntityByName(this.getPlayerName()).getCommandSenderName().equals(this.getPlayerName()))
            {

            }
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound tag)
    {
        super.readFromNBT(tag);
        playerName = tag.getString("OwnerID");
    }

    @Override
    public void writeToNBT(NBTTagCompound tag)
    {
        super.writeToNBT(tag);
    }

    public void setPlayerName(String name)
    {
        playerName = name;
    }

    public String getPlayerName()
    {
        if (playerName != null)
        {
            return playerName;
        }
        else
        {
            return "doDa";
        }
    }
}
