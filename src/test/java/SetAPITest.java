import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

/**
 * Tests regarding Sets.
 */
public class SetAPITest implements MagicAPITest
{
    /**
     * Test to check whether endpoint address is correct.
     */
    @Test( timeout = TIMEOUT_VALUE )
    public void checkWhetherEndpointIsCorrect()
    {
        given()
                .when().get( getSetsApiEndpoint() )
                .then()
                .assertThat().statusCode( HttpStatus.SC_OK ).contentType( ContentType.JSON )
                .body( "sets", notNullValue() );
    }

    /**
     * Test to check whether Sets API can filter cards by query param 'name'.
     */
    @Test( timeout = TIMEOUT_VALUE )
    public void checkSetsFilteringByName()
    {
        final String nameFilter = "Khans of Tarkir";

        given().queryParam( "name", nameFilter )
                .when().get( getSetsApiEndpoint() )
                .then().assertThat()
                .statusCode( HttpStatus.SC_OK ).contentType( ContentType.JSON )
                .body( "sets.name", everyItem( containsString( nameFilter ) ) );
    }

    /**
     * Test to check whether Sets API can filter cards by query param 'block'.
     */
    @Test( timeout = TIMEOUT_VALUE )
    public void checkSetsFilteringByBlock()
    {
        final String nameFilter = "Khans of Tarkir";

        given().queryParam( "block", nameFilter )
                .when().get( getSetsApiEndpoint() )
                .then().assertThat()
                .statusCode( HttpStatus.SC_OK ).contentType( ContentType.JSON )
                .body( "sets.block", everyItem( containsString( nameFilter ) ) );
    }

    /**
     * Test to check whether set can be fetched by code.
     */
    @Test( timeout = TIMEOUT_VALUE )
    public void checkFetchingCardByCode()
    {
        final String code = "10E";

        given().when().get( getSetsApiEndpoint() + "/" + code )
                .then().assertThat()
                .statusCode( HttpStatus.SC_OK ).contentType( ContentType.JSON )
                .body( "set.code", is( code ) );
    }

    /**
     * Test to check whether we will get 404 when code does not match any set.
     */
    @Test( timeout = TIMEOUT_VALUE )
    public void shouldFailWhenFetchingByNonExistableCode()
    {
        final String code = "nonExistableCode";

        given().when().get( getSetsApiEndpoint() + "/" + code )
                .then().assertThat()
                .statusCode( HttpStatus.SC_NOT_FOUND ).contentType( ContentType.JSON );
    }

    /**
     * Test to check whether we can retrieve cards from existing set.
     */
    @Test( timeout = TIMEOUT_VALUE )
    public void checkFetchingCardsFromSet()
    {
        final String code = "10E";

        given().when().get( getSetsApiEndpoint() + "/" + code + "/booster" )
                .then().assertThat()
                .statusCode( HttpStatus.SC_OK ).contentType( ContentType.JSON );
    }
}
