package aafanasyevaa.api;

import aafanasyevaa.lombok.LombokUserData;

import static aafanasyevaa.specs.Specs.requestSpec;
import static aafanasyevaa.specs.Specs.responseSpec;
import static io.restassured.http.ContentType.JSON;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.core.Is.is;

import io.restassured.RestAssured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static io.restassured.RestAssured.given;

public class ApiTests {

    @Test
    @DisplayName("LIST <RESOURCE>")
    public void getResourceList() {
        given()
                .spec(requestSpec)
                .when()
                .get("/unknown")
                .then()
                .spec(responseSpec)
                .log().all()
                .body("data.findAll{it.id}.size", is(6));
    }

    @Test
    @DisplayName("SINGLE USER")
    public void SingleUserTest() {

        String email = "janet.weaver@reqres.in";

        LombokUserData data =
                given()
                        .spec(requestSpec)
                        .when()
                        .get("/users/2")
                        .then()
                        .spec(responseSpec)
                        .log().all()
                        .extract().as(LombokUserData.class);
        assertEquals(email, data.getUser().getEmail());
    }

    @Test
    @DisplayName("LOGIN - SUCCESSFUL")
    void loginSuccessful() {

        String data = "{\"email\": \"eve.holt@reqres.in\",\"password\": \"pistol\" }";
        given()
                .spec(requestSpec)
                .contentType(JSON)
                .body(data)
                .when()
                .post("/login")
                .then()
                .spec(responseSpec)
                .log().all()
                .body("token", is("QpwL5tke4Pnpja7X4"));
    }

    @Test
    @DisplayName("DELAYED RESPONSE")
    void delayedResponse() {

        String responseData = "{ \"id\": 6, \"email\": \"tracey.ramos@reqres.in\", \"first_name\": \"Tracey\", \"last_name\": \"Ramos\", \"avatar\": \"https://reqres.in/img/faces/6-image.jpg\" }";
        ArrayList response = RestAssured
                .given()
                .spec(requestSpec)
                .contentType(JSON)
                .queryParams("delay", 3)
                .when()
                .put("users")
                .then()
                .spec(responseSpec)
                .log().all()
                .extract().response().path("data");
        assertThat(response.get(5)).toString().equals(responseData);
    }

    @Test
    @DisplayName("UPDATE")
    public void updateTest() {

        String data = "{ \"name\": \"morpheus\", \"job\": \"zion resident\" }";
        String expectedResponse = "morpheus";
        String response = RestAssured
                .given()
                .spec(requestSpec)
                .log().all()
                .contentType(JSON)
                .body(data)
                .when()
                .put("/users/2")
                .then()
                .spec(responseSpec)
                .log().all()
                .extract().response().path("name");
        assertThat(response.equals(expectedResponse));
    }
}