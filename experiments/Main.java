package experiments;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Person p1=new Person();
        p1.setName("Peman");
        p1.setAge(20);
        p1.setHeight(150);
        p1.setWeight(50);

        Person p2=new Person();
        p2.setName("Budi");
        p2.setAge(30);
        p2.setHeight(150);
        p2.setWeight(50);

        List<Person> persons= Arrays.asList(p1,p2);
        Collections.sort(persons);
        for(Person person:persons){
            System.out.println(person);
        };

        checkInfo(p1);
        checkInfoSecond(p2);
    }

    private static void checkInfoSecond(Object object) throws IllegalAccessException {
        Class<?> clazz=object.getClass();
        Map<String,Integer> jsonElementsMap=new HashMap<>();
        for (Field field:clazz.getDeclaredFields()) {
            field.setAccessible(true);
            if(field.isAnnotationPresent(myFieldsMethod.class)){
                jsonElementsMap.put(getKey(field),(Integer)field.get(object));
            }
        }

        String jsonString=jsonElementsMap.entrySet()
                .stream()
                .map(entry->"\""+entry.getKey()+ "\":\"" + entry.getValue() + "\"")
                .collect(Collectors.joining(","));
        System.out.println("{"+jsonString+"}");
    }

    private static void checkInfo(Object object) throws InvocationTargetException, IllegalAccessException {
        if(Objects.isNull(object)){
            throw new IllegalStateException("null object");
        }

        Class<?> clazz=object.getClass();
        System.out.println(Arrays.toString(clazz.getMethods()));
        System.out.println(Arrays.toString(clazz.getDeclaredMethods()));
        System.out.println(Arrays.toString(clazz.getDeclaredFields()));
        for (Method method:clazz.getDeclaredMethods()){
            if(method.isAnnotationPresent(myTestMethods.class)){
                method.setAccessible(true);
                method.invoke(object);
            }
        }
    }

    private static String getKey(Field field){
        String val = field.getAnnotation(myFieldsMethod.class).keyName();
        return val.isEmpty()?field.getName():val;
    }
}
