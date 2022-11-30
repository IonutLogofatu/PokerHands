public enum HandRank {
    HIGHCARD(1),
    PAIR(2),
    TWOPAIR(3),
    THREEOFAKIND(4),
    STRAIGHT(5),
    FLUSH(6),
    FULLHOUSE(7),
    FOUROFAKIND(8),
    STRAIGHTFLUSH(9);

    private final int handRankIndex;

    HandRank(final int handRankIndex) {
        this.handRankIndex = handRankIndex;
    }

    public int getHandRankIndex() {
        return this.handRankIndex;
    }
}
