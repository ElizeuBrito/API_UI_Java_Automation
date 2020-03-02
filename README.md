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

- 00 0 -> Indica meia noite
- 12 -> Indica meio dia
- * -> Indica vazio para dia do mês
- * -> Indica vazio para mês
- 0 - 6 -> De segunda a segunda

Segue esquema, para melhor entendimento:

 - minute (0 - 59)
 - hour (0 - 23)
 - day of month (1 - 31)
 - month (1 - 12)
 - day of week (0 - 6) (Sunday to Saturday                                   
 - (7 is also Sunday on some systems)
 
 Basicamente, tudo isso!!! :)

Dúvidas, fiquem a vontade em me contatar através do email: elizeu.brito@gmail.com

- Perguntas teóricas do teste

1.	O software de função de engenheiro de qualidade mudou muito nos últimos anos. Atualmente, como você pode definir a importância desse papel?
Resposta:
No meu ponto de vista, acredito que hoje o Engenheiro de Qualidade deve ser proficiente em uma série de coisas. Nos últimos anos tenho observado que o Engenheiro de Qualidade precisou não apenas ter o conhecimento de como testar o software (aplicando as melhores práticas da escola/cultura de QA), mas também precisou se adaptar a uma nova realidade de qualidade de software, por exemplo:
- Hoje um Engenheiro de Qualidade de software deve ser capaz de trabalhar em equipes multidisciplinares, com metodologias ágeis (scrum), e se adequar a tão falada transformação digital.
- O Engenheiro de Qualidade de software deve ser capaz de automatizar testes (regressivos, funcionais), deve ser proficiente em progração para tal. Neste item, penso que o que forma um bom automatizador de testes, é que o mesmo tenha passado por vários processos/fluxos de testes manuais/funcionais. Cultura de QA é uma bagagem e tanto para o Engenheiro que vai automatizar qualquer sitema, seja ele front end, back end ou sistema de contratos.
- Tambem não poderia deixar de mencionar a questão do idioma. O Engenheiro de Qualidade que tiver mais de um idioma, com certeza irá se destacar mais, principalmente o idioma Inglês, dado o vasto conteúdo de qualidade (QA) existente na internet, bem como o vasto número de empresas estrangeiras (seja ela da américa ou não, porque o Inglês é universal) trabalhando fortemente com qualidade de software, Engenheiros de Qualidade, SDETs (Software Development Engineer in Test).
- O Engenheiro de Qualidade também deve se aprofundar no estudo de metodologias ágeis, que é uma tendência atualmente.

2.	Imagine que você está em nossa equipe, trabalhando com automação de testes, pensando em cenários de teste, realizando testes de desempenho e outras coisas relacionadas à qualidade do software. Como você avaliaria se este software tem qualidade ou não?
Resposta:
Eu avalio se um software tem qualidade ou não quando o mesmo atende aos critérios de aceite elucidados durante o desenvolvimento dos épicos e das histórias. O sofware deve realizar exatamente o que foi definido pelo Product Owner e aprovado por toda a equipe (Gestores, Scrum Master, Testadores, Engenheiros de Qualidade, Analistas, Cliente).
Ou seja, o output deve atender o input, seja o teste realizado manualmente ou automaticamente.
