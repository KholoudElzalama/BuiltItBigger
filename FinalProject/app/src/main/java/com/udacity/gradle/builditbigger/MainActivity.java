package com.udacity.gradle.builditbigger;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.Jokes;
import com.example.android.displayjoke.JokeActivity;


public class MainActivity extends AppCompatActivity {

    public static String joke;
    ProgressDialog progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {

        progress= new ProgressDialog(this);
        progress.setMessage(getString(R.string.progress_dialoge_msg));
        progress.show();

        //execute asynk task
        new EndpointsAsyncTask().execute();
    }
    public class EndpointsAsyncTask extends AsyncTask<Void,Void, String> {

        @Override
        protected String doInBackground(Void... voids) {

            Jokes jokes = new Jokes();
            String joke = jokes.tellJoke();
            return joke;
        }


        @Override
        protected void onPostExecute(String result) {
          MainActivity.joke = result;
            // make intent to android lib
            Intent intent = new Intent(MainActivity.this,JokeActivity.class);
            //put joke(result of asynk task) as an extra
            intent.putExtra(JokeActivity.joke_key,result);
            progress.dismiss();
            startActivity(intent);
        }


    }

}
