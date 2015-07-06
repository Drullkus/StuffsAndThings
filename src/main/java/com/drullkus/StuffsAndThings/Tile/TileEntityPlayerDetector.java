package com.drullkus.StuffsAndThings.Tile;

import com.drullkus.StuffsAndThings.Blocks.ModBlocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityPlayerDetector extends TileEntity {

    public String playerName = "";
    public boolean RSState = false;
    int tick = 0;

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
                }
            }
        }
        else
        {
            if (this.getRSState())
            {
                this.setRSState(false);
            }
        }

        tick++;

        if (tick > 10)
        {
            worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
            tick = 0;
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
            return "MHF_Alex"; // See http://minecraft.gamepedia.com/Mob_head#Mojang_skins
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
