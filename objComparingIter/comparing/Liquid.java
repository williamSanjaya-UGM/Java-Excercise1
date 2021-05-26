package objComparingIter.comparing;

public class Liquid implements Comparable<Liquid>{
    private int liquidAmount;

    public int getLiquidAmount() {
        return liquidAmount;
    }

    public void setLiquidAmount(int liquidAmount) {
        this.liquidAmount = liquidAmount;
    }

    @Override
    public int compareTo(Liquid l2) {
        if(this.getLiquidAmount()<l2.getLiquidAmount())
            return 1;
        else
            return -1;
    }

    @Override
    public String toString() {
        return "Liquid{" +
                "liquidAmount=" + liquidAmount +
                '}';
    }
}
