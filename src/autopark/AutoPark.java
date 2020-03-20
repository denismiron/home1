package autopark;

import auto.Car;
import auto.ElectricCar;
import auto.GasCar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class AutoPark {

    private List<Car> autoPark = new ArrayList<Car>();
    private List<GasCar> gasCars = new ArrayList<GasCar>();
    private List<ElectricCar> electricCars = new ArrayList<ElectricCar>();

    public void addAutoParkCar(Car car) {

        this.autoPark.add(car);
    }

    public void addGasCar(GasCar car) {

        this.gasCars.add(car);
    }

    public void addElectricCar(ElectricCar car) {

        this.electricCars.add(car);
    }

    public long calculateCarsCoast() {

        long sum = 0;
        for (Car car : autoPark) {
            sum = sum + car.getPrice();
        }
        return sum;
    }

    public List<GasCar> sortByFuelConsumption() {

        List<GasCar> sortedCards = new ArrayList<>(this.gasCars);
        Collections.sort(sortedCards, Comparator.comparing(GasCar::getFuelConsumption));
        return sortedCards;
    }

    public List<ElectricCar> sortLifeTimeBattery() {

        List<ElectricCar> sortedCards = new ArrayList<>(this.electricCars);
        Collections.sort(sortedCards, Comparator.comparing(ElectricCar::getLifeTimeBattery));
        return sortedCards;
    }

    public List<Car> searchBySpeed(float min, float max) {

        List<Car> carSelection = new ArrayList<Car>();
        for (Car car : autoPark) {
            if (car.getMaxSpeed() >= min && car.getMaxSpeed() <= max) {
                carSelection.add(car);
            }
        }
        return carSelection;
    }
}

