package api.get;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameOfThrones {

    @Test
    public void snowHouse() {

        RestAssured.baseURI = "https://api.got.show";
        RestAssured.basePath = "api/show/characters";

        Response response = RestAssured.given().header("Accept", "application/json")
                .when().get()
                .then()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .extract().response();

        List<Map<String, Object>> charactersList = response.as(
                new TypeRef<List<Map<String, Object>>>() {
                });

        for (int i = 0; i < charactersList.size(); i++) {

            Map<String, Object> characterMap = charactersList.get(i);
            String characterName = String.valueOf(characterMap.get("name"));
            String characterName2 = "" + characterMap.get("name");
            if (characterName.equals("Jon Snow")) {
                System.out.println("Character name: " + characterName);
                System.out.println("Character name2: " + characterName2);
                System.out.println(characterMap.get("house"));
            }

        }
    }

    @Test
    public void characterToHouseMappingTest(){
        RestAssured.baseURI = "https://api.got.show";
        RestAssured.basePath = "api/show/characters";

        Response response= RestAssured.given().header("Accept","application/json")
                .when().get()
                .then().statusCode(200).and()
                .contentType("application/json; charset=utf-8").extract().response();

        List<Map<String,Object>> gotCharacterList= response.as(new TypeRef<List<Map<String,Object>>>(){
        });

        Map<String,List<String>>charactersByHouse = new HashMap<>();


        for (Map<String,Object>characterMap: gotCharacterList
             ) {
            String tempName = String.valueOf(characterMap.get("name"));
            String tempHouse = String.valueOf(characterMap.get("house"));
            if(tempHouse.equals("null")){
                continue;
            }
            if(charactersByHouse.containsKey(tempHouse)){
                List<String>charactersNames = charactersByHouse.get(tempHouse);
                charactersNames.add(tempName);
                charactersByHouse.put(tempHouse,charactersNames);
            }else{
                List<String > newCharacterName= new ArrayList<>();
                newCharacterName.add(tempName);
                charactersByHouse.put(tempHouse, newCharacterName);
            }
        }
        System.out.println(charactersByHouse.keySet().size());
        System.out.println(charactersByHouse);
        System.out.println(charactersByHouse.get("House Stark"));
    }


}
