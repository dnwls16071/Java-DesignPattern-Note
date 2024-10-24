package FactoryMethod;

public class Bus implements Vehicle {

	@Override
	public void drive() {
		System.out.println("버스 부릉부릉");
	}
}
