package utilities;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class RestAssuredExtension {

    public static RequestSpecification request;

    public RestAssuredExtension() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("http://localhost:3000/");
        requestSpecBuilder.setContentType(ContentType.JSON);
        var requestspec = requestSpecBuilder.build();
        request = RestAssured.given().spec(requestspec);
    }

    public static void getOpsWithPathPara(String url, Map<String, String> pathParams) throws URISyntaxException {
        request.pathParams(pathParams);
        request.get(new URI(url));
    }

    public static ResponseOptions<Response> getOps(String url) {
        try{
            return request.get(new URI(url));
        }catch (URISyntaxException e){
            e.printStackTrace();
        }
        return null;
    }
}
