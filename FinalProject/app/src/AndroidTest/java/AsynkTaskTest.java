import android.os.AsyncTask;
import android.test.AndroidTestCase;

import com.example.Jokes;

/**
 * Created by win on 11/05/2017.
 */

public class AsynkTaskTest extends AndroidTestCase {
    String joke;
    EndpointsAsyncTask asyncTask;


    @Override
    protected void setUp() throws Exception {
        super.setUp();
        asyncTask =new EndpointsAsyncTask();
    }

    public class EndpointsAsyncTask extends AsyncTask<Void,Void, String> {

        @Override
        protected String doInBackground(Void... voids) {

            Jokes jokes = new Jokes();
            String joke = jokes.tellJoke();
            return joke;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            joke = s;
            assertNotNull(joke);
        }
    }

}
