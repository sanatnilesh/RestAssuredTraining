package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import utilities.RestAssuredExtension;
import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;


public class GetPostSteps{

    private  static ResponseOptions<Response> response;
    @Given("I perform GET operation for {string}")
    public void iPerformGETOperationFor(String url) throws  Throwable{
        response = RestAssuredExtension.getOps(url);
    }

    @Then("I should see the author name as {string}")
    public void iShouldSeeTheAuthorNameAs(String authorName) throws  Throwable{
        assertThat(response.getBody().jsonPath().get("author"), hasItem("typicode"));
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