package edu.byu.cstaheli.cs456.homework3.main;

import android.content.Intent;
import android.graphics.Point;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import edu.byu.cstaheli.cs456.homework3.R;
import edu.byu.cstaheli.cs456.homework3.main.view.SnowManView;
import edu.byu.cstaheli.cs456.homework3.recycle.RecycleActivity;

public class MainActivity extends AppCompatActivity
{
    private static final String TAG = "MAIN";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SnowManView view = (SnowManView) findViewById(R.id.snowman_view);
        view.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                SnowManView localSnowMan = (SnowManView) v;
                Log.d(TAG, "Clicked Snowman view");
                localSnowMan.setOffset(new Point(10, 10));
                localSnowMan.invalidate();
            }
        });
    }

    // Menu icons are inflated just as they were with actionbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        Intent intent;
        switch (item.getItemId())
        {
            case R.id.action_snowman:
                // User chose the "Settings" item, show the app settings UI...
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                Log.d(TAG, "Snowman MenuItem clicked");
                return true;

            case R.id.action_recycle:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                intent = new Intent(this, RecycleActivity.class);
                startActivity(intent);
                Log.d(TAG, "Recycle MenuItem clicked");
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    private void toast(CharSequence message)
    {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT)
                .show();
    }

    private Snackbar snackBar(CharSequence message)
    {
        return Snackbar.make(findViewById(R.id.coordinator_layout), message, Snackbar.LENGTH_SHORT);
    }
}
