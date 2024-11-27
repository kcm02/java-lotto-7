package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.model.ErrorMessage;

public class InputValidator {

    public static int validatePurchaseAmount(String input) {
        checkIsEmpty(input);
        var money = checkNumberFormat(input);

        if (money < 1000 || money % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_PURCHASE_UNIT_MESSAGE);
        }
        return money;
    }

    public static List<Integer> validateTokens(String input) {
        checkIsEmpty(input);
        List<Integer> numbers = new ArrayList<>();

        try {
            var tokens = separateInput(input);

            for (String token : tokens) {
                numbers.add(validateToken(token));
            }
            return numbers;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public static int validateToken(String token) {
        checkIsEmpty(token);
        int number = checkNumberFormat(token);

        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_NUMERIC_RANGE);
        }
        return number;
    }

    private static String[] separateInput(String input) {
        var numbers = input.split(",");

        if (numbers.length == 1) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_DELIMITER_MESSAGE);
        }
        return numbers;
    }

    private static int checkNumberFormat(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER_MESSAGE);
        }
    }

    private static void checkIsEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_STRING_MESSAGE);
        }
    }
}
