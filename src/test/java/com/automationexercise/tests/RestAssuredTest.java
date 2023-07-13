package com.automationexercise.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

class RestAssuredTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://reqres.in/api";
    }

    @Test
    void testeCriarUsuario() {
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body("{\"name\": \"morpheus\", \"job\": \"leader\"}")
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .body("name", equalTo("morpheus"))
                .body("job", equalTo("leader"))
                .body(matchesJsonSchemaInClasspath("create-user-schema.json"))
                .extract()
                .response();
        System.out.println(response.getBody().asString());
    }

    @Test
    void testeConsultarUsuario() {
        Response response = RestAssured.given()
                .when()
                .get("/users/2")
                .then()
                .statusCode(200)
                .body("data.id", equalTo(2))
                .body("data.email", equalTo("janet.weaver@reqres.in"))
                .body("data.first_name", equalTo("Janet"))
                .body("data.last_name", equalTo("Weaver"))
                .body("data.avatar", equalTo("https://reqres.in/img/faces/2-image.jpg"))
                .body("support.url", equalTo("https://reqres.in/#support-heading"))
                .body("support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"))
                .body(matchesJsonSchemaInClasspath("get-user-schema.json"))
                .extract()
                .response();
        System.out.println(response.getBody().asString());
    }

    @Test
    void testeConsultarListaUsuarios() {
        Response response = RestAssured.given()
                .when()
                .get("/users?page=2")
                .then()
                .statusCode(200)
                .body("data[0].id", equalTo(7))
                .body("data[0].email", equalTo("michael.lawson@reqres.in"))
                .body("data[0].first_name", equalTo("Michael"))
                .body("data[0].last_name", equalTo("Lawson"))
                .body("data[0].avatar", equalTo("https://reqres.in/img/faces/7-image.jpg"))
                .body(matchesJsonSchemaInClasspath("get-user-list-schema.json"))
                .extract()
                .response();
        System.out.println(response.getBody().asString());
    }
    @Test
    void testeAtualizarUsuario() {
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body("{\"name\": \"morpheus\", \"job\": \"zion resident\"}")
                .when()
                .patch("/users/2")
                .then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("patch-user-schema.json"))
                .body("name", equalTo("morpheus"))
                .body("job", equalTo("zion resident"))
                .extract()
                .response();
        System.out.println(response.getBody().asString());
    }


}
