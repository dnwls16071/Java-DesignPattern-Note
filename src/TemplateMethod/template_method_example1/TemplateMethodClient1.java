package TemplateMethod.template_method_example1;

import TemplateMethod.template_method_example2.CSVDataProcessor;

public class TemplateMethodClient1 {
	public static void main(String[] args) {

		Beverage tea = new Tea();
		Beverage coffee = new Coffee();

		System.out.println("\nMaking tea...");
		tea.prepareRecipe();

		System.out.println("\nMaking coffee...");
		coffee.prepareRecipe();

		//

		new CSVDataProcessor();
	}
}
