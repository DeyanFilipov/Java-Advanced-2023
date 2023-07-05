package JavaOOP.InterfacesAndAbstraction.Exercise.MilitaryElite_06;

import java.util.Arrays;

public enum State {
    IN_PROGRESS("inProgress"),
    FINISHED("finished");

    private final String stateName;

    State(String stateName) {
        this.stateName = stateName;
    }

    public String getStateName() {
        return stateName;
    }

    public static boolean contains(String name) {
        return Arrays.stream(State.values()).anyMatch(e -> e.getStateName().equals(name));
    }
}
