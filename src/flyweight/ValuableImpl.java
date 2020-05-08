package flyweight;

public class ValuableImpl implements T
{

    private String name;
    private int value;

    public ValuableImpl(String name, int value) {
        System.out.println("Shine bright like a diamond...");
        this.name = name;
        this.value = value;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getValue() {
        return value;
    }
}
