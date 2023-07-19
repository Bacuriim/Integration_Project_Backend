package model;

public enum CategoryEnum {

    CRONOS_OLD("Cronos Old"),
    CRONOS_L("Cronos L"),
    CRONOS_NG("Cronos-NG"),
    ARES_TB("Ares TB"),
    ARES_THS("Ares THS");

    private final String name;

    CategoryEnum(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

