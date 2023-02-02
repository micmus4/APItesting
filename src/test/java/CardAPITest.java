import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Collections;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Tests regarding Cards.
 */
public class CardAPITest implements MagicAPITest
{
    /**
     * Test to check whether endpoint address is correct.
     */
    @Test( timeout = TIMEOUT_VALUE )
    public void checkWhetherEndpointIsCorrect()
    {
        given()
                .when().get( getCardApiEndpoint() )
                .then()
                .assertThat().statusCode( HttpStatus.SC_OK ).contentType( ContentType.JSON )
                .body( "cards", notNullValue() );
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
                .statusCode( HttpStatus.SC_OK ).contentType( ContentType.JSON )
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
                .statusCode( HttpStatus.SC_OK ).contentType( ContentType.JSON )
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
                .statusCode( HttpStatus.SC_OK ).contentType( ContentType.JSON )
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
                .statusCode( HttpStatus.SC_OK ).contentType( ContentType.JSON )
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
                .statusCode( HttpStatus.SC_OK ).contentType( ContentType.JSON )
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
                .statusCode( HttpStatus.SC_OK ).contentType( ContentType.JSON )
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
                .statusCode( HttpStatus.SC_OK ).contentType( ContentType.JSON )
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
                .statusCode( HttpStatus.SC_OK ).contentType( ContentType.JSON )
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
                .statusCode( HttpStatus.SC_OK ).contentType( ContentType.JSON )
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
                .statusCode( HttpStatus.SC_OK ).contentType( ContentType.JSON )
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
                .statusCode( HttpStatus.SC_OK ).contentType( ContentType.JSON )
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
                .statusCode( HttpStatus.SC_OK ).contentType( ContentType.JSON )
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
                .statusCode( HttpStatus.SC_OK ).contentType( ContentType.JSON )
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
                .statusCode( HttpStatus.SC_OK ).contentType( ContentType.JSON )
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
                .statusCode( HttpStatus.SC_OK ).contentType( ContentType.JSON )
                .body( "cards.artist", everyItem( equalTo( artistFilter ) ) );
    }

    /**
     * Test to check whether Card API can filter by query param 'power'.
     */
    @Test( timeout = TIMEOUT_VALUE )
    public void checkCardFilteringByPower()
    {
        final String powerFilter = "4";

        given().queryParam( "power", powerFilter )
                .when().get( getCardApiEndpoint() )
                .then().assertThat()
                .statusCode( HttpStatus.SC_OK ).contentType( ContentType.JSON )
                .body( "cards.power", everyItem( equalTo( powerFilter ) ) );
    }

    /**
     * Test to check whether Card API can filter by query param 'toughness'.
     */
    @Test( timeout = TIMEOUT_VALUE )
    public void checkCardFilteringByToughness()
    {
        final String toughnessFilter = "4";

        given().queryParam( "toughness", toughnessFilter )
                .when().get( getCardApiEndpoint() )
                .then().assertThat()
                .statusCode( HttpStatus.SC_OK ).contentType( ContentType.JSON )
                .body( "cards.toughness", everyItem( equalTo( toughnessFilter ) ) );
    }

    /**
     * Test to check whether Card API can filter by query param 'language'.
     */
    @Test( timeout = TIMEOUT_VALUE )
    public void checkCardFilteringByLanguage()
    {
        final String languageFilter = "French";

        given().queryParam( "language", languageFilter )
                .when().get( getCardApiEndpoint() )
                .then().assertThat()
                .statusCode( HttpStatus.SC_OK ).contentType( ContentType.JSON )
                .body( "cards.foreignNames.language", everyItem( hasItem( languageFilter ) ) );
    }

