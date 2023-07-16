package by.itacademy.melnichenko.leonid.ui.utils;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverSingletone {
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
    private DriverSingletone() {
    }
    public static void quit(){
        if(webDriver != null){
            webDriver.quit();
            webDriver = null;
        }
    }
}
