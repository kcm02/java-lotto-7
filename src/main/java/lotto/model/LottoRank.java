package lotto.model;

import java.text.DecimalFormat;

public enum LottoRank {

    NONE(0, 0, false, 0),
    FIFTH(5, 3, false, 5000),
    FOURTH(4, 4, false, 50000),
    THIRD(3, 5, false, 1500000),
    SECOND(2, 5, true, 30000000),
    FIRST(1, 6, false, 2000000000);

    private int rank;
    private int matchCount;
    private boolean bonusMatch;
    private int prize;


    LottoRank(int rank, int matchCount, boolean bonusMatch, int prize) {
        this.rank = rank;
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prize = prize;
    }

    public static LottoRank valueOf(int matchCount, boolean bonusMatch) {
        for (LottoRank lottoRank : values()) {
            if (matchCount != 5) {
                bonusMatch = false;
            }

            if (lottoRank.matchCount == matchCount && lottoRank.bonusMatch == bonusMatch) {
                return lottoRank;
            }
        }
        return NONE;
    }

    public String rankToString() {
        var bonusMessage = "";
        if (bonusMatch) {
            bonusMessage = ", 보너스 볼 일치";
        }
        return matchCount + "개 일치" + bonusMessage + " (" + formatPrize(prize) + "원)";
    }

    private String formatPrize(int prize) {
        DecimalFormat df = new DecimalFormat("###,###");
        return df.format(prize);
    }

    public int getPrize() {
        return prize;
    }
}
