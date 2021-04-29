package caesarCipher;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nextLine= scanner.nextLine();
        StringBuilder sb = new StringBuilder();

        for(String s:nextLine.split(" ")){
            sb.append(s+" ");
        }
        StringBuilder encrypted = CaesarEncrypt(sb, 3);

        StringBuilder decrypted = CaesarDecrypt(sb, 3);

        System.out.println("encrypt: "+encrypted);
        System.out.println("decrypt: "+decrypted);
    }

    private static StringBuilder CaesarEncrypt(StringBuilder sb,int moveBy){
        StringBuilder caesarResult=new StringBuilder();

        for(int i=0;i<sb.length();i++){
            if(!Character.isWhitespace(sb.charAt(i))) {
                if(Character.isUpperCase(sb.charAt(i))) {
                    int ascii=(sb.charAt(i)+moveBy-65)%26;
                    int caesar= ascii+65;
                    caesarResult.append(Character.toString(caesar));
                }else {
                    int ascii=(sb.charAt(i)+moveBy-97)%26;
                    int caesar= ascii+97;
                    caesarResult.append(Character.toString(caesar));
                }
            }else{
                caesarResult.append(" ");
            }
        }
        return caesarResult;
    }

    private static StringBuilder CaesarDecrypt(StringBuilder sb, int moveBy) {
        StringBuilder caesarResult=new StringBuilder();

        for(int i=0;i<sb.length();i++){
            if(!Character.isWhitespace(sb.charAt(i))) {
                if(Character.isUpperCase(sb.charAt(i))) {
                    int ascii=(sb.charAt(i)-moveBy-65)%26;
                    int caesar= ascii+65;
                    caesarResult.append(Character.toString(caesar));
                }else {
                    int ascii=(sb.charAt(i)-moveBy-97)%26;
                    int caesar= ascii+97;
                    caesarResult.append(Character.toString(caesar));
                }
            }else{
                caesarResult.append(" ");
            }
        }
        return caesarResult;
    }
}
