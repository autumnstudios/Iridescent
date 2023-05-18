package com.autumnstudios.libraries.iridescent.commands.testing;

import com.autumnstudios.libraries.iridescent.api.math.SpellCasting;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CreateCircle implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length > 3) {
            Player player = (Player) commandSender;
            int distance = Integer.parseInt(strings[0]);
            int radius = Integer.parseInt(strings[1]);
            SpellCasting spellCasting = new SpellCasting();
            spellCasting.createCircle(player, radius, distance);
        }
        return false;
    }
}
