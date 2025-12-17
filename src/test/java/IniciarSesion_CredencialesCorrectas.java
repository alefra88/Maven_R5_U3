
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * Universidad Virtual Del Estado de Guanajuato
 * Alumno: Alan Efraín Ocampo Guzmán
 * Matrícula: 24007267
 * Asesor: Esdras Eduardo García
 * Módulo: Calidad y Pruebas de Software
 * Reto: Reto 5. Automatización de una pantalla login
 * Diciembre 17, 2025
 * 
 */
public class IniciarSesion_CredencialesCorrectas {
    
    WebDriver driver;
    String url = "https://practice.automationtesting.in/my-account/";

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @Test
    public void testCredencialesCorrectas() {
        WebElement emailInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.name("login"));

        emailInput.sendKeys("efra.rlz@gmail.com"); 
        passwordInput.sendKeys("_$Al4nROX$_");
        loginButton.click();

        WebElement signOutLink = driver.findElement(By.xpath("//a[contains(text(),'Sign out')]"));
        
        Assert.assertTrue(signOutLink.isDisplayed(), "No se inició sesión correctamente (no se ve el botón Sign Out)");
        System.out.println("Prueba de Credenciales Correctas: PASADO");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    
}
