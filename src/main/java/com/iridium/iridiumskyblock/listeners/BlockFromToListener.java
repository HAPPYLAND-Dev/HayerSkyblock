package com.iridium.iridiumskyblock.listeners;

import com.iridium.iridiumskyblock.IridiumSkyblock;
import com.iridium.iridiumskyblock.SettingType;
import com.iridium.iridiumskyblock.database.IslandSetting;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;

public class BlockFromToListener implements Listener {

    @EventHandler
    public void onBlockFromTo(BlockFromToEvent event) {
        var island = IridiumSkyblock.getInstance().getIslandManager().getIslandViaLocation(event.getToBlock().getLocation());
        if (island.isPresent()) {
            if (event.getBlock().getType() == Material.WATER || event.getBlock().getType() == Material.LAVA) {
                if(!island.get().isInIsland(event.getToBlock().getLocation())){
                    event.setCancelled(true);
                }
                IslandSetting liquidFlowSettings = IridiumSkyblock.getInstance().getIslandManager().getIslandSetting(island.get(), SettingType.LIQUID_FLOW);
                if (!liquidFlowSettings.getBooleanValue()) {
                    event.setCancelled(true);
                }
            }
        }
    }

}
