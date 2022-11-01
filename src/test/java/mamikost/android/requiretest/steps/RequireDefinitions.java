package mamikost.android.requiretest.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mamikost.android.commondef.CommonDefinition;
import org.testng.Assert;


public class RequireDefinitions extends CommonDefinition {

    @Before
    public void initData(Scenario sc){
        createAndroidDriver(sc.getName());
    }

    @Given("When in dabashboard page")
    public void UserInDashboardPage(){
        System.out.println("User in dashboard page");

    }

    @When("User click require page")
    public void UserClickRequirePage(){
        System.out.println("User click require page");
    }

    @Then("Redirect in require page")
    public void UserGetTop3TheLowestPriceOfTheBorderHouse(){
        System.out.println("User get top 3 the lowest price of the border house");
    }

    @After
    public void dispathDriver(){
        tearDown();
    }


    //@Test
    //public void iniTestBaru(){
    //    System.out.println("Test baru dipanggil");
    //}

}
