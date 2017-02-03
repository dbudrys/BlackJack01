package com.dustin_domas_assignment.blackjack01;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class PlayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
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

        //New game buttons
        Button hit;
        findViewById(R.id.hit_button).setOnClickListener(new HitListener());
        Button bet25;
        findViewById(R.id.twentyFive_button).setOnClickListener(new BetListener());
        Button bet50;
        findViewById(R.id.fifty_button).setOnClickListener(new BetListener());
        Button bet100;
        findViewById(R.id.hundred_button).setOnClickListener(new BetListener());
        Button Fold;
        findViewById(R.id.hold_button).setOnClickListener(new HoldListener());
        Button Exit;
        findViewById(R.id.exit_button).setOnClickListener(new ExitListener());
        Button about;
        findViewById(R.id.exit_button).setOnClickListener(new AboutListener());
        //findViewById(R.id.sound_button).setOnClickListener(new StartListener());





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

    class AboutListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            /*if(){


            }*/
        }
    }

}
