package ByTitleNumber;

import java.util.HashMap;
import java.util.Map;

public class two_sum {
    // 暴力解法，两层for循环
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for(int i=0;i<nums.length;i++)
            for(int j=i+1;j<nums.length;j++)
                if(nums[i]+nums[j]==target){
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
        return null;
    }

    //两遍哈希表
    //时间复杂度：O(n)
    //空间复杂度：O(n)
    public int[] solution2(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], i);
        }
        for(int i=0; i<nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement) && map.get(complement)!=i ){
                return new int[] {i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No sum solution");
    }

    //一遍哈希表
    //时间复杂度：O(n)
    //空间复杂度：O(n)
    public int[] solution3(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[] {map.get(complement), i};
            }
            map.put(map.get(complement), i);
        }
        throw new IllegalArgumentException("No sum solution");
    }

}
