package cw.GuiduusRC.listeners;

import cw.GuiduusRC.config.MainConfigManager;
import cw.GuiduusRC.utils.MessageUtils;
import cw.GuiduusRC.MiPlugin;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.List;

public class PlayerListener implements Listener {

    private MiPlugin plugin;

    public PlayerListener(MiPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        MainConfigManager mainConfigManager = plugin.getMainConfigManager();

        if (!mainConfigManager.isExitEnabled()){
            event.setQuitMessage(null);
        }else {
            String quitMessage = mainConfigManager.getExitMessage();
            quitMessage = quitMessage.replace("%player%", player.getName());
            event.setQuitMessage(MessageUtils.getColoredMessage(quitMessage));
        }
    }
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        MainConfigManager mainConfigManager = plugin.getMainConfigManager();


        if (mainConfigManager.isSoundEnabled()){
            String soundSound = plugin.getMainConfigManager().getSoundSound();
            double soundVolume = plugin.getMainConfigManager().getSoundVolume();
            double soundPitch = plugin.getMainConfigManager().getSoundPitch();

            player.playSound(player.getLocation(), soundSound, (float) soundVolume, (float) soundPitch);
        }


        if (mainConfigManager.isTitleEnabled()) {
            String title = plugin.getMainConfigManager().getTitleMessage();
            String subTitle = plugin.getMainConfigManager().getSubMessage();
            int fadeIn = plugin.getMainConfigManager().getFadeInTitleMessage();
            int stay = plugin.getMainConfigManager().getStayTitleMessage();
            int fadeOut = plugin.getMainConfigManager().getFadeOutTitleMessage();
            title = title.replace("%player%", player.getName());
            subTitle = subTitle.replace("%player%", player.getName());

            player.sendTitle(title, subTitle, fadeIn, stay, fadeOut);
        }


        if (!mainConfigManager.isJoinedEnabled()){
            event.setJoinMessage(null);
        }else {
            String joinedMessage = mainConfigManager.getJoinedMessage();
            joinedMessage = joinedMessage.replace("%player%", player.getName());
            event.setJoinMessage(MessageUtils.getColoredMessage(joinedMessage));
        }

            if (mainConfigManager.isWelcomeMessageEnabled()) {
            List<String> message = mainConfigManager.getWelcomeMessageMessages();
            for (String m : message) {
                player.sendMessage(MessageUtils.getColoredMessage(m.replace("%player%", player.getName())));
                }
                player.sendMessage("");
            }
        if (mainConfigManager.isTeleportCoordEnabled()) {
            Location location = new Location(Bukkit.getWorld(plugin.getMainConfigManager().getSelectorWorld()), plugin.getMainConfigManager().getTeleportCoordX(), plugin.getMainConfigManager().getTeleportCoordY(), plugin.getMainConfigManager().getTeleportCoordZ());
            player.teleport(location);
        }

    }
}
