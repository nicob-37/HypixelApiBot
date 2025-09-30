package org.nico;

import net.hypixel.api.HypixelAPI;
import net.hypixel.api.reply.PlayerReply;
import net.hypixel.api.reply.PlayerReply.Player;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class PlayerInfo {

    public static void main(String[] args) throws InterruptedException {
        HypixelAPI api = Util.API;

        PlayerReply apiReply;

        try {
            UUID playerUuid = Util.FAKENICO;

            apiReply = api.getPlayerByUuid(playerUuid).get();
        } catch (ExecutionException e) {
            System.err.println("API Request Failed :(");

            e.getCause().printStackTrace();
            return;
        } finally {
            api.shutdown();
        }

        Player player = apiReply.getPlayer();
        if (!player.exists()) {
            System.err.println("Player Not Found");

            api.shutdown();
            return;
        }

        System.out.println("[" + Util.formatRank(player.getHighestRank()) + "] " + player.getName() + "'s Stats");
        System.out.println();
        System.out.println("UUID ----------> " + player.getUuid());
        System.out.println("On Build Team? > " + player.isOnBuildTeam());
        System.out.println("Exact Level ---> " + player.getNetworkLevel());
        System.out.println("Experience ----> " + player.getNetworkExp());
        System.out.println("Karma ---------> " + player.getKarma());
        System.out.println("Last Game Type > " + player.getMostRecentGameType());
    }
}
