package FactoryMethod;

public abstract class VehicleFactory {

	abstract Vehicle createVehicle();

	public void deliverVehicle() {
		Vehicle vehicle = createVehicle();
		System.out.println("Delivering vehicle...");
		vehicle.drive();
	}
}
