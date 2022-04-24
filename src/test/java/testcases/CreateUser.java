package testcases;

import io.restassured.RestAssured;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CreateUser {

    @BeforeTest
    public void setUp(){
        RestAssured.baseURI = "https://reqres.in/";
    }

    @Test
    public void createSingleUser(){
        JSONObject request = new JSONObject();
        request.put("name", "abhi");
        request.put("org", "google");
        System.out.println(request.toString());
        given().header("Content-Type", "application/json").
                body(request.toJSONString()).when().post("api/users").then().statusCode(201).log().all().assertThat().body("name", equalTo("kc"));
    }


    @Test
    public void createSingleUserUsingFile(){
        JSONObject request = new JSONObject();
        File jsonDataInFile = new File("src/test/java/data.json");

        System.out.println(request.toString());
        given().header("Content-Type", "application/json").
                body(jsonDataInFile).when().post("api/users").then().statusCode(201).log().all().assertThat().body("name", equalTo("abhi"));
    }


}
