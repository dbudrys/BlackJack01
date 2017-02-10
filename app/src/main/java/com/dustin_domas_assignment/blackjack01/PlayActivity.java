package com.dustin_domas_assignment.blackjack01;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class PlayActivity extends AppCompatActivity {

    private int [] getCard = {
            R.drawable.aceofclubs,
            R.drawable.aceofdiamonds,
            R.drawable.aceofhearts,
            R.drawable.aceofspades,
            R.drawable.eightofclubs,
            R.drawable.eightofdiamonds,
            R.drawable.eightofhearts,
            R.drawable.eightofspades,
            R.drawable.fiveofclubs,
            R.drawable.fiveofdiamonds,
            R.drawable.fiveofhearts,
            R.drawable.fiveofspades,
            R.drawable.fourofclubs,
            R.drawable.fourofdiamonds,
            R.drawable.fourofhearts,
            R.drawable.fourofspades,
            R.drawable.jackofclubs,
            R.drawable.jackofdiamonds,
            R.drawable.jackofhearts,
            R.drawable.jackofspades,
            R.drawable.kingofclubs,
            R.drawable.kingofdiamonds,
            R.drawable.kingofhearts,
            R.drawable.kingofspades,
            R.drawable.nineofclubs,
            R.drawable.nineofdiamonds,
            R.drawable.nineofhearts,
            R.drawable.nineofspades,
            R.drawable.queenofdiamonds,
            R.drawable.queenofhearts,
            R.drawable.queenofspades,
            R.drawable.quessofclubs,

            R.drawable.sevenofcluns,
            R.drawable.sevenofdiamonds,
            R.drawable.sevenofhearts,
            R.drawable.sevenofspades,
            R.drawable.sixofclubs,
            R.drawable.sixofdiamonds,
            R.drawable.sixofhearts,
            R.drawable.sixofspades,
            R.drawable.tenofclubs,
            R.drawable.tenofdiamonds,
            R.drawable.tenofhearts,
            R.drawable.tenofspades,
            R.drawable.threeofclubs,
            R.drawable.threeofdiamonds,
            R.drawable.threeofhearts,
            R.drawable.threeofspades,
            R.drawable.twoofclubs,
            R.drawable.twoofdiamonds,
            R.drawable.twoofhearts,
            R.drawable.twoofclubs,
            R.drawable.twoofspades };

    int [] number =
            {11,11,11,11,
                    8,8,8,8,
                    5,5,5,5,
                    4,4,4,4,
                    10,10,10,10,
                    10,10,10,10,
                    9,9,9,9,
                    10,10,10,10,
                    7,7,7,7,
                    6,6,6,6,
                    10,10,10,10,
                    3,3,3,3,
                    2,2,2,2};


    ImageView  playerCard1;
    ImageView  playerCard2;
    ImageView  playerCard3;
    ImageView  playerCard4;
    ImageView  playerCard5;

    ImageView dealerCard1;
    ImageView dealerCard2;
    ImageView dealerCard3;
    ImageView dealerCard4;
    ImageView dealerCard5;

    TextView betAmount;
    TextView cashAmount;

    private int randomArrayIndex;
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

        findViewById(R.id.twentyFive_button).setOnClickListener(new BetListener());
        Button bet50_button;
        findViewById(R.id.fifty_button).setOnClickListener(new BetListener());
        Button bet100_button;
        findViewById(R.id.hundred_button).setOnClickListener(new BetListener());
        Button hold_button;
        findViewById(R.id.hold_button).setOnClickListener(new HoldListener());
        Button exit_button;
        findViewById(R.id.exit_button).setOnClickListener(new ExitListener());

       // findViewById(R.id.Play_button).setOnClickListener(new PlayListener());


        cashAmount = (TextView ) findViewById(R.id.Player_CashView);
        betAmount = (TextView) findViewById(R.id.player_bet_amount);


        //findViewById(R.id.sound_button).setOnClickListener(new StartListener());

        //setting the player cards to an ImageView
        playerCard1 = (ImageView) findViewById(R.id.Card_1_P1);
        playerCard2 = (ImageView) findViewById(R.id.Card2_P);
        playerCard3 = (ImageView) findViewById(R.id.Card3_P);
        playerCard4 = (ImageView) findViewById(R.id.Card4_P);
        playerCard5 = (ImageView) findViewById(R.id.Card5_P);
        //setting dealer cards to an ImageView
        dealerCard1 = (ImageView) findViewById(R.id.Card1_D);
        dealerCard2 = (ImageView) findViewById(R.id.Card2_D);
        dealerCard3 = (ImageView) findViewById(R.id.Card3_D);
        dealerCard4 = (ImageView) findViewById(R.id.Card4_D);
        dealerCard5 = (ImageView) findViewById(R.id.Card5_D);



        playerCard1.setImageResource(R.drawable.facedown);
        playerCard2.setImageResource(R.drawable.facedown);
        playerCard3.setImageResource(R.drawable.facedown);
        playerCard4.setImageResource(R.drawable.facedown);
        playerCard5.setImageResource(R.drawable.facedown);
        //set dealer board
        dealerCard1.setImageResource(R.drawable.facedown);
        dealerCard2.setImageResource(R.drawable.facedown);
        dealerCard3.setImageResource(R.drawable.facedown);
        dealerCard4.setImageResource(R.drawable.facedown);
        dealerCard5.setImageResource(R.drawable.facedown);
    }

    class PlayListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            intializeGameBoard();

            /*if(){


            }*/
        }
    }
/********************************************

            IntializeGameBoard Function
********************************************
 */
    protected void intializeGameBoard(){

       // View play_bt = findViewById(R.id.Play_button);
        //play_bt.setVisibility(View.GONE);
        int sum = 0;



        Random rand = new Random();
        randomArrayIndex = rand.nextInt(getCard.length);

        //if() {
            playerCard1.setImageResource(getCard[randomArrayIndex]);
            sum+= number[randomArrayIndex];
        randomArrayIndex = rand.nextInt(getCard.length);
            playerCard2.setImageResource(getCard[randomArrayIndex]);
            sum += number[randomArrayIndex];


        cashAmount.setText(""+sum);
        //}



       // Toast.makeText(getApplicationContext(), "Your bet has been placed", Toast.LENGTH_SHORT).show();


        //startGame();

    }

    //game is ready for bets etc
    protected void startGame(){



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
    // new bet Views
            View bet25 = findViewById(R.id.twentyFive_button);
            View bet50 = findViewById(R.id.fifty_button);
            View bet100 = findViewById(R.id.hundred_button);


            if(v.getId() == bet25.getId()){
                betAmount.setText("25");
            } else if (v.getId() == bet50.getId()){
                betAmount.setText("50");
            }
            else if(v.getId() == bet100.getId()){
                betAmount.setText("100");
            }


                intializeGameBoard();






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

            Intent intent = new Intent(getApplicationContext(),
                    MainActivity.class); //Explicit intent

            startActivity(intent);
            /*if(){


            }*/
        }
    }



}
