package abo;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;
//import java.util.logging.Logger;

import abo.utils.ABOConfig;
import abo.utils.Log;
import buildcraft.lib.registry.CreativeTabManager;
import buildcraft.lib.registry.CreativeTabManager.CreativeTabBC;

@Mod(modid = ABO.MODID, name = ABO.NAME, dependencies = "required-after:buildcrafttransport@[7.99.13,);required-after:buildcraftsilicon;required-after:buildcraftfactory", version = ABO.VERSION)
public class ABO
{
    public static final String MODID = "adbcobj";
    public static final String NAME = "Additional Buildcraft Objects";
    public static final String VERSION = "1.0";
    //#public static final String DEPEND = "required-after:BuildCraft|Transport;required-after:BuildCraft|Energy;required-after:BuildCraft|Silicon;required-after:BuildCraft|Factory;required-after:BuildCraft|Builders;after:BuildCraft|Robotics";
    @Instance(MODID)
    public static ABO instance;
    public CreativeTabBC creativeTab;
    public File configFile;
    
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	Log.info("Mod Loading");
    	//Make config (buildcraft required config file)
    	configFile = event.getSuggestedConfigurationFile();
    	ABOConfig.loadConfigs(configFile);
    	MinecraftForge.EVENT_BUS.register(this);
    	
    	//create buildcraft creative tab
        creativeTab = CreativeTabManager.createTab("abocreativetab");
        Log.info("Registering pipes");
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
