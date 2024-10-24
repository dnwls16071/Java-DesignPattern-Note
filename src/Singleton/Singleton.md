# Singleton

* instance vs static의 중요한 차이
* instance의 경우 객체를 생성할 때마다 메모리에 할당된다.
* static의 경우 프로그램이 시작될 때 메모리에 할당(단 하나만 존재)
---
* 싱글톤 패턴이란, 단 하나의 유일한 객체를 만들기 위한 코드 패턴이다.
* 메모리 절약을 위해 매번 객체를 생성할 때마다 메모리에 할당하지 않는다는 것이다.
* 싱글톤 패턴이 적용된 객체가 필요한 경우는 해당 객체가 리소스를 많이 차지하는 역할을 할 때 적용하는 것이 적합하다.
* 대표적으로는 데이터베이스 연결 모듈을 예로 들 수 있는데, 데이터베이스에 접속하는 작업은 그 자체로 무거운 작업에 속하며 또한 한 번만 객체를 생성하고 돌려쓰면 되지 굳이 데이터베이스 연결 모듈 자체를 여러 개 생성할 필요가 없다는 것이다.

### 예제

```java
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
```