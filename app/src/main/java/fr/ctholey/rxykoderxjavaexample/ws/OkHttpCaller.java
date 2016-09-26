package fr.ctholey.rxykoderxjavaexample.ws;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;

import javax.inject.Inject;

import fr.ctholey.rxykoderxjavaexample.models.Joke;
import fr.ctholey.rxykoderxjavaexample.ws.interfaces.ICaller;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import rx.Observable;

/**
 * Created by ctholey on 07/09/2016.
 */
public class OkHttpCaller implements ICaller{

    protected static final String CHUCK_JOKE_RANDOM = "http://api.icndb.com/jokes/random";

    private OkHttpClient client;

    @Inject
    Gson gson;

    public OkHttpCaller(OkHttpClient httpClient) {
        this.client = httpClient;
    }


    public void triggerRequestAsync(String url, Callback responseCallback){
        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(responseCallback);
    }

    public Response triggerRequestSync(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        return client.newCall(request).execute();
    }

    @Override
    public Observable<Joke> getChuckNorrisJokeRandom() {
        return Observable.create(subscriber -> {
            try {
                if (!subscriber.isUnsubscribed()){
                    Response response = triggerRequestSync(CHUCK_JOKE_RANDOM);
                    subscriber.onNext(getObjectFromJsonKey(response, "value", Joke.class));
                    subscriber.onCompleted();
                }
            } catch (IOException e) {
                subscriber.onError(e);
            }
        });

    }

    private <T> T getObjectFromJsonKey(Response response, String key, Class<T> type) throws IOException {

        final JsonParser jsonParser = new JsonParser();
        T result;

        JsonObject jsonObject = jsonParser.parse(response.body().string()).getAsJsonObject();
        result = gson.fromJson(jsonObject.get(key).toString(), type);

        return result;
    }

}
