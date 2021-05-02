package numVowels;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println(checkVowels(name));
    }

    private static int checkVowels(String vowels){
        int numVowels=0;
        for(int i=0;i<vowels.length();i++){
            if(vowels.charAt(i)=='a'||vowels.charAt(i)=='A'||
                    vowels.charAt(i)=='i'||vowels.charAt(i)=='I'||
                    vowels.charAt(i)=='u'||vowels.charAt(i)=='U'||
                    vowels.charAt(i)=='e'||vowels.charAt(i)=='E'||
                    vowels.charAt(i)=='o'||vowels.charAt(i)=='O'
            )
                numVowels++;
        }
        return numVowels;
    }
}