    /**
     * Test to check whether Card API can filter by query param 'legality'.
     */
    @Test( timeout = TIMEOUT_VALUE )
    public void checkCardFilteringByLegality()
    {
        final String legalityFilter = "Legal";

        given().queryParam( "legality", legalityFilter )
                .when().get( getCardApiEndpoint() )
                .then().assertThat()
                .statusCode( HttpStatus.SC_OK ).contentType( ContentType.JSON )
                .body( "cards.legalities.legality", everyItem( hasItem( legalityFilter ) ) );
    }

    /**
     * Test to check whether Card API can filter by query param 'gameFormat'.
     */
    @Test( timeout = TIMEOUT_VALUE )
    public void checkCardFilteringByGameFormat()
    {
        final String gameFormatFilter = "Duel";

        given().queryParam( "legality", gameFormatFilter )
                .when().get( getCardApiEndpoint() )
                .then().assertThat()
                .statusCode( HttpStatus.SC_OK ).contentType( ContentType.JSON )
                .body( "cards.legalities.format", everyItem( hasItem( gameFormatFilter ) ) );
    }

    /**
     * Test to check whether Card API can apply page to response.
     */
    @Test( timeout = TIMEOUT_VALUE )
    public void checkApplyingPageToRequest()
    {
        final int page = 1;

        given().queryParam( "page", page )
                .when().get( getCardApiEndpoint() )
                .then().assertThat()
                .statusCode( HttpStatus.SC_OK ).contentType( ContentType.JSON );
    }

    /**
     * Test to check whether negative page value is considered as bad request.
     */
    @Test( timeout = TIMEOUT_VALUE )
    @APIVulnerability( reason = "Page number must not be negative." )
    public void pageNumberMustNotBeNegative()
    {
        int page = -99999999;

        given().queryParam( "page", page )
                .when().get( getCardApiEndpoint() )
                .then().assertThat()
                .statusCode( HttpStatus.SC_BAD_REQUEST );
    }

    /**
     * Test to check whether Card API can filter by query param 'page'.
     */
    @Test( timeout = TIMEOUT_VALUE )
    public void checkApplyingPageSizeToRequest()
    {
        final int pageSize = 50;

        given().queryParam( "pageSize", pageSize )
                .when().get( getCardApiEndpoint() )
                .then().assertThat()
                .statusCode( HttpStatus.SC_OK ).contentType( ContentType.JSON );
    }

    /**
     * Test to check if page size extending its max value will result in bad request.
     */
    @Test( timeout = TIMEOUT_VALUE )
    @APIVulnerability( reason = "Page size should not be exceed its maximum value." )
    public void pageSizeShouldNotExceedItsMaximumValue()
    {
        final int pageSize = 500; // max is 100

        given().queryParam( "pageSize", pageSize )
                .when().get( getCardApiEndpoint() )
                .then().assertThat()
                .statusCode( HttpStatus.SC_BAD_REQUEST );
    }

    /**
     * Test to check if page size being negative will result in bad request.
     */
    @Test( timeout = TIMEOUT_VALUE )
    @APIVulnerability( reason = "Page size should not be negative." )
    public void pageSizeShouldNotBeNegative()
    {
        final int pageSize = -999; // max is 100

        given().queryParam( "pageSize", pageSize )
                .when().get( getCardApiEndpoint() )
                .then().assertThat()
                .statusCode( HttpStatus.SC_BAD_REQUEST );
    }

    /**
     * Test to check whether Card API can be grouped by a property.
     */
    @Test( timeout = TIMEOUT_VALUE )
    @APIVulnerability( reason = "Ordering by field end with server error." )
    public void checkApplyingOrderByToRequest()
    {
        final String orderByProperty = "cards.name";

        given().queryParam( "orderBy", orderByProperty )
                .when().get( getCardApiEndpoint() )
                .then().assertThat().statusCode( HttpStatus.SC_OK ).contentType( ContentType.JSON );
    }

    /**
     * Test to check whether Card API can be randomly fetched.
     */
    @Test( timeout = TIMEOUT_VALUE )
    public void checkFetchingRandomNumberOfCards()
    {
        given().queryParam( "random" )
                .when().get( getCardApiEndpoint() )
                .then().assertThat().statusCode( HttpStatus.SC_OK ).contentType( ContentType.JSON );
    }

