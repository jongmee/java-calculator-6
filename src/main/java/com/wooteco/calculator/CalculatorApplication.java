package com.wooteco.calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
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
    public static String findCustomDelimiter(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            return m.group(1);
        }
        return "";
    }

    //구분자로 문자열 분리 메서드
    public static String mergeDelimiter(String text) {
        if (!text.isEmpty()) {
            return ",|:|" + text;
        }
        return ",|:" + text;
    }

    public static void main(String[] args) {
        String input = readLine();
        List<String> separator = new ArrayList<>(List.of(":", ","));
        final Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            final String customDelimiter = m.group(1);
            final String[] tokens= m.group(2).split(customDelimiter);
            // 덧셈 구현
        }

    }
}