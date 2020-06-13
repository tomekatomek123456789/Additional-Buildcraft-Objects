package abo.utils;

import abo.ABO;
import buildcraft.api.transport.pipe.PipeDefinition;
import buildcraft.lib.registry.RegistrationHelper;
import buildcraft.transport.item.ItemPipeHolder;

public class PipeCreator
{

	// saves items during preInit, then registers them during the RegisterEvent
    private static final RegistrationHelper regHelper = new RegistrationHelper();
    

	/**
	 * Creates and registers a buildcraft pipe from the provided definition.
	 * @param clas
	 * @return
	 */
	public static ItemPipeHolder createPipeItem(PipeDefinition pipeDef)
	{		
		ItemPipeHolder item = ItemPipeHolder.create(pipeDef);
		item.setRegistryName(pipeDef.identifier.getResourcePath());
		item.setUnlocalizedName("pipe.adbcobj." + pipeDef.identifier.getResourcePath());
		item.registerWithPipeApi();
		item.setCreativeTab(ABO.instance.creativeTab);
		
		regHelper.addItem(item);
		
		return item;
	}
}