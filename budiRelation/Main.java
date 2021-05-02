package budiRelation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'getResult' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER N
     *  2. INTEGER M
     *  3. 2D_INTEGER_ARRAY relations
     */

    public static int getResult(int N, int M, List<List<Integer>> relations) {
        if(M>=0 && M<=N*(N-1)/2) {
            List<List<Integer>> newLists = new ArrayList<>();
            List<List<Integer>> relations1=null;
            int tampungan=0;
            for(List<Integer> relation:relations) {
                if(relation.contains(0)) {
                    newLists.add(relation);
                }
            }
            if(!relations.contains(newLists)) {
                relations1 = relations;
            }
            Set<Integer> result = relations1.stream().flatMap(Collection::stream)
                    .collect(Collectors.toSet());

            for(int i=0;i<N;i++){
                if(!result.contains(i))
                    tampungan++;
            }

            return tampungan;
        }
        return 0;
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int N = Integer.parseInt(firstMultipleInput[0]);

        int M = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> relations = new ArrayList<>();

        IntStream.range(0, M).forEach(i -> {
            try {
                relations.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.getResult(N, M, relations);

        System.out.println(String.valueOf(result));
    }
}

