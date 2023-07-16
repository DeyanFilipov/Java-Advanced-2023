package JavaOOP.ReflectionAndAnnotation.Exercise.BarracksWarsTheCommandsStrikeBack_04;


import JavaOOP.ReflectionAndAnnotation.Exercise.BarracksWarsTheCommandsStrikeBack_04.core.Engine;
import JavaOOP.ReflectionAndAnnotation.Exercise.BarracksWarsTheCommandsStrikeBack_04.core.factories.UnitFactoryImpl;
import JavaOOP.ReflectionAndAnnotation.Exercise.BarracksWarsTheCommandsStrikeBack_04.data.UnitRepository;
import JavaOOP.ReflectionAndAnnotation.Exercise.BarracksWarsTheCommandsStrikeBack_04.interfaces.Repository;
import JavaOOP.ReflectionAndAnnotation.Exercise.BarracksWarsTheCommandsStrikeBack_04.interfaces.UnitFactory;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }

    //Engine -> parse and execute commands
    //Repository -> военна единица : брой
        //archer: брой стрелци
        //pikeman: брой копиеносци
        //swordsman: брой мечоносците
    //UnitFactory: създаване на военни единици
}
