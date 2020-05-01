package flyweight;

import java.util.HashMap;
import java.util.Map;

//Flyweight's Factory
public class Mine {

    private static Map<String, Valuable> valuables = new HashMap<>();

    public static Valuable getValues(String name, int value){
        Valuable item = valuables.get(name);
        if (item == null){
            item = new ValuableImpl(name, value);
        }
        return item;
    }
}
