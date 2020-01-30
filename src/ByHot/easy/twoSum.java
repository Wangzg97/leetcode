package ByHot.easy;

import java.util.HashMap;
import java.util.Map;

public class twoSum {

    // 暴力解法，两层遍历
    public int[] solution1(int[] nums, int target) {
        int[] res = new int[2];
        for (int i=0; i< nums.length; i++)
            for (int j=i+1; j<nums.length; j++){
                if (nums[i] + nums[j] == target){
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }

        return null;
    }

    // 两边哈希表
    public int[] solution2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            map.put(nums[i], i);
        }
        for (int i=0; i<nums.length; i++){
            int temp = target - nums[i];
            if (map.containsKey(temp) && map.get(temp) != i){
                return new int[] {i, map.get(temp)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    // 一遍哈希表
    public int[] solution3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            int temp = target - nums[i];
            if (map.containsKey(temp) && map.get(temp) != i){
                return new int[] {i, map.get(temp)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
