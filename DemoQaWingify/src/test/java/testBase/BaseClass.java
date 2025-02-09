package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class BaseClass {
    
    public static WebDriver driver;
    public Properties p;
    protected WebDriverWait wait;
    
    @BeforeClass
    public void setup() throws IOException {
        FileReader file = new FileReader("./src//test//resources//config.properties");
        p = new Properties();
        p.load(file);
        
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        driver.get(p.getProperty("appURL"));
        driver.manage().window().maximize();
    }
    
    @BeforeMethod
    public void resetBrowserState() {
        driver.get(p.getProperty("appURL"));
        driver.manage().deleteAllCookies();
    }
    
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
    
    public String captureScreen(String tname) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        
        String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
        File targetFile=new File(targetFilePath);
        
        sourceFile.renameTo(targetFile);
        
        return targetFilePath;
    }
    
    @DataProvider(name = "LoginData")
    public Object[][] getData() {
        return new Object[][] {
            { p.getProperty("validUsername"), p.getProperty("validPassword"), "valid" },
            { p.getProperty("incorrectUsername"), p.getProperty("incorrectPassword"), "invalid" },
            { p.getProperty("validUsername"), p.getProperty("incorrectPassword"), "invalid" },
            { p.getProperty("incorrectUsername"), p.getProperty("validPassword"), "invalid" },
            { "", "", "invalid" },
            { "", p.getProperty("validPassword"), "invalid" },
            { p.getProperty("validUsername"), "", "invalid" }
        };
    }
}