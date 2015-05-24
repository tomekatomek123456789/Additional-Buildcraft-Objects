// Date: 5/29/2014 2:14:39 AM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX

package abo.render;

import buildcraft.core.lib.render.IInventoryRenderer;
import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import abo.ABO;
import abo.energy.TileWindmill;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import buildcraft.BuildCraftCore;
import buildcraft.BuildCraftCore.RenderMode;

public class RenderWindmill extends TileEntitySpecialRenderer implements IInventoryRenderer {
	// fields
	private ModelBase			Windmill	= new ModelBase() {};

	private ModelRenderer		Stand;
	private ModelRenderer		WingsY;
	private ModelRenderer		WingsZ;
	private ModelRenderer		Trunk;

	private ResourceLocation	texture;

	public RenderWindmill() {
		Stand = new ModelRenderer(Windmill, 0, 0);
		Stand.addBox(-2F, -13F, -2F, 4, 13, 4);
		Stand.setRotationPoint(0F, 24F, 0F);
		Stand.setTextureSize(64, 32);
		Trunk = new ModelRenderer(Windmill, 0, 0);
		Trunk.addBox(2F, -12F, -4F, 6, 8, 8);
		Trunk.setRotationPoint(0F, 24F, 0F);
		Trunk.setTextureSize(64, 32);
		WingsY = new ModelRenderer(Windmill, 16, 0);
		WingsY.addBox(-2, 0, -1, 2, 7, 1);
		WingsY.addBox(-2, -7, 0, 2, 7, 1);
		WingsY.setRotationPoint(-2F, 13F, 0F);
		WingsY.setTextureSize(64, 32);
		WingsZ = new ModelRenderer(Windmill, 22, 0);
		WingsZ.addBox(-2, 0, 0, 2, 1, 7);
		WingsZ.addBox(-2, -1, -7, 2, 1, 7);
		WingsZ.setRotationPoint(-2F, 13F, 0F);
		WingsZ.setTextureSize(64, 32);
		field_147501_a = TileEntityRendererDispatcher.instance;
		texture = new ResourceLocation("additional-buildcraft-objects:textures/blocks/windmill.png");
	}

	@Override
	public void inventoryRender(double x, double y, double z, float f, float f1) {
		render(0.25F, x, y, z, TileWindmill.TRUNK_BLUE_TEXTURE, -1, -1, -1);
	}

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {

		TileWindmill engine = (TileWindmill) tileentity;

		if (engine != null) {
			render(engine.animProgress, x, y, z, engine.getTrunkTexture(engine.getEnergyStage()), tileentity.xCoord,
					tileentity.yCoord, tileentity.zCoord);
		}
	}

	private void render(double progress, double x, double y, double z, ResourceLocation TrunkTexture, int xCoord,
			int yCoord, int zCoord) {

		if (BuildCraftCore.render == RenderMode.NoDynamic) { return; }

		GL11.glPushMatrix();
		GL11.glPushAttrib(GL11.GL_ENABLE_BIT);
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glColor3f(1, 1, 1);

		GL11.glTranslated(x + 0.5D,y + 1.5D,z + 0.5D);

		float factor = (float) (0.0625);

		Stand.rotateAngleX = 0; // (float) -Math.PI;
		Stand.rotateAngleY = 0;
		Stand.rotateAngleZ = 0;// (float) -Math.PI;

		WingsY.rotateAngleX = 0; // (float) -Math.PI;
		WingsY.rotateAngleY = 0;
		WingsY.rotateAngleZ = 0;// (float) -Math.PI;

		WingsZ.rotateAngleX = 0; // (float) -Math.PI;
		WingsZ.rotateAngleY = 0;
		WingsZ.rotateAngleZ = 0;// (float) -Math.PI;

		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);

		bindTexture(texture);
		Stand.render(factor);

		boolean inDist = true;
		try {
			if (!(xCoord == -1 && yCoord == -1 && zCoord == -1)) {
				EntityClientPlayerMP player = FMLClientHandler.instance().getClientPlayerEntity();
				double dist = (xCoord - player.posX) * (xCoord - player.posX) + (yCoord - player.posY)
						* (yCoord - player.posY) + (zCoord - player.posZ) * (zCoord - player.posZ);
				if (dist > ((double) ABO.windmillAnimDist * (double) ABO.windmillAnimDist)) inDist = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (ABO.windmillAnimations && inDist) {
			float step = (float) Math.toRadians(progress * 360);
			WingsY.rotateAngleX = step;
			WingsZ.rotateAngleX = step;
		}

		WingsY.render(factor);
		WingsZ.render(factor);

		bindTexture(TrunkTexture);
		Trunk.rotateAngleX = 0;
		Trunk.rotateAngleY = 0;
		Trunk.rotateAngleZ = 0;
		Trunk.render(factor);

		GL11.glPopMatrix();

		GL11.glPopAttrib();
		GL11.glPopMatrix();
	}

}
