package helper;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class Helpers {

    private static WebDriver driver;
    private static WebDriverWait wait;
    private final String resourceDrivesPath = "drives/%s";

    protected void configuration(String path) {
        if (System.getProperty("os.name").toUpperCase().contains("WINDOWS")) {
            System.setProperty("webdriver.chrome.driver", getFilePathFromResources(String.format(resourceDrivesPath, "chromedriver.exe")));
        } else
            System.setProperty("webdriver.chrome.driver", getFilePathFromResources(String.format(resourceDrivesPath, "chromedriver")));
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
        driver.get(path);
    }

    public String getFilePathFromResources(String relativePath) {
        try {
            if (System.getProperty("os.name").toUpperCase().contains("WINDOWS")) {
                return URLDecoder.decode(getClass().getResource("/" + relativePath).getPath(), "UTF-8").replaceFirst("/", "");
            } else {
                return URLDecoder.decode(getClass().getResource("/" + relativePath).getPath(), "UTF-8");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    public  void clickAndWait(String elementXpath) {
        clickAndWait(elementXpath, 0, 0);
    }

    public  void clickAndWait(String elementXpath, int timerInitial, int timerAfter) {
        waitSomeSeconds(timerInitial);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementXpath)));
        waitElementXPath(elementXpath).click();
        waitSomeSeconds(timerAfter);
    }

    public  WebElement waitElementXPath(String elementXpath) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
        return driver.findElement(By.xpath(elementXpath));
    }

    public  WebElement waitElementClass(String elementClass) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(elementClass)));
        return driver.findElement(By.className(elementClass));
    }

    public  WebElement waitElementID(String elementID) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elementID)));
        return driver.findElement(By.id(elementID));
    }

    public  void elementMatchTextID(String expectedMsg, String elementID) {
        wait.until(ExpectedConditions.textToBe(By.id(elementID), expectedMsg));
        Assert.assertEquals(expectedMsg, waitElementID(elementID).getText());
    }

    public void elementMatchTextClass(String expectedMsg, String elementClass) {
        wait.until(ExpectedConditions.textToBe(By.className(elementClass), expectedMsg));
        Assert.assertEquals(expectedMsg, waitElementClass(elementClass).getText());
    }

    public void elementMatchText(String expectedMsg, String elementXpath) {
        wait.until(ExpectedConditions.textToBe(By.xpath(elementXpath), expectedMsg));
        if(!waitElementXPath(elementXpath).getText().equals(expectedMsg)){
            throw new Error("Error occurs because comparison is invalid");
        }
    }

    public  void waitSomeSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public  void finish() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static String usingBufferedReader(String filePath)
    {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {

            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null)
            {
                contentBuilder.append(sCurrentLine).append("\n");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }
}
