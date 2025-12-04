package me.imsd.autorespawn.listeners;

import me.imsd.autorespawn.AutoRespawn;
import me.imsd.autorespawn.utils.ColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class RespawnListener implements Listener {

    private final AutoRespawn plugin;

    public RespawnListener(AutoRespawn plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();

        int seconds = plugin.getConfig().getInt("respawn-delay", 1);
        long ticks = (seconds <= 0) ? 10L : seconds * 20L;

        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            if (player.isOnline() && player.isDead()) {

                player.spigot().respawn();

                if (plugin.getConfig().getBoolean("titles.enabled")) {
                    String mainTitle = ColorUtil.translateColor(plugin.getConfig().getString("titles.main", ""));
                    String subTitle = ColorUtil.translateColor(plugin.getConfig().getString("titles.sub", ""));
                    player.sendTitle(mainTitle, subTitle, 10, 60, 20);
                }

                if (plugin.getConfig().getBoolean("sounds.enabled")) {
                    String soundName = plugin.getConfig().getString("sounds.sound", "entity.experience_orb.pickup");
                    player.playSound(player.getLocation(), soundName, 1.0f, 1.0f);
                }

                if (plugin.getConfig().getBoolean("particles.enabled")) {
                    String effectName = plugin.getConfig().getString("particles.effect", "villager_happy");
                    try {
                        Particle effect = Particle.valueOf(effectName.toUpperCase());
                        player.getWorld().spawnParticle(effect, player.getLocation(), 30, 0.5, 1, 0.5, 0.01);
                    } catch (IllegalArgumentException e) {
                        plugin.getLogger().warning("Config error: Particle '" + effectName + "' not found!");
                    }
                }
            }
        }, ticks);
    }
}