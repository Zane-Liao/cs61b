public class Palindrome {

    /**
     * This */
    public Deque<Character> wordToDeque(String word) {
        ArrayDeque<Character> single_ch = new ArrayDeque<Character>();
        for (int i = 0; i < word.length(); i += 1) {
            char ch = word.charAt(i);
            single_ch.addLast(ch);
        }
        return single_ch;
    }

    /**
     * */
    public boolean isPalindrome(String word) {
        int wordLength = word.length() / 2;
        Deque singleWord = wordToDeque(word);
        String ch1 = "";
        String ch2 = "";
        while (wordLength > 0) {
            ch1 += singleWord.removeFirst();
            ch2 += singleWord.removeLast();
            wordLength -= 1;
        }
        if (ch1.equals(ch2)) { // String and String not use '=='
            return true;
        }
        return false;
    }

    /**
     * */
    public boolean isPalindrome(String word, CharacterComparator cc) {
        int wordLength = word.length() / 2;
        for (int i = 0; i < wordLength / 2; i += 1) {
            if (!cc.equalChars(word.charAt(i), word.charAt(wordLength - i - 1))) { // Solution
                return false;
            }
        }
        return true;
    }
}
