package JavaOOP.InterfacesAndAbstraction.Exercise.MilitaryElite_06;

import java.util.Arrays;

public enum Corps {
    AIRFORCES("Airforces"),
    MARINES("Marines");

    private final String corpsName;

    Corps(String corpsName) {
        this.corpsName = corpsName;
    }

    public String getCorpsName() {
        return corpsName;
    }

    public static boolean contains(String name) {
        return Arrays.stream(Corps.values()).anyMatch(e -> e.getCorpsName().equals(name));
    }
}
