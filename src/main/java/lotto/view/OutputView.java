package lotto.view;

import java.util.List;
import lotto.model.Lotto;

public class OutputView {

    public static void printPurchaseMessage() {
        System.out.println("\n구입금액을 입력해 주세요.");
    }

    public static void printWinningLottoMessage() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public static void printBonusNumberMessage() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public static void printErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }

    public static void printLottos(int num, List<Lotto> lottos) {
        System.out.println("\n" + num + "개를 구매했습니다.");
        lottos.forEach(lotto -> System.out.println(lotto.toString()));
    }

    public static void printWinningResults(List<String> results) {
        System.out.println("당첨 통계");
        System.out.println("---");

        for (String result : results) {
            System.out.println(result);
        }
    }

    public static void printTotalReturn(float profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.", profitRate);
    }
}
