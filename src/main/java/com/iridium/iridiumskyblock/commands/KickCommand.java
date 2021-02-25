package com.iridium.iridiumskyblock.commands;

import com.iridium.iridiumskyblock.IridiumSkyblock;
import com.iridium.iridiumskyblock.api.IridiumSkyblockAPI;
import com.iridium.iridiumskyblock.database.Island;
import com.iridium.iridiumskyblock.database.User;
import com.iridium.iridiumskyblock.utils.PlayerUtils;
import com.iridium.iridiumskyblock.utils.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Command which creates a new island for an user.
 */
public class KickCommand extends Command {

    /**
     * The default constructor.
     */
    public KickCommand() {
        super(Collections.singletonList("kick"), "Kick a player", "", true);
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
        User user = IridiumSkyblockAPI.getInstance().getUser(player);
        Optional<Island> island = user.getIsland();
        if (island.isPresent()) {
            OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(args[1]);
            User offlineUser = IridiumSkyblockAPI.getInstance().getUser(offlinePlayer);
            if (island.get().equals(offlineUser.getIsland().orElse(null))) {
                if (offlineUser.getIslandRank().getLevel() >= user.getIslandRank().getLevel()) {
                    player.sendMessage(StringUtils.color(IridiumSkyblock.getInstance().getMessages().cannotKickUser.replace("%prefix%", IridiumSkyblock.getInstance().getConfiguration().prefix)));
                } else {
                    if (offlinePlayer instanceof Player) {
                        ((Player) offlinePlayer).sendMessage(StringUtils.color(IridiumSkyblock.getInstance().getMessages().youHaveBeenKicked.replace("%player%", player.getName()).replace("%prefix%", IridiumSkyblock.getInstance().getConfiguration().prefix)));
                        PlayerUtils.teleportSpawn((Player) offlinePlayer);
                    }
                    offlineUser.setIsland(null);
                    for (User member : island.get().getMembers()) {
                        Player p = Bukkit.getPlayer(member.getUuid());
                        if (p != null) {
                            if (p != player) {
                                p.sendMessage(StringUtils.color(IridiumSkyblock.getInstance().getMessages().kickedPlayer.replace("%kicker%", player.getName()).replace("%player%", offlineUser.getName()).replace("%prefix%", IridiumSkyblock.getInstance().getConfiguration().prefix)));
                            } else {
                                p.sendMessage(StringUtils.color(IridiumSkyblock.getInstance().getMessages().youKickedPlayer.replace("%player%", offlineUser.getName()).replace("%prefix%", IridiumSkyblock.getInstance().getConfiguration().prefix)));
                            }
                        }
                    }
                }
            } else {
                player.sendMessage(StringUtils.color(IridiumSkyblock.getInstance().getMessages().userNotInYourIsland.replace("%prefix%", IridiumSkyblock.getInstance().getConfiguration().prefix)));
            }
        } else {
            player.sendMessage(StringUtils.color(IridiumSkyblock.getInstance().getMessages().dontHaveIsland.replace("%prefix%", IridiumSkyblock.getInstance().getConfiguration().prefix)));
        }
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
        return null;
    }

}
