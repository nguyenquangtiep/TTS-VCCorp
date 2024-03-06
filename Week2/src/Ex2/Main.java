package Ex2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String s = "catsanddog";
        String[] wordDict = {"cat", "cats", "and", "sand", "dog"};
        List<String> rs = addSpace(s, wordDict);
        for (String e: rs) {
            System.out.println(e);
        }
    }

    static List<String> addSpace(String s, String[] wordDict) {

        List<String> dict = Arrays.asList(wordDict);

        List<String> results = new LinkedList<>();

        addSpaceHelper(s, dict, 0, "", results);

        return results;

    }



    static void addSpaceHelper(String s, List<String> wordDict, int start, String current, List<String> results) {

        if (start == s.length()) {
            results.add(current.trim());
            return;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);
            if (wordDict.contains(word)) {
                addSpaceHelper(s, wordDict, end, current + word + " ", results);
            }
        }

    }
}
