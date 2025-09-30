package org.nico;

import net.hypixel.api.HypixelAPI;
import net.hypixel.api.apache.ApacheHttpClient;
import net.hypixel.api.reply.AbstractReply;

import java.util.UUID;
import java.util.function.BiConsumer;

public class Util {

    private static String getApiKey() {
        String apiKey = System.getenv("HYPIXEL_API_KEY");
        if (apiKey != null) {return apiKey;}

        return System.getProperty("apiKey", "4bc9573c-37e4-4cf4-96e3-f95bc046af57");
    }

    public static final HypixelAPI API;

    static {
        API = new HypixelAPI(new ApacheHttpClient(UUID.fromString(getApiKey())));
    }

    public static final UUID HYPIXEL = UUID.fromString("f7c77d99-9f15-4a66-a87d-c4a51ef30d19");
    public static final UUID FAKENICO = UUID.fromString("84351d14-143a-4d91-95e9-06dcdd5a60eb");
    //public static final UUID YARD = UUID.fromString("")

    public static void await() {
        while (!Thread.interrupted()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static <T extends AbstractReply> BiConsumer<T, Throwable> getTestConsumer() {
        return (result, throwable) -> {
            if (throwable != null) {
                throwable.printStackTrace();
                System.exit(0);
                return;
            }

            System.out.println(result);

            System.exit(0);
        };
    }

    public static String formatRank(String r) {
        if (r.contains("PLUS")) {
            r = r.replace("_PLUS", "+");
        }
        return r;
    }

}
