package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import element_locators.ElementLocators;
import page_factory.PageFactory;
import page_utils.RandomString;

public class FE_StepDefinitions {

	@Given("^que o usuario abre o website de criacao de tasks$")
	public void que_o_usuario_abre_o_website_de_criacao_de_tasks() throws Throwable {
		PageFactory.openBrowser("http://www.juliodelima.com.br/taskit/");
	}

	@When("^o usuario faz o registro no website passando \"([^\"]*)\" \"([^\"]*)\" e \"([^\"]*)\"$")
	public void o_usuario_faz_o_registro_no_website_passando_e(String nome, String usuario, String senha)
			throws Throwable {

		// Size of random alphanumeric String
		int n = 10;
		String randomName = RandomString.getAlphaNumericString(n);

		PageFactory.registrarUsuario(nome, randomName, usuario, senha, ElementLocators.signInRegisterButton,
				ElementLocators.nameTextField, ElementLocators.loginTextField, ElementLocators.passwordTextField,
				ElementLocators.saveTaskButton);
	}

	@Then("^o usuario de nome \"([^\"]*)\" eh registrado com sucesso$")
	public void o_usuario_de_nome_eh_registrado_com_sucesso(String usuario) throws Throwable {

		boolean verificar = PageFactory.validarRegistroUsuario(usuario, ElementLocators.userRegistered);

		if (verificar == true) {
			System.out.println("Usuario registrado com sucesso!!!");
		} else {
			System.out.println("Usuário não foi registrado!!!");
		}
	}
	
	
	@When("^o usuario cria uma task com titulo \"([^\"]*)\" e detalhe \"([^\"]*)\" e marca a task com status \"([^\"]*)\"$")
	public void o_usuario_cria_uma_task_com_titulo_e_detalhe_e_marca_a_task_com_status(String titulo_task, String detalhe_task,
			String status_task) throws Throwable {
		
		PageFactory.criarTask(
				ElementLocators.letsAddTasksButton,
				ElementLocators.addTaskButton,
				ElementLocators.tituloTaskTextField,
				titulo_task,
				ElementLocators.clicarComponenteData,
				ElementLocators.todayTaskButton,
				ElementLocators.okDateTaskButton,
				ElementLocators.clicarComponenteTempo,
				ElementLocators.hourTaskTime,
				ElementLocators.minutesTaskTime,
				ElementLocators.okTimeTaskButton,
				ElementLocators.detalheTaskTextField,
				detalhe_task,
				ElementLocators.dropdown,
				status_task,
				ElementLocators.saveTaskButton);
		
		System.out.println("Task criada com sucesso!!!");
	}
	
	@Then("^o usuario visualiza sua task criada com sucesso com o titulo \"([^\"]*)\" e com o detalhe \"([^\"]*)\"$")
	public void o_usuario_visualiza_sua_task_criada_com_sucesso_com_o_titulo_e_com_o_detalhe(String titulo_task,
			String detalhe_task) throws Throwable {
		
		boolean verificar = PageFactory.validarTaskCriada(titulo_task, detalhe_task, ElementLocators.taskCriadaTitulo,
				ElementLocators.taskCriadaDetalhe);

		if (verificar == true) {
			System.out.println("Task encontrada com sucesso com o título " +titulo_task+ " e com detalhe "
		+detalhe_task);
		} else {
			System.out.println("Usuário não foi registrado!!!");
		}
	    
	}
}
