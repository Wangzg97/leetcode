package ByTitleNumber;

public class isPalindrome {

    // 时间复杂度：O(\log_{10}(n))
    //空间复杂度：O(1)
    public boolean solution1(int x) {
        // 负数不是回文数
        if (x < 0) {
            return false;
        }
        // 最后一位是0时，只有0符合条件
        if (x % 10 == 0 && x != 0) {
            return false;
        }

        int temp = 0;
        while (x > temp) {
            temp = x % 10 + temp * 10;
            x = x / 10;
        }

        if (x == temp) {
            return true;
        } else if (x == temp / 10) { // x长度为奇数，此时temp比处理后的x多一位，中间位不影响
            return true;
        } else {
            return false;
        }
    }

    // 整数转化为字符串,效率低
    public boolean solution2(int x) {
        String reverse = (new StringBuilder(x+"")).reverse().toString();
        return reverse.equals(x+"");
    }
}
