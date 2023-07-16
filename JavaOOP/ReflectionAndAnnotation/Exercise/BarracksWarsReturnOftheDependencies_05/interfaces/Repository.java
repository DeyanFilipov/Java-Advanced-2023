package JavaOOP.ReflectionAndAnnotation.Exercise.BarracksWarsReturnOftheDependencies_05.interfaces;

import jdk.jshell.spi.ExecutionControl;

public interface Repository {

	void addUnit(Unit unit);

	String getStatistics();

	void removeUnit(String unitType);
}
