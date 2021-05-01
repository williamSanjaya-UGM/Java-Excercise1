package markerInterface;

public interface Permission {
    default void allowed(){
        System.out.println("You are allowed to access this");
    }
}
