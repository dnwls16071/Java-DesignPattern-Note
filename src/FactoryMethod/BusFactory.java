package FactoryMethod;

public class BusFactory extends VehicleFactory {

	@Override
	Vehicle createVehicle() {
		return new Bus();
	}
}
