package com.dustin_domas_assignment.blackjack01;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class PlayActivity extends AppCompatActivity {

    private int [] getCard = {

    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        /*
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

       */

        //New game buttons
        Button hit_button = new Button(this);
        findViewById(R.id.hit_button).setOnClickListener(new HitListener());
        Button bet25_button;
        findViewById(R.id.twentyFive_button).setOnClickListener(new BetListener());
        Button bet50_button;
        findViewById(R.id.fifty_button).setOnClickListener(new BetListener());
        Button bet100_button;
        findViewById(R.id.hundred_button).setOnClickListener(new BetListener());
        Button hold_button;
        findViewById(R.id.hold_button).setOnClickListener(new HoldListener());
        Button exit_button;
        findViewById(R.id.exit_button).setOnClickListener(new ExitListener());

        findViewById(R.id.Play_button).setOnClickListener(new PlayListener());


        //findViewById(R.id.sound_button).setOnClickListener(new StartListener());





    }

    class PlayListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            intializeGameBoard();

            /*if(){


            }*/
        }
    }

    protected void intializeGameBoard(){

        View play_bt = findViewById(R.id.Play_button);
        play_bt.setVisibility(View.GONE);



    }
    //listeners to game buttons
    class HitListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            /*if(){


            }*/
        }
    }

    class BetListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            /*if(){


            }*/
        }
    }

    class HoldListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            /*if(){


            }*/
        }
    }

    class ExitListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            /*if(){


            }*/
        }
    }



}
