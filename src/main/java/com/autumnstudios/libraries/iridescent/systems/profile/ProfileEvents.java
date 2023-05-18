package com.autumnstudios.libraries.iridescent.systems.profile;

import com.autumnstudios.libraries.iridescent.MainGrab;
import com.autumnstudios.libraries.iridescent.api.chat.Chat;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerResourcePackStatusEvent;

public class ProfileEvents implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.getPlayer().setResourcePack(MainGrab.getMain().getConfig().getString("pack"));
    }

    @EventHandler
    public void pack(PlayerResourcePackStatusEvent e) {
        if (e.getStatus() == PlayerResourcePackStatusEvent.Status.DECLINED) {
            e.getPlayer().kickPlayer(Chat.gen("&c&lYOU MUST ACCEPT PACK"));
        }
        else if (e.getStatus() == PlayerResourcePackStatusEvent.Status.FAILED_DOWNLOAD) {
            e.getPlayer().kickPlayer(Chat.gen("&c&lSERVER SIDE ISSUE"));
        }

        if (e.getStatus() == PlayerResourcePackStatusEvent.Status.SUCCESSFULLY_LOADED) {

        }
    }
}
