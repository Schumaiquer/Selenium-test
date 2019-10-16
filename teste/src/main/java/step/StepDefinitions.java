package step;

import cucumber.api.java.pt.*;
import gherkin.deps.com.google.gson.Gson;
import helper.Helpers;
import com.github.javafaker.Faker;
import org.junit.After;

import java.io.FileNotFoundException;

import static pages.CreateProjectPage.*;
import static pages.NewTaskPage.*;
import static pages.ProjectPage.*;
import static pages.RegisterPage.*;
import static pages.UrlPage.*;

public class StepDefinitions extends Helpers {
    Faker faker = new Faker();
    private static String nameProject = "";


    @Dado("^a pagina aberta$")
    public void aPaginaAberta() {
        configuration(BASE_URL);
    }

    @Quando("^clico em Cadastre-se$")
    public void clicoEmCadastreSe() {
        clickAndWait(REGISTER_NEW_USER);
    }

    @E("^informo os dados de cadastro de usuário$")
    public void informoOsDadosDeCadastroDeUsuário() {
        waitElementID("user_login").sendKeys(faker.name().username());
        waitElementID("user_password").sendKeys("12345");
        waitElementID("user_password_confirmation").sendKeys("12345");
        waitElementID("user_firstname").sendKeys(faker.name().firstName());
        waitElementID("user_lastname").sendKeys(faker.name().lastName());
        waitElementID("user_mail").sendKeys(faker.internet().emailAddress());
    }

    @E("^clico em Enviar$")
    public void clicoEmEnviar() {
        clickAndWait(REGOSTER_BUTTON_SUBMIT);
    }

    @Então("^valido o cadatro do novo usuario$")
    public void validoOCadatroDoNovoUsuario() {
        elementMatchTextID("Sua conta foi ativada. Você pode acessá-la agora.", "flash_notice");
    }

    @After
    public void end() {
        finish();
    }

    @E("^clico na aba Projetos$")
    public void clicoNaAbaProjetos() {
        clickAndWait(PROJECT_TAB);
    }

    @E("^clico em Novo Projeto$")
    public void clicoEmNovoProjeto() {
        clickAndWait(NEW_PROJECT_TAB);
    }

    @E("^informo os dados para criação do novo projeto$")
    public void informoOsDadosParaCriaçãoDoNovoProjeto() {
        nameProject = "teste " + faker.idNumber().valid();

        waitElementID("project_name").sendKeys(nameProject);
        waitElementID("project_description").sendKeys("TESTE DESCRIÇÃO");
        clickAndWait(SECOND_CHECKED);
        clickAndWait(THIRD_CHECKED);
    }

    @E("^clico em Criar e continuar$")
    public void clicoEmCriarEContinuar() {
        clickAndWait(CREATE_AND_CONTINUE);
    }

    @Então("^valido que foi criado com sucesso$")
    public void validoQueFoiCriadoComSucesso() {
        elementMatchTextID("Criado com sucesso.", "flash_notice");
    }

    @E("^clico no projeto criado$")
    public void clicoEmUmProjetoCriado() {
        clickAndWait(PROJECT_CREATE);
    }

    @E("^clico na aba Nova tarefa$")
    public void clicoNaAbaNovaTarefa() {
        clickAndWait(NEW_TASK_TAB);
    }


    @E("^crio (\\d+) novas tarefas$")
    public void crioNovasTarefas(int arg0) throws FileNotFoundException {
        String json = usingBufferedReader("C:/Users/Zupper/Desktop/teste/src/main/resources/json/test.json");
        Task task = new Gson().fromJson(json, Task.class);
        for (int i = 0; i <= arg0; i++) {
            waitElementID("issue_subject").sendKeys(task.getTasks().get(i).getTitle());
            waitElementID("issue_description").sendKeys(task.getTasks().get(i).getTitle());
            if(i==2){
                nameProject = waitElementXPath(FLASH_NOTICE_CODE).getText().replace("#","");
            }
            clickAndWait(NEW_TASK_CREATE_AND_CONTINUE);
        }
    }

    @E("^clico na aba Tarefas$")
    public void clicoNaAbaTarefas() {
        clickAndWait(TASK_TAB);
    }

    @E("^aplico paginação$")
    public void aplicoPaginação() {
        clickAndWait(NEXT_PAGE_TASK);
    }

    @Então("^valido a tarefa (\\d+)$")
    public void validoATarefa(int arg0) throws FileNotFoundException {
        String json = usingBufferedReader("C:/Users/Zupper/Desktop/teste/src/main/resources/json/jsonValidate.json");
        Task task = new Gson().fromJson(json, Task.class);

        elementMatchText("Bug", "//*[@id=\"issue-"+nameProject+"\"]/td[3]");
        elementMatchText("New", "//*[@id=\"issue-"+nameProject+"\"]/td[4]");
        elementMatchText("Normal", "//*[@id=\"issue-"+nameProject+"\"]/td[5]");
        elementMatchText(task.getTasks().get(1).getTitle(),"//*[@id=\"issue-"+nameProject+"\"]/td[6]/a");

    }

}
