package TemplateMethod.template_method_example1;

public class Coffee extends Beverage {
	@Override
	void brew() {
		System.out.println("Dripping Coffee through filter");
	}

	@Override
	void addCondiments() {
		System.out.println("Adding Sugar and Milk");
	}
}
