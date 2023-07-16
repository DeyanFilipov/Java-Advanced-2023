package JavaOOP.ReflectionAndAnnotation.Exercise.BarracksWarsTheCommandsStrikeBack_04.interfaces;

import jdk.jshell.spi.ExecutionControl;

public interface UnitFactory {

    Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException;
}