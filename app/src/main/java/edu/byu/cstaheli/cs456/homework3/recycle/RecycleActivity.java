package edu.byu.cstaheli.cs456.homework3.recycle;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import edu.byu.cstaheli.cs456.homework3.R;
import edu.byu.cstaheli.cs456.homework3.main.MainActivity;
import edu.byu.cstaheli.cs456.homework3.recycle.convert.EnglishNumberToWords;

public class RecycleActivity extends AppCompatActivity
{
    private static final String TAG = "RECYCLE";
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        recyclerView = (RecyclerView) findViewById(R.id.activity_recycle);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new RecycleViewAdapter(createDataset());
        recyclerView.setAdapter(adapter);
    }

    private String[] createDataset()
    {
        String[] dataset = new String[1000];
        for (int i = 0; i < 1000; ++i)
        {
            dataset[i] = EnglishNumberToWords.convert(i + 1);
        }
        return dataset;
    }

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
