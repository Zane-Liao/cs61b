import edu.princeton.cs.algs4.Queue;

public class QuickSort {
    /**
     * Returns a new queue that contains the given queues catenated together.
     *
     * The items in q2 will be catenated after all of the items in q1.
     */
    private static <Item extends Comparable> Queue<Item> catenate(Queue<Item> q1, Queue<Item> q2) {
        Queue<Item> catenated = new Queue<Item>();
        for (Item item : q1) {
            catenated.enqueue(item);
        }
        for (Item item: q2) {
            catenated.enqueue(item);
        }
        return catenated;
    }

    /** Returns a random item from the given queue. */
    private static <Item extends Comparable> Item getRandomItem(Queue<Item> items) {
        int pivotIndex = (int) (Math.random() * items.size());
        Item pivot = null;
        // Walk through the queue to find the item at the given index.
        for (Item item : items) {
            if (pivotIndex == 0) {
                pivot = item;
                break;
            }
            pivotIndex--;
        }
        return pivot;
    }

    /**
     * Partitions the given unsorted queue by pivoting on the given item.
     *
     * @param unsorted  A Queue of unsorted items
     * @param pivot     The item to pivot on
     * @param less      An empty Queue. When the function completes, this queue will contain
     *                  all of the items in unsorted that are less than the given pivot.
     * @param equal     An empty Queue. When the function completes, this queue will contain
     *                  all of the items in unsorted that are equal to the given pivot.
     * @param greater   An empty Queue. When the function completes, this queue will contain
     *                  all of the items in unsorted that are greater than the given pivot.
     */
    private static <Item extends Comparable> void partition(
            Queue<Item> unsorted, Item pivot,
            Queue<Item> less, Queue<Item> equal, Queue<Item> greater) {
        // Your code here!
        for (Item sorted: unsorted) {
            if (pivot.compareTo(sorted) > 0) { // (pivot and sorted) > 0, pivot > sorted -> less
                less.enqueue(sorted);
            } else if (pivot.compareTo(sorted) < 0) { // (pivot and sorted) < 0, pivot < sorted -> greater
                greater.enqueue(sorted);
            } else {
                equal.enqueue(sorted);
            }
        }
    }

    /** Returns a Queue that contains the given items sorted from least to greatest. */
    public static <Item extends Comparable> Queue<Item> quickSort(
            Queue<Item> items) {
        // Your code here!
        int n = items.size();
        if (n <= 1) return items;
        Item pivot = getRandomItem(items);
        Queue<Item> less = new Queue<>();
        Queue<Item> equal = new Queue<>();
        Queue<Item> greater = new Queue<>();
        partition(items, pivot, less, equal, greater);
        if (!less.isEmpty()) less = quickSort(less); // use recurse update less and greater
        if (!greater.isEmpty()) greater = quickSort(greater);
        Queue<Item> almostHalf = catenate(less, equal);
        Queue<Item> results = catenate(almostHalf, greater);
        return results;
    }
    public static void main(String args[]) {
        Queue<Integer> studentNumbers = new Queue<>();
        studentNumbers.enqueue(-367);
        studentNumbers.enqueue(5);
        studentNumbers.enqueue(79);
        studentNumbers.enqueue(4623746);
        studentNumbers.enqueue(-6875875);
        studentNumbers.enqueue(1024);
        studentNumbers.enqueue(1);
        studentNumbers.enqueue(87);
        studentNumbers.enqueue(99);
        studentNumbers.enqueue(-78);
        System.out.print("Before: " + studentNumbers + " ");
        System.out.println();
        System.out.print("QuickSort: " + QuickSort.quickSort(studentNumbers) + " ");
        System.out.println();
    }
}
