package checkTypes;

public class Main{
    public static void main(String[] args) {
        String firstName="William";
        int nums=3;
        typeChecker(firstName,nums);
    }

    public static <T,W> void typeChecker(T types1, W types2){
        String tipe1=types1.getClass().getSimpleName();
        String tipe2=types2.getClass().getSimpleName();
        System.out.println("tipe1: "+tipe1+" "+"tipe2: "+tipe2);
        if(tipe1==tipe2) System.out.println("kedua tipe sama");
        else System.out.println("kedua tipe beda");
    }
}