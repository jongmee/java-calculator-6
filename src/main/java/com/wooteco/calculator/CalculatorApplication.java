package com.wooteco.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorApplication {
    // 문자열 입력 메서드
    public static String inputText() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    //빈 문자열 혹은 null 입력 시 0 반환 메서드
    public static boolean isZeroValue(String text) {
        return text == null || text.isEmpty();
    }

    //커스텀 구분자 찾기 메서드
    public static List<String> findCustomDelimiter(String text) {
        Matcher m = Pattern.compile("//(.)\\\\n(.*)").matcher(text);
        if (m.find()) {
            return Arrays.asList(m.group(1), m.group(2));
        }
        return Arrays.asList("", text);
    }

    //구분자로 문자열 분리 메서드
    public static String mergeDelimiter(String delimiter) {
        if (!delimiter.isEmpty()) {
            return ",|:|" + delimiter;
        }
        return ",|:" + delimiter;
    }

    // 숫자들을 더하는 메서드
    public static int sumNumbers(String[] numbers) {
        int result = 0;
        for(String number: numbers) {
            int parsedNumber = parseInteger(number);
            validateMinusNumber(parsedNumber);
            result += parsedNumber;
        }
        return result;
    }

    // 문자열을 정수로 변환하는 메서드
    public static int parseInteger(String number) {
        try {
            return Integer.valueOf(number);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자를 입력해주세요.");
        }
    }

    // 음수 검증 메서드
    public static void validateMinusNumber(int number) {
        if(number < 0) {
            throw new RuntimeException("음수를 입력할 수 없습니다.");
        }
    }

    public static void main(String[] args) {
        String input = inputText();
        Boolean isZeroValue = isZeroValue(input);
        if(isZeroValue) {
            System.out.println(0);
        }
        List<String> customDelimiter = findCustomDelimiter(input);
        String separators = mergeDelimiter(customDelimiter.get(0));
        String[] numbers = customDelimiter.get(1).split(separators);

        System.out.println(sumNumbers(numbers));
    }
}