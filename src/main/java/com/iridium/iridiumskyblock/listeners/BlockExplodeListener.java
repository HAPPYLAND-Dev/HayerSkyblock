package com.iridium.iridiumskyblock.listeners;

import com.iridium.iridiumcore.dependencies.xseries.XMaterial;
import com.iridium.iridiumskyblock.IridiumSkyblock;
import com.iridium.iridiumskyblock.SettingType;
import com.iridium.iridiumskyblock.database.IslandBlocks;
import com.iridium.iridiumskyblock.database.IslandSetting;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockExplodeEvent;

public class BlockExplodeListener implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void onBlockExplode(BlockExplodeEvent event) {
        IridiumSkyblock.getInstance().getIslandManager().getIslandViaLocation(event.getBlock().getLocation()).ifPresent(island -> {
            IslandSetting tntExplosion = IridiumSkyblock.getInstance().getIslandManager().getIslandSetting(island, SettingType.TNT_DAMAGE);
            if (!tntExplosion.getBooleanValue()) {
                event.setCancelled(true);
                return;
            }
            event.blockList().removeIf(block -> !island.isInIsland(block.getLocation()));
            event.blockList().forEach(block -> {
                IslandBlocks islandBlocks = IridiumSkyblock.getInstance().getIslandManager().getIslandBlock(island, XMaterial.matchXMaterial(block.getType()));
                if (islandBlocks.getAmount() > 0) {
                    islandBlocks.setAmount(islandBlocks.getAmount() - 1);
                }
            });
        });
    }


}
