public class HorribleSteve {
    public static void main(String [] args) {
        int i = 0;
        int b = 0;
        for (int j = 0; j < 500; j += 1) {
            if (Flik.isSameNumber(i, b)) {
                b += 1;
                i += 1;
            } else {
                break;
            }
        }
        System.out.println("i is " + i);
    }
}
