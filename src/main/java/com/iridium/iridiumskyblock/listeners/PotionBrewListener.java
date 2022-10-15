package com.iridium.iridiumskyblock.listeners;

import com.iridium.iridiumskyblock.IridiumSkyblock;
import com.iridium.iridiumskyblock.database.Island;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.BrewEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;

import java.util.Optional;

public class PotionBrewListener implements Listener {

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void monitorPotionBrew(BrewEvent event) {
        // Delay the check so the new potion is checked
        Bukkit.getScheduler().scheduleSyncDelayedTask(IridiumSkyblock.getInstance(), () -> {

            for (int i = 0; i < 3; i++) {
                ItemStack itemStack = event.getContents().getItem(i);
                if (itemStack != null && itemStack.getItemMeta() instanceof PotionMeta) {
                }
            }
        });
    }

}
