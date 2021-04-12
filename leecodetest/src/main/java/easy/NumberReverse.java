package easy;

import java.util.Arrays;

public class NumberReverse {
    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
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
}
