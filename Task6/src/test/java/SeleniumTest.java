import org.apache.commons.exec.CommandLine;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SeleniumTest {


    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();

        System.out.println("Launching chrome browser");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        System.out.println("The chrome window is maximized");
        Thread.sleep(2000);

        driver.get("https://www.thesparksfoundationsingapore.org/");
        System.out.println("Spark Foundation website is successfully loaded");
        Thread.sleep(2000);

        // Test Case:01 verifying the page title
        String title = "The Sparks Foundation | Home";
        boolean flag = false;
        if (driver.getTitle().equalsIgnoreCase(title)){
             flag = true;
             System.out.println("The title Exists");
        }
        Assert.assertTrue(flag, "Page title is not matching with expected");
        Thread.sleep(2000);

        // Test Case:02 Testing Header
        boolean flag1 = false;
        if(driver.findElement(By.tagName("nav")) != null){
            flag1 = true;
            System.out.println("The Nav Bar Exists");
        }
        Assert.assertTrue(flag1, "Page Header does not exists");
        Thread.sleep(2000);

        // Test Case: 03 Testing Program pages
        driver.findElement(By.linkText("Student Scholarship Program")).click();
        Thread.sleep(2000);
        System.out.println("Successfully loaded Student Scholarship Program page");

        // Test Case: 04 Testing Program pages
        driver.findElement(By.linkText("Student Mentorship Program")).click();
        Thread.sleep(2000);
        System.out.println("Successfully loaded Student Mentorship Program page");

        // Test Case: 05 Testing Program pages
        driver.findElement(By.linkText("Student SOS Program")).click();
        Thread.sleep(2000);
        System.out.println("Successfully loaded Student Student SOS Program page");

        // Test Case: 06 Testing Program pages
        driver.findElement(By.linkText("About Us")).click();
        Thread.sleep(2000);
        System.out.println("Successfully loaded About Us page");

        // Test Case: 07 Join us Page
        driver.findElement(By.linkText("Expert Mentor")).click();
        Thread.sleep(2000);
        System.out.println("Successfully loaded Expert Mentor page");

        // Test Case: 08 Automatic form submission
        driver.findElement(By.name("Name")).sendKeys("Hassaan Ali");
        Thread.sleep(2000);
        System.out.println("Automatically entered the name");
        driver.findElement(By.name("Email")).sendKeys("hassaanali723@gmail.com");
        Thread.sleep(2000);
        System.out.println("Automatically entered the gmail");
        Select form = new Select(driver.findElement(By.className("form-control")));
        form.selectByVisibleText("Student");
        Thread.sleep(2000);
        System.out.println("Automatically entered the Role");
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/form/input[3]")).submit();
        Thread.sleep(2000);
        System.out.println("Automatically submitted the form");


        // Test Case:09 Testing Footer
        boolean flag2 = false;
        if(driver.findElement(By.className("footer")) != null){
            flag2 = true;
            System.out.println("The Footer Exists");
        }
        Assert.assertTrue(flag2, "Footer does not exists");

        // Test Case:10 Testing Copyright
        boolean flag3 = false;
        if(driver.findElement(By.className("copyright-wthree")) != null){
            flag3 = true;
            System.out.println("The Copyrights Exists");
        }
        Assert.assertTrue(flag3, "Copyrights does not exists");

        driver.close();
        driver.quit();
    }
}
