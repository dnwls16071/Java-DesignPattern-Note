package Singleton;

public class Label {

	private String text;

	public Label(String text) {
		this.text = text;
	}

	public void display() {
		String themeColor = Theme.getInstance().getThemeColor();
		System.out.println("컬러 출력: " + themeColor);
	}
}
