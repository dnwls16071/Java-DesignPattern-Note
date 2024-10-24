package FactoryMethod;

public class VehicleClient {
	public static void main(String[] args) {

		CarFactory carFactory = new CarFactory();
		carFactory.createVehicle();

		BusFactory busFactory = new BusFactory();
		busFactory.createVehicle();
	}
}
