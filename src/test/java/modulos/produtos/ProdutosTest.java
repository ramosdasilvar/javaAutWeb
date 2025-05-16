package modulos.produtos;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@DisplayName("Testes Web do modulo de produtos")
public class ProdutosTest {

    @Test
    @DisplayName("Não é permitido registrar produto com valor igual a zero")
    public void testNaoPermiteRegistroProdutoComValorZerado (){
        // Abrir o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver-win64\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();

        // Vou maximizar a tela
        navegador.manage().window().maximize();

        // Navegar para a pagina da Lojinha Web
        navegador.get("http://165.227.93.41/lojinha-web/v2");
        //Fazer login
        navegador.findElement(By.cssSelector("label[for='usuario']")).click();
        navegador.findElement(By.id("usuario")).sendKeys("admin");

        navegador.findElement(By.cssSelector("label[for='senha']")).click();
        navegador.findElement(By.id("senha")).sendKeys("admin");

        navegador.findElement(By.id("btn-entrar")).click();
        // Vou para a tela de registro de produto

        // Vou preencher dados do produto e o valor sera igaul a zero

        // Vou submeter o formulario

        // Vou validar que a mensagem de erro foi apresentada
    }
}
