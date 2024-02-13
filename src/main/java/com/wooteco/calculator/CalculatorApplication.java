package com.wooteco.calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorApplication {

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