package eu.skullproject.cosmetics;


import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class LayerCape
  implements LayerRenderer<AbstractClientPlayer>
{
	private final RenderPlayer playerRenderer;
	  private static final String __OBFID = "CL_00002425";
	  
	  public LayerCape(RenderPlayer p_i46123_1_)
	  {
	    this.playerRenderer = p_i46123_1_;
	  }
	  
	  public void doRenderLayer(AbstractClientPlayer entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
	  {
	    ResourceLocation rl = new ResourceLocation("capes/" + entitylivingbaseIn.getName());
	    if ((entitylivingbaseIn.hasPlayerInfo()) && (!entitylivingbaseIn.isInvisible()) && (entitylivingbaseIn.isWearing(EnumPlayerModelParts.CAPE)) && rl != null)
	    {
	      float f9 = 0.125F;
	      float f10 = 0.0F;
	      if (entitylivingbaseIn.isSneaking())
	      {
	        f9 = 0.1F;
	        f10 = 0.11F;
	      }
	      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
	      this.playerRenderer.bindTexture(rl);
	      GlStateManager.pushMatrix();
	      GlStateManager.translate(0.0F, f10, f9);
	      double d0 = entitylivingbaseIn.prevChasingPosX + (entitylivingbaseIn.chasingPosX - entitylivingbaseIn.prevChasingPosX) * partialTicks - (entitylivingbaseIn.prevPosX + (entitylivingbaseIn.posX - entitylivingbaseIn.prevPosX) * partialTicks);
	      double d1 = entitylivingbaseIn.prevChasingPosY + (entitylivingbaseIn.chasingPosY - entitylivingbaseIn.prevChasingPosY) * partialTicks - (entitylivingbaseIn.prevPosY + (entitylivingbaseIn.posY - entitylivingbaseIn.prevPosY) * partialTicks);
	      double d2 = entitylivingbaseIn.prevChasingPosZ + (entitylivingbaseIn.chasingPosZ - entitylivingbaseIn.prevChasingPosZ) * partialTicks - (entitylivingbaseIn.prevPosZ + (entitylivingbaseIn.posZ - entitylivingbaseIn.prevPosZ) * partialTicks);
	      float f = entitylivingbaseIn.prevRenderYawOffset + (entitylivingbaseIn.renderYawOffset - entitylivingbaseIn.prevRenderYawOffset) * partialTicks;
	      double d3 = MathHelper.sin(f * 0.017453292F);
	      double d4 = -MathHelper.cos(f * 0.017453292F);
	      float f1 = (float)d1 * 10.0F;
	      f1 = MathHelper.clamp_float(f1, -6.0F, 32.0F);
	      float f2 = (float)(d0 * d3 + d2 * d4) * 100.0F;
	      float f3 = (float)(d0 * d4 - d2 * d3) * 100.0F;
	      if (f2 < 0.0F) {
	        f2 = 0.0F;
	      }
	      float f4 = entitylivingbaseIn.prevCameraYaw + (entitylivingbaseIn.cameraYaw - entitylivingbaseIn.prevCameraYaw) * partialTicks;
	      f1 += MathHelper.sin((entitylivingbaseIn.prevDistanceWalkedModified + (entitylivingbaseIn.distanceWalkedModified - entitylivingbaseIn.prevDistanceWalkedModified) * partialTicks) * 6.0F) * 32.0F * f4;
	      if (entitylivingbaseIn.isSneaking()) {
	        f1 += 20.0F;
	      }
	      GlStateManager.rotate(5.0F + f2 / 2.0F + f1, 1.0F, 0.0F, 0.0F);
	      GlStateManager.rotate(f3 / 2.0F, 0.0F, 0.0F, 1.0F);
	      GlStateManager.rotate(-f3 / 2.0F, 0.0F, 1.0F, 0.0F);
	      GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
	      this.playerRenderer.getMainModel().renderCape(0.0625F);
	      GlStateManager.popMatrix();
	    }
	  }
	  
	  public boolean shouldCombineTextures()
	  {
	    return false;
	  }
	  
	}