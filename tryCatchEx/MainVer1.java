package tryCatchEx;

import java.util.Arrays;
import java.util.List;

public class MainVer1 {
    public static void main(String[] args) {
        List<Integer> listTemp = listOfArr();
        try{
            listTemp.stream().forEach(integer -> System.out.println(integer*2));
            System.out.println("get executed 1");
            try{
                listTemp.stream().forEach(integer -> System.out.println(integer/0));
                System.out.println("get executed 2");
            } catch (ArithmeticException e){
                throw new ArithmeticException("Error arithmetic is not allowed");
            } finally {
                System.out.println("get executed 3");
            }
            System.out.println("it will not run");
        }catch (NullPointerException e ){
            throw new NullPointerException("Null from int1 is not allowed");
        }finally {
            System.out.println("does this get executed?");
        }
    }

    public static List<Integer> listOfArr(){
        return Arrays.asList(2,5,7,34,40,17);
    }
}
