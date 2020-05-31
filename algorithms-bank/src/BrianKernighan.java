public class BrianKernighan {

    /*
        Brian Kernighan's algorithm to turn off the rightmost bit of a number
        LeetCode: Bitwise AND of Numbers Range, Hamming Distance
        Time Complexity: O(1)
        Space Complexity: O(1)
     */
    public int rangeBitwiseAnd(int m, int n) {
        while(m < n) {
            // turn off rightmost 1-bit
            n = n & (n - 1);
        }
        return (m & n);
    }
}
