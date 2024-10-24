# Strategy Pattern

* 전략 패턴은 실행(런타임) 중에 알고리즘 전략을 선택하여 객체 동작을 실시간으로 바뀌도록 할 수 있게 하는 행위 디자인 패턴이다.
* 전략은 결국 추상화된 알고리즘(인터페이스)이고 이 전략 알고리즘을 구현한 저마다의 전략 알고리즘들이 존재하게 된다.

### 예제1 : 결제 수단 - 신용카드, 페이팔

```java
// 결제 수단 추상화 - 어떤 결제 수단을 사용할 것인지
public interface PaymentStrategy {
	void pay(int amount);
}

// 신용카드 결제 시 필요한 필드 : 이름, 카드 번호
public class CreditCardPayment implements PaymentStrategy {

	private String name;
	private String cardNumber;

	public CreditCardPayment(String name, String cardNumber) {
		this.name = name;
		this.cardNumber = cardNumber;
	}

	@Override
	public void pay(int amount) {
		System.out.println(amount + " paid with credit card.");
	}
}

// 페이팔 결제 시 필요한 필드 : 이메일
public class PayPalPayment implements PaymentStrategy {

	private String email;

	public PayPalPayment(String email) {
		this.email = email;
	}

	@Override
	public void pay(int amount) {
		System.out.println(amount + " paid using PayPal.");
	}
}
```

### 예제2 : 문자열 압축

```java
// 압축 기법 추상화 : 어떤 압축 기법을 사용할 것인지
public interface CompressionStrategy {
	String compress(String data);
}

// setter를 통해 전략적으로 선택할 수 있도록
public class Compressor {

	// 전략 : 추상화된 알고리즘
	private CompressionStrategy strategy;

	// setter를 통해 전략을 수립
	public void setCompressionStrategy(CompressionStrategy strategy) {
		this.strategy = strategy;
	}

	public String compress(String data) {
		return strategy.compress(data);
	}
}
```