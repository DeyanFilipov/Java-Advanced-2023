package JavaOOP.InterfacesAndAbstraction.Exercise.CollectionHierarchy_07;

public class MyListImpl extends Collection implements MyList {

    private int used;

    protected MyListImpl() {
        super();
    }

    @Override
    public int add(String item) {
        getItems().add(0, item);
        return 0;
    }

    @Override
    public String remove() {
        return getItems().remove(0);
    }

    @Override
    public int getUsed() {
        return getItems().size();
    }
}
