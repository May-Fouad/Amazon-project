package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Main {
    public  static WebDriver driver;
    public static WebElement SearchTxtBox;
    public static WebElement SearchBtn;
    public static WebElement SearchResultTxt;

    public static String KeyWord="phone";
    public static String ProductName;



    public static void searchByKeyword()
    {
        driver=new ChromeDriver();
        driver.get("https://www.amazon.eg/?language=en_AE");
        SearchTxtBox =driver.findElement(By.id("twotabsearchtextbox"));
        SearchTxtBox.sendKeys(KeyWord);
        SearchBtn=driver.findElement(By.id("nav-search-submit-button"));
                SearchBtn.click();
        List<WebElement> ProductNames=driver.findElements(By.xpath("//span[@class=\"a-size-base-plus a-color-base a-text-normal\"]"));
        for(int i=0;i<ProductNames.size();i++)
        {

            ProductName=ProductNames.get(i).getText();
            System.out.println(ProductName);

        }

    }

  /*  public static void addToCart()
    {
        List<WebElement> products=driver.findElements(By.cssSelector("button.sc-8be8088a-6.hRzhje"));
for(int i=0;i<products.size();i++)
{
products.get(i).getText();
    if(products)
}
    }*/
    public static void main(String[] args) {


        searchByKeyword();
    }
}