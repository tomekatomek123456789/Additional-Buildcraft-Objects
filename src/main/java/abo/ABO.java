package abo;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

import org.apache.logging.log4j.Logger;

import buildcraft.lib.registry.CreativeTabManager;
import buildcraft.lib.registry.CreativeTabManager.CreativeTabBC;

@Mod(modid = ABO.MODID, name = ABO.NAME, version = ABO.VERSION, dependencies = ABO.DEPEND, useMetadata = true)
public class ABO
{
    public static final String MODID = "Additional-Buildcraft-Objects";
    public static final String NAME = "Additional-Buildcraft-Objects";
    public static final String VERSION = "1.0";
    public static final String DEPEND = "required-after:BuildCraft|Transport;required-after:BuildCraft|Energy;required-after:BuildCraft|Silicon;required-after:BuildCraft|Factory;required-after:BuildCraft|Builders;after:BuildCraft|Robotics";

    public static ABO instance;
    public CreativeTabBC creativeTab;
    //private static Logger logger;
    public File configFile;
    
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        //logger = event.getModLog();
        creativeTab = CreativeTabManager.createTab("abocreativetab");
        ABOPipesDefs.createPipes();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        //logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
        creativeTab.setItem(new ItemStack(ABOPipesDefs.crossoverPipeItem));
    }
}
