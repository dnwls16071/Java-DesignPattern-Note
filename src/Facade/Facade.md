# Facade Pattern

* 퍼사드 패턴(Facade Pattern)은 구조 패턴의 한 종류로써 복잡한 서브 클래스들의 공통적인 기능을 정의하는 상위 수준의 인터페이스를 제공하는 패턴이다.
* 퍼사드 객체는 서브 클래스의 코드에 의존하는 정도를 낮추고 복잡한 소프트웨어를 간단히 사용할 수 있게 해준다.
* 퍼사드 객체를 사용하는 클라이언트는 퍼사드 객체를 이루는 다양한 서브 시스템에 대해 깊이 있게 알 필요 없이 편하게 사용할 수 있다.

### 예제1 : 온도 조절, 전구, 커피머신 클래스

```java
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

```

### 예제2 : 파일 읽기, 파일 쓰기, 파일 삭제하기

```java
package Facade.facade_example2;

import java.io.IOException;

public class FileSystemFacade {

	private FileWriter fileWriter;
	private FileReader fileReader;
	private FileDeleter fileDeleter;

	// 생성자 내부에서 new 키워드로 서브 시스템 객체를 생성
	public FileSystemFacade() {
		this.fileWriter = new FileWriter();
		this.fileReader = new FileReader();
		this.fileDeleter = new FileDeleter();
	}

	public String readFile(String filePath) {
		try {
			return fileReader.readFile(filePath);
		} catch (IOException e) {
			System.err.println("Error reading file: " + e.getMessage());
			return null;
		}
	}

	public boolean writeFile(String filePath, String content) {
		try {
			fileWriter.writeFile(filePath, content);
			return true;
		} catch (IOException e) {
			System.err.println("Error writing file: " + e.getMessage());
			return false;
		}
	}

	public boolean deleteFile(String filePath) {
		try {
			fileDeleter.deleteFile(filePath);
			return true;
		} catch (IOException e) {
			System.err.println("Error deleting file: " + e.getMessage());
			return false;
		}
	}
}
```