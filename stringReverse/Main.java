package stringReverse;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String fileName=args[0];
        File inputFile = new File(fileName);
        List<String> nameLists = readFile(inputFile);

        // consider distinct is a must cause for exercise (not using Set interface)
        List<String> collectName = nameLists.stream().distinct().collect(Collectors.toList());

        showOutput.accept(outputLimitList.apply(collectName));
    }

    private static List<String> readFile(File file){
        List<String> nameLists = new ArrayList<>();
        try{
            Scanner scanner= new Scanner(file);
            while (scanner.hasNextLine()){
                nameLists.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return nameLists;
    }

    // limit by 4 parallel
    // if there is william, drop it
    private static Function<List<String>,List<StringBuilder>> outputLimitList= collectName -> collectName
            .stream().dropWhile(s -> s.contains("William")).map(s -> {
        String[] split = s.split("");
        Collections.reverse(Arrays.asList(split));

        StringBuilder sb = new StringBuilder();
        for (String word : split) {
            sb.append(word);
        }
        return sb;
    }).collect(Collectors.toList()).stream().parallel().limit(4).collect(Collectors.toList());

    private static Consumer<List<StringBuilder>> showOutput= System.out::println;
}
