package com.epam.training.volodymyr_bilan.api.test;

import com.epam.training.volodymyr_bilan.api.constants.UrlAndEndpoints;
import com.epam.training.volodymyr_bilan.api.specification.Specifications;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;

public class JsonPlaceHolderUserApiTests {

    @Test
    public void testStatusCodeIs200() {
        Specifications.installSpecification(
                Specifications.requestSpecification(UrlAndEndpoints.BASE_URL),
                Specifications.responseSpecificationStatusOk200()
        );
        given()
                .when()
                .get(UrlAndEndpoints.GET_USERS);
    }

    @Test
    public void testResponseHeader() {
        Specifications.installSpecification(
                Specifications.requestSpecification(UrlAndEndpoints.BASE_URL),
                Specifications.responseSpecificationHeaderContentType()
        );
        given()
                .when()
                .get(UrlAndEndpoints.GET_USERS);
    }

    @Test
    public void testResponseBody() {
        Specifications.installSpecification(
                Specifications.requestSpecification(UrlAndEndpoints.BASE_URL)
        );
        given()
                .when()
                .get(UrlAndEndpoints.GET_USERS)
                .then()
                .assertThat()
                .body("$", hasSize(10));
    }
}
