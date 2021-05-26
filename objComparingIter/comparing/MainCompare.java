package objComparingIter.comparing;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainCompare {
    public static void main(String[] args) {
        Liquid l1 = new Liquid();
        l1.setLiquidAmount(3);
        Liquid l2 = new Liquid();
        l2.setLiquidAmount(10);
        Liquid l3 = new Liquid();
        l3.setLiquidAmount(7);
        Liquid l4 = new Liquid();
        l4.setLiquidAmount(2);
        Liquid l5 = new Liquid();
        l5.setLiquidAmount(12);

        Glass g1 = new Glass();
        g1.setSize(3);
        Glass g2 = new Glass();
        g2.setSize(10);
        Glass g3 = new Glass();
        g3.setSize(7);
        Glass g4 = new Glass();
        g4.setSize(2);
        Glass g5 = new Glass();
        g5.setSize(12);

        List<Glass> glasses = Arrays.asList(g1,g2,g3,g4,g5);
        Comparator<Glass> glassCom=new GlassComp();

        glasses.sort(glassCom);
        System.out.println(glasses);

        List<Liquid> liquids = Arrays.asList(l1,l2,l3,l4,l5);
        Collections.sort(liquids);
        System.out.println(liquids);
    }
}
