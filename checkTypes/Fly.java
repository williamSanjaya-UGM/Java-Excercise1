package checkTypes;

public interface Fly {
    int flySpeed=0;
    default void showSpeed(){
        System.out.println(flySpeed);
    }
}
