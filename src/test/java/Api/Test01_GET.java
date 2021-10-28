package Api;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.response.Response;

public class Test01_GET {

	@Test
	void test1() {
		Response response = get("https://reqres.in/api/users?page=2");

		System.out.println(response.asString());
		System.err.println("_________________________________________________________________________________");
		System.out.println(response.getBody().asPrettyString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getTime());

		int status = response.getStatusCode();
		assertEquals(status, 200);

	}

	@Test
	void test2() {
		
	given().get("https://reqres.in/api/users?page=2").
		then().statusCode(200).body("data.id[1]", equalTo(8));

	}

}
