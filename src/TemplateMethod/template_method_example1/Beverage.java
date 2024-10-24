package TemplateMethod.template_method_example1;

public abstract class Beverage {
	final void prepareRecipe() {
		boilWater();
		brew();
		pourInCup();
		addCondiments();
	}

	void boilWater() {
		System.out.println("물 끓이기");
	}

	void pourInCup() {
		System.out.println("컵에 따르기");
	}

	abstract void brew();			// 내리기
	abstract void addCondiments();	// 첨가제 넣기
}
