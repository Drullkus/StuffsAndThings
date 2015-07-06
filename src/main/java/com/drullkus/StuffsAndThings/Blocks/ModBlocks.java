package com.drullkus.StuffsAndThings.Blocks;

import com.drullkus.StuffsAndThings.Tile.TileEntityPlayerDetector;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {

    public static Block blockSturdy, blockModel;
    
    public static void preInit() {
        blockSturdy = new BlockTest(Material.rock, "aTexture", "purpleThingAnim").setBlockName("sturdy");
        blockModel = new BlockPlayerDetector(Material.rock, "aTexture", "purpleThingAnim").setBlockName("modelThing");

        GameRegistry.registerBlock(blockSturdy, "sturdyBlock");
        GameRegistry.registerBlock(blockModel, "coolThing");
        GameRegistry.registerTileEntity(TileEntityPlayerDetector.class, "coolThing");
    }

    public static void init() {

    }
}
