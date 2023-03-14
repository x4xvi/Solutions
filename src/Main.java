import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] singleNumber_test = new int[]{-1, -1, 0,0,1, 3, 3, 44, 44, 5, 5, 5, 5, 5, 5, 5};
        System.out.println(singleNumber(singleNumber_test));
        int minSplit_test = 156;
        System.out.println(minSplit(minSplit_test));
        int[] notContains_test= new int[]{40, 0, -1, 1};
        System.out.println((notContains(notContains_test)));
        String a_test="1010";
        String b_test="1011";
        System.out.println(addBinaryString(a_test,b_test));
        int stearsCount_test=3;
        System.out.println(countVariants(stearsCount_test));

        MyCustomList data= new MyCustomList();
        data.add(5);
        data.get(0);
        data.add(10);
        data.add(11);
        data.get(1);
        data.delete(5);


    }


    public static int singleNumber(int[] nums) {
        //declaring Hashmap for storing array numbers as keys and repetitions as values
        HashMap<Integer, Integer> Numbers = new HashMap<>();
        //iterating trough number array
        for (int number : nums) {
            /* checking if hashmap already contains number as a key if not adding number as key with value 1
             if hashmap already contains key then changing  its value adding 1*/
            if (Numbers.containsKey(number)) {
                Numbers.put(number, Numbers.get(number) + 1);
            } else {
                Numbers.put(number, 1);
            }
        }
        /* iterating though  hashmap keys and checking if there is a key with value 1 if yes return that key if not
         return -1
         */
        for (int key_num : Numbers.keySet()) {
            if (Numbers.get(key_num) == 1) {
                return key_num;
            }
        }
        return -1;
    }
    public static int minSplit(int amount){
        int coin_count=0;
        //declaring available coins as array in a reverse order
        int [] coin_array= new int[]{50,20,10,5,1};
        //iterating trough coin array and decreasing amount using the greatest coins till amount it's possible
        for (int i=0;i<coin_array.length;i++){
            while (amount>=coin_array[i]){
                amount-=coin_array[i];
                coin_count++;
            }
        }
        return coin_count;
    }
    public static int notContains(int[] array){
        int array_len = array.length;
        boolean[] boolean_array = new boolean[array_len+1];
        //iterating trough array and filling boolean_array with true if array member is greater than 0 and is less or equal to array len
        for (int i = 0; i < array_len; i++) {
            if (array[i] > 0 && array[i] <= array_len) {
                boolean_array[array[i]] = true;
            }
        }
        for (int i = 1; i <= array_len; i++) {
            if (!boolean_array[i]) {
                return i;
            }
        }
        return array_len+1;
    }

    public static String addBinaryString(String a, String b) {
        // converting binary into integer and adding
        int sum = Integer.parseInt(a, 2) + Integer.parseInt(b, 2);
        // returning sum converted into binary
        return Integer.toBinaryString(sum);
    }
    public static int countVariants(int stearsCount){
        int[] stair_climb_variants =  new int[stearsCount];
        //if stearsCount is 1 then there is one possibility to climb that stair
        if (stearsCount==1) {
            return 1;
        }
        //if stearsCount is 2 then there is two possibility to climb that stair
        if (stearsCount==2) {
            return 2;
        }
        //adding stair_climb_variants numbers of variation when stearsCount is 1 and 2
        stair_climb_variants[0]=1;
        stair_climb_variants[1]=2;
        //every second stair climb  variation equals to the sum of pervious  two stair climb  variations
        for(int i=2;i<stearsCount;i++){
            stair_climb_variants[i]=stair_climb_variants[i-1]+stair_climb_variants[i-2];
        }
        return stair_climb_variants[stearsCount-1];
    }


    }







