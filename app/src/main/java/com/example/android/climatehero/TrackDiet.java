package com.example.android.climatehero;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class TrackDiet extends AppCompatActivity {
    private int dietScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_diet);


    }

    public void vegan(View view) {
        dietScore = 2;

    }

    public void vegetarian(View view) {
        dietScore = 1;

    }

    public void omnivore(View view) {
        dietScore = 0;

    }

    public void meat(View view) {
        dietScore = -1;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_save_or_delete, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_save:
                Toast.makeText(this, "Back to home screen", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
                return true;
            case R.id.menu_delete:
                Toast.makeText(this, "Diet deleted", Toast.LENGTH_SHORT).show();
                dietScore = 0;
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void trackNext(View view) {

        Score s = new Score(dietScore, "Food Efficiency", R.drawable.spinach);
        Intent data = new Intent();
        data.putExtra(Keys.SCORE, s);
        setResult(RESULT_OK, data);
        finish();

    }
}
