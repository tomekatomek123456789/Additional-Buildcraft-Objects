/** 
 * Copyright (C) 2011 Flow86
 * 
 * AdditionalBuildcraftObjects is open-source.
 *
 * It is distributed under the terms of my Open Source License. 
 * It grants rights to read, modify, compile or run the code. 
 * It does *NOT* grant the right to redistribute this software or its 
 * modifications in any form, binary or source, except if expressively
 * granted by the copyright holder.
 */

package AdditionalBuildcraftObjects;

import net.minecraft.src.TileEntity;
import buildcraft.api.Orientations;
import buildcraft.api.Trigger;
import buildcraft.api.TriggerParameter;
import buildcraft.energy.Engine;
import buildcraft.energy.Engine.EnergyStage;
import buildcraft.energy.TileEngine;
import buildcraft.transport.ITriggerPipe;
import buildcraft.transport.Pipe;

/**
 * @author Flow86
 *
 */
public class TriggerEngineControl extends Trigger implements ITriggerPipe {

	public TriggerEngineControl(int id) {
		super(id);
	}

	private boolean checkEngine(TileEntity entity) {
		Engine engine = ((TileEngine) entity).engine;

		if (engine != null
				&& (engine.getEnergyStage() != EnergyStage.Blue && engine.getEnergyStage() != EnergyStage.Green))
			return false;

		return true;
	}

	@Override
	public String getTextureFile() {
		return ABO.triggerTexture;
	}

	@Override
	public int getIndexInTexture() {
		return 0 * 16 + 0;
	}

	@Override
	public String getDescription() {
		return "Engine Safe";
	}

	@Override
	public boolean isTriggerActive(TileEntity tile, TriggerParameter parameter) {

		if (tile instanceof TileEngine) {
			return checkEngine(tile);
		}

		return false;
	}

	@Override
	public boolean isTriggerActive(Pipe pipe, TriggerParameter parameter) {
		boolean result = true;

		for (Orientations o : Orientations.dirs()) {

			TileEntity entity = pipe.container.getTile(o);
			if (entity instanceof TileEngine) {
				if (!checkEngine(entity))
					result = false;
			}
		}

		return result;
	}
}