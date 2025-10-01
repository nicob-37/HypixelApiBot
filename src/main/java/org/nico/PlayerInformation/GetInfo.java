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

    public static String getUUID(String s) throws ExecutionException {
        String reply = null;
        try {
            reply = api.getPlayerByName(s).get().getPlayer().getUuid().toString();;
            return reply;
        } catch (InterruptedException e) {
            System.err.println("Couldn't get Player UUID");
        }
        return reply;
    }

    public static boolean getOnline(UUID id) throws InterruptedException {
        try {
            player = api.getPlayerByUuid(id).get().getPlayer();
        } catch (ExecutionException e) {
            System.err.println("Couldn't get online status");
        }
        return player.isOnline();
    }
    public static boolean getOnline(String ign) throws InterruptedException{
        try {
            player = api.getPlayerByUuid(ign).get().getPlayer();
        } catch (ExecutionException e) {
            System.err.println("Couldn't get online status");
        }
        return player.isOnline();
    }

    public static Info playerOverview(UUID id) throws InterruptedException {
        Info info = new Info();

        try {
            player = api.getPlayerByUuid(id).get().getPlayer();
        } catch (ExecutionException e) {
            System.err.println("GetInfo playerOverview()");
            return info;
        }

        if (player == null || !player.exists()) {
            System.err.println("Player Not Found");
            return info;
        }

        player.getMos

        info.setName(player.getName());
        info.setOnline(player.isOnline());
        info.setUUID(player.getUuid());
        info.setKarma(player.getKarma());
        info.setHighestRank(player.getHighestRank());
        info.setFirstLoginDate(player.getFirstLoginDate());
        info.setLastLoginDate(player.getLastLoginDate());
        info.setLastLogoutDate(player.getLastLogoutDate());
        info.setMostRecentGametype(player.getMostRecentGameType());

        return info;
    }

}
