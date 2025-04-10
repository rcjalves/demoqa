package utils;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebdriverUtils {

    WebDriver driver;

    public WebdriverUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void clicar(By by) {
        driver.findElement(by).click();
        sleep(500);
    }

    public void clicarComJavaScript(By by) {
        WebElement element = driver.findElement(by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        sleep(500);
    }

    
    public void inserirValor(By by, String texto) {
        WebElement campo = driver.findElement(by);
        campo.clear();
        campo.sendKeys(texto);
        sleep(300);
    }

    public String getText(By by) {
        return driver.findElement(by).getText();
    }

    public void validarElementoTexto(String textoEsperado, By by) {
        String textoElemento = getText(by);
        Assert.assertTrue("Texto não encontrado: " + textoEsperado, textoElemento.contains(textoEsperado));
    }

    
    
    public void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    public void sleep () {
    	sleep(5000);
    }
    
    public void scrollToElement(By by) {
        WebElement element = driver.findElement(by);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
        sleep(500);
    }

    public void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        sleep(500);
    }
    
    public void inserirValorInputLimpaTab(By locator, String valor) {
        WebElement input = driver.findElement(locator);
        input.click();                         
        input.clear();                         
        input.sendKeys(Keys.CONTROL + "a");   
        input.sendKeys(Keys.DELETE);           
        input.sendKeys(valor);                 
        input.sendKeys(Keys.TAB);              
    }

}
