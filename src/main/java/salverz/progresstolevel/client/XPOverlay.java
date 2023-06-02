package salverz.progresstolevel.client;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.font.TextRenderer;

public class XPOverlay implements HudRenderCallback {
    private static int color = 0x0455FF55;
    private static String percent;
    private static MinecraftClient client = MinecraftClient.getInstance();
    private static TextRenderer renderer;

    @Override
    public void onHudRender(MatrixStack matrixStack, float tickDelta) {
        if (renderer == null) {
            renderer = client.textRenderer;
        }

        if (client != null) {
            int width = client.getWindow().getScaledWidth();
            int height = client.getWindow().getScaledHeight();
            int x = width / 2;
            int y = height;
            renderer.drawWithShadow(matrixStack, percent, x + 93, y - 30 , color);
        }
    }

    public static void changeColor(int colorChange) {
        color += colorChange;
    }

    public static void setColor(int newColor) {
        color = newColor;
    }

    public static void setPercent(String newPercent) {
        percent = newPercent;
    }
}
