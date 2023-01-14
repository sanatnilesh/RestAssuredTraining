package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.is;


public class GetPostSteps{
    @Given("I perform GET operation for {string}")
    public void iPerformGETOperationFor(String url) throws  Throwable{}

    @And("I perform GET for the post number {string}")
    public void iPerformGETForThePostNumber(String postNumber) throws  Throwable{
            BDDStyleMethod.GetPostSteps(postNumber);
    }

    @Then("I should see the author name as {string}")
    public void iShouldSeeTheAuthorNameAs(String arg0) throws  Throwable{

    }

    @Then("I should see the author names")
    public void iShouldSeeTheAuthorNames() {
        BDDStyleMethod.ContainsAnyCollection();
    }

    @Then("I should verify Get parameter")
    public void iShouldVerifyGetParameter() {
        BDDStyleMethod.PerformPathParameter();
    }

    @Then("I should verify query parameter")
    public void iShouldVerifyQueryParameter() {
        BDDStyleMethod.PerformQueryParameter();
    }
}