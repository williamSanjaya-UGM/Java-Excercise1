package rupiah;

public class Main {
    public static void main(String[] args) {
        int[] arr = {3, 9, 87, 18, 69, 65, 74};
        String[] stringsArr = new String[arr.length];

        for (int i = 0; i < arr.length; i++) {
            stringsArr[i] = String.valueOf(arr[i]);
        }

        //Expected strResult:
        String withPlus=String.join("+",stringsArr);
        System.out.println(withPlus);

        //ExpectedNumResult
        String joined = String.join("", stringsArr);
        System.out.println(joined);
    }

}
