package salary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        File file=new File("./src/empSalary.txt");
        List<String> fileStringList = loadFile(file);

        System.out.print("Input the name or money amount you want: ");
        Scanner scanner = new Scanner(System.in);
        String inputName = scanner.next();

        List<String> collect1 = encryptResultVer1(fileStringList, inputName);

        List<String> collect2 = encryptResultVer2(fileStringList, inputName);

        System.out.println("ver1: "+collect1);
        System.out.println("ver2: "+collect2);
    }

    private static List<String> loadFile(File file) {
        List<String> fileStringList = new ArrayList<>();
        try {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()){
                fileStringList.add(fileScanner.nextLine().replace(" ",""));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return fileStringList;
    }

    private static List<String> encryptResultVer1(List<String> fileStringList, String inputName) {
        return fileStringList.stream()
                .filter(s -> s.contains(inputName))
                .map(s -> {
                    String[] split = s.split(",");
                    String name=split[0];
                    String digits = split[1];
                    String encrypt = hideString(name);
                    String firstChar=name.substring(0, 1);
                    String twoLastChar=name.substring(name.length() - 2);
                    return firstChar + encrypt + twoLastChar + "," + replaceLastThree(digits);
                }).collect(Collectors.toList());
    }

    private static String hideString(String word){
       return word.substring(1,word.length()-2).replaceAll("[a-zA-Z]", "*");
    }

    private static String replaceLastThree(String digits){
        if(digits.length()>3) {
            return digits.substring(0,digits.length()-3)+"***";
        }
        return "Error, provided digits is less than 3";
    }

    private static List<String> encryptResultVer2(List<String> fileStringList, String inputName) {
        return fileStringList.stream()
                .filter(s -> s.contains(inputName))
                .map(s -> {
                    String[] split = s.split(",");
                    String name=split[0];
                    String digits = split[1];
                    StringBuilder builder = encryptProcess(name);
                    return builder+","+ replaceLastThree(digits);
                }).collect(Collectors.toList());
    }

    private static StringBuilder encryptProcess(String name) {
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<name.length();i++) {
            if(i==0 || i==name.length()-2||i==name.length()-1){
                builder.append(name.charAt(i));
            }else
                builder.append("*");
        }
        return builder;
    }
}
