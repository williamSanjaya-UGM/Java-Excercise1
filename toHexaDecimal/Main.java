package toHexaDecimal;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String test="hello how are you?";
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<test.length();i++){
            int ascii=(int)test.charAt(i);
            System.out.println(ascii);
            sb.append(Character.toString(ascii+2));
        }
        System.out.println(sb);

        // Hash function example
        int[] arr={10,30,49,3,50,9,100};
        createHashMap(arr);
    }

    private static void createHashMap(int arr[]){
        HashMap<Integer,Integer> hMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            // Get if the element is present
            Integer c = hMap.get(arr[i]);

            // If this is first occurrence of element
            // Insert the element
            if (hMap.get(arr[i]) == null) {
                hMap.put(arr[i], 1);
            }else {
                hMap.put(arr[i], ++c);
            }
        }
        System.out.println(hMap);
    }
}
