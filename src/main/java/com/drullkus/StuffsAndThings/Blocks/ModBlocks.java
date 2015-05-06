package com.drullkus.StuffsAndThings.Blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {

    public static Block blockSturdy;
    
    public static void preInit() {
        blockSturdy = new BlockTest(Material.rock, "aTexture", "aTexture").setBlockName("sturdy");

        GameRegistry.registerBlock(blockSturdy, "sturdyBlock");
    }

    public static void init() {

    }
}
