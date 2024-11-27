package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.service.InputValidator;

public class InputView {

    public static int inputPurchaseAmount() {
        while (true) {
            OutputView.printPurchaseMessage();
            var input = Console.readLine();

            try {
                var money = InputValidator.validatePurchaseAmount(input);
                return money;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    public static Lotto inputWinningLotto() {
        while (true) {
            OutputView.printWinningLottoMessage();
            var input = Console.readLine();

            try {
                Lotto lotto = new Lotto(InputValidator.validateTokens(input));
                return lotto;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    public static int inputBonusNumber() {
        while (true) {
            OutputView.printBonusNumberMessage();
            var input = Console.readLine();

            try {
                return InputValidator.validateToken(input);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
