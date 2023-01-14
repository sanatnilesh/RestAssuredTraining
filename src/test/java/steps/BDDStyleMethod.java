package steps;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;

public class BDDStyleMethod {

    public  static void GetPostSteps(String postNumber){
        given()
                .contentType(ContentType.JSON)
        .when()
                .get(String.format("http://localhost:3000/posts/%s",postNumber))
        .then()
                .body("author", is("sanat"));
    }

    public  static  void  ContainsAnyCollection(){
        given()
                .contentType(ContentType.JSON)
                .when()
                .get(String.format("http://localhost:3000/posts/"))
                .then()
                .body("author", containsInAnyOrder("sanat", "sanat", "typicode")).statusCode(200);
    }

}
