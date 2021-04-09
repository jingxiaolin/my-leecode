package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**两数之和
 * @author jingxiaolin
 */
public class TwoNumAdd {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum1(new int[]{3,2,4},6)));
    }

    /**时间复杂度O（n平方），空间复杂度O（1）
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target){
        int i=0,j=0;
        for(;i<nums.length;i++){
                for(j=i+1;j<nums.length;j++){
                    if((nums[i]+nums[j])==target){
                        return new int[]{i,j};
                    }
                }
        }
        return new int[]{i,j};
    }
    public static int[] twoSum1(int[] nums, int target){
        int i=0;
        Map<Integer,Integer> hasMap = new HashMap<Integer, Integer>(nums.length);
        for(;i<nums.length;i++){
            if(hasMap.containsKey(target-nums[i])){
                return new int[]{i,hasMap.get(target-nums[i])};
            }
            hasMap.put(nums[i],i);
        }
        return new int[]{0,0};
    }

}
