package org.example.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class SearchPage {

  public static WebDriver driver;

    public  WebElement SearchTxtBox;
    public  WebElement SearchBtn;
    public  WebElement SearchResultTxt;
    public WebElement SearchCategory;
    public WebElement AddtoCartBtn;
    By phoneActualResult= By.xpath("//span[@class=\"a-color-state a-text-bold\"]");
    By AmountInShoppingCart = By.xpath("//div[@class=\"a-section a-spacing-mini\"]/span");
    By SelectedAmountSymbol=By.xpath("//span[@class='a-price-symbol']");
    By SelectedAmountValue=By.xpath("//span[@class='a-price-whole']");
    By SelectedAmountFraction=By.xpath("//span[@class='a-price-fraction']");
    String TxtSelectedAmountSymbol;
    String TxtSelectedAmountValue;
    String TxtSelectedAmountFraction;
    public String Amount;


    public String ProductName;
   public  String  selectedproductName;
   public String PriceOfProduct;

public String returnText(String phone){
    if (phone=="phone") {
        return driver.findElement(phoneActualResult).getText();
    }
    else if (phone=="Amount") {
        return driver.findElement(AmountInShoppingCart).getText();
    }
    else return "fail";
}
    public SearchPage(WebDriver driver){
        SearchPage.driver =driver;

    }

    public void searchByKeyword(String KeyWord)
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        SearchTxtBox =driver.findElement(By.id("twotabsearchtextbox"));
        SearchTxtBox.sendKeys(KeyWord);
        SearchBtn=driver.findElement(By.id("nav-search-submit-button"));
        SearchBtn.click();

        //using the following code to get all the result displayed of the first page to make sure the returned results are mobile
        List<WebElement> ProductNames=driver.findElements(By.xpath("//span[@class=\"a-size-base-plus a-color-base a-text-normal\"]"));
        for(int i=0;i<ProductNames.size();i++)
        {

          ProductName=ProductNames.get(i).getText();
            System.out.println(ProductName);

        }


    }
    public void searchByCategory(){
SearchCategory=driver.findElement(By.xpath("//a[contains(text(),\"Home\")]"));
SearchCategory.click();


    }
    public void addItemToCart() {
        List<WebElement> products = driver.findElements(By.cssSelector("span[class=\"a-size-base-plus a-color-base a-text-normal\"]"));
        selectedproductName = products.get(3).getText();
        TxtSelectedAmountSymbol=driver.findElements(SelectedAmountSymbol).get(6).getText();
        TxtSelectedAmountValue=driver.findElements(SelectedAmountValue).get(6).getText();
        TxtSelectedAmountFraction=driver.findElements(SelectedAmountFraction).get(6).getText();
         Amount=TxtSelectedAmountSymbol+" "+TxtSelectedAmountValue+"."+TxtSelectedAmountFraction;

        PriceOfProduct = driver.findElements(By.xpath("//span[@class=\"a-price-whole\"]")).get(3).getText();
        System.out.println("the selected product Name " + selectedproductName);
        System.out.println(TxtSelectedAmountValue);

        for (int i = 0; i < products.size(); i++) {
            ProductName = products.get(i).getText();
            if (ProductName.contains(selectedproductName)) {
                WebElement SelectedElement = driver.findElements(By.xpath("//button[@class='a-button-text']")).get(i);
                SelectedElement.click();

                System.out.println("ProductName is added " + selectedproductName);

                break;

            }
        }


        // driver.findElement(By.id("nav-cart")).click();
        //  driver.findElement(By.xpath("nav-cart")).click();
        //driver.findElement(By.cssSelector("nav-a nav-a-2.nav-progressive-attribute")).click();

        // System.out.println("proceedtocheckout");

       // return PriceOfProduct;

    }
    public void goToBasket(){
        driver.findElement(By.cssSelector("span[class=\"a-button a-button-span11 a-button-base a-button-small\"]")).click();
        // System.out.println("go to basket");

    }
    public void proceedToCheckout(){
        driver.findElement(By.name("proceedToRetailCheckout")).click();


    }

}
