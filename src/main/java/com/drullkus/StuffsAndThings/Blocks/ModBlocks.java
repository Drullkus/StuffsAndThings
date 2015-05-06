package com.drullkus.StuffsAndThings.Blocks;

import com.drullkus.StuffsAndThings.Proxy.ClientProxy;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {

    public static Block blockSturdy;
    public static Block blockXything;
    
    public static void preInit() {
        blockSturdy = new BlockTest(Material.rock, "aTexture", ClientProxy.testFX).setBlockName("sturdy");
        //blockXything = new BlockTest(Material.rock, "aTexture", ClientProxy.cloudFX).setBlockName("xything");

        GameRegistry.registerBlock(blockSturdy, "sturdyBlock");
        //GameRegistry.registerBlock(blockXything, "xyThingBlock");
    }

    public static void init() {

    }
}
