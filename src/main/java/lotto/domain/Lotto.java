package lotto.domain;

import java.util.Collections;
import java.util.List;
import lotto.constans.ErrorMessage;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6 || numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_NUMBERS_SIZE);
        }
    }

    public LottoRank compareLotto(Lotto winningLotto, int bonusNumber, Lotto lotto) {
        var matchCount = 0;
        var bonusMatch = false;

        for (int number : lotto.numbers) {
            if (winningLotto.numbers.contains(number)) {
                matchCount += 1;
            }
            if (bonusNumber == number) {
                bonusMatch = true;
            }
        }

        LottoRank lottoRank = LottoRank.valueOf(matchCount, bonusMatch);
        return lottoRank;
    }

    public String toString() {
        return numbers.toString();
    }
}
