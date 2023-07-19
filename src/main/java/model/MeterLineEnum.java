package model;

public enum MeterLineEnum {

    CRONOS("Cronos"),
    ARES("Ares");

    private final String name;

    MeterLineEnum(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
