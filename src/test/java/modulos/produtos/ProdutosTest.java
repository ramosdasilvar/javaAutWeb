package modulos.produtos;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@DisplayName("Testes Web do modulo de produtos")
public class ProdutosTest {

    private WebDriver navegador;

    @BeforeEach
    public void beforeEach(){
        // Abrir o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver-win64\\chromedriver.exe");
        this.navegador = new ChromeDriver();

        // Vou maximizar a tela
        navegador.manage().window().maximize();

        // Vou definir um tempo de espera padrão de 5 segundos
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Navegar para a pagina da Lojinha Web
        navegador.get("http://165.227.93.41/lojinha-web/v2");
    }

    @Test
    @DisplayName("Não é permitido registrar produto com valor igual a zero")
    public void testNaoPermiteRegistroProdutoComValorZerado (){

        //Fazer login
        navegador.findElement(By.cssSelector("label[for='usuario']")).click();
        navegador.findElement(By.id("usuario")).sendKeys("admin");

        navegador.findElement(By.cssSelector("label[for='senha']")).click();
        navegador.findElement(By.id("senha")).sendKeys("admin");

        navegador.findElement(By.id("btn-entrar")).click();

        // Vou para a tela de registro de produto
        navegador.findElement(By.linkText("ADICIONAR PRODUTO")).click();

        // Vou preencher dados do produto e o valor sera igaul a zero
        navegador.findElement(By.id("produtonome")).sendKeys("MacBook Pro");
        navegador.findElement(By.name("produtovalor")).sendKeys("000");
        navegador.findElement(By.id("produtocores")).sendKeys("keys");

        // Vou submeter o formulario
        navegador.findElement(By.cssSelector("button[type='submit']")).click();

        // Vou validar que a mensagem de erro foi apresentada
        String mensagemToast = navegador.findElement(By.cssSelector(".toast.rounded")).getText();
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemToast);

    }

    @AfterEach
    public void afterEach(){

        // Fechar o navegador
        navegador.close();
    }
}
