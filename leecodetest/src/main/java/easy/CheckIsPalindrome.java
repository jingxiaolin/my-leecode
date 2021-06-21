package easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author jingxiaolin
 */
public class CheckIsPalindrome {
    /*
    * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
    * */

    public static void main(String[] args) {
        System.out.println(check(122));
    }
    public static boolean  check(int x){
        if(x<0){
            return false;
        }
        int tmp = x,res = 0;
        while(tmp!=0){
            res *= 10;
            res += tmp%10;
            tmp/=10;
        }
        return Objects.equals(x,res);
    }

    public static boolean  check2(int x){
        if(x<0 || (x%10==0 && x!=0)){
            return false;
        }
        int res = 0;
        while(res < x){
            res *= 10;
            res += x%10;
            x/=10;
        }
        return Objects.equals(res,x) || Objects.equals(res/10,x);
    }
}
