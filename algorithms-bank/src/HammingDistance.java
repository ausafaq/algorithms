public class HammingDistance {

    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    /**
     * Using Brian Kernighan's Algorithm
     */
    public int hammingDistanceBrianK(int x, int y) {
        int xor = x ^ y;
        int distance = 0;
        while(xor != 0) {
            distance += 1;
            xor = xor & (xor - 1);
        }
        return distance;
    }
}
