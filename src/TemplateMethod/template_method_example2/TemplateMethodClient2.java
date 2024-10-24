package TemplateMethod.template_method_example2;

public class TemplateMethodClient2 {
	public static void main(String[] args) {

		DataProcessor jsonProcessor = new JsonDataProcessor();
		jsonProcessor.process("JSON Data");

		DataProcessor csvDataProcessor = new CSVDataProcessor();
		csvDataProcessor.process("XML Data");
	}
}
