package Singleton;

public class Theme {
	private static Theme instance;	// Theme 타입의 인스턴스(static이므로 메모리에 하나 존재)
	private String themeColor;

	// 생성자를 private 접근 제어자로 막아 외부에서의 생성자 사용을 금지한다.
	private Theme() {
		this.themeColor = "light";
	}

	// 클래스 자체에서 호출
	public static Theme getInstance() {
		if (instance == null) {
			instance = new Theme();
		}
		return instance;
	}

	public String getThemeColor() {
		return themeColor;
	}

	public void setThemeColor(String themeColor) {
		this.themeColor = themeColor;
	}
}
