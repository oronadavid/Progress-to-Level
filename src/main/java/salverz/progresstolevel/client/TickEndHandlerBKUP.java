//package salverz.progresstolevel.client;
//
//import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
//import net.minecraft.client.MinecraftClient;
//
//public class TickEndHandlerBKUP implements ClientTickEvents.EndTick {
//    static int lastXp;
//    static int currentXp;
//    static long endTime = 0;
//    static int FADE_TIME = 10; // length of fade-in/out in ticks
//    static int DISPLAY_TIME = 50; // length text stays at full brightness in ticks
//    static int color_change  = 255 / FADE_TIME;
//
//    @Override
//    public void onEndTick(MinecraftClient client) {
//        if (client.world == null) {
//            return;
//        }
//        long time = client.world.getTime();
//        if (endTime > time) {
//            if (endTime - time >= 50) {
//                XPOverlay.color += 0x18000000;
//            } else if (endTime - time <= 10) {
//                XPOverlay.color -= 0x18000000;
//            }
//        }
//
//        currentXp = XPCalculations.getCurrentXp();
//        if (currentXp != lastXp) {
//            System.out.println("xp updated");
//            if (endTime > client.world.getTime()) {
//                System.out.println("ANIMATION IN PROGRESS");
//                endTime = client.world.getTime() + 50;
//                XPOverlay.color = 0xFF55FF55;
//            } else {
//                endTime = client.world.getTime() + 60;
//                XPOverlay.color = 0x0D55FF55;
//            }
//
//        }
//        lastXp = XPCalculations.getCurrentXp();
//    }
//}
