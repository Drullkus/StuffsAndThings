package com.drullkus.StuffsAndThings;

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
                System.out.println("Your name /IS/ " + playerName);

                if (this.getRSState())
                {
                    this.setRSState(true);
                    worldObj.notifyBlockChange(xCoord, yCoord, zCoord, ModBlocks.blockModel);
                }
            }
            else
            {
                System.out.println("Your name is not " + playerName);

                if (!this.getRSState())
                {
                    this.setRSState(false);
                    worldObj.notifyBlockChange(xCoord, yCoord, zCoord, ModBlocks.blockModel);
                }
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
        if (playerName != null)
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
