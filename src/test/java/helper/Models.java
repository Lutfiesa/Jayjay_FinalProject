package helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import static helper.Utility.generateRandomEmail;

public class Models {

    private static RequestSpecification request;

    public static void setupHeaders() {
        request = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("app-id", "63a804408eb0cb069b57e43a");
    }

    public static Response getListUser(String endpoint) {
        setupHeaders();
        return request.when().get(endpoint);
    }

    public static Response getSingleUser(String endpoint) {
        setupHeaders();
        return request.when().get(endpoint + "/" + "60d0fe4f5311236168a109d3");
    }

    public static Response deleteUser(String endpoint, String user_id) {
        setupHeaders();
        String finalEndpoint = endpoint + "/" + user_id;
        return request.when().delete(finalEndpoint);
    }

    public static Response updateUser(String endpoint, String user_id) {
        String firstName = "Lutfi pp";
        String lastName = "Esa pp";
        JSONObject payload = new JSONObject();
        payload.put("firstName", firstName);
        payload.put("lastName", lastName);

        setupHeaders();
        String finalEndpoint = endpoint + "/" + user_id;
        return request.body(payload.toString()).when().put(finalEndpoint);
    }

    public static Response postCreateUser(String endpoint) {
        String firstName = "Lutfi Esa P";
        String lastName = "male";
        String email = generateRandomEmail();

        JSONObject payload = new JSONObject();
        payload.put("firstName", firstName);
        payload.put("lastName", lastName);
        payload.put("email", email);

        setupHeaders();
        return request.body(payload.toString()).when().post(endpoint);
    }

}
