package us.danny.nametaghider;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.NameTagVisibility;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class CommandHideNameTags implements CommandExecutor {
    private static final String HIDDEN_TEAM = "hidden";

    private JavaPlugin plugin;

    public CommandHideNameTags(JavaPlugin plugin){
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player)commandSender;
            for(Player p : plugin.getServer().getOnlinePlayers()) {
                Scoreboard scoreboard = p.getScoreboard();
                Team hidden = getHidden(scoreboard);
                hidden.addEntry(player.getName());
            }
            player.sendMessage("Nametags Turned Off");
            return true;
        }
        return false;
    }

    private Team getHidden(Scoreboard scoreboard){
        Team hidden = scoreboard.getTeam(HIDDEN_TEAM);
        if(hidden == null){
            hidden = scoreboard.registerNewTeam(HIDDEN_TEAM);
        }
        if(hidden.getNameTagVisibility() != NameTagVisibility.NEVER){
            hidden.setNameTagVisibility(NameTagVisibility.NEVER);
        }
        return hidden;
    }
}
