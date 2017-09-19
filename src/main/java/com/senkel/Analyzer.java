package com.senkel;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Analyzer {

    /**
     * Determines number of occurrences of words in the text.
     *
     * @param fileName path to the file to analyze.
     * @return number of words in the text.
     */
    public Map<String, Integer> getWordCount(String fileName) {
        FileInputStream fileInputStream;
        DataInputStream dataInputStream;
        BufferedReader bufferedReader = null;
        Map<String, Integer> wordMap = new HashMap<String, Integer>();
        try {
            fileInputStream = new FileInputStream(fileName);
            dataInputStream = new DataInputStream(fileInputStream);
            bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, " ");
                while (st.hasMoreTokens()) {
                    String tmp = st.nextToken().toLowerCase();
                    if (wordMap.containsKey(tmp)) {
                        wordMap.put(tmp, wordMap.get(tmp) + 1);
                    } else {
                        wordMap.put(tmp, 1);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (Exception ignored) {
            }
        }
        return wordMap;
    }

    /**
     * Sorts occurrences of words in the text.
     *
     * @param wordMap number of occurrences of words in the text.
     * @return sorted occurrences.
     */
    public List<Entry<String, Integer>> sortByValue(Map<String, Integer> wordMap) {
        Set<Entry<String, Integer>> set = wordMap.entrySet();
        List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);
        Collections.sort(list, new Comparator<Entry<String, Integer>>() {
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        return list;
    }
}