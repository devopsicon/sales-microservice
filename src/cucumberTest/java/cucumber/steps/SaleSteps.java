package cucumber.steps;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;

public class SaleSteps {
    private static String URL_string = "https://devopsicon-sales-staging.herokuapp.com/";
    private static String PATH = "sales/";
    private String sale_save_json;

    @Before
    public void beforeScenario() {
        StringBuilder result = new StringBuilder("");

        //Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("sale-save.json").getFile());

        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        sale_save_json = result.toString();
    }

    @When("^users create a new sale entry$")
    public void usersCreateANewSaleEntry() throws Exception {
        //Then has all logic
    }

    @Then("^the server should handle it and return a success status$")
    public void theServerShouldHandleItAndReturnASuccessStatus() throws Exception {
        given()
                .header("Content-Type", "application/json")
                .body(sale_save_json).
                when()
                .post(URL_string+PATH).
                then()
                .statusCode(200);
    }

    @When("^users want to get information on a particular sale entry$")
    public void usersWantToGetInformationOnAParticularSaleEntry() throws Exception {
        //Then contains all logic
    }

    @Then("^the requested data about sale entry is returned$")
    public void theRequestedDataAboutSaleEntryIsReturned() throws Exception {
        ValidatableResponse response = given().when().get(URL_string+PATH+"1").
                then();
        response.statusCode(200);
        response.body("amount", is(new Float(1500.0)));
    }

    @When("^users want to get information on all sales entries$")
    public void usersWantToGetInformationOnAllSalesEntries() throws Exception {
        //Then has all the logic
    }

    @Then("^the requested data about all sale entries are returned$")
    public void theRequestedDataAboutAllSaleEntriesAreReturned() throws Exception {
        ValidatableResponse response = given().when().get(URL_string+PATH).
                then();
        response.statusCode(200);
        assertThat(response.extract().jsonPath().getList("$").size(), greaterThan(0));    }
}
