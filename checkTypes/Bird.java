package checkTypes;

public class Bird<T> implements Fly {
    public T giveTypes(T typing){
        return typing;
    }

    public static <E> E giveInfo(E info){
        return info;
    }
}
