package assured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class Test1 {

	public static void main(String[] args) {
		
		RestAssured.baseURI="http://216.10.245.166";
		
		Response res=given().
		body("{"+

"\"name\":\"Learn Appium Automation with Java\","+
"\"isbn\":\"bcd\","+
"\"aisle\":\"8024445556\","+
"\"author\":\"John foe\"}").
		when().
		post("Library/Addbook.php").
		then().assertThat().contentType(ContentType.JSON).and().statusCode(200).extract().response();
		
		String stringresp=res.asString();
		System.out.println(stringresp);
		JsonPath js=new JsonPath(stringresp);
		
		System.out.println(js);

	}

}
