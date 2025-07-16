/*MAJORITY ELEMENT - Given an integer array of size n, find all
elements that appear more than floor(n/3) times */

//They key here is number and value is frequency

import java.util.*;
public class majorityelement {
    
    public static void function(int nums[]){

        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }

        for(int key: map.keySet()){
            if(map.get(key) > Math.floor(n/3)){
                System.out.println(key);
            }
        }
    }

    public static void main(String args[]){
        int nums[] = {1,3,2,5,1,3,1,15,1};
        function(nums);
    }
}
