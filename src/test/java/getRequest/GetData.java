package getRequest;

import java.util.HashMap;
import java.util.List;

import org.junit.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetData {
	
	static int statusCode;

	static String jsonendpoint = "https://swapi.co/api/films/";

	public static boolean conetarNaAPI(int code) {

		try {
			RestAssured.
			when().
			get(jsonendpoint).
			then().assertThat().statusCode(200);
			
			statusCode = RestAssured.get(jsonendpoint).statusCode();
			
		} catch (Exception e) {
			System.out.println("Teste Falhou!!!" +e);
		}
		
		return statusCode == code;
		
	}
	
	public static void VerificarFilmes(String filme, int i) {
		
		Response response = RestAssured.when().get(jsonendpoint).andReturn();
		JsonPath jsonPath = new JsonPath(response.body().asString());
		
		List<HashMap<String, String>> ret = jsonPath.get("results");
		Assert.assertEquals(filme, ret.get(i).get("title"));
	}
	
	public static void VerificarFilmesPorCriteria(String diretor, String produtor) {
		
		Response response = RestAssured.when().get(jsonendpoint).andReturn();
		JsonPath jsonPath = new JsonPath(response.body().asString());
				
		Assert.assertEquals(""+diretor+"", jsonPath.get("results.find { it.director == '"+diretor+"'}.director"));
		Assert.assertEquals(""+produtor+"", jsonPath.get("results.find { it.producer == '"+produtor+"'}.producer"));
	}

	public static List<HashMap<String, String>> BuscarFilmes() {

		Response response = RestAssured.when().get(jsonendpoint).andReturn();
		JsonPath jsonPath = new JsonPath(response.body().asString());

		return (jsonPath.get("results.title"));
	}
	
	public static List<HashMap<String, String>> BuscarFilmesPorCriterio(String diretor, String produtor) {
		
		Response response = RestAssured.when().get(jsonendpoint).andReturn();
		JsonPath jsonPath = new JsonPath(response.body().asString());
		
		return (jsonPath
				.get("results.findAll { it.director == '"+diretor+"' " + "&& it.producer == '"+produtor+"'}.title"));
	}

}
