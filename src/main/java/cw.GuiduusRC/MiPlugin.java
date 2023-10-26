package cw.GuiduusRC;

import cw.GuiduusRC.config.MainConfigManager;
import cw.GuiduusRC.listeners.PlayerListener;
import cw.GuiduusRC.commands.MainCommands;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class MiPlugin extends JavaPlugin {

    public static String prefix = "&b&lCustom Welcomer";
    private String version = getDescription().getVersion();
    private MainConfigManager mainConfigManager;

    public void onEnable() {
        registerCommands();
        registerEvents();
        mainConfigManager = new MainConfigManager(this);
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', prefix+" esta activo. Version: "+version));
    }

    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', prefix+" esta desactivado. Version: "+version));
    }

    public void registerCommands() {this.getCommand("customwelcomer").setExecutor(new MainCommands(this));}

    public void registerEvents(){
        getServer().getPluginManager().registerEvents(new PlayerListener(this), this);
    }

    public MainConfigManager getMainConfigManager() {
        return mainConfigManager;
    }
}
