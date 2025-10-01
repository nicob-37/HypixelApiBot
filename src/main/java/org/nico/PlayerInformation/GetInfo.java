package org.nico.PlayerInformation;

import net.hypixel.api.HypixelAPI;

import net.hypixel.api.reply.GuildReply;
import net.hypixel.api.reply.PlayerReply;
import net.hypixel.api.reply.PlayerReply.Player;
import net.hypixel.api.reply.GuildReply.Guild;
import org.nico.Util;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class GetInfo {
    public static final HypixelAPI api = Util.API;
    public static PlayerReply apiReply;
    public static GuildReply guildReply;
    public static Player player;
    public static Guild guild;

    public static Info playerOverview(UUID id) throws InterruptedException {
        Info info = new Info();

        try {
            player = api.getPlayerByUuid(id).get().getPlayer();
        } catch (ExecutionException e) {
            System.err.println("GetInfo playerOverview() error");
            return info;
        }

        if (player == null || !player.exists()) {
            System.err.println("Player Not Found");
            return info;
        }
        info = new Info(player.getName(), player.isOnline(), player.getUuid(), player.getKarma(),
                player.getHighestRank(), player.getFirstLoginDate(), player.getLastLoginDate(), player.getLastLogoutDate(),
                player.getMostRecentGameType(), player.getNetworkExp(), player.getNetworkLevel(), player.getSelectedPlusColor(),
                player.getSuperstarTagColor(), player.getPetStats()
        );

        return info;
    }

}
