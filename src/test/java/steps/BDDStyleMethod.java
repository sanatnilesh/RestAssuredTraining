package steps;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

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

    public static void PerformPathParameter() {
        given()
                .contentType(ContentType.JSON)
                .with()
                .pathParam("posts", "3")
                .when()
                .get("http://localhost:3000/posts/{posts}")
                .then()
                .body("author",containsStringIgnoringCase("sanat"));
    }

    public static void PerformQueryParameter() {
        given()
                .contentType(ContentType.JSON)
                .with()
                .queryParam("id", 3)
                .when()
                .get("http://localhost:3000/posts/")
                .then()
                .body("author", hasItem("sanat"));
    }
}
