package State;

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
