package lotto.model;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private final List<LottoRank> lottoRanks;
    private final Map<LottoRank, Integer> lottoRankCounts;

    public LottoResult(List<LottoRank> lottoRanks) {
        this.lottoRanks = lottoRanks;
        this.lottoRankCounts = new EnumMap<>(LottoRank.class);
        setLottoRankCounts();
        putRankMatches();
    }

    public List<String> getLottoRankCountsToString() {
        List<String> results = new ArrayList<>();

        for (Map.Entry<LottoRank, Integer> entry : lottoRankCounts.entrySet()) {
            var lottoRank = entry.getKey();
            var count = entry.getValue();

            if (lottoRank != LottoRank.NONE) {
                String result = lottoRank.rankToString() + " - " + count + "개";
                results.add(result);
            }
        }
        return results;
    }

    public void putRankMatches() {
        for (LottoRank lottoRank : lottoRanks) {
            lottoRankCounts.put(lottoRank, lottoRankCounts.get(lottoRank) + 1);
        }
    }

    private void setLottoRankCounts() {
        lottoRankCounts.put(LottoRank.NONE, 0);
        lottoRankCounts.put(LottoRank.FIFTH, 0);
        lottoRankCounts.put(LottoRank.FOURTH, 0);
        lottoRankCounts.put(LottoRank.THIRD, 0);
        lottoRankCounts.put(LottoRank.SECOND, 0);
        lottoRankCounts.put(LottoRank.FIRST, 0);
    }
}
