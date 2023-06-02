package salverz.progresstolevel.client;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.font.TextRenderer;

public class XPOverlay implements HudRenderCallback {
    public static int color = 0x0055FF55;

    @Override
    public void onHudRender(MatrixStack matrixStack, float tickDelta) {
        MinecraftClient client = MinecraftClient.getInstance();
        int x = 0;
        int y = 0;

        if (client != null) {
            int width = client.getWindow().getScaledWidth();
            int height = client.getWindow().getScaledHeight();
            x = width / 2;
            y = height;
        }

        String percentToThirty = Double.toString(Math.round((1.0 * XPCalculations.getCurrentXp() / 1395) * 10000) / 100.0);
        TextRenderer renderer = client.textRenderer;

        long time = client.world.getTime();
//        renderer.drawWithShadow(matrixStack, Long.toString(time), x + 93, y - 20 , color);
        renderer.drawWithShadow(matrixStack, percentToThirty + "%", x + 93, y - 30 , color);

//        if (lastXp != totalXp) {
//            lastXp = totalXp;
//            int ticksRemaining = 40;
//        }

////         If xp has been gained
//        if (lastXp != totalXp) {
//            lastXp = totalXp;
//            long startTime = client.world.getTime();
//            long finishTime = startTime + 40;
//            long currentTime = startTime;
//            long lastTime = currentTime - 1;
//
//            int alpha = 0x0055FF55;
//            while (finishTime > currentTime) {
//                currentTime = client.world.getTime();
//                if (currentTime > lastTime) {
//                    lastTime = currentTime;
//                    System.out.println("current time is: " + currentTime);
//                }
//            }
//        } else {
//            renderer.drawWithShadow(matrixStack, percentToThirty + "%", x + 93, y - 31 , 0x6655FF55);
//        }
    }
}
