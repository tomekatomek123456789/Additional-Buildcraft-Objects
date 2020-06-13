package abo.gui;

import abo.utils.Log;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class ABOGuiHandler implements IGuiHandler {
	// Gui IDs
	public static final int PIPE_TP = 1;


	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tile = world.getTileEntity(new BlockPos(x, y, z));
		if(tile == null) {
			return null;
		}
		
		Log.debug("Opening Container " + ID + " on the server");
		
		switch(ID) {
		case PIPE_TP:
			//return new ContainerTeleportPipe(player, (PipeBehaviorTeleport) ((TilePipeHolder) tile).getPipe().getBehaviour());
			return null;
		default:
			return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tile = world.getTileEntity(new BlockPos(x, y, z));
		if(tile == null) {
			return null;
		}
		
		Log.debug("Opening GUI " + ID + " on the client");
		
		switch(ID)
		{
		case PIPE_TP:
			//return new GuiTeleportPipe(player, ((PipeBehaviorTeleport)((TilePipeHolder) tile).getPipe().getBehaviour()));
			return null;
		default:
			return null;
		}
	}
}
