package Facade;

import Facade.facade_example1.CoffeeMaker;
import Facade.facade_example1.Lights;
import Facade.facade_example1.SmartHomeFacade;
import Facade.facade_example1.Thermostat;
import Facade.facade_example2.FileSystemFacade;

public class FacadeClient {
	public static void main(String[] args) {
		CoffeeMaker coffeeMaker = new CoffeeMaker();
		Lights lights = new Lights();
		Thermostat thermostat = new Thermostat();

		SmartHomeFacade smartHomeFacade = new SmartHomeFacade(thermostat, lights, coffeeMaker);

		smartHomeFacade.wakeUp();
		smartHomeFacade.leaveHome();

		//

		FileSystemFacade fileSystemFacade = new FileSystemFacade();

		boolean b = fileSystemFacade.writeFile("test.txt", "Hello, Facade Pattern!");
		System.out.println("File write success: " + b);

		String content = fileSystemFacade.readFile("test.txt");
		System.out.println("File Content: " + content);

		boolean d = fileSystemFacade.deleteFile("test.txt");
		System.out.println("File delete success: " + d);
	}
}
