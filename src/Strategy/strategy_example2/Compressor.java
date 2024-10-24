package Strategy.strategy_example2;

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
