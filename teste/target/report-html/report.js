$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("teste.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#language: pt"
    }
  ],
  "line": 3,
  "name": "Painel de Aprovação",
  "description": "Como usuário\r\nAo acessar minha aplicação\r\nGostaria de ver a listagem de SG\u0027S",
  "id": "painel-de-aprovação",
  "keyword": "Funcionalidade",
  "tags": [
    {
      "line": 2,
      "name": "@Smoke"
    }
  ]
});
formatter.background({
  "line": 8,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Contexto"
});
formatter.step({
  "line": 9,
  "name": "a pagina aberta",
  "keyword": "Dado "
});
formatter.match({
  "location": "StepDefinitions.aPaginaAberta()"
});
formatter.result({
  "duration": 9196084300,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "criar um novo usuario",
  "description": "",
  "id": "painel-de-aprovação;criar-um-novo-usuario",
  "type": "scenario",
  "keyword": "Cenario"
});
formatter.step({
  "line": 12,
  "name": "clico em Cadastre-se",
  "keyword": "Quando "
});
formatter.step({
  "line": 13,
  "name": "informo os dados de cadastro de usuário",
  "keyword": "E "
});
formatter.step({
  "line": 14,
  "name": "clico em Enviar",
  "keyword": "E "
});
formatter.step({
  "line": 15,
  "name": "valido o cadatro do novo usuario",
  "keyword": "Então "
});
formatter.step({
  "line": 16,
  "name": "clico na aba Projetos",
  "keyword": "E "
});
formatter.step({
  "line": 17,
  "name": "clico em Novo Projeto",
  "keyword": "E "
});
formatter.step({
  "line": 18,
  "name": "informo os dados para criação do novo projeto",
  "keyword": "E "
});
formatter.step({
  "line": 19,
  "name": "clico em Criar e continuar",
  "keyword": "E "
});
formatter.step({
  "line": 20,
  "name": "valido que foi criado com sucesso",
  "keyword": "Então "
});
formatter.step({
  "line": 21,
  "name": "clico na aba Projetos",
  "keyword": "E "
});
formatter.step({
  "line": 22,
  "name": "clico no projeto criado",
  "keyword": "E "
});
formatter.step({
  "line": 23,
  "name": "clico na aba Nova tarefa",
  "keyword": "E "
});
formatter.step({
  "line": 24,
  "name": "crio 30 novas tarefas",
  "keyword": "E "
});
formatter.step({
  "line": 25,
  "name": "clico na aba Tarefas",
  "keyword": "E "
});
formatter.step({
  "line": 26,
  "name": "aplico paginação",
  "keyword": "E "
});
formatter.step({
  "line": 27,
  "name": "valido a tarefa 29",
  "keyword": "Então "
});
formatter.match({
  "location": "StepDefinitions.clicoEmCadastreSe()"
});
formatter.result({
  "duration": 722701900,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.informoOsDadosDeCadastroDeUsuário()"
});
formatter.result({
  "duration": 810454300,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.clicoEmEnviar()"
});
formatter.result({
  "duration": 1262851500,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.validoOCadatroDoNovoUsuario()"
});
formatter.result({
  "duration": 340801800,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.clicoNaAbaProjetos()"
});
formatter.result({
  "duration": 813798800,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.clicoEmNovoProjeto()"
});
formatter.result({
  "duration": 623011400,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.informoOsDadosParaCriaçãoDoNovoProjeto()"
});
formatter.result({
  "duration": 576273100,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.clicoEmCriarEContinuar()"
});
formatter.result({
  "duration": 1119325800,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.validoQueFoiCriadoComSucesso()"
});
formatter.result({
  "duration": 85049900,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.clicoNaAbaProjetos()"
});
formatter.result({
  "duration": 787313700,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.clicoEmUmProjetoCriado()"
});
formatter.result({
  "duration": 851357300,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.clicoNaAbaNovaTarefa()"
});
formatter.result({
  "duration": 648811300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "30",
      "offset": 5
    }
  ],
  "location": "StepDefinitions.crioNovasTarefas(int)"
});
formatter.result({
  "duration": 50245700700,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.clicoNaAbaTarefas()"
});
formatter.result({
  "duration": 921498600,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.aplicoPaginação()"
});
formatter.result({
  "duration": 856548500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "29",
      "offset": 16
    }
  ],
  "location": "StepDefinitions.validoATarefa(int)"
});
formatter.result({
  "duration": 303991200,
  "status": "passed"
});
});