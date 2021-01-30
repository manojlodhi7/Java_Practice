//import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.specification.SpecificationQuerier;
import javafx.application.Application;
import org.apache.http.client.methods.RequestBuilder;
import org.json.simple.JSONObject;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.Map;



public class RestAssuredTest {

    static RequestSpecification requestSpecification;
    static ResponseSpecification responseSpecification;

    @BeforeClass
    public static void createRequestSpec01(){
        requestSpecification = RestAssured
                .given()
                .port(8090) // Default value is 8080
                .baseUri("https://ifm.test.aw.actimize-afcm.cloud/ensService/ens/adhocrun")
                .basePath("/11ea2d67-7385-c750-9a4d-0242ac110002")
                .basePath("/Tuning_log")
                .contentType(ContentType.JSON);

//        Setting default requestSpecification if user does not specify while calling api
        RestAssured.requestSpecification = requestSpecification;

        // Querying RequestSpecification
        // Use query() method of SpecificationQuerier class to query
        QueryableRequestSpecification queryRequest = SpecificationQuerier.query(requestSpecification);
        String retrieveURI = queryRequest.getBaseUri();
        int retrievePORT = queryRequest.getPort();
        String retrieveBasePath = queryRequest.getBasePath();
        System.out.println("Base URI is : "+retrieveURI + " PORT is : " + retrievePORT +
                " and base path is : " + retrieveBasePath);
    }

    @BeforeClass
    public static void createRequestSpec02(){
        requestSpecification = new RequestSpecBuilder().setBaseUri("base uri")
                .setPort(8080)
                .setContentType(ContentType.JSON)
                .build();
    }

    @BeforeClass
    public static void createRequestSpec03(){
        requestSpecification = RestAssured
                .with()
                .port(8080)
                .baseUri("https://ifm.test.aw.actimize-afcm.cloud/ensService/ens/adhocrun")
                .basePath("/11ea2d67-7385-c750-9a4d-0242ac110002")
                .basePath("/Tuning_log")
                .contentType(ContentType.JSON);
    }

    @BeforeClass
    public static void createResponseSpec(){
        responseSpecification = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectStatusCode(200)
                .build();
    }


    @Test
    public void userRequest(){
        Response response = RestAssured
                .given()
                .spec(requestSpecification) // Set default/predefined request specifications
                .queryParam("param1", "value1")
                .pathParam("pathParam01", "pathValue01")// formParams
                .when()
                .get("/{pathParam01}");

//        OR

        /*
        Response response = RestAssured
                .given(requestSpecification)
                .queryParam("param1", "value1")
                .pathParam("pathParam01", "pathValue01")// formParams
                .when()
                .get("/{pathParam01}");
        * */
//        OR
        /*
        Response response = requestSpecification
                .queryParam("param1", "value1")
                .pathParam("pathParam01", "pathValue01")// formParams
                .when()
                .get("/{pathParam01}");
                */

                response.then().spec(responseSpecification); // Validate default/predefined response specifications
    }


    public static void get(){
        RestAssured.baseURI = "https://reqres.in/api/users?page=2";
        Response res = RestAssured
                .given()
                .log().all()
                .get();
        res.then()
                .log().all()
                .assertThat().statusCode(200).and().contentType(ContentType.JSON);
//        res.then().body("total", equalTo(12));
        System.out.println("Extract Practice");
        int total_pages001 = res.then().extract().path("total_pages");
        System.out.println("Extract Practice total_pages-->" + total_pages001);
        System.out.println("Extract Practice first_name-->" + res.then().extract().path("data[0].first_name"));

        System.out.println(res.jsonPath().prettify());
        JsonPath jsonPathEvaluator = res.jsonPath();
        String total_pages = jsonPathEvaluator.getString("total_pages");
        System.out.println("total_pages " + total_pages);

        System.out.println("getStatusCode " + res.getStatusCode());
        System.out.println("getBody " + res.getBody().jsonPath().prettify());
        /*Map<Object, Object> company = res.jsonPath().getMap("data");
        System.out.println(company.get("email"));*/

        /* *******OR****** Object OR String OR All Wrapper classes** */
        /*Map<String, String> company = res.jsonPath().getMap("data[0]");
        System.out.println(company.get("email"));*/

        /* *******OR******** */
        List<Map<Object, Object>> Data = jsonPathEvaluator.getList("data");
        System.out.println("City received from Response " + Data);
        for(int i = 0; i<Data.size(); i++){
            System.out.println(Data.get(i).get("email"));
            System.out.println(Data.get(i).get("id"));
        }
    }

