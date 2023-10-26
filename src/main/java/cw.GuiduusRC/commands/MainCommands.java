package cw.GuiduusRC.commands;

import cw.GuiduusRC.MiPlugin;
import cw.GuiduusRC.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainCommands implements CommandExecutor {

    private MiPlugin plugin;

    public MainCommands(MiPlugin plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String alies, String[] args) {
        if (!(sender instanceof Player)) {
            // consola
        }else if (args.length >= 1) {
            if (args[0].equalsIgnoreCase("reload")) {
                subCommandReload(sender);
                return true;
            }
            return true;
        }

        if (args.length >= 1) {
            if (args[0].equalsIgnoreCase("get")) {
                subCommandGet(sender, args);
                return true;
            } else if (args[0].equalsIgnoreCase("reload")) {
                subCommandReload(sender);
                return true;
            } else {
                help(sender);
            }

        } else {
            help(sender);
        }
        return false;
    }

    public void help(CommandSender sender) {
        sender.sendMessage(MessageUtils.getColoredMessage("&6&l_____[ COMMANDS &a&lCustom Welcomer&6&l ]_____"));
        sender.sendMessage(MessageUtils.getColoredMessage(""));
        sender.sendMessage(MessageUtils.getColoredMessage("&b- /cw get &6<autor/version>"));
        sender.sendMessage(MessageUtils.getColoredMessage("&b- /cw reload"));
    }

    public void subCommandGet(CommandSender sender, String[] args) {
        if (!sender.hasPermission("customwelcomer.commands.get")) {
            sender.sendMessage(MessageUtils.getColoredMessage(MiPlugin.prefix+"&cYou do not have permission to use this command."));
            return;
        }


        if (args.length == 1) {
            sender.sendMessage(MessageUtils.getColoredMessage(MiPlugin.prefix+"&7 Use &b/cw get <autor/version>"));
            return;
        }
        if (args[1].equalsIgnoreCase("autor")) {
            sender.sendMessage(MessageUtils.getColoredMessage(
                    MiPlugin.prefix+"The author of the plugin is" + plugin.getDescription().getAuthors()));
        } else if (args[1].equalsIgnoreCase("version")) {
            sender.sendMessage(MessageUtils.getColoredMessage(
                    MiPlugin.prefix+"The plugin version is" + plugin.getDescription().getVersion()));
        } else {
            sender.sendMessage(MessageUtils.getColoredMessage(MiPlugin.prefix+"&7 Use &b/cw get <autor/version>"));
        }
    }

    public void subCommandReload(CommandSender sender) {
        if (!sender.hasPermission("customwelcomer.commands.get")) {
            sender.sendMessage(MessageUtils.getColoredMessage(MiPlugin.prefix+"&c You do not have permission to use this command."));
            return;
        }
        plugin.getMainConfigManager().reloadConfig();
        sender.sendMessage(MessageUtils.getColoredMessage(MiPlugin.prefix+"&a Plugin reloaded."));
    }
}
