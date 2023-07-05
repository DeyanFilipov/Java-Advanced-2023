package JavaOOP.InterfacesAndAbstraction.Exercise.MilitaryElite_06;

public class MissionImpl implements Mission {
    private String codeName;
    private String state;

    public MissionImpl(String codeName, String state) {
        setCodeName(codeName);
        setState(state);
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public void setState(String state) {
        if (State.contains(state)) {
            this.state = state;
        }
    }

    @Override
    public void completeMission() {
        this.state = State.FINISHED.getStateName();
    }

    @Override
    public String getCodeName() {
        return codeName;
    }

    @Override
    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s", this.codeName, this.state);
    }
}
