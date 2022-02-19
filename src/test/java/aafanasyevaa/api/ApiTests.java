package aafanasyevaa.api;

import aafanasyevaa.api.lombok.LombokUserData;

import static aafanasyevaa.api.specs.Specs.requestSpec;
import static aafanasyevaa.api.specs.Specs.responseSpec;
import static io.restassured.http.ContentType.JSON;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.core.Is.is;

import io.restassured.RestAssured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static io.restassured.RestAssured.given;

public class ApiTests extends TestData {

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
        LombokUserData data =
                given()
                        .spec(requestSpec)
                        .when()
                        .get("/users/2")
                        .then()
                        .spec(responseSpec)
                        .log().all()
                        .extract().as(LombokUserData.class);
        assertEquals(expectedEmail, data.getUser().getEmail());
    }

    @Test
    @DisplayName("LIST USERS")
    void loginSuccessful() {
        given()
                .spec(requestSpec)
                .when()
                .get("/users?page=2")
                .then()
                .spec(responseSpec)
                .log().all()
                .body("page", is(2));
    }

    @Test
    @DisplayName("DELAYED RESPONSE")
    void delayedResponse() {
        ArrayList response = RestAssured
                .given()
                .spec(requestSpec)
                .contentType(JSON)
                .queryParams("delay", 3)
                .when()
                .get("users")
                .then()
                .spec(responseSpec)
                .log().all()
                .extract().response().path("data");
        assertThat(response.get(5)).toString().equals(responseData);
    }

    @Test
    @DisplayName("SINGLE <RESOURCE>")
    public void updateTest() {
        LombokUserData data =
                given()
                        .spec(requestSpec)
                        .log().all()
                        .when()
                        .get("/unknown/2")
                        .then()
                        .spec(responseSpec)
                        .log().all()
                        .extract().as(LombokUserData.class);
        assertEquals(data.getUser().getName(), expectedName);
    }
}
