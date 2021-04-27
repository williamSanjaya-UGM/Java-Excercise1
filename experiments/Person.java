package experiments;

public class Person implements Comparable<Person>{

    private String name;

    @myFieldsMethod(keyName = "personAge")
    private int age;

    @myFieldsMethod(keyName = "personHeight")
    private int height;

    @myFieldsMethod(keyName = "personWeight")
    private int weight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Person person) {
        return this.name.compareTo(person.getName());
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }

    @myTestMethods
    public void shout(){
        System.out.println("this is test");
    }
}
