package numSpace;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println(numSpace(name));
    }

    private static int numSpace(String s){
        int numSpace=0;
        for(int i=0;i<s.length();i++){
            if(Character.isWhitespace(s.charAt(i))){
                numSpace++;
            }
        }
        return numSpace;
    }
}
