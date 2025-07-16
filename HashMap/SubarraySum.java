//Return number of subarrays whose sum amount to k.

//This is a very important question asked in MS and Amazon interviews and is often seen in modified forms.


/* HINT - The approach used here is called prefix sum
 * it takes O(n2) as opposed to O(n3) by traditional methods
 * 
 * to find the sum of elements between i and j (inclusive of it),
 * remove all the sum of elements before i.
 * 
 * sub(j)-sub(i-1) = k
 * 
 * OR since sub(j) - k = sub(i-1) by simply checking if sub(j) - k exists
 * within the array we can conclude if the required subarray exists
  */


import java.util.*;

public class SubarraySum {
    public static void main(String[] args) {

        int arr[] = {10,2,-2,-20,10}; 
        int k = -10; //target sum
        HashMap<Integer, Integer> map = new HashMap<>(); //<Sum,freq> a particular sum and how much time it appears as the sum of subsets eg [2,2] and [0,4]
        map.put(0,1); //empty subarray
        int ans = 0;
        int sum = 0;
        for(int j=0; j<arr.length; j++){
            sum+=arr[j];

            if(map.containsKey(sum-k)){
                ans += map.get(sum-k);
            }
     
            if(map.containsKey(sum)){
                map.put(sum,map.get(sum)+1);
            }else{
                map.put(sum,1);
            }
        }

        System.out.println(ans);
    }
}
