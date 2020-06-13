package abo;

import abo.pipes.item.CrossoverPipe;
import abo.utils.PipeCreator;
import buildcraft.api.transport.pipe.PipeDefinition;
import buildcraft.api.transport.pipe.PipeDefinition.PipeDefinitionBuilder;
import net.minecraft.item.Item;

public class ABOPipesDefs {
	
	//Crossover Pipe
	public static Item crossoverPipeItem;
	public static PipeDefinition crossoverPipeDef;
	
	
	public static void createPipes()
	{
		crossoverPipeDef = new PipeDefinitionBuilder().flowItem().idTexPrefix("pipe_items_addition").logic(CrossoverPipe::new, CrossoverPipe::new).define();
		crossoverPipeItem = PipeCreator.createPipeItem(crossoverPipeDef);
	}

}
