package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Homepage
{
    protected static WebDriver driver;

    @BeforeMethod
    public void openBrowser()
    {
        System.setProperty("webdriver.chrome.driver", "src/test/java/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
    }

    @AfterMethod
    public void closeBrowser()
    {
        driver.quit();
    }

    @Test
    public void EmailAFriend()
    {
        // Find the link containing "Apple MacBook Pro 13-inch" on the homepage and perform click action on it
        driver.findElement(By.linkText("Apple MacBook Pro 13-inch")).click();

        // Click on "Email a friend" button on this webpage
        driver.findElement(By.xpath("// button [@class='button-2 email-a-friend-button']")).click();

        // Fill friend's email id
        driver.findElement(By.id("FriendEmail")).sendKeys("abc@mail.com");
        // Fill own email id
        driver.findElement(By.id("YourEmailAddress")).sendKeys("xyz@mail.com");
        // Fill personal message
        driver.findElement(By.id("PersonalMessage")).sendKeys("Check this out!!!");
        // Click the "SEND EMAIL" button
        driver.findElement(By.name("send-email")).click();

        // Get the text from the error message displayed
        String strTitleText = driver.findElement(By.xpath("//*[contains(text(),'Only')]")).getText();
        System.out.println(strTitleText);
    }

    @Test
    public void NewsComments()
    {
        // Find the "Details" button for the middle column in the news on the homepage and perform click action on it
        driver.findElement(By.xpath("//a [@href=\"/nopcommerce-new-release\" and @class=\"read-more\"]")).click();

        // Fill the Title box as per the input provided below
        driver.findElement(By.id("AddNewComment_CommentTitle")).sendKeys("MyTitle");
        // Fill the Comment box as per the input provided below
        driver.findElement(By.id("AddNewComment_CommentText")).sendKeys("My Comment");
        // Click the "New Comment" button
        driver.findElement(By.name("add-comment")).click();

        // Get the resultant Text displayed from thr webpage
        String strNewsSuccessfulText = driver.findElement(By.className("result")).getText();
        System.out.println(strNewsSuccessfulText);
    }

    @Test
    public void HomePageCategories()
    {
        // Find the link containing "computers" from the notmobile section of the webpage and get the link text from it
        String strTitleText = driver.findElement(By.xpath("//ul [@class='top-menu notmobile'] // * [contains(@href,'computers')]")).getText();
        System.out.println(strTitleText);

        // Find the link containing "electronics" from the notmobile section of the webpage and get the link text from it
        strTitleText = driver.findElement(By.xpath("//ul [@class='top-menu notmobile'] // * [contains(@href,'electronics')]")).getText();
        System.out.println(strTitleText);

        // Find the link containing "apparel" from the notmobile section of the webpage and get the link text from it
        strTitleText = driver.findElement(By.xpath("//ul [@class='top-menu notmobile'] // * [contains(@href,'apparel')]")).getText();
        System.out.println(strTitleText);

        // Find the link containing "digital-" from the notmobile section of the webpage and get the link text from it
        strTitleText = driver.findElement(By.xpath("//ul [@class='top-menu notmobile'] // * [contains(@href,'digital-')]")).getText();
        System.out.println(strTitleText);

        // Find the link containing "books" from the notmobile section of the webpage and get the link text from it
        strTitleText = driver.findElement(By.xpath("//ul [@class='top-menu notmobile'] //li[5] / * [contains(@href,'books')]")).getText();
        System.out.println(strTitleText);

        // Find the link containing "jewelry" from the notmobile section of the webpage and get the link text from it
        strTitleText = driver.findElement(By.xpath("//ul [@class='top-menu notmobile'] // * [contains(@href,'jewelry')]")).getText();
        System.out.println(strTitleText);

        // Find the link containing "gift-" from the notmobile section of the webpage and get the link text from it
        strTitleText = driver.findElement(By.xpath("//ul [@class='top-menu notmobile'] // * [contains(@href,'gift-')]")).getText();
        System.out.println(strTitleText);
    }

    @Test
    public void Products()
    {
        // Find the element -Computers (by link text) - on the homepage and perform click action on it
        driver.findElement(By.linkText("Computers")).click();
        // Find the element -Desktops (by link text) - on the homepage and perform click action on it
        driver.findElement(By.linkText("Desktops")).click();

        // Find the link which contains the word - "build" and get the link text
        String strTitleText = driver.findElement(By.xpath("// h2 //*[contains(@href,'build')]")).getText();
        System.out.println(strTitleText);

        // Find the link which contains the word - "vanquish-" and get the link text
        strTitleText = driver.findElement(By.xpath("// h2 //*[contains(@href,'vanquish-')]")).getText();
        System.out.println(strTitleText);

        // Find the link which contains the word - "lenovo-" and get the link text
        strTitleText = driver.findElement(By.xpath("// h2 //*[contains(@href,'lenovo-')]")).getText();
        System.out.println(strTitleText);
    }

}
