package flyweight;

import java.util.HashMap;
import java.util.Map;

//Flyweight's Factory
public class Mine {

    private static Map<String, T> valuables;
    private static Mine mine;

    static {
        mine = new Mine();
    }

    public Mine() {
        valuables = new HashMap<>();
    }

    public static T getValues(String name, int value){
        T item = valuables.get(name);
        if (item == null){
            if (name.equalsIgnoreCase("Diamond")){
                item = new Diamond();
                valuables.put(name, item);
            } else if (name.equalsIgnoreCase("GoldNugget")){
                item = new GoldNugget();
                valuables.put(name, item);
            } else if (name.equalsIgnoreCase("Ruby")){
                item = new Ruby();
                valuables.put(name, item);
            }
        }
        return item;
    }
}
