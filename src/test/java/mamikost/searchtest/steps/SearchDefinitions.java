package mamikost.searchtest.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mamikost.searchtest.commondef.CommonDefinition;


public class SearchDefinitions extends CommonDefinition {

    @Before
    public void initData(Scenario sc){
        createAndroidDriver(sc.getName());

    }

    @Given("User input dipo tower keyword")
    public void UserInputDipoTowerKeyword(){
        System.out.println("Testing input search key");
        getPageCollection().getMainPage().getLoginPage();
    }

    @When("User sorting the price from the lowest price")
    public void UserSortingThePriceFromTheLowestPrice(){
        System.out.println("Sorting the price from the lowest price");
    }

    @Then("User get top 3 the lowest price of the border house")
    public void UserGetTop3TheLowestPriceOfTheBorderHouse(){
        System.out.println("User get top 3 the lowest price of the border house");
    }

    @After
    public void dispathDriver(){
        tearDown();
    }
}
