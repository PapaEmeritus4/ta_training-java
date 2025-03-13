package com.epam.training.volodymyr_bilan.api.specification;

import com.epam.training.volodymyr_bilan.api.constants.ResponseConstants;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specifications {
    public static RequestSpecification requestSpecification(String url) {
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .build();
    }

    public static ResponseSpecification responseSpecificationStatusOk200() {
        return new ResponseSpecBuilder()
                .expectStatusCode(ResponseConstants.STATUS_OK)
                .build();
    }

    public static ResponseSpecification responseSpecificationHeaderContentType() {
        return new ResponseSpecBuilder()
                .expectHeader(ResponseConstants.CONTENT_TYPE_HEADER_NAME, ResponseConstants.CONTENT_TYPE_VALUE)
                .build();
    }

    public static void installSpecification(RequestSpecification request) {
        RestAssured.requestSpecification = request;
    }

    public static void installSpecification(RequestSpecification request, ResponseSpecification response) {
        RestAssured.requestSpecification = request;
        RestAssured.responseSpecification = response;
    }
}
