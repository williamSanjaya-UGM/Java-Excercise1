package markerInterface;

class Test implements Permission{
    public void myMethod(){
        System.out.println("This is from myClass Method");
    }
}

public class Main {
    public static void main(String[] args) {
        Test test =  new Test();
        if(test instanceof Permission)
            test.myMethod();
        else
            System.out.println("method inside class Test is not accessible");
    }
}
