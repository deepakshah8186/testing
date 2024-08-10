package factorypattern;

public class VehicleFactory {

    public Vehicle getVehicle(String vehicleTYpe){
        if(vehicleTYpe == null){
            return null;
        }
        if(vehicleTYpe.equals("car")){
            return new Car();
        } else if(vehicleTYpe.equals("bike")){
            return new Bike();
        }
        return null;
    }
}
