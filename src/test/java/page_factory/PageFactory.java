package page_factory;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageFactory {

	static WebDriver driver;
	static WebDriverWait wait;

	public static void openBrowser(String url) {

		System.out.println("Abrindo a URL " + url + " " + "!!!");

		// WebDriverManager.chromedriver().version("2.36").setup(); -> Aqui você pode
		// mudar a versão do chromedriver
		WebDriverManager.chromedriver().setup();

		// WebDriver driver = new ChromeDriver();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}

	public static void registrarUsuario(String nome, String random, String usuario, String senha,
			By signInRegisterButtonLocator, By nameTextFieldLocator, By loginTextFieldLocator,
			By passwordTextFieldLocator, By saveButtonLocator) {
		
		try {
			
			String nomeDoUsuario = nome;
			nomeDoUsuario = nomeDoUsuario.concat(" ").concat(random);

			String loginDoUsuario = usuario;
			loginDoUsuario = loginDoUsuario.concat(" ").concat(random);

			WebElement signInRegisterButton = driver.findElement(signInRegisterButtonLocator);
			signInRegisterButton.click();

			WebElement nameTextField = driver.findElement(nameTextFieldLocator);
			nameTextField.clear();
			nameTextField.sendKeys(nomeDoUsuario);

			WebElement loginTextField = driver.findElement(loginTextFieldLocator);
			loginTextField.clear();
			loginTextField.sendKeys(loginDoUsuario);

			WebElement passwordTextField = driver.findElement(passwordTextFieldLocator);
			passwordTextField.clear();
			passwordTextField.sendKeys(senha);

			WebElement saveButton = driver.findElement(saveButtonLocator);
			saveButton.click();

			
		} catch (Exception e) {
			System.out.println("Erro ao efetuar o registro do usuário!!!");
		}
	}

	public static boolean validarRegistroUsuario(String usuario, By usuarioRegistradoLocator) throws Exception {

		try {

			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

			String verificarUsuario = driver.findElement(usuarioRegistradoLocator).getText();

			assertTrue(verificarUsuario.contains(usuario));

			return true;

		} catch (Exception e) {

			Assert.fail("Usuário não foi registrado!!!");
			return false;
		}
	}

	public static void criarTask(By letsAddTasksButtonLocator, By addTaskButtonLocator, By tituloTaskTextFieldLocator,
			String titulo_task, String componenteData, By todayTaskButtonLocator, By okDateTaskButtonLocator,
			String componenteTempo, By hourTaskTimeLocator, By minutesTaskTimeLocator, By okTimeTaskButtonLocator,
			By detalheTaskTextFieldLocator, String detalhe_task, By dropdownLocator, String status_task,
			By saveTaskButtonLocator) throws Exception {

		try {

			WebElement letsAddSomeTasksButton = driver.findElement(letsAddTasksButtonLocator);
			letsAddSomeTasksButton.click();

			WebElement addTaskButton = driver.findElement(addTaskButtonLocator);
			addTaskButton.click();

			WebElement tatkTituloField = driver.findElement(tituloTaskTextFieldLocator);
			tatkTituloField.sendKeys(titulo_task);

			JavascriptExecutor jse_1 = (JavascriptExecutor) driver;
			jse_1.executeScript(componenteData);

			WebElement todayTaskButton = driver.findElement(todayTaskButtonLocator);
			todayTaskButton.click();

			WebElement okDateTaskButton = driver.findElement(okDateTaskButtonLocator);
			okDateTaskButton.click();

			JavascriptExecutor jse_2 = (JavascriptExecutor) driver;
			jse_2.executeScript(componenteTempo);

			WebElement hourTaskTime = driver.findElement(hourTaskTimeLocator);
			hourTaskTime.click();

			WebElement minutesTaskTime = driver.findElement(minutesTaskTimeLocator);
			minutesTaskTime.click();

			WebElement okTimeTaskButton = driver.findElement(okTimeTaskButtonLocator);
			okTimeTaskButton.click();

			WebElement detalheTaskTextField = driver.findElement(detalheTaskTextFieldLocator);
			detalheTaskTextField.sendKeys(detalhe_task);

			Select taskStatus = new Select(driver.findElement(dropdownLocator));
			taskStatus.selectByVisibleText(status_task);

			WebElement saveTaskButton = driver.findElement(saveTaskButtonLocator);
			saveTaskButton.click();

		} catch (Exception e) {
			
			System.out.println("Task não foi criada!!!");
		}
	}
	
	public static boolean validarTaskCriada(String titulo_task, String detalhe_task, By taskCriadaTituloLocator,
			By taskCriadaDetalheLocator) throws Exception {
		try {
			
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

			String verificarTaskTitulo = driver.findElement(taskCriadaTituloLocator).getText();

			assertTrue(verificarTaskTitulo.contains(titulo_task));
			
			String verificarTaskDetalhe = driver.findElement(taskCriadaDetalheLocator).getText();

			assertTrue(verificarTaskDetalhe.contains(detalhe_task));
			
			driver.close();
			driver.quit();
			
			return true;
			
		} catch (Exception e) {
			
			Assert.fail("Task não foi encontrada!!!");
			
			driver.close();
			driver.quit();
			
			return false;
		}
	}
}
