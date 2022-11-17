package com.iridium.iridiumskyblock.listeners;

import com.iridium.iridiumskyblock.api.IridiumSkyblockAPI;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

public class PlayerFishListener implements Listener {

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void monitorPlayerFish(PlayerFishEvent event) {
        if (!IridiumSkyblockAPI.getInstance().isIslandWorld(event.getPlayer().getWorld())) return;

        Entity caughtEntity = event.getCaught();
        if (caughtEntity == null || event.getState() != PlayerFishEvent.State.CAUGHT_FISH);

    }

}
