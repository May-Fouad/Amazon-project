import org.example.amazon.SearchPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchByKeywordAndCheckoutTestCase extends TestBase{

    String phoneExpectedResult="\"phone\"";
    String PAGE_TITLE;
    String KEYWORD="phone";
    String AmountInShoppingCart="Amount";
    public SearchPage searchpage;
    //SearchPage searchPage;
    @Test(priority = 1,description = "success test search by keyword and add to cart to checkout scenario")
    public void SearchByKeyWord() {
        searchpage=new SearchPage(driver);
        searchpage.searchByKeyword(KEYWORD);
        Assert.assertEquals(searchpage.returnText(KEYWORD),phoneExpectedResult);
        searchpage.addItemToCart();
        searchpage.goToBasket();

       // AmountInShoppingCart = driver.findElement(By.xpath("//div[@class=\"a-section a-spacing-mini\"]/span")).getText();
        Assert.assertEquals(searchpage.returnText(AmountInShoppingCart),searchpage.Amount);

        searchpage.proceedToCheckout();
}
//@Test(priority = 2,description="select add to cart of specific phone")
  //      public void AddItemToCart()
//{

   // searchpage=new SearchPage(driver);
  //  searchpage.searchByKeyword(KEYWORD);
  //  searchpage.addItemToCart();
  //  searchpage.goToBasket();
   // searchpage.proceedToCheckout();
//}
}
