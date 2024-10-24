package FactoryMethod;

public class Car implements Vehicle {

	@Override
	public void drive() {
		System.out.println("차 부릉부릉");
	}
}
