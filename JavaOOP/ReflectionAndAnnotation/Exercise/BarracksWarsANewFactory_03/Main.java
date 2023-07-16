package JavaOOP.ReflectionAndAnnotation.Exercise.BarracksWarsANewFactory_03;

import JavaOOP.ReflectionAndAnnotation.Exercise.BarracksWarsANewFactory_03.interfaces.Repository;
import JavaOOP.ReflectionAndAnnotation.Exercise.BarracksWarsANewFactory_03.interfaces.Runnable;
import JavaOOP.ReflectionAndAnnotation.Exercise.BarracksWarsANewFactory_03.interfaces.UnitFactory;
import JavaOOP.ReflectionAndAnnotation.Exercise.BarracksWarsANewFactory_03.core.Engine;
import JavaOOP.ReflectionAndAnnotation.Exercise.BarracksWarsANewFactory_03.core.factories.UnitFactoryImpl;
import JavaOOP.ReflectionAndAnnotation.Exercise.BarracksWarsANewFactory_03.data.UnitRepository;

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
