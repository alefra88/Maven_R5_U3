
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
public class IniciarSesion_CorreoIncorrecto {
    
    WebDriver driver;
    String url = "https://practice.automationtesting.in/my-account/";

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @Test
    public void testCorreoIncorrecto() {
        WebElement emailInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.name("login"));

        emailInput.sendKeys("correo_falso_123@prueba.com"); 
        passwordInput.sendKeys("PasswordDificil123!");
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.cssSelector(".woocommerce-error"));
        
        Assert.assertTrue(errorMessage.getText().contains("Error"), "El mensaje de error no apareció correctamente");
        System.out.println("Prueba de Correo Incorrecto: PASADO");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    
}
