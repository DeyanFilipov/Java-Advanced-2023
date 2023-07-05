package JavaOOP.InterfacesAndAbstraction.Exercise.CollectionHierarchy_07;

public class AddCollection extends Collection implements Addable {

    protected AddCollection() {
        super();
    }

    @Override
    public int add(String item) {
        super.getItems().add(item);
        return getItems().indexOf(item);
    }
}
