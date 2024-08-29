package dev.prangellplays.plushies;

import eu.midnightdust.lib.config.MidnightConfig;

public class PlushiesConfig extends MidnightConfig {
    @Entry(category = "plushies")
    public static boolean plushieSound = true;
    @Entry(category = "plushies")
    public static boolean creeperPlushieExplosion = true;
}
