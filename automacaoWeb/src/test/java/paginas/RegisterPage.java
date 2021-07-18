package paginas;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class RegisterPage extends BasePage{
    private Wait<WebDriver>wait;
    public RegisterPage(WebDriver driver) {
        super(driver);
        this.wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
            .pollingEvery(Duration.ofMillis(2000)).ignoring(NoSuchElementException.class);
    }
    public void acessarSite(String site){
        driver.get(site);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public void CriarNovaConta(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@class='create-new-account ng-scope']")));
        driver.findElement(By.xpath(".//*[@class='create-new-account ng-scope']")).click();
    }

    public void digitarUsuarioRegistro(String username){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("usernameRegisterPage")));
        driver.findElement(By.name("usernameRegisterPage")).sendKeys(username);
    }

    public void digitarEmail(String email) {
        driver.findElement(By.name("emailRegisterPage")).sendKeys(email);
    }

    public void digitarSenhaRegistro(String senha) {
        driver.findElement(By.name("passwordRegisterPage")).sendKeys(senha);
    }

    public void confirmarSenha(String confirSenha) {
        driver.findElement(By.name("confirm_passwordRegisterPage")).sendKeys(confirSenha);
    }

    public void digitarPrimeiroNome(String primeiroNome) {
        driver.findElement(By.name("first_nameRegisterPage")).sendKeys(primeiroNome);
    }

    public void digitarUltimoNome(String ultimoNome){
        driver.findElement(By.name("last_nameRegisterPage")).sendKeys(ultimoNome);
    }

    public void digitarCelular(String celular){
        driver.findElement(By.name("phone_numberRegisterPage")).sendKeys(celular);
    }

    public void selecionarUmPais(String pais){
        driver.findElement(By.xpath("//option[@label='" +pais+"']")).click();
    }

    public void digitarCidade(String cidade){
        driver.findElement(By.name("cityRegisterPage")).sendKeys(cidade);
    }

    public void digitarEndereco(String endereco){
        driver.findElement(By.name("addressRegisterPage")).sendKeys(endereco);
    }

    public void digitarRegiao(String regiao){
        driver.findElement(By.name("state_/_province_/_regionRegisterPage")).sendKeys(regiao);
    }

    public void digitarCEP(String cep){
        driver.findElement(By.name("postal_codeRegisterPage")).sendKeys(cep);
    }

    public void clicarNoCheckBoxEuConcordo(){
        driver.findElement(By.name("i_agree")).click();
    }

    public void clicarEmRegister() {
        driver.findElement(By.id("register_btnundefined")).click();
    }

    public void verificarSeOUsuarioEstaLogado(String username, String screenShotName) throws IOException, InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'hi-user containMiniTitle')]")));
        assertEquals(username, driver.findElement(By.xpath("//span[contains(@class,'hi-user containMiniTitle')]")).getText());
        //tira print da tela
        TakesScreenshot ts=(TakesScreenshot)driver;
        File source=ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("./screenshot/advantage"+ screenShotName +".png"));
    }

    public void clicarNoBotaoQueAbreATelaDeLogin(){
        driver.findElement(By.id("hrefUserIcon")).click();
    }

    public void digitarLogin(String usuario) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(usuario);
    }

    public void digitarSenha(String senha) {
        driver.findElement(By.name("password")).sendKeys(senha);
    }

    public void clicarEmSignIn() {
        driver.findElement(By.xpath("//*[@id='sign_in_btnundefined']")).click();
    }

    public void verificarSeAMensagemEsperadaFoiRetornada(String mensagem, String screenShotName) throws IOException {
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("signInResultMessage")), mensagem));
        //tira print da tela
        TakesScreenshot ts=(TakesScreenshot)driver;
        File source=ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("./screenshot/advantage"+ screenShotName +".png"));
    }
}