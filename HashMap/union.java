//Program to implement union of 2 arrays
import java.util.*;
public class union {
    
    public static int function(int arr1[], int arr2[]){

        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<arr1.length; i++){
            set.add(arr1[i]);
        }

        for(int j=0; j<arr2.length; j++){
            set.add(arr2[j]);
        }

        return set.size();
    }

    public static void main(String[] args) {
        int arr1[] = {7,3,9};
        int arr2[] = {6,3,9,2,9,4};
        System.out.println(function(arr1,arr2));
    }
}
