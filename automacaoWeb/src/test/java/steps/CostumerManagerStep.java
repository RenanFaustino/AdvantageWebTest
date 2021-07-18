package steps;

import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.RegisterPage;

import java.io.File;
import java.io.IOException;

public class CostumerManagerStep {
    ChromeDriver driver = new ChromeDriver();

    @After
    public void fecharNegador(){
        driver.quit();
    }

    @Dado("que eu acesse o site {string}")
    public void que_eu_acesse_o_site(String site){
        new RegisterPage(driver).acessarSite(site);
    }

    @E("clico no campo usuario")
    public void clico_no_campo_usuario(){
        new RegisterPage(driver).clicarNoBotaoQueAbreATelaDeLogin();
    }

    @E("clico no campo create new account")
    public void clico_em_criar_nova_conta() throws Throwable {
        new RegisterPage(driver).CriarNovaConta();
    }

    @E("digito o usuario para registro {string}")
    public void digito_o_usuario_para_registro(String username) throws Throwable {
        new RegisterPage(driver).digitarUsuarioRegistro(username);
    }


    @E("digito o email {string}")
    public void digito_o_email(String email) {
        new RegisterPage(driver).digitarEmail(email);
    }

    @E("digito a senha para registro {string}")
    public void digito_a_senha_para_registro(String senha){
        new RegisterPage(driver).digitarSenhaRegistro(senha);
    }

    @E("confirmo a senha {string}")
    public void confirmo_a_senha(String senhaConfirmacao){
        new RegisterPage(driver).confirmarSenha(senhaConfirmacao);
    }

    @E("digito o primeiro nome {string}")
    public void digito_o_primeiro_nome(String primeiroNome){
        new RegisterPage(driver).digitarPrimeiroNome(primeiroNome);
    }

    @E("digito o ultimo nome {string}")
    public void digito_o_ultimo_nome(String ultimoNome){
        new RegisterPage(driver).digitarUltimoNome(ultimoNome);
    }

    @E("digito o celular {string}")
    public void digito_o_celular(String celular){
        new RegisterPage(driver).digitarCelular(celular);
    }

    @E("seleciono o pais {string}")
    public void seleciono_o_pais(String pais){
        new RegisterPage(driver).selecionarUmPais(pais);
    }

    @E("digito a cidade {string}")
    public void digito_uma_cidade(String cidade){
        new RegisterPage(driver).digitarCidade(cidade);
    }

    @E("digito o endereco {string}")
    public void digito_o_endereco(String endereco){
        new RegisterPage(driver).digitarEndereco(endereco);
    }

    @E("digito a regiao {string}")
    public void digito_uma_regiao(String regiao){
        new RegisterPage(driver).digitarRegiao(regiao);
    }

    @E("digito o cep {string}")
    public void digito_um_cep(String cep){
        new RegisterPage(driver).digitarCEP(cep);
    }

    @E("clico em eu concordo")
    public void clico_em_eu_concordo(){
        new RegisterPage(driver).clicarNoCheckBoxEuConcordo();
    }

    @Quando("clico em register")
    public void clico_em_register() {
        new RegisterPage(driver).clicarEmRegister();
    }

    @Entao("verifico se o usuario esta logado {string} {string}")
    public void verifico_se_o_usuario_esta_logado(String username, String screenShotName) throws IOException, InterruptedException {
        new RegisterPage(driver).verificarSeOUsuarioEstaLogado(username, screenShotName);
    }





    //Login

    @E("clico em User para Login")
    public void clico_em_user_para_Login(){
        new RegisterPage(driver).clicarNoBotaoQueAbreATelaDeLogin();
    }

    @E("digito o usuario {string}")
    public void digito_o_login(String usuario){
        new RegisterPage(driver).digitarLogin(usuario);
    }

    @E("digito a senha {string}")
    public void digito_a_senha(String senha) {
        new RegisterPage(driver).digitarSenha(senha);
    }

    @Quando("clico em sign in")
    public void clico_em_sign_in(){
        new RegisterPage(driver).clicarEmSignIn();
    }


    @E("verifico se a mensagem {string} foi retornada {string}")
    public void verifico_se_a_mensagem_foi_retornada(String mensagem, String screenShotName) throws IOException {
        new RegisterPage(driver).verificarSeAMensagemEsperadaFoiRetornada(mensagem, screenShotName);
    }

    @E("espero alguns segundos para tentar logar novamente")
    public void esperoAlgunsSegundosParaTentarLogarNovamente() throws InterruptedException {
        Thread.sleep(10000);
    }
}
