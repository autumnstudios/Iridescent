package com.autumnstudios.libraries.iridescent.api.sched;

import com.autumnstudios.libraries.iridescent.api.util.DateTime;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;
import java.util.concurrent.Callable;

public class RunFuture {
    int taskId;
    public RunFuture(JavaPlugin plugin, DateTime time, FutureCode code) {
        taskId = Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, code::execute, time.inTicks());
    }

    public int getTaskID() {
        return taskId;
    }


}
