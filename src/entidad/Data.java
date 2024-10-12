package entidad;

import centro.Todas_monedas;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import service.Consumir_Api;

import java.lang.reflect.Type;
import java.util.Map;

public class Data {

    private final Consumir_Api api;

    public Data(String apiKey) {
        this.api = new Consumir_Api(apiKey);
    }

    public Map<String, Double> getMonedas(String baseCurrency) throws Exception {
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();

        Todas_monedas todas_monedas = gson.fromJson(api.getRequest(baseCurrency), Todas_monedas.class);

        Type type = new TypeToken<Map<String, Double>>(){}.getType();
        Map<String, Double> map = gson.fromJson(todas_monedas.conversion_rates().toString(), type);

        return map;
    }
}
