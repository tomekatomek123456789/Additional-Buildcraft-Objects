package abo.pipes.item;


import abo.pipes.ABOPipe;
import buildcraft.api.transport.pipe.IPipe;
import buildcraft.api.transport.pipe.PipeEventItem;
//import buildcraft.api.transport.pipe.PipeEventItem.ItemEntry;
//import buildcraft.transport.pipe.flow.TravellingItem;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.Mod.EventHandler;

public class CrossoverPipe extends ABOPipe {
	
	public CrossoverPipe(IPipe pipe, NBTTagCompound nbt) {
		super(pipe, nbt);
		// TODO Auto-generated constructor stub
	}
	public CrossoverPipe(IPipe pipe) {
		super(pipe);
		// TODO Auto-generated constructor stub
	}
	@EventHandler
	public void findDestEvent(PipeEventItem.FindDest event)
	{
		//List<ForgeDirection> result = event.destinations;
		//ImmutableList<ItemEntry> item = event.items;
		//List<ForgeDirection> list = new LinkedList<ForgeDirection>();

		//if (transport.inputOpen(item.input)) {
		//	list.add(item.input);
		//	result.clear();
		//	result.addAll(list);
		//}
	}
	



}
