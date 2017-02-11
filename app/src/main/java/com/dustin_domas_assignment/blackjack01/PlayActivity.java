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

    //Number array holds the values of the cards in the equivalent element as
    //to the card in the getCard array with its drawable ID
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
    TextView cardAmount;

    int bankAmount=0;
    int accumalatedBet;
    int hitCounter;
    int sum = 0;
    int playerCash = 500;
    private int randomArrayIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);


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
        cardAmount = (TextView) findViewById(R.id.card_total);

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


    /*****************************************************************
    *
    *       INTIALIZE GAMEBOARD
    *
    * **************************************************************/

    protected void intializeGameBoard(){

       // View play_bt = findViewById(R.id.Play_button);
        //play_bt.setVisibility(View.GONE);

        Random rand = new Random();
        randomArrayIndex = rand.nextInt(getCard.length);

        if(accumalatedBet == 26 || accumalatedBet == 51 || accumalatedBet == 101 ) {
            playerCard1.setImageResource(getCard[randomArrayIndex]);
            sum+= number[randomArrayIndex];

        randomArrayIndex = rand.nextInt(getCard.length);
            playerCard2.setImageResource(getCard[randomArrayIndex]);
            sum += number[randomArrayIndex];


        cardAmount.setText(""+sum);

            if(sum == 21){
                Toast.makeText(getApplicationContext(), "You win!!! $"+ betAmount,Toast.LENGTH_SHORT).show();
                playerCash += (accumalatedBet-1);
                cashAmount.setText(""+playerCash);
                resetGameboard();
            }
        }

        /*if (hitCounter<4){

        }
*/
        // Toast.makeText(getApplicationContext(), "Your bet has been placed", Toast.LENGTH_SHORT).show();
    }


    /*****************************************************
    *
     *              ResetGameBoard
    *
     *
    ******************************************************* */
    protected void resetGameboard(){


            accumalatedBet = 0;
            hitCounter = 0;
            sum = 0;

        cardAmount.setText(""+sum);

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

        Toast.makeText(getApplicationContext(),"Bet to start new hand", Toast.LENGTH_SHORT).show();

    }


    /*************************************************************
    *
    *               HIT LISTENER
    *
    * *********************************************************/
    class HitListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            Random rand = new Random();
            randomArrayIndex = rand.nextInt(getCard.length);

            hitCounter++;

            //First hit button if statement
            if (hitCounter ==1){
                //set player's 3rd card
                playerCard3.setImageResource(getCard[randomArrayIndex]);


                //if sum is greater than 11 and an ace comes out give it the value of one
                if(sum >= 11 && number[randomArrayIndex] == 11){
                        sum+=1;
                    cardAmount.setText(""+sum);

                    //21 ifstatement
                    if(sum == 21){
                        Toast.makeText(getApplicationContext(), "You win!!! $"+ ""+betAmount,Toast.LENGTH_SHORT).show();
                        playerCash += (accumalatedBet-1);
                        cashAmount.setText(""+playerCash);
                        onPause();
                        resetGameboard();
                    }
                     /* Bust Check if statement*/
                    if (sum > 21){
                        Toast.makeText(getApplicationContext(),"You BUSTED!!!!!!!!!!", Toast.LENGTH_SHORT).show();
                        playerCash -= (accumalatedBet-1);
                        cashAmount.setText(""+playerCash);
                        resetGameboard();
                    }//end Bust check

                } else {
                    sum += number[randomArrayIndex];
                    cardAmount.setText(""+sum);
                    //21 check if statement
                    if(sum == 21){
                        Toast.makeText(getApplicationContext(), "You win!!! $"+ betAmount,Toast.LENGTH_SHORT).show();
                        playerCash += (accumalatedBet-1);
                        cashAmount.setText(""+playerCash);
                        resetGameboard();
                    }else if (sum > 21){
                        Toast.makeText(getApplicationContext(),"You BUSTED!!!!!!!!!!", Toast.LENGTH_SHORT).show();
                        playerCash -= (accumalatedBet-1);
                        cashAmount.setText(""+playerCash);
                        resetGameboard();
                    }//end Bust check



                    }//end of first hit button if statement

                //second hit button if statement
            } else  if (hitCounter ==2){
                playerCard4.setImageResource(getCard[randomArrayIndex]);



                if(sum >= 11 && number[randomArrayIndex] == 11){
                    sum+=1;
                    cardAmount.setText(""+sum);

                    //21 if statement
                    if(sum == 21){
                        Toast.makeText(getApplicationContext(), "You win!!! $"+ betAmount,Toast.LENGTH_SHORT).show();
                        playerCash += (accumalatedBet-1);
                        cashAmount.setText(""+playerCash);

                        //intializeGameBoard();
                        resetGameboard();

                    } else
                    /* Bust Check if statement*/
                    if (sum > 21){
                        Toast.makeText(getApplicationContext(),"You BUSTED!!!!!!!!!!", Toast.LENGTH_SHORT).show();
                        playerCash -= (accumalatedBet-1);
                        cashAmount.setText(""+playerCash);
                        resetGameboard();
                    }//end Bust check


                } else {
                    sum += number[randomArrayIndex];
                    cardAmount.setText(""+sum);
                        //added the if statement to the else
                    if(sum == 21){
                        Toast.makeText(getApplicationContext(), "You win!!! $"+ betAmount,Toast.LENGTH_SHORT).show();
                        playerCash += (accumalatedBet-1);
                        cashAmount.setText(""+playerCash);
                        resetGameboard();
                    }else if (sum > 21){
                        Toast.makeText(getApplicationContext(),"You BUSTED!!!!!!!!!!", Toast.LENGTH_SHORT).show();
                        playerCash -= (accumalatedBet-1);
                        cashAmount.setText(""+playerCash);
                        resetGameboard();
                    }//end Bust check

                }//end second hit if statement
                //Third hit button if statement
            } else if (hitCounter ==3){

                playerCard5.setImageResource(getCard[randomArrayIndex]);

                if(sum >= 11 && number[randomArrayIndex] == 11){
                    sum+=1;
                    cardAmount.setText(""+sum);

                    //21 check if statement
                    if(sum == 21){
                        Toast.makeText(getApplicationContext(), "You win!!! $"+ betAmount,Toast.LENGTH_SHORT).show();
                        playerCash += (accumalatedBet-1);
                        cashAmount.setText(""+playerCash);
                        resetGameboard();
                    }else
                        cardAmount.setText(""+sum);
                      /* Bust Check if statement*/
                    if (sum > 21){
                        Toast.makeText(getApplicationContext(),"You BUSTED!!!!!!!!!!", Toast.LENGTH_SHORT).show();
                        playerCash -= (accumalatedBet-1);
                        cashAmount.setText(""+playerCash);
                        resetGameboard();
                    }//end Bust check

                }else{
                    sum += number[randomArrayIndex];
                    cardAmount.setText(""+sum);
                    //21 check if statement
                    if(sum == 21){
                        Toast.makeText(getApplicationContext(), "You win!!! $"+ betAmount,Toast.LENGTH_SHORT).show();
                        playerCash += (accumalatedBet-1);
                        cashAmount.setText(""+playerCash);
                        resetGameboard();
                    }else if (sum > 21){
                        Toast.makeText(getApplicationContext(),"You BUSTED!!!!!!!!!!", Toast.LENGTH_SHORT).show();
                        playerCash -= (accumalatedBet-1);
                        cashAmount.setText(""+playerCash);
                        resetGameboard();
                    }//end Bust check


                }//end of third hit if statement

                //Warning for over hitting
            } else if (hitCounter>3){
                Toast.makeText(getApplicationContext(),"You can no longer hit",Toast.LENGTH_SHORT).show();
            }

        }
    }

    /***********************************************************************
    *
    *               BETLISTERNER
    *
    * *****************************************************************/
    class BetListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
    // new bet Views
            View bet25 = findViewById(R.id.twentyFive_button);
            View bet50 = findViewById(R.id.fifty_button);
            View bet100 = findViewById(R.id.hundred_button);


            if(v.getId() == bet25.getId()){
                betAmount.setText("25");
                accumalatedBet+=26;
            } else if (v.getId() == bet50.getId()){
                betAmount.setText("50");
                accumalatedBet+=51;
            }
            else if(v.getId() == bet100.getId()){
                betAmount.setText("100");
                accumalatedBet+=101;
            }


                intializeGameBoard();

        }
    }
    /*************************************************************
    *
    *       HOLD LISTENER
    *
    * *********************************************************/

    class HoldListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {

        }
    }


    /******************************************************************
    *
    *                   EXITLISTENER
    *
    * *****************************************************************/
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
