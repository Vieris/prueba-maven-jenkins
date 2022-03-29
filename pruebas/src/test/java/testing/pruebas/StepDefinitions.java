package testing.pruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class StepDefinitions {
	
	private WebDriver driver;
	
	
	@Before
	public void añadir_driver() {
		
		System.setProperty("webdriver.chrome.driver", "../_lib/Browser/chromedriver.exe");

		driver = (WebDriver) new ChromeDriver();
		
	}
	
	
	@Given("Un usuario se encuentra en la página principal de eltiempo.es")
	public void pagina_principal_eltiempo() throws Exception {

			driver.manage().window().maximize();

			driver.get("https://www.eltiempo.es/");
			
			Thread.sleep(1000);
			
    }
	
	String textoBusqueda;
	@And("quiere encontrar el tiempo que hace en San Roque")
	public void termino_busqueda_localidad() throws Exception {
		
        textoBusqueda = "Jerez de la Frontera";

    }
	
	@When("Introduce \"San Roque\" en el cuadro de búsqueda")
	public void introducir_texto_busqueda() throws Exception {
		
		driver.findElement(By.id("term")).click();
		driver.findElement(By.id("term")).sendKeys(textoBusqueda);
		
		Thread.sleep(1000);
		
		driver.findElement(By.id("term")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2500);

    }
	
	@And("Clica en la primera opción")
	public void click_opcion() throws Exception {
		
		driver.findElement(By.xpath(" //*[ text() = 'Jerez de la Frontera, Cádiz' ]")).click();
		
		Thread.sleep(2000);

    }
	
	@Then("Se muestra la página con el título de San Roque")
	public void h1_localidad() throws Exception {
		
		WebElement ciudad = driver.findElement(By.className("-itr"));
		String textoCiudad = ciudad.getAttribute("innerText");
		
		assertEquals(textoBusqueda, textoCiudad);
		
		driver.quit();
		
    }

}
