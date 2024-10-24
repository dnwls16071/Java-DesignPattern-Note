package Facade.facade_example1;

public class SmartHomeFacade {

	// 퍼사드 시스템을 구성하는 다양한 서브 클래스들을 한 번에
	private CoffeeMaker coffeeMaker;
	private Lights lights;
	private Thermostat thermostat;

	// 생성자로 초기화
	public SmartHomeFacade(Thermostat thermostat, Lights lights, CoffeeMaker coffeeMaker) {
		this.thermostat = thermostat;
		this.lights = lights;
		this.coffeeMaker = coffeeMaker;
	}

	public void wakeUp() {
		lights.on();
		thermostat.setTemperature(22);
		coffeeMaker.brewCoffee();
	}

	public void leaveHome() {
		lights.off();
		thermostat.setTemperature(20);
	}
}
