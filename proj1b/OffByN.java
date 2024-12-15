public class OffByN implements CharacterComparator {
    public int N;
    public OffByN(int N) {
        this.N = N;
    }
    @Override
    public boolean equalChars(char x, char y) {
        int diff = Math.abs(x - y);
        if (diff == N) {
            return true;
        }
        return false;
    }
}
