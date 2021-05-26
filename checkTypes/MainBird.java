package checkTypes;

public class MainBird {
    public static void main(String[] args) {
        String birdName="pelican";
        Wings wings =new Wings();
        wings.setWingNum(4);

        Bird<Wings> stringBird=new Bird<>();
        System.out.println("isi generic class Bird adl: "+stringBird.giveTypes(wings));
        System.out.println(stringBird.giveTypes(wings).getWingNum());
        System.out.println(Bird.giveInfo(birdName));
    }
}
