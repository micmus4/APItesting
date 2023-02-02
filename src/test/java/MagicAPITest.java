public interface MagicAPITest
{
    String API_URL = "https://api.magicthegathering.io";

    String API_VERSION = "v1";

    String CARD_API = "cards";

    String SETS_API = "sets";

    String TYPES_API = "types";

    String SUBTYPES_API = "subtypes";

    String SUPERTYPES_API = "supertypes";

    String FORMATS_API = "formats";


    long TIMEOUT_VALUE = 30 * 1000L; // 30 seconds to millis.

    default String getCardApiEndpoint()
    {
        return API_URL + "/" + API_VERSION + "/" + CARD_API;
    }

    default String getSetsApiEndpoint()
    {
        return API_URL + "/" + API_VERSION + "/" + SETS_API;
    }

    default String getTypesApiEndpoint()
    {
        return API_URL + "/" + API_VERSION + "/" + TYPES_API;
    }

    default String getSubtypesApiEndpoint()
    {
        return API_URL + "/" + API_VERSION + "/" + SUBTYPES_API;
    }

    default String getSupertypesApiEndpoint()
    {
        return API_URL + "/" + API_VERSION + "/" + SUPERTYPES_API;
    }

    default String getFormatsApiEndpoint()
    {
        return API_URL + "/" + API_VERSION + "/" + FORMATS_API;
    }
}
