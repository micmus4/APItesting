public abstract class MagicAPITest
{
    private static final String API_URL = "https://api.magicthegathering.io";

    private static final String API_VERSION = "v1";

    private static final String CARD_API = "cards";

    public final String getCardApiEndpoint()
    {
        return API_URL + "/" + API_VERSION + "/" + CARD_API;
    }
}
