public class NewtonAlgorithm {

    /**
     * Newton's Algorithm to check if a num is a perfect square
     * x2 = (x1 + num/x1) / 2
     * Time complexity: O(log(n))
     * Space complexity: O(1)
     */
    public static boolean isPerfectSquareNewtons(int num) {
        if(num < 2) {
            return true;
        }
        long x = num / 2;
        while(x * x > num) {
            x = (x + num/x) / 2;
        }
        return (x*x == num);
    }
}
