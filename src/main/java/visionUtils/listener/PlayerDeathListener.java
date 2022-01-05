package visionUtils.listener;

import org.bukkit.entity.Pose;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import visionUtils.Plugin;
import visionUtils.npc.Corp;
import visionUtils.npc.VisionNPC;

import java.util.Arrays;

public class PlayerDeathListener implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {

        // Erstelle Leiche
        Plugin.getCorpManager().spawnCorp(
                event.getEntity(),
                System.currentTimeMillis(),
                Arrays.stream(event.getEntity().getInventory().getContents())
                        .filter(item -> item != null).toArray(ItemStack[]::new));

        event.getDrops().clear();

        /*
        * CUSTOM DEATH MESSAGES
        * */


    }
}
