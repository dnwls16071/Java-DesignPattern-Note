package State;

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
