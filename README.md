# API_UI_Java_Automation - Teste Inmetrics

Este projeto de automação de testes contem cenários escritos em BDD e contemplam automação de contratos (API) e automação de fron end. O framework foi construído utilizando as seguintes tecnologias e padrões:

- Linguagem de programação Java
- Selenium WebDriver
- Conceito de orientação à objetos (POO)
- Conceito de Page Object e Page Factory
- Projeto construído através de Maven project (pom.xml, dependências, etc)

Para construir este projeto localmente, se faz necessário ter as seguintes ferramentas, softwares e plugins instalados:

- JDK instalado, bem como todas as variáveis de ambiente configuradas.
- Eclipse IDE (pode ser utilizada outra IDE, como o Intellij Idea)
- Maven instalado, bem como todas as variáveis de ambiente configuradas.
- Git (para fazer o clone do projeto)
- Jenkins instalado localmente para construir job para rodar o projeto.
- No Jenkins, instale todas as extesões do Maven e instale a extensão do Cucumber Report para gerar os relatórios de execução dos testes.

Para executar o projeto:

1- Caso queira rodar o projeto localmente, basta apenas fazer o clone do mesmo e abri-lo através do Eclipse ou do Intellij Idea.
Dica: No intellij Idea basta apenas importar o arquivo pom.xml.

2- Caso queira rodar o projeto no Jenkins, crie um Job (projeto free style), aponte para o repositório do Git, configure o Maven e pronto. Após isso basta apenas rodar o Job e a automação do contrato e do front end serão executados com sucesso. Caso queira que a build rode duas vezes por dia, após criar a build, clique em "Configurar", vá para "Trigger de builds", marque a opção "Construir periodicamente" e preencha o campo "Agenda" com a seguinte informação: 00 0,12 * * 0-6. Isso indica que a build automatizada será rodada todos os dias de segunda a segunda meia noite e meio dia, onde:

00 0 -> Indica meia noite
12 -> Indica meio dia
* -> Indica vazio para dia do mês
* -> Indica vazio para mês
0 - 6 -> De segunda a segunda

Segue esquema, para melhor entendimento:


 ┌───────────── minute (0 - 59)
 │ ┌───────────── hour (0 - 23)
 │ │ ┌───────────── day of month (1 - 31)
 │ │ │ ┌───────────── month (1 - 12)
 │ │ │ │ ┌───────────── day of week (0 - 6) (Sunday to Saturday;
 │ │ │ │ │                                       7 is also Sunday on some systems)
 │ │ │ │ │
 │ │ │ │ │
 * * * * *  schedule command to execute
 
 Basicamente, tudo isso!!! :)

Dúvidas, fiquem a vontade em me contatar através do email: elizeu.brito@gmail.com
