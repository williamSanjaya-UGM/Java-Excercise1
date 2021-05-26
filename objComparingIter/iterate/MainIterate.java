package objComparingIter.iterate;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MainIterate {
    public static void main(String[] args) {
        List<Integer> intLists = Arrays.asList(20,30,45,12,35);
        Iterator<Integer> it= intLists.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
