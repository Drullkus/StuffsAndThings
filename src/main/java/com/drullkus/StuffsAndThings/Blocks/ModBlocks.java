package com.drullkus.StuffsAndThings.Blocks;

import com.drullkus.StuffsAndThings.Tile.TileEntityProvocateur;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {

    public static Block blockSturdy, blockNodeManipulator;
    
    public static void preInit() {
        blockSturdy = new BlockGlow(Material.rock, "aTexture", "purpleThingAnim").setBlockName("sturdy");
        blockNodeManipulator = new BlockNodeProvocateur(Material.rock, "aTexture", "purpleThingAnim").setBlockName("nodeManipulator");

        GameRegistry.registerBlock(blockSturdy, "sturdyBlock");
        GameRegistry.registerBlock(blockNodeManipulator, "nodeManipulator");
        GameRegistry.registerTileEntity(TileEntityProvocateur.class, "nodeManipulator");
    }

    public static void init() {

    }
}
