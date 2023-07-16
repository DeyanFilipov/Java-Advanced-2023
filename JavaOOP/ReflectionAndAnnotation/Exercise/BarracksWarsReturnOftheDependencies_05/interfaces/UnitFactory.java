package JavaOOP.ReflectionAndAnnotation.Exercise.BarracksWarsReturnOftheDependencies_05.interfaces;

import jdk.jshell.spi.ExecutionControl;

public interface UnitFactory {

    Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException;
}