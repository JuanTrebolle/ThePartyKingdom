package flyweight;

import java.util.HashMap;
import java.util.Map;

//Flyweight's Factory
public class Mine {

    private static Map<String, T> valuables = new HashMap<>();

    public static T getValues(String name, int value){
        T item = valuables.get(name);
        if (item == null){
            item = new ValuableImpl(name, value);
        }
        return item;
    }
}
