package State;

public class StateClient {
	public static void main(String[] args) {
		Door door = new Door();

		door.open();
		door.open();

		door.close();
		door.close();
	}
}
