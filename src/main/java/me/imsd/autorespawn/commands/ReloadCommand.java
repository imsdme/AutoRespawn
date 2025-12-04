package me.imsd.autorespawn.commands;

import me.imsd.autorespawn.AutoRespawn;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadCommand implements CommandExecutor {

    private final AutoRespawn plugin;

    public ReloadCommand(AutoRespawn plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length > 0) {

            if (args[0].equalsIgnoreCase("reload")) {

                plugin.reloadConfig();
                plugin.saveDefaultConfig();

                sender.sendMessage(ChatColor.GREEN + "AutoRespawn config successfully reloaded!");
                return true;
            }
        }

        sender.sendMessage(ChatColor.RED + "Usage: /autorespawn reload");
        return true;
    }
}