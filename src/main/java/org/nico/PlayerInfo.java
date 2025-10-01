package org.nico;

import net.hypixel.api.HypixelAPI;

import net.hypixel.api.reply.GuildReply;
import net.hypixel.api.reply.PlayerReply;
import net.hypixel.api.reply.PlayerReply.Player;
import net.hypixel.api.reply.GuildReply.Guild;
import org.nico.PlayerInformation.GetInfo;
import org.nico.PlayerInformation.Info;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class PlayerInfo {

    public static final HypixelAPI api = Util.API;
    public static PlayerReply apiReply;
    public static GuildReply guildReply;
    public static Player player;
    public static Guild guild;

    public static void shutDown() {
        api.shutdown();
    }

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

    private static String onlineStatus(UUID ID) throws InterruptedException {
        try {
            apiReply = api.getPlayerByUuid(ID).get();
            guildReply = api.getGuildByPlayer(ID).get();
        } catch (ExecutionException e) {
            System.err.println("API Request Failed");
        }

        return (player.isOnline()? "Online" : "Offline");
    }

    public static void getPlayerInfo(UUID ID) throws InterruptedException {
        try {

            apiReply = api.getPlayerByUuid(ID).get();
            guildReply = api.getGuildByPlayer(ID).get();

        } catch (ExecutionException e) {
            System.err.println("API Request Failed");

            e.getCause().printStackTrace();
            return;

        }

        player = apiReply.getPlayer();
        guild = guildReply.getGuild();

        if (!player.exists()) {
            System.err.println("Player Not Found");
            return;
        }

        System.out.println("[" + Util.formatRank(player.getHighestRank()) + "] " + player.getName() + "'s Stats");
        System.out.println("UUID: " + player.getUuid());
        System.out.println("Guild Name: " + guild.getName());
        System.out.println("Status: " + onlineStatus(ID));

        try {
            System.out.println("MVP++ UUID: " + getUUID("mameowo"));
        } catch (ExecutionException e) {
            System.err.println("UUID Fetch Fail");
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println(GetInfo.playerOverview(Util.UUIDS.FAKENICO).NAME);
        } catch (InterruptedException e) {
            System.out.println("PlayerInfo.java main() error");
        } finally {
            shutDown();
        }
    }
}
