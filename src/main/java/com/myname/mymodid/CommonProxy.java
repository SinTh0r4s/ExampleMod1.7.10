package com.myname.mymodid;

import cpw.mods.fml.common.event.*;
import net.minecraft.block.material.Material;
import net.minecraft.client.gui.GuiScreenBook;
import net.minecraft.init.Blocks;

public class CommonProxy {

    // preInit "Run before anything else. Read your config, create blocks, items,
    // etc, and register them with the GameRegistry."
    public void preInit(FMLPreInitializationEvent event) 	{
        Config.syncronizeConfiguration(event.getSuggestedConfigurationFile());
        
        MyMod.info(Config.greeting);
        MyMod.info("I am " + Tags.MODNAME + " at version " + Tags.VERSION + " and group name " + Tags.GROUPNAME);
    }

    // load "Do your mod setup. Build whatever data structures you care about. Register recipes."
    public void init(FMLInitializationEvent event) {

    }

    // postInit "Handle interaction with other mods, complete your setup based on this."
    public void postInit(FMLPostInitializationEvent event) {
        // Access originally package-private subclass
        GuiScreenBook.NextPageButton button = null;

        // Access originally private field
        Material air = Blocks.air.blockMaterial;

        // Access originally protected method
        Blocks.air.disableStats();
    }

    public void serverAboutToStart(FMLServerAboutToStartEvent event) {

    }

    // register server commands in this event handler
    public void serverStarting(FMLServerStartingEvent event) {

    }

    public void serverStarted(FMLServerStartedEvent event) {

    }

    public void serverStopping(FMLServerStoppingEvent event) {

    }

    public void serverStopped(FMLServerStoppedEvent event) {

    }
}