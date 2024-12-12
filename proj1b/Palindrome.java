public class Palindrome {

    /**
     * This */
    public Deque<Character> wordToDeque(String word) {
        LinkedListDeque<Character> single_ch = new LinkedListDeque<Character>();
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
        if (ch1 == ch2) {
            while (wordLength > 0) {
                ch1 += singleWord.removeFirst();
                ch2 += singleWord.removeLast();
                wordLength -= 1;
            }
        } else {
            return false;
        }
//        for (int i = 0; i < wordLength / 2; i += 1) {
//            if (ch1 == ch2) {
//                ch1 += singleWord.removeFirst();
//                ch2 += singleWord.removeLast();
////                if (ch1 != ch2) {
////                    return false;
////                }
//            }
//            return true;
//        }
//        return true;
        return true;
    }
}
