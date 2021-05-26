package objComparingIter.comparing;

import java.util.Comparator;

public class GlassComp implements Comparator<Glass> {
    @Override
    public int compare(Glass o1, Glass o2) {
        return o1.getSize()<o2.getSize()?1:-1;
    }
}
