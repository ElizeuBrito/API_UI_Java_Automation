package steps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import getRequest.GetData;

public class API_StepDefinitions {

	@Given("^que o usuario se conecta na API com codigo de retorno igual a (\\d+)$")
	public void que_o_usuario_se_conecta_na_API_com_codigo_de_retorno_igual_a(int statusCode) throws Throwable {
		
		boolean validarRetorno = GetData.conetarNaAPI(statusCode);
		if (validarRetorno == true) {
			System.out.println("Usuário conectado com sucesso na API com STATUS CODE = " +statusCode);
		}
	}

	@When("^o usuario busca por filmes")
	public void o_usuario_busca_filmes_por_titulos(DataTable data) throws Throwable {

		List<Map<String, String>> list = data.asMaps(String.class, String.class);

		for (int i = 0; i < list.size(); i++) {

			GetData.VerificarFilmes(list.get(i).get("filmes"), Integer.parseInt(list.get(i).get("ID")));
		}
	}

	@When("^o usuario busca filmes por criteria \"([^\"]*)\" \"([^\"]*)\"$")
	public void o_usuario_busca_filmes_por_criteria(String arg1, String arg2) throws Throwable {

		GetData.VerificarFilmesPorCriteria(arg1, arg2);
	}

	@Then("^a API retorna todos os titulos dos filmes$")
	public void a_API_retorna_todos_os_titulos_dos_filmes() throws Throwable {

		List<HashMap<String, String>> result = GetData.BuscarFilmes();

		System.out.println("Os títulos de filmes existestem na API são: " +result);
	}

	@Then("^a API retorna todos os titulos de filmes por criteria \"([^\"]*)\" \"([^\"]*)\"$")
	public void a_API_retorna_todos_os_titulos_de_filmes_por_criteria(String diretor, String produtor) throws Throwable {

		List<HashMap<String, String>> result = GetData.BuscarFilmesPorCriterio(diretor, produtor);

		System.out.println("Os filmes produzidos pelo diretor " +diretor+ " e pelo produtor " +produtor+
				" são os seguintes: " +result);

	}

}
