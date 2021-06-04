package com.iridium.iridiumskyblock.gui;

import com.iridium.iridiumcore.utils.InventoryUtils;
import com.iridium.iridiumcore.utils.ItemStackUtils;
import com.iridium.iridiumcore.utils.Placeholder;
import com.iridium.iridiumcore.utils.StringUtils;
import com.iridium.iridiumskyblock.IridiumSkyblock;
import com.iridium.iridiumskyblock.PlaceholderBuilder;
import com.iridium.iridiumskyblock.database.Island;
import com.iridium.iridiumskyblock.database.IslandInvite;
import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

/**
 * GUI which allows users to manage invites.
 */
public class InvitesGUI implements GUI {

    private final Island island;
    private final HashMap<Integer, String> invites;

    /**
     * The default constructor.
     *
     * @param island The Island this GUI belongs to
     */
    public InvitesGUI(@NotNull Island island) {
        this.island = island;
        invites = new HashMap<>();
    }

    /**
     * Builds and returns this inventory.
     *
     * @return The new inventory
     */
    @NotNull
    @Override
    public Inventory getInventory() {
        Inventory inventory = Bukkit.createInventory(this, IridiumSkyblock.getInstance().getInventories().islandInvitesGUI.size, StringUtils.color(IridiumSkyblock.getInstance().getInventories().islandInvitesGUI.title));

        addContent(inventory);

        return inventory;
    }

    @Override
    public void addContent(Inventory inventory) {
        List<IslandInvite> islandInvites = IridiumSkyblock.getInstance().getDatabaseManager().getIslandInviteTableManager().getEntries(island);
        inventory.clear();
        InventoryUtils.fillInventory(inventory, IridiumSkyblock.getInstance().getInventories().islandInvitesGUI.background);


        int i = 0;
        for (IslandInvite islandInvite : islandInvites) {
            List<Placeholder> placeholderList = new PlaceholderBuilder().applyPlayerPlaceholders(islandInvite.getUser()).applyIslandPlaceholders(island).build();
            placeholderList.add(new Placeholder("inviter", islandInvite.getInviter().getName()));
            placeholderList.add(new Placeholder("time", islandInvite.getTime().format(DateTimeFormatter.ofPattern(IridiumSkyblock.getInstance().getConfiguration().dateTimeFormat))));
            inventory.setItem(i, ItemStackUtils.makeItem(IridiumSkyblock.getInstance().getInventories().islandInvitesGUI.item, placeholderList));
            invites.put(i, islandInvite.getUser().getName());
            i++;
        }
    }

    /**
     * Called when there is a click in this GUI.
     * Cancelled automatically.
     *
     * @param event The InventoryClickEvent provided by Bukkit
     */
    @Override
    public void onInventoryClick(InventoryClickEvent event) {
        if (invites.containsKey(event.getSlot())) {
            String command = IridiumSkyblock.getInstance().getCommands().unInviteCommand.aliases.get(0);
            Bukkit.getServer().dispatchCommand(event.getWhoClicked(), "is " + command + " " + invites.get(event.getSlot()));
            event.getWhoClicked().openInventory(getInventory());
        }
    }

}