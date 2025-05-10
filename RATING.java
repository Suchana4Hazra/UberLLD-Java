public enum RATING {
    FIVE_STAR(5),
    FOUR_STAR(4),
    THREE_STAR(3),
    TWO_STAR(2),
    ONE_STAR(1);

    private final int value;

    RATING(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static RATING fromValue(int value) {
        for (RATING rating : values()) {
            if (rating.getValue() == value) {
                return rating;
            }
        }
        throw new IllegalArgumentException("Invalid rating value: " + value);
    }
}