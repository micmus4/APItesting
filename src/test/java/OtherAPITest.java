import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.regex.Matcher;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

/**
 * TODO: Describe this class (The first line - until the first dot - will interpret as the brief description).
 */
public class OtherAPITest implements MagicAPITest
{
    /**
     * Test to check whether endpoint address is correct.
     */
    @Test( timeout = TIMEOUT_VALUE )
    public void checkWhetherTypesEndpointIsCorrect()
    {
        given()
                .when().get( getTypesApiEndpoint() )
                .then()
                .assertThat().statusCode( HttpStatus.SC_OK ).contentType( ContentType.JSON )
                .body( "types", notNullValue() );
    }

    /**
     * Test to check whether endpoint address is correct.
     */
    @Test( timeout = TIMEOUT_VALUE )
    public void checkWhetherSubtypesEndpointIsCorrect()
    {
        given()
                .when().get( getSubtypesApiEndpoint() )
                .then()
                .assertThat().statusCode( HttpStatus.SC_OK ).contentType( ContentType.JSON )
                .body( "subtypes", notNullValue() );
    }

    /**
     * Test to check whether endpoint address is correct.
     */
    @Test( timeout = TIMEOUT_VALUE )
    public void checkWhetherSupertypesEndpointIsCorrect()
    {
        given()
                .when().get( getSupertypesApiEndpoint() )
                .then()
                .assertThat().statusCode( HttpStatus.SC_OK ).contentType( ContentType.JSON )
                .body( "supertypes", notNullValue() );
    }

    /**
     * Test to check whether endpoint address is correct.
     */
    @Test( timeout = TIMEOUT_VALUE )
    public void checkWhetherFormatsEndpointIsCorrect()
    {
        given()
                .when().get( getFormatsApiEndpoint() )
                .then()
                .assertThat().statusCode( HttpStatus.SC_OK ).contentType( ContentType.JSON )
                .body( "formats", notNullValue() );
    }
}
