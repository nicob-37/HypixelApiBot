package org.nico;

import net.hypixel.api.HypixelAPI;
import net.hypixel.api.apache.ApacheHttpClient;
import net.hypixel.api.http.HypixelHttpClient;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        HypixelHttpClient client = new ApacheHttpClient(UUID.fromString("4bc9573c-37e4-4cf4-96e3-f95bc046af57"));
        HypixelAPI hypixelAPI = new HypixelAPI(client);
        hypixelAPI.getPlayerByName("FakeNico")
                .exceptionally(throwable -> {
                    // Handle exceptions here
                    throwable.printStackTrace();
                    return null;
                })
                .thenAccept(System.out::println);

    }
}