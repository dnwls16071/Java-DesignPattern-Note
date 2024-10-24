package Strategy;

import Strategy.strategy_example1.CreditCardPayment;
import Strategy.strategy_example1.PayPalPayment;
import Strategy.strategy_example1.ShoppingCart;
import Strategy.strategy_example2.Compressor;
import Strategy.strategy_example2.RunLengthEncoding;
import Strategy.strategy_example2.SimpleReplacementCompression;

public class StrategyClient {
	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();

		cart.setPaymentStrategy(
				new CreditCardPayment(
						"John Doe",
						"1234567890123456"
				)
		);
		cart.checkout(100);
		//100 paid with credit card

		cart.setPaymentStrategy(
				new PayPalPayment(
						"johndoe@example.com"
				)
		);
		cart.checkout(200);
		// 200 paid using PayPal

		//
		Compressor compressor = new Compressor();
		String data = "aabcccccaaa";

		compressor.setCompressionStrategy(new RunLengthEncoding());
		System.out.println(
				"RLE Compression: " + compressor.compress(data)
		);
		// RLE Compression: a2b1c5a3

		compressor.setCompressionStrategy(new SimpleReplacementCompression());
		System.out.println(
				"Simple Replacement: " + compressor.compress(data)
		);
		// Simple Replacement: 11bccccc111
	}
}
