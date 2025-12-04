package me.imsd.autorespawn;

import me.imsd.autorespawn.commands.ReloadCommand;
import me.imsd.autorespawn.listeners.RespawnListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class AutoRespawn extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new RespawnListener(this), this);

        Objects.requireNonNull(getCommand("autorespawn")).setExecutor(new ReloadCommand(this));

        getLogger().info("Successfully enabled AutoRespawn version " + getDescription().getVersion());
    }

    @Override
    public void onDisable() {
        getLogger().info("AutoRespawn version " + getDescription().getVersion() + " disabled.");
    }
}