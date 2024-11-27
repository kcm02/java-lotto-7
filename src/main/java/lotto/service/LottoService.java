package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.LottoResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoService {

    private static int purchasedMoney;

    public static List<Lotto> drawLotto() {
        purchasedMoney = InputView.inputPurchaseAmount();
        var num = purchasedMoney / 1000;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            var numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        OutputView.printLottos(num, lottos);
        return lottos;
    }

    public static List<LottoRank> compareLotto(List<Lotto> lottos) {
        List<LottoRank> lottoRanks = new ArrayList<>();
        var winningLotto = InputView.inputWinningLotto();
        var bonusNumber = InputView.inputBonusNumber();

        for (Lotto lotto : lottos) {
            var lottoRank = lotto.compareLotto(winningLotto, bonusNumber, lotto);
            lottoRanks.add(lottoRank);
        }
        return lottoRanks;
    }

    public static void calculateTotalReturn(List<LottoRank> lottoRanks) {
        var totalPrize = 0;

        for (LottoRank lottoRank : lottoRanks) {
            totalPrize += lottoRank.getPrize();
        }

        var profitRate = calculateProfitRate(totalPrize, purchasedMoney);

        OutputView.printTotalReturn(profitRate);
    }

    public static void printLottoRanks(List<LottoRank> lottoRanks) {
        LottoResult lottoResult = new LottoResult(lottoRanks);
        List<String> results = lottoResult.getLottoRankCountsToString();
        OutputView.printWinningResults(results);
    }

    public static float calculateProfitRate(float totalPrize, float purchasedMoney) {
        if (purchasedMoney == 0) {
            return 0f;
        }
        return (totalPrize / purchasedMoney) * 100;
    }
}
