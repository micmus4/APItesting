import org.apache.http.HttpStatus;
import org.junit.Ignore;
import org.junit.Test;

import java.time.Duration;
import java.util.Collections;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

/**
 * Tests regarding Cards.
 */
public class CardAPITest extends MagicAPITest
{
    private static final long TIMEOUT_VALUE = 30 * 1000; // 30 seconds to millis.

    @Test( timeout = TIMEOUT_VALUE )
    @Ignore
    public void test()
    {
                given()
                .when().get( getCardApiEndpoint() )
                .then().log().all();
    }

    /**
     * Test to check whether endpoint address is correct.
     */
    @Test( timeout = TIMEOUT_VALUE )
    public void checkWhetherEndpointIsCorrect()
    {
        given()
                .when().get( getCardApiEndpoint() )
                .then()
                .assertThat().statusCode( HttpStatus.SC_OK );
    }

    /**
     * Test to check whether Card API can filter cards by query param 'name'.
     */
    @Test( timeout = TIMEOUT_VALUE )
    public void checkCardFilteringByName()
    {
        final String nameFilter = "Archangel Avacyn // Avacyn, the Purifier";

        given().queryParam( "name", nameFilter )
                .when().get( getCardApiEndpoint() )
                .then().assertThat()
                .statusCode( HttpStatus.SC_OK )
                .body( "cards.name", everyItem( equalTo( nameFilter ) ) );

    }

    /**
     * Test to check whether Card API can filter by query param 'layout'.
     */
    @Test( timeout = TIMEOUT_VALUE )
    public void checkCardFilteringByLayout()
    {
        final String layoutFilter = "normal";

        given().queryParam( "layout", layoutFilter )
                .when().get( getCardApiEndpoint() )
                .then().assertThat()
                .statusCode( HttpStatus.SC_OK )
                .body( "cards.layout", everyItem( equalTo( layoutFilter ) ) );
    }

    /**
     * Test to check whether Card API can filter by query param 'cmc'.
     */
    @Test( timeout = TIMEOUT_VALUE )
    public void checkCardFilteringByConvertedManaCost()
    {
        final int cmcFilter = 7;

        given().queryParam( "cmc", cmcFilter )
                .when().get( getCardApiEndpoint() )
                .then().assertThat()
                .statusCode( HttpStatus.SC_OK )
                .body( "cards.cmc", everyItem( equalTo( (float)cmcFilter ) ) );
    }

    /**
     * Test to check whether Card API can filter by query param 'colors'.
     */
    @Test( timeout = TIMEOUT_VALUE )
    public void checkCardFilteringByColors()
    {
        final String colorFilter = "W";

        given().queryParam( "colors", colorFilter )
                .when().get( getCardApiEndpoint() )
                .then().assertThat()
                .statusCode( HttpStatus.SC_OK )
                .body( "cards.colors", hasItems( Collections.singletonList( colorFilter ) ) );
    }

    /**
     * Test to check whether Card API can filter by query param 'color identity'.
     */
    @Test( timeout = TIMEOUT_VALUE )
    public void checkCardFilteringByColorIdentity()
    {
        final String colorIdentityFilter = "W";

        given().queryParam( "colorIdentity", colorIdentityFilter )
                .when().get( getCardApiEndpoint() )
                .then().assertThat()
                .statusCode( HttpStatus.SC_OK )
                .body( "cards.colorIdentity", hasItems( Collections.singletonList( colorIdentityFilter ) ) );
    }

    /**
     * Test to check whether Card API can filter by query param 'type'.
     */
    @Test( timeout = TIMEOUT_VALUE )
    public void checkCardFilteringByType()
    {
        final String typeFilter = "Creature";

        given().queryParam( "type", typeFilter )
                .when().get( getCardApiEndpoint() )
                .then().assertThat()
                .statusCode( HttpStatus.SC_OK )
                .body( "cards.type", everyItem( containsString( typeFilter ) ) );
    }

    /**
     * Test to check whether Card API can filter by query param 'supertypes'.
     */
    @Test( timeout = TIMEOUT_VALUE )
    public void checkCardFilteringBySuperTypes()
    {
        final String superTypesFilter = "Legendary";

        given().queryParam( "supertypes", superTypesFilter )
                .when().get( getCardApiEndpoint() )
                .then().assertThat()
                .statusCode( HttpStatus.SC_OK )
                .body( "cards.supertypes", hasItems( Collections.singletonList( superTypesFilter ) ) );
    }

