package cw.GuiduusRC.config;

import cw.GuiduusRC.MiPlugin;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;

public class MainConfigManager {
    private CustomConfig configFile;
    private MiPlugin plugin;

    private String selectorWorld;

    private double teleportCoordX;
    private double teleportCoordY;
    private double teleportCoordZ;

    private boolean teleportCoordEnabled;
    private boolean welcomeMessageEnabled;

    private List<String> welcomeMessageMessages;

    private String joinedMessage;
    private String exitMessage;

    private boolean joinedEnabled;
    private boolean exitEnabled;

    private boolean titleEnabled;

    private String titleMessage;
    private String subMessage;

    private int stayTitleMessage;
    private int fadeInTitleMessage;
    private int fadeOutTitleMessage;

    private boolean soundEnabled;

    private double soundVolume;
    private double soundPitch;

    private String soundSound;

    public MainConfigManager(MiPlugin plugin){
        this.plugin = plugin;
        configFile = new CustomConfig("config.yml", null,plugin);
        configFile.registerConfig();
        loadConfig();
    }

    public void loadConfig(){
        FileConfiguration config = configFile.getConfig();
        soundPitch = config.getDouble("config.sound.pitch");
        soundVolume = config.getDouble("config.sound.volume");
        soundSound = config.getString("config.sound.sound");
        soundEnabled = config.getBoolean("config.sound.enabled");
        welcomeMessageEnabled = config.getBoolean("config.welcome_message.enabled");
        welcomeMessageMessages = config.getStringList("config.welcome_message.message");
        selectorWorld = config.getString("config.teleport_coord.world");
        teleportCoordEnabled = config.getBoolean("config.teleport_coord.enabled");
        teleportCoordX = config.getDouble("config.teleport_coord.x");
        teleportCoordY = config.getDouble("config.teleport_coord.y");
        teleportCoordZ = config.getDouble("config.teleport_coord.z");
        joinedMessage = config.getString("config.join.message");
        exitMessage = config.getString("config.exit.message");
        joinedEnabled = config.getBoolean("config.join.enabled");
        exitEnabled = config.getBoolean("config.exit.enabled");
        titleEnabled = config.getBoolean("config.title_message.enabled");
        titleMessage = config.getString("config.title_message.title");
        subMessage = config.getString("config.title_message.subtitle");
        stayTitleMessage = config.getInt("config.title_message.stay");
        fadeInTitleMessage = config.getInt("config.title_message.fadeIn");
        fadeOutTitleMessage = config.getInt("config.title_message.fadeOut");

    }

    public void reloadConfig(){
        configFile.reloadConfig();
        loadConfig();
    }
    public boolean isWelcomeMessageEnabled() {
        return welcomeMessageEnabled;
    }

    public List<String> getWelcomeMessageMessages() {
        return welcomeMessageMessages;
    }

    public String getSelectorWorld() {
        return selectorWorld;
    }

    public double getTeleportCoordX() {
        return teleportCoordX;
    }

    public double getTeleportCoordY() {
        return teleportCoordY;
    }

    public double getTeleportCoordZ() {
        return teleportCoordZ;
    }

    public boolean isTeleportCoordEnabled() {
        return teleportCoordEnabled;
    }

    public String getJoinedMessage() {
        return joinedMessage;
    }

    public String getExitMessage() {
        return exitMessage;
    }

    public boolean isJoinedEnabled() {
        return joinedEnabled;
    }

    public boolean isExitEnabled() {
        return exitEnabled;
    }

    public boolean isTitleEnabled() {
        return titleEnabled;
    }

    public String getTitleMessage() {
        return titleMessage;
    }

    public String getSubMessage() {
        return subMessage;
    }

    public int getStayTitleMessage() {
        return stayTitleMessage;
    }

    public int getFadeInTitleMessage() {
        return fadeInTitleMessage;
    }

    public int getFadeOutTitleMessage() {
        return fadeOutTitleMessage;
    }

    public boolean isSoundEnabled() {
        return soundEnabled;
    }

    public double getSoundVolume() {
        return soundVolume;
    }

    public double getSoundPitch() {
        return soundPitch;
    }

    public String getSoundSound() {
        return soundSound;
    }
}
