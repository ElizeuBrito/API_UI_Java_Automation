@tag
Feature: Acessar o webiste de tasks gerar uma task e visualiza-la
  
  @tag1
  Scenario Outline: Usuario acessa o website de tasks e se registra
  	Given que o usuario abre o website de criacao de tasks 
  	When o usuario faz o registro no website passando <nome> <login> e <senha>
  	Then o usuario de nome <nome> eh registrado com sucesso
  	When o usuario cria uma task com titulo <titulo_task> e detalhe <detalhe_task> e marca a task com status <status_done>
  	Then o usuario visualiza sua task criada com sucesso com o titulo <titulo_task> e com o detalhe <detalhe_task>
  	
  	
  	Examples:
  		| nome     | login 	  | senha    | titulo_task  | detalhe_task   | status_done |
  		| "Elizeu" | "ebrito" | "123456" | "Minha task" | "Criar wesite" | "Not"			 |
  	