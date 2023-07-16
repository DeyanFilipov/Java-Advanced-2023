package JavaOOP.ReflectionAndAnnotation.Exercise.BarracksWarsANewFactory_03.interfaces;

import jdk.jshell.spi.ExecutionControl;

public interface UnitFactory {

    Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException;
}