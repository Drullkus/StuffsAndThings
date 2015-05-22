package com.drullkus.StuffsAndThings.Tile;

import com.drullkus.StuffsAndThings.Blocks.ModBlocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TETest extends TileEntity {

    public String playerName = "";
    public boolean RSState = false;

    @Override
    public void updateEntity()
    {
        if (worldObj.getPlayerEntityByName(this.getPlayerName()) != null)
        {
            if (worldObj.getPlayerEntityByName(this.getPlayerName()).getCommandSenderName().equals(this.getPlayerName()))
            {
                //System.out.println("Your name /IS/ " + playerName);

                if (!this.getRSState())
                {
                    this.setRSState(true);
                    worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
                }
            }
            else
            {
                //System.out.println("Your name is not " + playerName);

                if (this.getRSState())
                {
                    this.setRSState(false);
                    worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
                }
            }
        }
        else
        {
            if (this.getRSState())
            {
                this.setRSState(false);
                worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
            }
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound tag)
    {
        super.readFromNBT(tag);
        playerName = tag.getString("OwnerID");
        RSState = tag.getBoolean("RedstoneState");
    }

    @Override
    public void writeToNBT(NBTTagCompound tag)
    {
        super.writeToNBT(tag);
        tag.setString("OwnerID", playerName);
        tag.setBoolean("RedstoneState", RSState);
    }

    public void setPlayerName(String name)
    {
        playerName = name;
    }

    public String getPlayerName()
    {
        if (!playerName.isEmpty())
        {
            return playerName;
        }
        else
        {
            return "doDa";
        }
    }

    public boolean getRSState()
    {
        return RSState;
    }

    public void setRSState(boolean newState)
    {
        RSState = newState;
    }
}
