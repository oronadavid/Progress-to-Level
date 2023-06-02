package salverz.progresstolevel.client;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;

public class TickEndHandler implements ClientTickEvents.EndTick {
    static final int FADE_TIME = 10; // length of fade-in/out in ticks
    static final int DISPLAY_TIME = 50; // length text stays at full brightness in ticks

    static int lastXp;
    static int currentXp;
    static long endTime = 0;
    static int color_change  = (255 / FADE_TIME) * 0x01000000;

    @Override
    public void onEndTick(MinecraftClient client) {
        if (client.world == null) {
            return;
        }

        long time = client.world.getTime();
        if (endTime > time) {
            if (endTime - time >= DISPLAY_TIME) {
                XPOverlay.changeColor(color_change);
            } else if (endTime - time <= FADE_TIME) {
                XPOverlay.changeColor(-color_change);
            }
        }

        currentXp = XPCalculations.getCurrentXp();
        if (currentXp != lastXp && !client.player.isCreative()) {
            XPOverlay.setPercent(XPCalculations.getPercent());
            if (endTime > client.world.getTime()) {
                endTime = client.world.getTime() + DISPLAY_TIME;
                XPOverlay.setColor(0xFF55FF55);
            } else {
                endTime = client.world.getTime() + DISPLAY_TIME + FADE_TIME;
                XPOverlay.setColor(0x0455FF55);
            }
        }
        lastXp = XPCalculations.getCurrentXp();
    }
}
