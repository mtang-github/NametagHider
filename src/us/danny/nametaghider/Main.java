package us.danny.nametaghider;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public void onEnable() {
        getCommand("hideNameTags").setExecutor(new CommandHideNameTags(this));
        System.out.println("[NametagHider] Enabled");
    }

    public void onDisable() {
        System.out.println("[NametagHider] Disabled");
    }
}
