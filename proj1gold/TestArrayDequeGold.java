import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayDeque;

public class TestArrayDequeGold {
    /** &#064;source  StudentArrayDequeLauncher.java and others Solution*/
    @Test
    public void testRandomArrayDeque() {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> sad2 = new ArrayDequeSolution<>();
        String errorLog = "";
        for (int i = 0; i < 100; i += 1) {
            int numberBetweenZeroAndOne = StdRandom.uniform(20);
            int number1 = StdRandom.uniform(100);
            if (numberBetweenZeroAndOne < 5) {
                sad1.addFirst(number1);
                sad2.addFirst(number1);
                errorLog += "addFirst" + "(" + number1 + ")" + "\n";
                // Every update element,
                // addFirst -> before: [2, 3]  after: [1, 2, 3] get(0) -> 1
                assertEquals(errorLog, sad2.get(0), sad1.get(0));
            } else if (numberBetweenZeroAndOne > 5 && numberBetweenZeroAndOne < 10){
                sad1.addLast(number1);
                sad2.addLast(number1);
                errorLog += "addLast" + "(" + number1 + ")" + "\n";
                // addLast -> before: [1, 2, 3]
                // after: [1, 2, 3, 4] get(sad2.size() - 1) -> 4
                // index - 1 = size() , Index starts at 0
                assertEquals(errorLog, sad2.get(sad2.size() - 1), sad1.get(sad1.size() - 1));
            } else if (numberBetweenZeroAndOne > 10 && numberBetweenZeroAndOne < 15) {
                errorLog += "removeFirst()" + "\n";
                assertEquals(errorLog, sad2.removeFirst(), sad1.removeFirst());
            } else {
                errorLog += "removeLast()" + "\n";
                assertEquals(errorLog, sad2.removeLast(), sad1.removeLast());
            }
        }
    }
    public static void main(String[] args) {
        jh61b.junit.TestRunner.runTests(TestArrayDequeGold.class);
    }
}
