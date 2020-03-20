import auto.Car;
import auto.ElectricCar;
import auto.GasCar;
import autocriteria.Brand;
import autocriteria.FuelType;
import autocriteria.Type;
import autopark.AutoPark;

public class Main {
    public static void main(String[] args) {
        GasCar gasCar1 = new GasCar(Brand.Citroen, Type.Convertible, 228, 3400, FuelType.Petrol, 10);
        ElectricCar electricCar1 = new ElectricCar(Brand.Audi, Type.Hatchback, 1336, 5000, 10, 15);
        GasCar gasCar2 = new GasCar(Brand.Bentley, Type.Sedun, 47, 4200, FuelType.Diesel, 15);
        ElectricCar electricCar2 = new ElectricCar(Brand.Geely, Type.Van, 33, 1300, 6, 100);

        AutoPark autoPark = new AutoPark();

        autoPark.addAutoParkCar(gasCar1);
        autoPark.addAutoParkCar(gasCar2);

        autoPark.addAutoParkCar(electricCar1);
        autoPark.addAutoParkCar(electricCar2);

        autoPark.addGasCar(gasCar1);
        autoPark.addGasCar(gasCar2);

        autoPark.addElectricCar(electricCar1);
        autoPark.addElectricCar(electricCar2);

        System.out.println("Total Cost:"+autoPark.calculateCarsCost());

        for (GasCar auto : autoPark.sortByFuelConsumption()) {
            auto.showInfoGasCar();
        }

        for (ElectricCar auto : autoPark.sortLifeTimeBattery()) {
            auto.showInfoElectricCar();
        }

        for (Car auto : autoPark.searchBySpeed(1335, 1338)) {
            if(auto instanceof GasCar){
                ((GasCar) auto).showInfoGasCar();
            } else{
                ((ElectricCar) auto).showInfoElectricCar();
            }
            auto.showInfo();
        }
    }
}