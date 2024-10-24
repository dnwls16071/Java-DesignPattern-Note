package Bridge;

// 추상화된 객체(Remote)가 구현된 객체(Device)를 연결
public abstract class Remote {

	protected Device device;

	// Remote는 Device에 의존적이다.
	protected Remote(Device device) {
		this.device = device;
	}

	public abstract void power();

	public void volumeUp() {
		device.setVolume(device.isEnabled() ? 1 : 0);
	}

	public void volumeDown() {
		device.setVolume(device.isEnabled() ? -1 : 0);
	}
}
