package by.itacademy.melnichenko.leonid.ui.domain;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverSingleton {
    private static WebDriver webDriver;
    public static WebDriver getDriver() {
        if(webDriver == null){
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");
            webDriver = new ChromeDriver(chromeOptions);
            webDriver.manage().window().maximize();
        }
        return webDriver;
    }
    private DriverSingleton() {
    }
    public static void quit(){
        if(webDriver != null){
            webDriver.quit();
            webDriver = null;
        }
    }
}
