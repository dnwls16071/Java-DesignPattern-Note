package TemplateMethod.template_method_example2;

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
