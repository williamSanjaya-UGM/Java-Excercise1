package StringVsStringBuilder;

public class Main {
    public static void main(String[] args) {
        String str = "Test String";
        str.concat("William");
        String first = str.concat(" William");
        System.out.println("from str :"+str);
        System.out.println("from first: "+first);

        StringBuffer sb =new StringBuffer("Test out");
        sb.append(" William");
        System.out.println("from sb :"+sb);
    }
}
