package State;

public interface State {
	void open(Door door);	// 문이 열린 상태
	void close(Door door);	// 문이 닫힌 상태
}
