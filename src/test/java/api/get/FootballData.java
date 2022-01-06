package api.get;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.checkerframework.checker.units.qual.A;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static utils.Constants.APPLICATION_JSON;


public class FootballData {

    @Test
    public void getapremierLeagueTest() {

        RestAssured.baseURI = "http://api.football-data.org";
        RestAssured.basePath = "/v2/competitions/";

        //get list of all competition
        Response response = RestAssured.given()
                .accept(APPLICATION_JSON)
                .header("X-Auth-Token\n" +
                        "\n", "c55b7a64e8424d46a52051bce36d1c0a")
                .when().get()
                .then().statusCode(200).contentType(APPLICATION_JSON)
                .extract().response();

        JsonPath jsonPath = response.jsonPath();
        List<Map<String, Object>> competitionList = jsonPath.getList("competitions");

        for (int i = 0; i < competitionList.size(); i++) {
            Map<String, Object> competitionMap = competitionList.get(i);
            if (competitionMap.get("name").equals("Premier Liga")) {
                int id = (int)competitionMap.get("id");
                Assert.assertEquals(id, 2035);
            }
        }


    }

    @Test
    public void getPremiumLeagueTest() {
        RestAssured.baseURI = "http://api.football-data.org";
        RestAssured.basePath = "/v2/competitions/";

        //get list of all competition
        Response response = RestAssured.given()
                .accept(APPLICATION_JSON)
                .header("X-Auth-Token\n" +
                        "\n", "c55b7a64e8424d46a52051bce36d1c0a")
                .when().get()
                .then().statusCode(200).contentType(APPLICATION_JSON)
                .body("competitions.find {it.name == 'Premier Liga'}.id", Matchers.equalTo(2035))
                .extract().response();

        int competitionId= response.path("competitions.find {it.name == 'Premier Liga'}.id") ;    // groovy function
        System.out.println(competitionId);
        Assert.assertEquals(competitionId,2035);

       int idNumber=  response.path("competition.find {it.plan =='TIER_FOUR'}.id");
        System.out.println(idNumber);
    }

}


//       Response response=  RestAssured.given()
//                .accept(APPLICATION_JSON)
//                .contentType(APPLICATION_JSON)
//                .when().get()
//                .then().statusCode(200)
//                .extract().response();
//
//        Map<String,Map<String,Object>>competitorInfo = response.as(new TypeRef<Map<String,Map<String,Object>>>() {
//       });
//
//        System.out.println(competitorInfo.get("Premier Liga"));


