package factorial;

public class Main {
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }

    private static int factorial(int num){
        int b=1;
        int a =0;
        for(int i=1;i<=num;i++){
            a=i;
            b=b*a;
        }
        return b;
    }
}
