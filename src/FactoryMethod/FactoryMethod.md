# Factory Method Pattern

* 클래스 생성과 사용의 처리 로직을 분리하여 결합도를 낮추고자 할 때 사용한다.
* 예로 들어, 차를 생각해보면 차의 종류에도 여러 가지가 있을 수 있다.
* 경찰차, 소방차, 기차, 버스 등등.. 매번 타입이 증가할수록 코드가 늘어나는 문제가 발생한다.

### 예제 1 : 운전 속성을 분리하여 팩토리 메서드 패턴 적용하기

```java
// 운송수단
public interface Vehicle {
	void drive();
}

// 버스(운송수단 인터페이스 구현)
public class Bus implements Vehicle {

	@Override
	public void drive() {
		System.out.println("버스 부릉부릉");
	}
}

// 차(운송수단 인터페이스 구현)
public class Car implements Vehicle {

	@Override
	public void drive() {
		System.out.println("차 부릉부릉");
	}
}
```

* 평소대로라면 구현 클래스에서 바로 인스턴스를 생성하겠지만 클래스 생성과 사용을 분리하기 위해 팩토리 메서드 패턴을 적용하여 팩토리 클래스를 작성해보자.

```java
// 추상 클래스
public abstract class VehicleFactory {

	// 반환 타입 : 운송 수단
	abstract Vehicle createVehicle();

	public void deliverVehicle() {
		Vehicle vehicle = createVehicle();
		System.out.println("Delivering vehicle...");
		vehicle.drive();
	}
}

// 버스 팩토리 클래스에서 인스턴스를 생성
public class BusFactory extends VehicleFactory {

	@Override
	Vehicle createVehicle() {
		return new Bus();
	}
}

// 차 팩토리 클래스에서 인스턴스를 생성
public class CarFactory extends VehicleFactory {

	@Override
	Vehicle createVehicle() {
		return new Car();
	}
}
```