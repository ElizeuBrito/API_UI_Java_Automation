package element_locators;

import org.openqa.selenium.By;

public class ElementLocators {
	
	public static String clicarComponenteData = "document.getElementsByName('date')[0].click();";
	public static String clicarComponenteTempo = "document.getElementsByName('time')[0].click();";
	
	public static By signInRegisterButton = By.xpath("//a[@id='signup']");
	public static By nameTextField = By.xpath("//input[@name='name']");
	public static By loginTextField = By.xpath("(//input[@name='login'])[1]");
	public static By passwordTextField = By.xpath("(//input[@name='password'])[1]");
	public static By myTasksArea = By.xpath("(//a[text()='My tasks'])[1]");
	public static By userRegistered = By.xpath("(//a[@class='me'])[1]");
	public static By letsAddTasksButton = By.xpath("//a[@class='waves-effect waves-light red darken-2 btn']");
	public static By addTaskButton = By.xpath("//button[text()='+ Add a task']");
	public static By tituloTaskTextField = By.xpath("//input[@name='title']");
	public static By detalheTaskTextField = By.xpath("//div[@class='input-field col s12']/textarea[@name='text']");
	public static By saveTaskButton = By.xpath("//a[text()='Save']");
	public static By todayTaskButton = By.xpath("//button[text()='Today']");
	public static By okDateTaskButton = By.xpath("//button[text()='Ok']");
	public static By okTimeTaskButton = By.xpath("//button[text()='OK']");
	public static By hourTaskTime = By.xpath("(//div[@class='clockpicker-tick' and text()='00'])[1]");
	public static By minutesTaskTime = By.xpath("//div[@class='clockpicker-tick' and text()='30']");
	public static By dropdown = By.name("done");
	public static By taskCriadaTitulo = By.xpath("//span[@class='title']");
	public static By taskCriadaDetalhe = By.xpath("//small");

}
