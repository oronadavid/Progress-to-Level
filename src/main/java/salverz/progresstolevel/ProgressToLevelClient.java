package salverz.progresstolevel;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import salverz.progresstolevel.client.TickEndHandler;
import salverz.progresstolevel.client.XPOverlay;

public class ProgressToLevelClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        HudRenderCallback.EVENT.register(new XPOverlay());
        ClientTickEvents.END_CLIENT_TICK.register(new TickEndHandler());
    }
}
