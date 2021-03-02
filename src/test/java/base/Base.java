package base;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

    private RemoteWebDriver remoteDriver;
    private WebDriverWait tiempoEspera;

    public Base(RemoteWebDriver remoteDriver) {
        this.remoteDriver = remoteDriver;
    }

    public WebElement findElement(By localizador) {
        return remoteDriver.findElement(localizador);
    }

    public List<WebElement> findElements(By localizador) {
        return remoteDriver.findElements(localizador);
    }

    public String getText(WebElement elemento) {
        return elemento.getText();
    }

    public String getText(By localizador) {
        return remoteDriver.findElement(localizador).getText();
    }

    public void teclear(String texto, By localizador) {
        remoteDriver.findElement(localizador).sendKeys(texto);
    }

    public void click(By localizador) {
        remoteDriver.findElement(localizador).click();
    }

    public String getTextSele(WebElement elemento) {
        return elemento.getText();
    }

    public String getTextSele(By localizador) {
        return remoteDriver.findElement(localizador).getText();
    }

    public void click(WebElement elemento) {
        elemento.click();
    }

    public String seleccionarListas(By listado, String campoSeleccionado) {
        Select lista = new Select(findElement(listado));
        lista.selectByVisibleText(campoSeleccionado);
        return getText(lista.getFirstSelectedOption());
    }

    public WebElement seleccionadoOpcion(By listado, String campoSeleccionado) {
        Select lista = new Select(findElement(listado));
        lista.selectByVisibleText(campoSeleccionado);
        return lista.getFirstSelectedOption();
    }

    public WebElement tiempoEmperaElementoVisible(By localizador, int segundos) {
        tiempoEspera = new WebDriverWait(remoteDriver, segundos);
        return tiempoEspera.until(ExpectedConditions.visibilityOfElementLocated(localizador));
    }

    public WebElement tiempoEsperaCampoListo(By localizador, int segundos) {
        tiempoEspera = new WebDriverWait(remoteDriver, segundos);
        return tiempoEspera.until(ExpectedConditions.elementToBeClickable(localizador));
    }

    public void tiempoEspera(int tiempo) throws Exception {
        Thread.sleep(tiempo);
    }

}
