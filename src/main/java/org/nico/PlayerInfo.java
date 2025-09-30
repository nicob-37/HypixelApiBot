package org.nico;

import net.hypixel.api.HypixelAPI;

import net.hypixel.api.reply.GuildReply;
import net.hypixel.api.reply.PlayerReply;
import net.hypixel.api.reply.PlayerReply.Player;
import net.hypixel.api.reply.GuildReply.Guild;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class PlayerInfo {

    public static final HypixelAPI api = Util.API;

    public static String getUUID(String s) throws InterruptedException, ExecutionException {
        String reply = api.getPlayerByName(s).get().getPlayer().getUuid().toString();
        return reply;
    }

    public static void getPlayerInfo() throws InterruptedException {
        PlayerReply apiReply;
        GuildReply guildReply;

        try {
            UUID playerUuid = Util.FAKENICO;

            apiReply = api.getPlayerByUuid(playerUuid).get();
            guildReply = api.getGuildByPlayer(playerUuid).get();

        } catch (ExecutionException e) {
            System.err.println("API Request Failed");

            e.getCause().printStackTrace();
            return;

        } finally {
            api.shutdown();
        }

        Player player = apiReply.getPlayer();
        Guild guild = guildReply.getGuild();

        if (!player.exists()) {
            System.err.println("Player Not Found");

            api.shutdown();
            return;
        }

        System.out.println("[" + Util.formatRank(player.getHighestRank()) + "] " + player.getName() + "'s Stats");
        System.out.println();
        System.out.println("UUID: " + player.getUuid());
        System.out.println("Guild Name: " + guild.getName());
    }

    public static void main(String[] args) throws InterruptedException {
        getPlayerInfo();
    }
}
