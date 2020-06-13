package abo.utils;

import java.io.File;

import abo.ABO;
import buildcraft.lib.registry.RegistryConfig;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class ABOConfig {
	
	public static boolean enableDebugLog;
	

	
	public static void loadConfigs(File configFile)
	{
		Configuration config = new Configuration(configFile);
		try 
		{
			config.load();
						
			
			Property enableDebugLogProperty = config.get(Configuration.CATEGORY_GENERAL, "enableDebugLog", false);
			enableDebugLogProperty.setComment("Enable debug logging for development");
			enableDebugLog = enableDebugLogProperty.getBoolean();
			
		} 
		catch(Exception e)
		{
			Log.error("Error loading Additional Buildcraft Objects configs." + e);
		}
		finally
		{
			config.save();
			
			// tell Buildcraft that this is our configuration file
			RegistryConfig.setRegistryConfig(ABO.MODID, config);
		}
	}

	

}
