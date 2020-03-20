package AUTOTEST;

import org.junit.Test;
import auto.Car;
import auto.ElectricCar;
import auto.GasCar;
import autocriteria.Brand;
import autocriteria.FuelType;
import autocriteria.Type;
import autopark.AutoPark;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.deepEquals;
import static org.junit.Assert.assertEquals;

public class autotest {
    private AutoPark autoPark = new AutoPark();
    private GasCar gasCar1;
    private GasCar gasCar2;
    private ElectricCar electricCar1;
    private ElectricCar electricCar2;

    @Before
    public void setUp() {
        GasCar gasCar1 = new GasCar(Brand.Citroen, Type.Convertible, 228, 3400, FuelType.Petrol, 10);
        ElectricCar electricCar1 = new ElectricCar(Brand.Audi, Type.Hatchback, 1336, 5000, 10, 15);
        GasCar gasCar2 = new GasCar(Brand.Bentley, Type.Sedun, 47, 4200, FuelType.Diesel, 15);
        ElectricCar electricCar2 = new ElectricCar(Brand.Geely, Type.Van, 33, 1300, 6, 100);

        autoPark.addAutoParkCar(gasCar1);
        autoPark.addAutoParkCar(gasCar2);
        autoPark.addAutoParkCar(electricCar1);
        autoPark.addAutoParkCar(electricCar2);
    }

    @Test
    public void calculateCarsCoast() {
        long actual = autoPark.calculateCarsCost();
        long expected = 11;
        assertEquals(expected, actual, 0.00000001);
    }

    @Test
    public void sortByFuelConsumption() {
        List<GasCar> actual = autoPark.sortByFuelConsumption();
        List<GasCar> expected = new ArrayList<>();
        expected.add(gasCar1);
        expected.add(gasCar2);
        deepEquals(actual, expected);
    }

    @Test
    public void sortByLifeTimeBattery() {
        List<ElectricCar> actual = autoPark.sortLifeTimeBattery();
        List<ElectricCar> expected = new ArrayList<>();
        expected.add(electricCar1);
        expected.add(electricCar2);
        deepEquals(actual, expected);
    }

    @Test
    public void searchBySpeed() {
        List<Car> actual = autoPark.searchBySpeed(46, 48);
        List<Car> expected = new ArrayList<>();
        expected.add(gasCar2);
        deepEquals(actual, expected);
    }
}