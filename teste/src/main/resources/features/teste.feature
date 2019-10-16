#language: pt
@Smoke
Funcionalidade: Painel de Aprovação
  Como usuário
  Ao acessar minha aplicação
  Gostaria de ver a listagem de SG'S

  Contexto:
    Dado a pagina aberta

    Cenario: criar um novo usuario
      Quando clico em Cadastre-se
      E informo os dados de cadastro de usuário
      E clico em Enviar
      Então valido o cadatro do novo usuario
      E clico na aba Projetos
      E clico em Novo Projeto
      E informo os dados para criação do novo projeto
      E clico em Criar e continuar
      Então valido que foi criado com sucesso
      E clico na aba Projetos
      E clico no projeto criado
      E clico na aba Nova tarefa
      E crio 30 novas tarefas
      E clico na aba Tarefas
      E aplico paginação
      Então valido a tarefa 29
