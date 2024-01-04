//Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:
//
//answer[i] % answer[j] == 0, or
//answer[j] % answer[i] == 0
//If there are multiple solutions, return any of them.
//
//
//
//Example 1:
//
//Input: nums = [1,2,3]
//Output: [1,2]
//Explanation: [1,3] is also accepted.
//Example 2:
//
//Input: nums = [1,2,4,8]
//Output: [1,2,4,8]
//
//
//Constraints:
//
//1 <= nums.length <= 1000
//1 <= nums[i] <= 2 * 109
//All the integers in nums are unique.


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> dp = new ArrayList<>();
        for (int i=0;i<nums.length;i++)
            dp.add(new ArrayList());

        for(int i = 0; i < nums.length; i++){
            List<Integer> dp_Sub = new ArrayList<>();
            for(int j = 0; j < i; j++){
                if(nums[i] % nums[j] == 0 && dp.get(j).size()>dp_Sub.size()){
                    dp_Sub= dp.get(j);
                }
            }
            dp.get(i).add(nums[i]);
            dp.get(i).addAll(dp_Sub);


        }

        List<Integer> longest = new ArrayList();
        for(List<Integer> c : dp){
            if(c.size() > longest.size()){
                longest = c;
            }

        }

        return longest;
    }
}
