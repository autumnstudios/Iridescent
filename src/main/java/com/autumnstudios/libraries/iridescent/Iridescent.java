package com.autumnstudios.libraries.iridescent;

import com.autumnstudios.libraries.iridescent.api.sched.FutureCode;
import com.autumnstudios.libraries.iridescent.api.sched.RunFuture;
import com.autumnstudios.libraries.iridescent.api.util.DateTime;
import com.autumnstudios.libraries.iridescent.commands.testing.CreateCircle;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Iridescent extends JavaPlugin {

    @Override
    public void onEnable() {
        MainGrab.setMain(this);
        // Plugin startup logic
        new RunFuture(this, new DateTime(10, "sec"), () -> {
            Bukkit.getLogger().info("test");
        });
        getCommand("circle").setExecutor(new CreateCircle());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


}
