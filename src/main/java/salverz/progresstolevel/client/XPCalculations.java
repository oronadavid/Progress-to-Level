package salverz.progresstolevel.client;

import net.minecraft.client.MinecraftClient;

public class XPCalculations {
   static MinecraftClient client = MinecraftClient.getInstance();

    protected static int getCurrentXp() {
        int xpLevel = client.player.experienceLevel;
        int totalLevelXp = totalExperienceAtLevel(xpLevel - 1);
        float xpProgress = client.player.experienceProgress;
        int totalProgressXp = Math.round(xpProgress * client.player.getNextLevelExperience());
        return totalLevelXp + totalProgressXp;
    }

    private static int totalExperienceAtLevel(int level) {
        if (level >= 30) {
            return totalExperienceAtLevel(level - 1) + (112 + (level - 20) * 9);
        }
        if (level >= 15) {
            return totalExperienceAtLevel(level - 1) + (37 + (level - 15) * 5);
        }
        if (level >= 0) {
            return totalExperienceAtLevel(level - 1) + (7 + level * 2);
        }
        return 0;
    }
}
