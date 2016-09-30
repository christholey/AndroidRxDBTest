package fr.ctholey.rxjavamvpexample.ws;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;

import javax.inject.Inject;

import fr.ctholey.rxjavamvpexample.models.Joke;
import fr.ctholey.rxjavamvpexample.ws.interfaces.ICaller;
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

    private OkHttpClient mClient;
    private Gson mGson;

    @Inject
    public OkHttpCaller(OkHttpClient httpClient, Gson gson) {
        this.mClient = httpClient;
        this.mGson = gson;
    }


    public void triggerRequestAsync(String url, Callback responseCallback){
        Request request = new Request.Builder()
                .url(url)
                .build();

        mClient.newCall(request).enqueue(responseCallback);
    }

    public Response triggerRequestSync(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        return mClient.newCall(request).execute();
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
        result = mGson.fromJson(jsonObject.get(key).toString(), type);

        return result;
    }

}
