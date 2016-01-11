package kushabk.com.trialversionapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    private int totalCount;


    private Button bt;

    private Button mResetButton;

    private Button mUnlimited;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        prefs = getPreferences(Context.MODE_PRIVATE);
        editor = prefs.edit();
        totalCount = prefs.getInt("counter", 0);
        totalCount++;
        editor.putInt("counter", totalCount);
        editor.apply();


        bt = (Button) findViewById(R.id.button);
        mUnlimited = (Button) findViewById(R.id.button3);


        if (totalCount >= 5) {
            bt.setVisibility(View.INVISIBLE);

            Toast.makeText(getApplicationContext(), "red button feature is locked ", Toast.LENGTH_LONG).show();

            //Toast.makeText(getApplicationContext(), "trial version active", Toast.LENGTH_SHORT).show();

        }

        mResetButton = (Button) findViewById(R.id.button2);



       // Toast.makeText(getApplicationContext(), String.valueOf(totalCount), Toast.LENGTH_LONG).show();
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                totalCount = prefs.getInt("counter", 0);
                totalCount++;
                editor.putInt("counter", totalCount);
                editor.apply();
                // String c =String.valueOf(totalCount);
                Toast.makeText(getApplicationContext(), String.valueOf(totalCount), Toast.LENGTH_SHORT).show();


                if (totalCount >= 5) {
                    bt.setVisibility(View.INVISIBLE);

                    Toast.makeText(getApplicationContext(), "trial version active", Toast.LENGTH_SHORT).show();

                }
            }
        });


        mResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putInt("counter", 0);
                editor.apply();
                bt.setBackgroundColor(Color.RED);
                bt.setVisibility(View.VISIBLE);

            }
        });


        mUnlimited.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Unlimited", Toast.LENGTH_SHORT).show();


            }
        });






        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
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

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://kushabk.com.trialversionapp/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://kushabk.com.trialversionapp/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }


}
