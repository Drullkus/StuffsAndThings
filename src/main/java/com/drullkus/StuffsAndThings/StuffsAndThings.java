package com.drullkus.StuffsAndThings;

import com.drullkus.StuffsAndThings.Blocks.ModBlocks;
import com.drullkus.StuffsAndThings.Proxy.ClientProxy;
import com.drullkus.StuffsAndThings.Proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import java.util.logging.Logger;

@Mod(modid = StuffsAndThings.MOD_ID, name = StuffsAndThings.MOD_NAME, version = StuffsAndThings.VERSION, dependencies = "after:ForgeMultipart;")
public class StuffsAndThings {

    public static final String MOD_ID = "stuffsandthings";
    public static final String MOD_NAME = "StuffsAndThings";
    public static final String VERSION = "@VERSION@";

    @Mod.Instance
    public static StuffsAndThings INSTANCE;
    public static Logger logger = Logger.getLogger(MOD_ID);

    @SidedProxy(clientSide = "com.drullkus.StuffsAndThings.Proxy.ClientProxy",
                serverSide = "com.drullkus.StuffsAndThings.Proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit();
        ModBlocks.preInit();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init();
        ModBlocks.init();
    }
}