    public static void post(){
        JSONObject inputBody = new JSONObject();
        inputBody.put("Name", "Lodhi");
        inputBody.put("job", "QA");
        inputBody.put("Salary", "100123");

        RestAssured.baseURI = "https://reqres.in/api/users";
        Response reso = RestAssured.given()
                .log().all()
                .header("Content-type", "application/json")
                .body(inputBody)
                .post();


        reso.then().assertThat().statusCode(201).and().contentType(ContentType.JSON);
//        reso.then().assertThat().body("201", equalTo("201"));
        System.out.println("getStatusCode " + reso.getStatusCode());
        System.out.println("getBody " + reso.getBody().jsonPath().prettify());

    }

//    OptionL Holiday

    /*Preemptive vs Challenged Basic Authentication
    There are two types of basic authentications - preemptive and "challenged basic authentication".

    Preemptive basic authentication sends the credentials even before the server ives an unauthorized
    response in certain situations, thus additional call is avoided.
    We normally prefer Preemptive basic authentication in most situations,
    unless we want to test the server’s ability to send back the challenge response.

    When using challenged basic authentication REST Assured will not supply the
    credentials unless the server has explicitly asked for it.
    This means that REST Assured will make an additional request to the server in order
    to be challenged and then follow up with the same request once more but this time setting the
    basic credentials in the header.*/

    public static void basicAuth(){
        RestAssured.baseURI = "";
//        send user id and a password encoded in Base64
        RestAssured.given()
                .auth()
                .basic("userName", "Password")
                .when()
                .get()
                .then()
                .assertThat()
                .statusCode(200);
    }

    public static void basicPreemptiveAuth(){
        RestAssured.baseURI = "";
//      With this in place, REST Assured will send the credentials without waiting for an Unauthorized response.
//      We hardly ever are interested in testing the server's ability to challenge.
//      Therefore, we can normally add this command to avoid complications and the overhead of making an additional request.
        RestAssured.given()
                .auth().preemptive()
                .basic("userName", "Password")
                .when()
                .get()
                .then()
                .assertThat()
                .statusCode(200);
    }

    public static void basicDigestAuth(){

        RestAssured.given()
                .auth()
                .digest("userName", "passWord")
                .when()
                .get("url");
    }
    public static void FormAuth(){
        Response resp1 = RestAssured.given()
                .auth()
                .form("userName", "passWord")
                .post();
    }

    public static void postOAuth1(){
        Response resp = RestAssured.given()
                .header("ContentType", "application/json")
                .auth()
                .oauth("consumer Key", "consumer Secret", "Access token", " Access secret token")
                .body("")
                .post("https://reqres.in/api/users");
    }

    public static void postOAuth2(){

        Response resp1 = RestAssured.given()
                .formParam("client_id", "Manoj")
                .formParam("client_secret", "secretCode")
                .formParam("grant_type ", "client_credentials")
                .post();
        String token = resp1.jsonPath().get("access_token");

//        OR
        /*
        String token = RestAssured.given().auth()
                .basic("userName", "Password")
                .when().post()
                .then().extract().path("access_token");
                */



        JSONObject body = new JSONObject();
        body.put("Name", "Lodhi");
        body.put("job", "QA");

        RestAssured.baseURI = "";
        Response resp = RestAssured.given()
                .header("Content-type", "application/json")
                .auth()
                .oauth2(token)
                .body(body)
                .post();

    }


    public static void main(String[] args) {
        get();
//        post();

        /*Response resp = RestAssured.given()
                .header("Content-type", "application/json")
                .get("https://root-location.dev.actimize-afcm.cloud/root-location/v1/649296/s3/AW_IFM/1");*/
//  Sample URL :       https://reqres.in/api/users?page=2

//        System.out.println(resp.getBody().jsonPath().prettify());
//
//        List<Map<Object, Object>> dataList = resp.jsonPath().getList("data");
//        int i = 0;
//        while(i<dataList.size()){
//            String url = dataList.get(i).get("avatar").toString();
//            Response linkResp = RestAssured.given()
//                    .get(url);
//            if(linkResp.getStatusCode() == 200) {
//                System.out.println("Working : " + url);
//                System.out.println("Body : " + linkResp.getHeaders());
//            }
//            i++;
//        }

    }

}