    /**
     * Test to check whether Card API can filter by query param 'types'.
     */
    @Test( timeout = TIMEOUT_VALUE )
    public void checkCardFilteringByTypes()
    {
        final String typesFilter = "Creature";

        given().queryParam( "types", typesFilter )
                .when().get( getCardApiEndpoint() )
                .then().assertThat()
                .statusCode( HttpStatus.SC_OK )
                .body( "cards.types", hasItems( Collections.singletonList( typesFilter ) ) );
    }

    /**
     * Test to check whether Card API can filter by query param 'rarity'.
     */
    @Test( timeout = TIMEOUT_VALUE )
    public void checkCardFilteringByRarity()
    {
        final String rarityFilter = "Mythic Rare";

        given().queryParam( "rarity", rarityFilter )
                .when().get( getCardApiEndpoint() )
                .then().assertThat()
                .statusCode( HttpStatus.SC_OK )
                .body( "cards.rarity", everyItem( containsString( rarityFilter ) ) );
    }

    /**
     * Test to check whether Card API can filter by query param 'set'.
     */
    @Test( timeout = TIMEOUT_VALUE )
    public void checkCardFilteringBySet()
    {
        final String setFilter = "10E";

        given().queryParam( "set", setFilter )
                .when().get( getCardApiEndpoint() )
                .then().assertThat()
                .statusCode( HttpStatus.SC_OK )
                .body( "cards.set", everyItem( containsString( setFilter ) ) );
    }

    /**
     * Test to check whether Card API can filter by query param 'setName'.
     */
    @Test( timeout = TIMEOUT_VALUE )
    public void checkCardFilteringBySetName()
    {
        final String setNameFilter = "Tenth Edition";

        given().queryParam( "setName", setNameFilter )
                .when().get( getCardApiEndpoint() )
                .then().assertThat()
                .statusCode( HttpStatus.SC_OK )
                .body( "cards.setName", everyItem( containsString( setNameFilter ) ) );
    }

    /**
     * Test to check whether Card API can filter by query param 'text'.
     */
    @Test( timeout = TIMEOUT_VALUE )
    public void checkCardFilteringByText()
    {
        final String textFilter = "Tenth Edition";

        given().queryParam( "text", textFilter )
                .when().get( getCardApiEndpoint() )
                .then().assertThat()
                .statusCode( HttpStatus.SC_OK )
                .body( "cards.text", everyItem( containsString( textFilter ) ) );
    }

    /**
     * Test to check whether Card API can filter by query param 'flavor'.
     */
    @Test( timeout = TIMEOUT_VALUE )
    public void checkCardFilteringByFlavor()
    {
        final String flavorFilter = "Every tear shed is a drop of immortality.";

        given().queryParam( "flavor", flavorFilter )
                .when().get( getCardApiEndpoint() )
                .then().assertThat()
                .statusCode( HttpStatus.SC_OK )
                .body( "cards.flavor", everyItem( containsString( flavorFilter ) ) );
    }

    /**
     * Test to check whether Card API can filter by query param 'number'.
     */
    @Test( timeout = TIMEOUT_VALUE )
    public void checkCardFilteringByNumber()
    {
        final String numberFilter = "2";

        given().queryParam( "number", numberFilter )
                .when().get( getCardApiEndpoint() )
                .then().assertThat()
                .statusCode( HttpStatus.SC_OK )
                .body( "cards.number", everyItem( equalTo( numberFilter ) ) );
    }

    /**
     * Test to check whether Card API can filter by query param 'artist'.
     */
    @Test( timeout = TIMEOUT_VALUE )
    public void checkCardFilteringByArtist()
    {
        final String artistFilter = "Volkan Baǵa";

        given().queryParam( "artist", artistFilter )
                .when().get( getCardApiEndpoint() )
                .then().assertThat()
                .statusCode( HttpStatus.SC_OK )
                .body( "cards.artist", everyItem( equalTo( artistFilter ) ) );
    }
}
