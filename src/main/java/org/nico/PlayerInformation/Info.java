package org.nico.PlayerInformation;

import net.hypixel.api.data.type.GameType;
import net.hypixel.api.pets.PetStats;
import org.nico.Util;

import java.time.ZonedDateTime;
import java.util.UUID;

public class Info {
    public String NAME;
    public boolean ONLINE;
    public UUID ID;
    public long KARMA;
    public String HIGHEST_RANK;
    public ZonedDateTime FIRST_LOGIN_DATE, LAST_LOGIN_DATE, LAST_LOGOUT_DATE;
    public GameType MOST_RECENT_GAMETYPE;
    public long NETWORK_EXP;
    public double NETWORK_LEVEL;
    public String SELECTED_PLUS_COLOR, SUPERSTAR_TAG_COLOR;
    public PetStats PET_STATS;

    public enum InfoObj {
        NAME, ONLINE, ID, KARMA,
        HIGHEST_RANK, FIRST_LOGIN_DATE,
        LAST_LOGIN_DATE, LAST_LOGOUT_DATE,
        MOST_RECENT_GAMETYPE, NETWORK_EXP,
        NETWORK_LEVEL, SELECTED_PLUS_COLOR,
        SUPERSTAR_TAG_COLOR, PET_STATS
    }

    public Info() {}
    public Info(String name, boolean online, UUID id, long karma, String highestRank, ZonedDateTime firstLoginDate, ZonedDateTime lastLoginDate,
                ZonedDateTime lastLogoutDate, GameType mostRecentGametype, long networkExp, double networkLevel,
                String selectedPlusColor, String superstarTagColor, PetStats petStats) {

        this.NAME = name;
        this.ONLINE = online;
        this.ID = id;
        this.KARMA = karma;
        this.HIGHEST_RANK = highestRank;
        this.FIRST_LOGIN_DATE = firstLoginDate;
        this.LAST_LOGIN_DATE = lastLoginDate;
        this.LAST_LOGOUT_DATE = lastLogoutDate;
        this.MOST_RECENT_GAMETYPE = mostRecentGametype;
        this.NETWORK_EXP = networkExp;
        this.NETWORK_LEVEL = networkLevel;
        this.SELECTED_PLUS_COLOR = selectedPlusColor;
        this.SUPERSTAR_TAG_COLOR = superstarTagColor;
        this.PET_STATS = petStats;
    }

    public void setName(String n) {this.NAME = n;}
    public void setOnline(boolean b) {this.ONLINE = b;}
    public void setUUID(UUID id) {this.ID = id;}
    public void setKarma(long k) {this.KARMA = k;}
    public void setHighestRank(String r) {this.HIGHEST_RANK = r;}
    public void setFirstLoginDate(ZonedDateTime z) {this.FIRST_LOGIN_DATE = z;}
    public void setLastLoginDate(ZonedDateTime z) {this.LAST_LOGIN_DATE = z;}
    public void setLastLogoutDate(ZonedDateTime z) {this.LAST_LOGOUT_DATE = z;}
    public void setMostRecentGametype(GameType g) {this.MOST_RECENT_GAMETYPE = g;}
    public void setNetworkExp(long e) {this.NETWORK_EXP = e;}
    public void setNetworkLevel(double l) {this.NETWORK_LEVEL = l;}
    public void setSelectedPlusColor(String c) {this.SELECTED_PLUS_COLOR = c;}
    public void setSuperstarTagColor(String c) {this.SUPERSTAR_TAG_COLOR = c;}
    public void setPetStats(PetStats p) {this.PET_STATS = p;}

    public Object returnValue(InfoObj type) {
        switch (type) {
            case NAME: return this.NAME;
            case ONLINE: return this.ONLINE;
            case ID: return this.ID;
            case KARMA: return this.KARMA;
            case HIGHEST_RANK: return this.HIGHEST_RANK;
            case FIRST_LOGIN_DATE: return this.FIRST_LOGIN_DATE;
            case LAST_LOGIN_DATE: return this.LAST_LOGIN_DATE;
            case LAST_LOGOUT_DATE: return this.LAST_LOGOUT_DATE;
            case MOST_RECENT_GAMETYPE: return this.MOST_RECENT_GAMETYPE;
            case NETWORK_EXP: return this.NETWORK_EXP;
            case NETWORK_LEVEL: return this.NETWORK_LEVEL;
            case SELECTED_PLUS_COLOR: return this.SELECTED_PLUS_COLOR;
            case SUPERSTAR_TAG_COLOR: return this.SUPERSTAR_TAG_COLOR;
            case PET_STATS: return this.PET_STATS;
            default: return null;
        }
    }
}
