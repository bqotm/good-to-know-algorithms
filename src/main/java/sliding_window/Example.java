package sliding_window;

import java.util.HashSet;
import java.util.Set;

public class Example {

    /*
        k=3
            [ 3 9  5  4  2  3  7]
              |    |
     */
    //Maximum Sum Subarray of Size K
    public static int maxSumSubarray(int[] array, int k) {

        int current = 0, sum;
        for (int i = 0; i < k; i++) {
            current += array[i];
        }
        sum = current;
        for (int i = k; i < array.length; i++) {
            current += (array[k] - array[i - k]);
            sum = Math.max(current, sum);
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {3, 9, 5, 4, 2, 3, 7};
        System.out.println(maxSumSubarray(arr, 3));
        System.out.println(lengthLongestSubstring("aebaerc"));
    }


    /*
        s o m e b |e d y o n. v r q x
        a e b a e r c
     */
    //Longest Substring Without Repeating Characters
    public static int lengthLongestSubstring(String s) {

        Set<Character> chars = new HashSet<>();
        int i=0, j=0, l=0;
        while(j<s.length()) {
            if(chars.add(s.charAt(j))) {
                l=Math.max(l, chars.size());
                j++;
            } else {
                chars.remove(s.charAt(i));
                i++;
            }
        }
        return l;
    }



}
