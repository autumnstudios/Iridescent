package com.autumnstudios.libraries.iridescent.systems.spells;

import com.autumnstudios.libraries.iridescent.MainGrab;
import com.autumnstudios.libraries.iridescent.api.math.SpellCasting;
import com.autumnstudios.libraries.iridescent.api.sched.RunFuture;
import com.autumnstudios.libraries.iridescent.api.util.DateTime;
import org.bukkit.entity.Player;

import java.lang.management.PlatformLoggingMXBean;
import java.util.HashMap;
import java.util.Map;

public class Casting {

    Map<Player, Boolean> casting;

    public Casting() {
        this.casting = new HashMap<>();
    }

    public void enableCastingMode(Player player) {
        casting.put(player, true);
        SpellCasting sCast = new SpellCasting();
        while (casting.get(player)) {
            new RunFuture(MainGrab.getMain(), new DateTime(1, "sec"), () -> {
                sCast.createCircle(player, 10, 5);
            });


        }
    }

    public void disableCastingMode(Player player) {
        casting.put(player, false);
    }


}
