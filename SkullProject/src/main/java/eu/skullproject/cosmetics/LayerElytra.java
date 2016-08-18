package eu.skullproject.cosmetics;

import com.typesafe.config.Config;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.LayerArmorBase;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class LayerElytra implements LayerRenderer<AbstractClientPlayer>
	{
	    /** The basic Elytra texture. */
	    private static final ResourceLocation TEXTURE_ELYTRA = new ResourceLocation("textures/entity/elytra.png");

	    /** Instance of the player renderer. */
	    private final RenderPlayer renderPlayer;

	    /** The model used by the Elytra. */
	    private final ModelElytra modelElytra = new ModelElytra();

	    public LayerElytra(RenderPlayer renderPlayerIn)
	    {
	        this.renderPlayer = renderPlayerIn;
	    }

	    public void doRenderLayer(AbstractClientPlayer entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
	    {

	            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
	            GlStateManager.enableBlend();

                if (entitylivingbaseIn.getName().equals("UUUUUUUUU") && entitylivingbaseIn.hasPlayerInfo() && entitylivingbaseIn.getLocationCape() != null && entitylivingbaseIn.isWearing(EnumPlayerModelParts.CAPE))
	            {
	                this.renderPlayer.bindTexture(entitylivingbaseIn.getLocationCape());
	            }
	            else
	            {
	                ResourceLocation resourcelocation = TEXTURE_ELYTRA;



	                this.renderPlayer.bindTexture(resourcelocation);
	            }

	            GlStateManager.pushMatrix();
	            GlStateManager.translate(0.0F, 0.0F, 0.125F);
	            this.modelElytra.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entitylivingbaseIn);
	            this.modelElytra.render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);


	            GlStateManager.popMatrix();
	        }

	    public boolean shouldCombineTextures()
	    {
	        return false;
	    }
	}

