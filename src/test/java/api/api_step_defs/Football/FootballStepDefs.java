package api.api_step_defs.Football;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import utils.Constants;

import java.util.List;
import java.util.Map;

public class FootballStepDefs {

    Response response;
    @Given("I have football competition endpoint")
    public void i_have_football_competition_endpoint() {

        RestAssured.baseURI="http://api.football-data.org/";
        RestAssured.basePath="v2/competitions/";
    }

    @When("I send GET request to retrieve list of competitons")
    public void i_send_get_request_to_retrieve_list_of_competitons() {
        response= RestAssured.given().accept(Constants.APPLICATION_JSON)
            .when().get();
    }


    @Then("Then status code should be {int}")
    public void statusCodeValidation(int expectedStatusCode) {
        int actualStatusCode=response.statusCode();
        Assert.assertEquals(actualStatusCode,expectedStatusCode);
    }

    @Then("competitions list must be more then {int}")
    public void competitions_list_must_be_more_then(int sizeOfCompetitionList) {

       List<Map<String,Object>>competitions = response.jsonPath().getList("competitions");
       Assert.assertTrue(competitions.size()>sizeOfCompetitionList);
    }
}
