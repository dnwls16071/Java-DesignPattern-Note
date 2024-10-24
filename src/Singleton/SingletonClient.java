package Singleton;

public class SingletonClient {
	public static void main(String[] args) {
		Label label = new Label("Username");

		label.display();

		Theme.getInstance().setThemeColor("Black");

		label.display();
	}
}
