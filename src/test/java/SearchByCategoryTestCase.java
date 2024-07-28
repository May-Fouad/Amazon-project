import org.example.amazon.SearchPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SearchByCategoryTestCase extends TestBase{
    SearchPage searchpage;
String PageTitle;
    @Test(priority=1, description ="Success Search by category = home")
    public void SearchByCategory(){
        searchpage=new SearchPage(driver);
        searchpage.searchByCategory();
        PageTitle=driver.findElement(By.xpath("//b[contains(.,'Home and Kitchen')]")).getText();
        System.out.println(PageTitle);


    }
}