    /**
     * Test to check whether Card API can be randomly fetched.
     */
    @Test( timeout = TIMEOUT_VALUE )
    public void checkWhetherContainFilterWorksWhenPropertyExists()
    {
        given().queryParam( "contains", "name" )
                .when().get( getCardApiEndpoint() )
                .then().assertThat().statusCode( HttpStatus.SC_OK ).contentType( ContentType.JSON );

        assertNotEquals( "{\"cards\":[]}", given().queryParam( "contains", "name" )
                .when().get( getCardApiEndpoint() ).getBody().toString() );
    }

    /**
     * Test to check whether Card API can be randomly fetched.
     */
    @Test( timeout = TIMEOUT_VALUE )
    public void checkWhetherContainFilterWorksWhenPropertyDoesNotExists()
    {
        given().queryParam( "contains", "rweqwaeage" )
                .when().get( getCardApiEndpoint() )
                .then().assertThat().statusCode( HttpStatus.SC_OK ).contentType( ContentType.JSON );

        assertEquals( "{\"cards\":[]}", given().queryParam( "contains", "rweqwaeage" )
                .when().get( getCardApiEndpoint() ).getBody().print() );
    }

    /**
     * Test to check whether Card API can filter by query param 'id'.
     */
    @Test( timeout = TIMEOUT_VALUE )
    public void checkCardFilteringById()
    {
        final String gameFormatFilter = "ecf2b08e-7eca-5f13-a9f7-7a915ee259f5";

        given().queryParam( "id", gameFormatFilter )
                .when().get( getCardApiEndpoint() )
                .then().assertThat()
                .statusCode( HttpStatus.SC_OK ).contentType( ContentType.JSON )
                .body( "cards.id", everyItem( equalTo( gameFormatFilter ) ) );
    }

    /**
     * Test to check whether Card API can filter by query param 'multiverseid'.
     */
    @Test( timeout = TIMEOUT_VALUE )
    public void checkCardFilteringByMultiverseId()
    {
        final String multiverseIdFilter = "130385";

        given().queryParam( "multiverseid", multiverseIdFilter )
                .when().get( getCardApiEndpoint() )
                .then().assertThat()
                .statusCode( HttpStatus.SC_OK ).contentType( ContentType.JSON )
                .body( "cards.multiverseid", everyItem( equalTo( multiverseIdFilter ) ) );
    }

    /**
     * Test to check whether card can be fetched by id.
     */
    @Test( timeout = TIMEOUT_VALUE )
    public void checkFetchingCardById()
    {
        final String id = "5f8287b1-5bb6-5f4c-ad17-316a40d5bb0c";

        given().when().get( getCardApiEndpoint() + "/" + id )
                .then().assertThat()
                .statusCode( HttpStatus.SC_OK ).contentType( ContentType.JSON )
                .body( "card.id", is( id ) );
    }

    /**
     * Test to check whether card can be fetched by multiverseid.
     */
    @Test( timeout = TIMEOUT_VALUE )
    public void checkFetchingCardByMutilverseId()
    {
        final String multiverseId = "130550";

        given().when().get( getCardApiEndpoint() + "/" + multiverseId )
                .then().assertThat()
                .statusCode( HttpStatus.SC_OK ).contentType( ContentType.JSON )
                .body( "card.multiverseid", is( multiverseId ) );
    }

    /**
     * Test to check whether we will get 404 when id does not match any card.
     */
    @Test( timeout = TIMEOUT_VALUE )
    public void shouldFailWhenFetchingByNonExistableId()
    {
        final String multiverseId = "nonExistableId";

        given().when().get( getCardApiEndpoint() + "/" + multiverseId )
                .then().assertThat()
                .statusCode( HttpStatus.SC_NOT_FOUND ).contentType( ContentType.JSON );
    }

}
