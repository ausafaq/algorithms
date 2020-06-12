public class DutchNationalFlagAlgorithm {

    /**
     * Sort 3 colors denoted by numbers
     */
    public void sortColors(int[] nums) {
        if(nums == null && nums.length <= 1) {
            return;
        }
        int left = 0, right = nums.length - 1;
        int curr = 0;

        while(curr <= right) {
            if(nums[curr] == 0) swap(nums, left++, curr++);
            else if(nums[curr] == 2) swap(nums, curr, right--);
            else curr++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
