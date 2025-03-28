package powie.helensim;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudLayerRegistrationCallback;
import net.fabricmc.fabric.api.client.rendering.v1.IdentifiedLayer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HelenKellerSimulator implements ModInitializer {
	public static final String MOD_ID = "helen-keller-simulator";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	private static final Identifier KELLER_LAYER = Identifier.of(MOD_ID, "hud-keller-layer");
	private static final MinecraftClient client = MinecraftClient.getInstance();


	@Override
	public void onInitialize() {
		LOGGER.info("Loading Helen Keller Simulator");
		HudLayerRegistrationCallback.EVENT.register(layeredDrawer -> layeredDrawer.attachLayerBefore(IdentifiedLayer.MISC_OVERLAYS , KELLER_LAYER, HelenKellerSimulator::render));
	}

	private static void render(DrawContext context, RenderTickCounter tickCounter) {
		context.fill(0, 0, client.getWindow().getScaledWidth(), client.getWindow().getScaledHeight(), 1, 0xFF000000);
	}
}