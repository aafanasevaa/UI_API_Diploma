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

public class ApiTests extends ApiTestData {

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
        assertEquals(email, data.getUser().getEmail());
    }

    @Test
    @DisplayName("LOGIN - SUCCESSFUL")
    void loginSuccessful() {
        given()
                .spec(requestSpec)
                .contentType(JSON)
                .body(loginData)
                .when()
                .post("/login")
                .then()
                .spec(responseSpec)
                .log().all()
                .body("token", is(expectedToken));
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
    @DisplayName("UPDATE")
    public void updateTest() {
        String response = RestAssured
                .given()
                .spec(requestSpec)
                .log().all()
                .contentType(JSON)
                .body(updateData)
                .when()
                .put("/users/2")
                .then()
                .spec(responseSpec)
                .log().all()
                .extract().response().path("name");
        assertThat(response.equals(expectedResponse));
    }
}
