import java.util.*;

class Solution{
    public int[] twosum(int[] a, int target){
        HashMap<Integer, Integer> dict = new HashMap<>();
        int i;
        for (i=0;i<a.length;i++){
            if (dict.containsKey(target - a[i])){
                return new int[]{dict.get(target - a[i]), i};
            }
            dict.put(a[i], i);
        }
        return new int[]{};
    }
}

public class Twosum {
    public static void main(String[] args){
        Solution sol = new Solution();
        int[] intarr = new int[]{2, 7, 10, 11};
        int[] result = sol.twosum(intarr, 17);
        System.out.println(Arrays.toString(result));
    }
}
