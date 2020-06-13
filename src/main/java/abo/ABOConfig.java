package abo;

import java.io.File;

import abo.utils.Log;
import buildcraft.lib.registry.RegistryConfig;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;


public class ABOConfig
{	
	
	public static boolean enableDebugLog;

	
	//set from config
	public static boolean filterRightclicks = false;

	
	public static void loadConfigs(File configFile)
	{
		Configuration config = new Configuration(configFile);
		try 
		{
			config.load();
						
			
			Property filterRightclicksProperty = config.get(Configuration.CATEGORY_GENERAL, "filterRightclicks", false);
			filterRightclicksProperty.setComment("When right clicking on something with a gui, do not show the gui if you have a pipe in your hand");
			filterRightclicks = filterRightclicksProperty.getBoolean();
			
			Property enableDebugLogProperty = config.get(Configuration.CATEGORY_GENERAL, "enableDebugLog", false);
			enableDebugLogProperty.setComment("Enable debug logging for development");
			enableDebugLog = enableDebugLogProperty.getBoolean();
			
			
		} 
		catch(Exception e)
		{
			Log.error("Error loading Additional Pipes configs." + e);
		}
		finally
		{
			config.save();
			
			// tell Buildcraft that this is our configuration file
			RegistryConfig.setRegistryConfig(ABO.MODID, config);
		}
	}

}
