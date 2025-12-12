import java.util.*;

class Main {
    public static void main(String[] args) {
        int arr[] = {11, 12, 13, 14};
        int places[] = {4, 2, 1, 3}; // positions starting from 1
        int new_arr[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            new_arr[places[i] - 1] = arr[i]; // subtract 1 from places[i]
           
        }
         System.out.println(Arrays.toString(new_arr));
    }
}
