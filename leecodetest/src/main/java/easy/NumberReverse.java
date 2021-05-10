package easy;

import java.util.Arrays;

public class NumberReverse {
    public static void main(String[] args) {
        System.out.println(reverse2(123));
    }

    public static int reverse(int x){
        String s = x+"";
        char[] characters = s.toCharArray();
        if(x<0){
            characters = s.substring(1).toCharArray();
        }
        int i=0,j=characters.length-1;
        for(;i<characters.length/2;i++,j--){
            char tmp = characters[i];
            characters[i] = characters[j];
            characters[j] = tmp;
        }
        int k=0;
        for(;k<characters.length-1;){
            if(characters[k] == '0'){
                k++;
            }else {
                break;
            }
        }
        char[] resChar = new char[characters.length-k];
        System.arraycopy(characters,k,resChar,0,characters.length-k);
        s = new String(resChar);
        long res = Long.valueOf(s);
        if(res>Integer.MAX_VALUE){
            return 0;
        }
        if(x<0){
            res = 0-res;
        }
        return (int)res;
    }

    public static int reverse2(int x){
        int res = 0;
        while (x != 0){
            if( res >0 && res > (Integer.MAX_VALUE-x%10)/10 || res <0 && res < (Integer.MIN_VALUE-x%10)/10){
                return 0;
            }
            res = res * 10 + x%10;
            x /= 10;
        }
        return res;
    }

}
