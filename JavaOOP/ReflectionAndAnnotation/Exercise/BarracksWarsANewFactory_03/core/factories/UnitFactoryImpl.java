package JavaOOP.ReflectionAndAnnotation.Exercise.BarracksWarsANewFactory_03.core.factories;

import JavaOOP.ReflectionAndAnnotation.Exercise.BarracksWarsANewFactory_03.interfaces.Unit;
import JavaOOP.ReflectionAndAnnotation.Exercise.BarracksWarsANewFactory_03.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"JavaOOP.ReflectionAndAnnotation.Exercise.barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) {
		//unitType: Archer, Pikeman, Swordsman
		try {
			Class unitClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
			Constructor<Unit> constructor = unitClass.getDeclaredConstructor(); //конструктор без аргументи
			return constructor.newInstance(); //нов празен обект
		} catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException |
				 IllegalAccessException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
