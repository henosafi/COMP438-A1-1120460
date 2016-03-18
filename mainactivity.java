package com.example.owners.guessrandnum;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class mainactivity extends AppCompatActivity {
    public int randomNumber;
    public EditText inputText;
    public Button checkB;
    public Button startAgain;
    Boolean flag = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainactivity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

       inputText = (EditText) findViewById(R.id.editText);
        Random R1 = new Random();
        randomNumber = R1.nextInt(1000);

        checkB = (Button) findViewById(R.id.button);
        startAgain = (Button) findViewById(R.id.button2);

        inputText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               inputText.setText("");



            }
        });

        checkB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int entered_number = Integer.parseInt(inputText.getText().toString());
                check(entered_number, randomNumber);


            }
        });

        startAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random R1 = new Random();
                randomNumber = R1.nextInt(1000);
                Message();

            }
        });


    }
    public void Message(){
        Toast.makeText(this, "The number is changed", Toast.LENGTH_LONG).show();
    }
    public void check(int enteredNum,int RandomNum){

        if (enteredNum == RandomNum) {
            Toast.makeText(this, "awesome,you guessed it :) ", Toast.LENGTH_LONG).show();

        }
        else if ((int) Math.abs(enteredNum - RandomNum) <= 5) {
            Toast.makeText(this, "very CLOSE ", Toast.LENGTH_LONG).show();
        }
        else if (RandomNum > enteredNum) {
            Toast.makeText(this, "The correct Number is Greater ", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "The correct Number is Smaller", Toast.LENGTH_LONG).show();
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mainactivity, menu);
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
}
