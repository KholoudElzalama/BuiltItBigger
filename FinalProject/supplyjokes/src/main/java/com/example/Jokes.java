
package com.example;

import com.example.win.myapplication.backend.jokeApi.JokeApi;
import com.example.win.myapplication.backend.jokeApi.model.Joke;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;



public class  Jokes {


    public Jokes() {

    }

    public String tellJoke() {
          JokeApi jokeApiService = null;
        Joke temp = new Joke();
        if(jokeApiService == null) {  // Only do this once
            JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            jokeApiService = builder.build();
        }


        try {
            long id = 1;
            String joke = jokeApiService.get(id).execute().getJoke();

            return joke;
        } catch (IOException e) {
            return e.getMessage();

        }

    }












}
