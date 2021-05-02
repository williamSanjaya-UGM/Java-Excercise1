package gembok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'getResult' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING A
     *  2. STRING B
     *  3. STRING_ARRAY moves
     */

    public static String getResult(String A, String B, List<String> moves) {
        List<Integer> getArr=new ArrayList<>();
        String result = null;
        for(String move:moves){
            List<Integer> acc = new ArrayList<>();
            for(int i=0;i<move.length();i++){
                if(move.charAt(i)=='>')
                    acc.add(1);
                else if(move.charAt(i)=='<') {
                    acc.add(-1);
                }
            }
            Integer reduce = acc.stream().reduce(0, (a, b) -> a + b);
            getArr.add(reduce);
        }
        List<String> resultList = new ArrayList<>();
        for(int i=0;i<4;i++){
            int i1 = Integer.parseInt(String.valueOf(A.charAt(i))) + getArr.get(i);
            int c = Integer.parseInt(String.valueOf(B.charAt(i)));
            if(i1>9) {
                i1=i1-9;
            }
            if(i1==c) {
                resultList.add("TERBUKA");
            }else
                resultList.add("TERKUNCI");
        }

        if(resultList.contains("TERKUNCI"))
            result="TERKUNCI";
        else
            result="TERBUKA";
        return result;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String A = bufferedReader.readLine();

        String B = bufferedReader.readLine();

        List<String> moves = IntStream.range(0, 4).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        String result = Result.getResult(A, B, moves);

        System.out.println(result);

        bufferedReader.close();
    }
}
