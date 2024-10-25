public class MajorityElement {

    public static int findMajorityElement(int[] nums) {
        int candidate = findCandidate(nums);
        return isMajority(nums, candidate) ? candidate : -1;
    }

    // Step 1: Find the candidate for majority element
    private static int findCandidate(int[] nums) {
        int candidate = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                candidate = nums[i];
                count = 1;
            }
        }

        return candidate;
    }

    // Step 2: Verify if the candidate is actually the majority
    private static boolean isMajority(int[] nums, int candidate) {
        int count = 0;

        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }

        return count > nums.length / 2;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int majorityElement = findMajorityElement(nums);

        if (majorityElement != -1) {
            System.out.println("The majority element is: " + majorityElement);
        } else {
            System.out.println("No majority element found.");
        }
    }
}
