# Template Method Pattern

* 템플릿 메서드 패턴은 여러 클래스에서 공통으로 사용하는 메서드를 템플릿화하여 상위 클래스에서 정의하고 하위 클래스마다 세부 동작 사항을 다르게 구현하는 패턴이다.
* 즉, 변하지 않는 기능(템플릿)은 상위 클래스에 정의하고 자주 변경되며 확장할 기능은 하위 클래스에서 만들도록 하여 상위 메서드 실행 동작 순서는 고정하면서 세부 실행 내용을 다양화할 수 있는 경우에 사용된다.
* 구현할 알고리즘의 구조는 고정되어 있되, 그 세부 과정 각각(커피나 차)은 변경되거나 확장될 수 있는 경우에 유용하게 활용될 수 있다.

### 예제1 : 차를 만드는 과정

* 물을 끓이는 과정
* 컵에 담는 과정

위의 두 과정은 동일하지만 티(Tea)와 커피(Coffee) 제조에는 차이가 있다.

* 어떤 첨가물을 넣어야 하는지?
* 어떻게 음료를 우려내야 하는지?

```java
public abstract class Beverage {
	// Template Method
	final void prepareRecipe() {
		boilWater();
		brew();
		pourInCup();
		addCondiments();
	}

	void boilWater() {
		System.out.println("물 끓이기");
	}

	void pourInCup() {
		System.out.println("컵에 따르기");
	}

    // brew() & addCondiments() 는 추상 메서드로 정의 -> 하위 클래스에서 재정의
	abstract void brew();			// 내리기
	abstract void addCondiments();	// 첨가제 넣기
}
```

### 예제2 : 여러 확장자 파일을 읽고 처리한 뒤 다른 형태로 저장하는 프로그램

```java
public abstract class DataProcessor {

	// process() 메서드를 그대로 가져가되 추상 클래스 메서드를 하위 클래스에서 재정의
	final void process(String data) {
		loadData(data);
		if (isValidDate(data)) {
			processData(data);
			saveData(data);
		} else {
			System.out.println("유효하지 않은 데이터입니다.");
		}
	}

	protected abstract void loadData(String data);
	protected abstract boolean isValidDate(String data);
	protected abstract void processData(String data);
	protected abstract void saveData(String data);
}

// CSV 프로세서
public class CSVDataProcessor extends DataProcessor {

	@Override
	protected void loadData(String data) {
		System.out.println("Loading data from CSV file: " + data);
	}

	@Override
	protected boolean isValidDate(String data) {
		return data != null && data.contains("CSV");
	}

	@Override
	protected void processData(String data) {
		System.out.println("Processing CSV data");
	}

	@Override
	protected void saveData(String data) {
		System.out.println("Saving CSV data to database");
	}
}

// JSON 프로세서
public class JsonDataProcessor extends DataProcessor {

	@Override
	protected void loadData(String data) {
		System.out.println("Loading data from JSON file: " + data);
	}

	@Override
	protected boolean isValidDate(String data) {
		return data != null && data.contains("JSON");
	}

	@Override
	protected void processData(String data) {
		System.out.println("Processing JSON data");
	}

	@Override
	protected void saveData(String data) {
		System.out.println("Saving JSON data to database");
	}
}
```