@tag
Feature: Obter todos os filmes por titulo
  
  @tag1
  Scenario Outline: Usuario chama a API para obter todos os filmes por titulo
    Given que o usuario se conecta na API com codigo de retorno igual a <codigo_de_retorno>
    When o usuario busca por filmes
    	|		filmes			  				| ID |
    	| A New Hope              | 0  |
    	| Attack of the Clones    | 1  |
    	| The Phantom Menace      |	2  |		
    	| Revenge of the Sith     | 3  |
    	| Return of the Jedi      | 4  |
    	| The Empire Strikes Back | 5  |
    	| The Force Awakens       | 6  |
    Then a API retorna todos os titulos dos filmes
   
    Examples: 
      | codigo_de_retorno  |
      | 200				         |
      
 @tag2
  Scenario Outline: Usuario chama a API para obter todos os filmes por diretor e produtor
    Given que o usuario se conecta na API com codigo de retorno igual a <codigo_de_retorno>
    When o usuario busca filmes por criteria <diretor> <produtor>
    Then a API retorna todos os titulos de filmes por criteria <diretor> <produtor>
   
    Examples: 
      | diretor         | produtor          | codigo_de_retorno  |
      | "George Lucas"  | "Rick McCallum"   | 200                |
      