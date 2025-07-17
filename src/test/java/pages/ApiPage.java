package pages;

import helper.Endpoint;
import helper.Utility;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;

import java.io.File;
import java.util.List;

import static helper.Models.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ApiPage {

    String setURL, global_id;
    Response res;

    public void prepareUrl(String url) {
        switch (url) {
            case "GET_LIST_USERS":
                setURL = Endpoint.GET_LIST_USERS;
                break;
            case "CREATE_NEW_USER":
                setURL = Endpoint.CREATE_NEW_USER;
                break;
            case "DELETE_USER":
                setURL = Endpoint.DELETE_USER;
                break;
            case "UPDATE_USER":
                setURL = Endpoint.UPDATE_USER;
                break;
            default:
                System.out.println("URL NOT FOUND");
        }
//        System.out.println("Set URL To : " + setURL);
    }

    public void hitApiGetListUsers() {
        res = getListUser(setURL);
//        System.out.println(res.body().asString());
    }

    public void hitApiGetSingleUsers() {
        res = getSingleUser(setURL);
//        System.out.println(res.body().asString());
    }

    public void hitApiCreateNewUser() {
        res = postCreateUser(setURL);
//        System.out.println(res.body().asString());
    }

    public void hitApiDeleteUser(){
        res = deleteUser(setURL,global_id);
    }

    public void hitApiUpdateUser(){
        res = updateUser(setURL,global_id);
//        System.out.println(res.body().asString());
    }

    public void validationStatusCodeIsEquals(int status_code) {
        assertThat(res.statusCode()).isEqualTo(status_code);
    }

    public void validationResponseBodyGetListUsers() {
        List<Object> id = res.jsonPath().getList("data.id");
        List<Object> firstName = res.jsonPath().getList("data.firstName");
        List<Object> lastName = res.jsonPath().getList("data.lastName");
        List<Object> title = res.jsonPath().getList("data.title");
        List<Object> picture = res.jsonPath().getList("data.picture");

        assertThat(id.get(0)).isNotNull();
        assertThat(firstName.get(0)).isNotNull();
        assertThat(lastName.get(0)).isNotNull();
        assertThat(title.get(0)).isNotNull();
        assertThat(picture.get(0)).isNotNull();
    }

    public void validationResponseBodyGetListSingleUsers() {
        JsonPath jsonPath = res.jsonPath();

        String id = jsonPath.getString("id");
        String title = jsonPath.getString("title");
        String firstName = jsonPath.getString("firstName");
        String lastName = jsonPath.getString("lastName");
        String picture = jsonPath.getString("picture");
        String gender = jsonPath.getString("gender");
        String email = jsonPath.getString("email");
        String dateOfBirth = jsonPath.getString("dateOfBirth");
        String phone = jsonPath.getString("phone");
        String registerDate = jsonPath.getString("registerDate");
        String updatedDate = jsonPath.getString("updatedDate");

        String street = jsonPath.getString("location.street");
        String city = jsonPath.getString("location.city");
        String state = jsonPath.getString("location.state");
        String country = jsonPath.getString("location.country");
        String timezone = jsonPath.getString("location.timezone");

        assertThat(id).isNotNull();
        assertThat(title).isIn("mr", "ms", "mrs"); // contoh title
        assertThat(firstName).isNotNull();
        assertThat(lastName).isNotNull();
        assertThat(picture).startsWith("https://");
        assertThat(gender).isIn("male", "female");
        assertThat(email).contains("@");
        assertThat(dateOfBirth).isNotNull();
        assertThat(phone).isNotNull();
        assertThat(registerDate).isNotNull();
        assertThat(updatedDate).isNotNull();

        assertThat(street).isNotNull();
        assertThat(city).isNotNull();
        assertThat(state).isNotNull();
        assertThat(country).isNotNull();
        assertThat(timezone).isNotNull();
    }

    public void validationResponseBodyCreateNewUser() {
        JsonPath jsonPathEvaluator = res.jsonPath();

        String id = jsonPathEvaluator.get("id");
        String firstName = jsonPathEvaluator.get("firstName");
        String lastName = jsonPathEvaluator.get("lastName");
        String email = jsonPathEvaluator.get("email");
        String registerDate = jsonPathEvaluator.get("registerDate");
        String updatedDate = jsonPathEvaluator.get("updatedDate");

        Assertions.assertThat(id).isNotNull();
        Assertions.assertThat(firstName).isNotNull();
        Assertions.assertThat(lastName).isNotNull();
        Assertions.assertThat(email).isNotNull();
        Assertions.assertThat(registerDate).isNotNull();
        Assertions.assertThat(updatedDate).isNotNull();

        global_id = id;
    }

    public void validationResponseBodyUpdateUser() {
        JsonPath jsonPathEvaluator = res.jsonPath();

        String id = jsonPathEvaluator.get("id");
        String firstName = jsonPathEvaluator.get("firstName");
        String lastName = jsonPathEvaluator.get("lastName");
        String email = jsonPathEvaluator.get("email");
        String registerDate = jsonPathEvaluator.get("registerDate");
        String updatedDate = jsonPathEvaluator.get("updatedDate");

        Assertions.assertThat(id).isNotNull();
        Assertions.assertThat(firstName).isNotNull();
        Assertions.assertThat(lastName).isNotNull();
        Assertions.assertThat(email).isNotNull();
        Assertions.assertThat(registerDate).isNotNull();
        Assertions.assertThat(updatedDate).isNotNull();

        global_id = id;
    }

    public void validationResponseJsonWithJSONSchema(String Filename) {
        File JSONFile = Utility.getJSONSchemaFile(Filename);
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONFile));
    }

}
