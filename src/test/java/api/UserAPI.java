package api;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

    public class UserAPI {

        public static Response getUser(int userId) {
            return given()
                    .header("x-api-key", "free_user_3D1s0B57Is5k1eq9VopZUrg3eRh")
                    .baseUri("https://reqres.in")
                    .when()
                    .get("/api/users/" + userId)
                    .then()
                    .extract().response();
        }
    }

