package lotto.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constans.ErrorMessage;
import lotto.util.InputValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"900","1500"})
    void purchaseAmountValidator(String input) {
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.WRONG_PURCHASE_UNIT_MESSAGE);

        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount("String"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_NUMBER_MESSAGE);
    }

    @Test
    void isEmpty() {
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.EMPTY_STRING_MESSAGE);
    }

    @Test
    void validateTokens() {
        assertThatThrownBy(() -> InputValidator.validateTokens(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.EMPTY_STRING_MESSAGE);

        assertThatThrownBy(() -> InputValidator.validateTokens("1:2:3:4:5:6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.WRONG_DELIMITER_MESSAGE);

        assertThatThrownBy(() -> InputValidator.validateTokens("1,2,3,4,5,66"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.WRONG_NUMERIC_RANGE);

        assertThatThrownBy(() -> InputValidator.validateTokens("1,2,3,,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.EMPTY_STRING_MESSAGE);
    }
}