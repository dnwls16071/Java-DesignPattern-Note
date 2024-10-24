package TemplateMethod.template_method_example2;

public abstract class DataProcessor {

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
