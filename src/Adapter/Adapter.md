# Adapter Pattern

* 이미 구축된 것을 새로운 어떤 것에 사용할 때 양쪽 간으 호환성을 유지하기 위해 사용하는 것이다.
* 다음과 같이 구버전과 신버전의 메시지 전송 서비스가 있다고 가정하자.
* 매개변수, 반환 타입이 달라 호환이 되지 않는다.

### 예제 1 : 메시지 전송 호환

```java
// 신버전 메시지 전송 인터페이스
public interface ModernMessageSender {
	void sendMessage(String message, String recipient);
}
```

```java
// 구버전 메시지 전송 인터페이스
public interface OldMessageSender {
	int send(String[] messageData);
}
```

```java
// 신버전과 구버전의 메시지 전송 인터페이스 간 호환을 위한 어댑터 구현
public class MessageAdapter implements ModernMessageSender {

	private OldMessageSender oldMessageSender;

	public MessageAdapter(OldMessageSender oldMessageSender) {
		this.oldMessageSender = oldMessageSender;
	}

	@Override
	public void sendMessage(String message, String recipient) {
		String[] messageData = {message, recipient};
		int result = oldMessageSender.send(messageData);
		if (result != 1) {
			System.out.println("메시지 전송에 실패했습니다.");
		}
	}
}
```

### 예제 2 : USB, HDMI, VGA 어댑터 -> 이 서로 다른 어댑터들은 규격이 갖지 않아 일률적으로 사용할 수 없다. 이를 개선해보자.

```java
// 어댑터 인터페이스
// 서로 다른 규격의 호환성을 일치시켜주는 역할
public interface DisplayAdapter {
	void display();
}

// HDMI 어댑터
public class HDMIAdapter implements DisplayAdapter {

	private HDMI hdmi;
	private int resolution;

	public HDMIAdapter(HDMI hdmi, int resolution) {
		this.hdmi = hdmi;
		this.resolution = resolution;
	}

	@Override
	public void display() {
		hdmi.connectWithHdmiCable(resolution);
	}
}

// VGA 어댑터
public class VGAAdapter implements DisplayAdapter {

	private VGA vga;
	private boolean highQuality;

	public VGAAdapter(VGA vga, boolean highQuality) {
		this.vga = vga;
		this.highQuality = highQuality;
	}

	@Override
	public void display() {
		vga.connectWithVgaCable(highQuality);
	}
}

// USB 어댑터
public class USBAdapter implements DisplayAdapter{

	private USB usb;
	private String data;

	public USBAdapter(USB usb, String data) {
		this.usb = usb;
		this.data = data;
	}

	@Override
	public void display() {
		usb.connectWithUsbCable(data);
	}
}
```