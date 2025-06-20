package quest.gekko.stella.api;

public enum Platform {
    DISCORD,
    TWITCH,
    OTHER;

    public static Platform from(final String input) {
        try {
            return Platform.valueOf(input.toUpperCase());
        } catch (final IllegalArgumentException ex) {
            return Platform.OTHER;
        }
    }
}
