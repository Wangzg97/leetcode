package ByTitleNumber;

import java.util.HashSet;
import java.util.Set;

public class length_of_LongestSubstring {
    // 暴力解法，会超时.时间复杂度：O(n^3)  空间复杂度：O(min(n, m))
    public int lengthOfLongestSubstring(String s){
        int n = s.length();
        int ans = 0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<=n; j++){
                if(allUnique(s, i, j))
                    ans = Math.max(ans, j-i);
            }
        }
        return ans;
    }

    public boolean allUnique(String s, int start, int end){
        Set<Character> set = new HashSet<>();
        for(int i=start;i<end;i++){
            Character ch = s.charAt(i);
            if(set.contains(ch))
                return false;
        }

        return true;
    }

    /********************************************************************/

    // 滑动窗口。时间复杂度：O(2n) = O(n)    空间复杂度：O(min(m, n))O(min(m,n))
    public int lengthOfLongestSubstring2(String s){
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while(i<n && j<n){
            // 窗口 [i,j) 左闭右开
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j-i);
            }else{
                set.remove(s.charAt(i++));
            }
        }

        return ans;
    }
}
