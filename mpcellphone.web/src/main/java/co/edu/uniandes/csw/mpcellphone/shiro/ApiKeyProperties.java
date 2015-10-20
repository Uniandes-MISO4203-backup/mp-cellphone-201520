package co.edu.uniandes.csw.mpcellphone.shiro;

import java.util.Properties;

public class ApiKeyProperties extends Properties {

    public ApiKeyProperties() {
        super.put("apiKey.id", System.getenv("STORMPATH_API_KEY_ID"));
        super.put("apiKey.secret", System.getenv("STORMPATH_API_KEY_SECRET"));
    }
}
