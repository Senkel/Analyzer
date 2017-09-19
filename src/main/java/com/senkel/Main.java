package com.senkel;

import java.util.List;
import java.util.Map;

/**
 * Application entry point.
 */
public class Main {

    private static final String fileName = "src/main/resources/file.txt";

    public static void main(String[] args) {
        Analyzer analyzer = new Analyzer();
        Map<String, Integer> wordMap = analyzer.getWordCount(fileName);
        List<Map.Entry<String, Integer>> list = analyzer.sortByValue(wordMap);
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
