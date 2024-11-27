package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.service.LottoService;

public class LottoController {

    public void run() {
        List<Lotto> lottos = LottoService.drawLotto();
        List<LottoRank> lottoRanks = LottoService.compareLotto(lottos);
        LottoService.printLottoRanks(lottoRanks);
        LottoService.calculateTotalReturn(lottoRanks);
    }
}
