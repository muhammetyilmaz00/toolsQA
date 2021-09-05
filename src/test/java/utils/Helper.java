package utils;

import driverManager.DriverManager;
import driverManager.DriverManagerFactory;
import driverManager.DriverType;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Helper {

    private static DriverManager driverManager;
    private static WebDriver driver;

    public Helper(WebDriver driver) {
        Helper.driver = driver;
    }

    public static void openBrowser(DriverType type) {
        driverManager = DriverManagerFactory.getDriverManager(type);
        driver = driverManager.getWebDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
    }

    public static void openBrowser() {
        ConfigFileReader configFileReader = ConfigFileReader.createOrGetInstance();
        String defaultBrowser = configFileReader.getDefaultBrowserName();
        DriverType defaultDriverType = DriverType.toDriverType(defaultBrowser);
        openBrowser(defaultDriverType);
    }

    public void navigate(String navigationUrl, WebDriver driver, String title) {
        driver.get(navigationUrl);
        Assert.assertEquals(title, driver.getTitle());
    }

    public static void closeBrowser() {
        driverManager.quitWebDriver();
    }

    public static String getTextOfWebElementByXpath(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        scrollIntoViewByXpath(xpath);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return element.getText();
    }

    public static String getTextOfWebElementByID(String id) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        scrollIntoViewById(id);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
        return element.getText();
    }

    public static String getTextOfWebElement(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        scrollIntoView(by);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return element.getText();
    }

    public static void scrollIntoViewByXpath(String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void scrollIntoViewById(String id) {
        WebElement element = driver.findElement(By.id(id));
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void scrollIntoView(By by) {
        WebElement element = driver.findElement(by);
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static String alertMessage() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    public static void acceptAlert() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public static void dismissAlert() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }


    public static void hoverToElementByXpath(String xpath) {
        Actions actions = new Actions(driver);
        WebElement menuOption = driver.findElement(By.xpath(xpath));
        actions.moveToElement(menuOption).perform();
    }

    public static void hoverToElementById(String id) {
        Actions actions = new Actions(driver);
        WebElement menuOption = driver.findElement(By.id(id));
        actions.moveToElement(menuOption).perform();
    }

    public static void waitAndClickByXpath(String xpath) {
        scrollIntoViewByXpath(xpath);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        element.click();
    }

    public static void waitAndClickByID(String id) {
        scrollIntoViewById(id);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
        element.click();
    }

    public static void waitAndSendKeysByXpath(String xpath, String text) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        element.sendKeys(text);
    }

    public static void waitAndSendKeysById(String id, String text) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
        element.sendKeys(text);
    }

    public static void switchToTab(int tab) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tab));
    }

    public static List<String> newWindowText(By by) {
        String mainWindow = driver.getWindowHandle();
        Set<String> set = driver.getWindowHandles();
        List<String> list = new ArrayList<>();

        for (String childWindow : set) {
            if (!mainWindow.equalsIgnoreCase(childWindow)) {
                driver.switchTo().window(childWindow);
                list.add(getTextOfWebElement(by));
            }
        }
        driver.close();
        driver.switchTo().window(mainWindow);
        return list;
    }

    public static boolean isElementPresent(String xpath) {
        try {
            return driver.findElement(By.xpath(xpath)) != null;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static boolean isElementDisplayed(String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        element.isDisplayed();
        return true;
    }

    public static void verifyCurrentPageURL(String URL) {
        Assert.assertEquals(driver.getCurrentUrl(), URL);
    }

    public static void navigateURL(String URL) {
        driver.navigate().to(URL);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        Helper.driver = driver;
    }

    public static void takeSnapShot() throws Exception {
        Date d = new Date();
        System.out.println(d);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");

        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File("src/test/java/screenshot/screen" + sdf.format(d) + ".png");
        FileUtils.copyFile(SrcFile, DestFile);
    }

}

