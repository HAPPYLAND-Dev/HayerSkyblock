package com.iridium.iridiumskyblock.commands;

import com.iridium.iridiumskyblock.IridiumSkyblock;
import com.iridium.iridiumskyblock.api.IridiumSkyblockAPI;
import com.iridium.iridiumskyblock.configs.Schematics;
import com.iridium.iridiumskyblock.database.User;
import com.iridium.iridiumskyblock.gui.SchematicGUI;
import com.iridium.iridiumskyblock.utils.StringUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Command which creates a new island for an user.
 */
public class CreateCommand extends Command {

    /**
     * The default constructor.
     */
    public CreateCommand() {
        super(Collections.singletonList("create"), "Create an island", "", true);
    }

    /**
     * Executes the command for the specified {@link CommandSender} with the provided arguments.
     * Not called when the command execution was invalid (no permission, no player or command disabled).
     * Tries to create a new island for the user.
     *
     * @param sender The CommandSender which executes this command
     * @param args   The arguments used with this command. They contain the sub-command
     */
    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        if (args.length == 1) {
            createIsland(player, player.getName());
        } else if (args.length == 2) {
            createIsland(player, args[1]);
        } else if (args.length == 3) {
            Optional<Schematics.SchematicConfig> schematicConfig = IridiumSkyblock.getInstance().getSchematics().schematics.stream().filter(config -> config.name.equalsIgnoreCase(args[2])).findFirst();
            if (schematicConfig.isPresent()) {
                createIsland(player, args[1], schematicConfig.get());
            } else {
                player.sendMessage(StringUtils.color(IridiumSkyblock.getInstance().getMessages().islandSchematicNotFound.replace("%prefix%", IridiumSkyblock.getInstance().getConfiguration().prefix)));
            }
        }
    }

    /**
     * Creates a new island for the specified Player.
     *
     * @param player The player who performed this command
     * @param name   The name of the new island
     */
    private void createIsland(Player player, String name) {
        User user = IridiumSkyblockAPI.getInstance().getUser(player);
        if (user.getIsland() != null) {
            player.sendMessage(StringUtils.color(IridiumSkyblock.getInstance().getMessages().alreadyHaveIsland.replace("%prefix%", IridiumSkyblock.getInstance().getConfiguration().prefix)));
            return;
        }
        if (IridiumSkyblock.getInstance().getDatabaseManager().getIslandByName(name).isPresent()) {
            player.sendMessage(StringUtils.color(IridiumSkyblock.getInstance().getMessages().islandWithNameAlreadyExists.replace("%prefix%", IridiumSkyblock.getInstance().getConfiguration().prefix)));
            return;
        }
        player.openInventory(new SchematicGUI(player, name, IridiumSkyblock.getInstance()).getInventory());
    }

    /**
     * Creates a new island for the specified Player.
     *
     * @param player The player who performed this command
     * @param name   The name of the new island
     */
    private void createIsland(Player player, String name, Schematics.SchematicConfig schematicConfig) {
        User user = IridiumSkyblockAPI.getInstance().getUser(player);
        if (user.getIsland() != null) {
            player.sendMessage(StringUtils.color(IridiumSkyblock.getInstance().getMessages().alreadyHaveIsland.replace("%prefix%", IridiumSkyblock.getInstance().getConfiguration().prefix)));
            return;
        }
        if (IridiumSkyblock.getInstance().getDatabaseManager().getIslandByName(name).isPresent()) {
            player.sendMessage(StringUtils.color(IridiumSkyblock.getInstance().getMessages().islandWithNameAlreadyExists.replace("%prefix%", IridiumSkyblock.getInstance().getConfiguration().prefix)));
            return;
        }
        player.sendMessage(StringUtils.color(IridiumSkyblock.getInstance().getMessages().creatingIsland.replace("%prefix%", IridiumSkyblock.getInstance().getConfiguration().prefix)));
        IridiumSkyblock.getInstance().getIslandManager().createIsland(player, name, schematicConfig).thenAccept(island -> player.teleport(island.getHome()));
    }

    /**
     * Handles tab-completion for this command.
     *
     * @param commandSender The CommandSender which tries to tab-complete
     * @param command       The command
     * @param label         The label of the command
     * @param args          The arguments already provided by the sender
     * @return The list of tab completions for this command
     */
    @Override
    public List<String> onTabComplete(CommandSender commandSender, org.bukkit.command.Command command, String label, String[] args) {
        if (args.length == 3) {
            return IridiumSkyblock.getInstance().getSchematics().schematics.stream().map(schematicConfig -> schematicConfig.name).collect(Collectors.toList());
        }
        return null;
    }

}