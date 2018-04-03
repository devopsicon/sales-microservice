package performance;


import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

@RunWith(JUnitPlatform.class)
public class PerformanceTests {
    private static String URL_string = "https://devopsicon-sales-staging.herokuapp.com/";
    private static String PATH = "sales/";

    @RepeatedTest(10)
    public void testPrep() {
        ValidatableResponse response = given().when().get(URL_string+PATH).
                then();
        response.time(lessThan(3000L));
    }
}
