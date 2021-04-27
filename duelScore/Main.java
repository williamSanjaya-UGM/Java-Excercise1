package duelScore;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        File file=new File("./src/scoring.txt");
        List<List<String>> playerList = readFile(file);

        System.out.print("Please input name you want to search: ");
        Scanner userInput=new Scanner(System.in);
        String singleTextInput = userInput.next();

        List<List<String>> collectList = playerList.stream().filter(player -> player.get(0).contains(singleTextInput))
                .collect(Collectors.toList());

        collectList.sort(Comparator.comparing(o -> o.get(1)));

//        List<String> output = swapFirstAndLastIndex(collectList);

        List<String> output = swapFunction.apply(collectList);

        for (String result:output){
            System.out.println(result);
        }
    }

    private static List<List<String>> readFile(File file){
        List<List<String>> playerList=new ArrayList<>();
        try {
            Scanner scanner=new Scanner(file);
            while (scanner.hasNextLine()){
                playerList.add(Arrays.asList(scanner.nextLine().split(",")));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return playerList;
    }

    // example, by using lambda
    private static Function<List<List<String>>,List<String>> swapFunction= collectList -> collectList.stream().map(strings -> {
        String[] split = strings.get(0).split("[ ]");
        Collections.reverse(Arrays.asList(split));

        StringBuilder sb = new StringBuilder();
        for (String word : split) {
            sb.append(word + " ");
        }
        return sb.substring(0, sb.length() - 1)+","+strings.get(1);
    }).collect(Collectors.toList());

    // example, by using imperative prgramming
    private static List<String> swapFirstAndLastIndex(List<List<String>> collectList){
        return collectList.stream().map(strings -> {
            String[] split = strings.get(0).split("[ ]");
            Collections.reverse(Arrays.asList(split));

            StringBuilder sb = new StringBuilder();
            for (String word : split) {
                sb.append(word + " ");
            }
            return sb.substring(0, sb.length() - 1)+","+strings.get(1);
        }).collect(Collectors.toList());
    }
}
