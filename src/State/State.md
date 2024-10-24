# State Pattern

* 객체가 특정 상태에 따라 행위를 달리 하는 상황에서 상태를 조건문으로 검사해서 행위를 달리하는 것이 아닌 상태를 객체화하여 상태가 행동을 할 수 있도록 위임하는 패턴이다.

### 예제 1 : 문을 열고 닫는 것

* 바로 여기서 문의 상태(열다 / 닫다)를 조건문으로 구현하는 것이 아니라 객체화해서 구현하겠다.

```java
// 현재 문의 상태 -> 객체화
public interface State {
	void open(Door door);	// 문이 열린 상태
	void close(Door door);	// 문이 닫힌 상태
}

// 문을 여는 상태를 객체화
public class OpenState implements State {

	@Override
	public void open(Door door) {
		System.out.println("이미 문은 열려있습니다.");
	}

	@Override
	public void close(Door door) {
		System.out.println("문을 닫습니다.");
		door.setState(new ClosedState());
	}
}

// 문을 닫는 상태를 객체화
public class ClosedState implements State {

	@Override
	public void open(Door door) {
		System.out.println("문을 엽니다.");
		door.setState(new OpenState());
	}

	@Override
	public void close(Door door) {
		System.out.println("이미 문은 닫혀있습니다.");
	}
}
```