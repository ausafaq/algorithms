public class BinarySearchInfiniteArray {

    public int binarySearch(int[] nums, int left, int right, int target) {
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public int findPosition(int[] nums, int target) {
        int left = 0;
        int right = 1;
        int value = nums[0];

        while(value < target) {
            left = right;
            if(2 * right < nums.length - 1) {
                right = 2 * right;
            } else {
                right = nums.length;
            }
            value = nums[right];
        }
        return binarySearch(nums, left, right, target);
    }
}
