public class KthLargestElement {
    public int kthLargestElement(int n, int[] nums) {
        java.util.Arrays.sort(nums);
        return nums[nums.length-n];
    }
}