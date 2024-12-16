import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    @Test
    public void testWordToDeque() {
        Deque d1 = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d1.removeFirst();
        }
        assertEquals("persiflage", actual);
    } // Uncomment this class once you've created your Palindrome class.
    @Test
    public void testIsPalindrome() {
        // return True
        assertTrue(palindrome.isPalindrome("noon"));
        assertTrue(palindrome.isPalindrome("racecar"));
        assertTrue(palindrome.isPalindrome("a"));
        // return False
        assertFalse(palindrome.isPalindrome("aaaaapd"));
        assertFalse(palindrome.isPalindrome("cats"));
        assertFalse(palindrome.isPalindrome("cbhgdhbc"));
    }
    @Test
    public void testOffByOneIsPalindrome() {
        CharacterComparator cc = new OffByOne();
        assertFalse(palindrome.isPalindrome("gork", cc));
        assertTrue(palindrome.isPalindrome("noon", cc));
        assertFalse(palindrome.isPalindrome("dcbyweuvcgwegh", cc));
    }
}
