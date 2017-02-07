package com.dustin_domas_assignment.blackjack01;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android.text.method.MovementMethod;

public class AboutActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);


        Button dev_b = (Button) findViewById(R.id.dev_button);
        dev_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(AboutActivity.this);
                builder.setTitle("Developers Of Black Jack!!!!!!!");
               builder.setMessage(Html.fromHtml("<h2>Dustin Lobato</h2> <br>"
                                                 + "<h2>Domas Budrys</h2>"));

                builder.setPositiveButton("EXIT", new DialogInterface.OnClickListener() {
                    public void onClick (DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });


                AlertDialog alertDialog = builder.create();

                // show it
                alertDialog.show();
            }//end of new onClick
        });// end of Button DEVELOPERS Declaration




        //Declare Button Credit
        Button credit_b = (Button) findViewById(R.id.credit_button);
        credit_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder builder = new AlertDialog.Builder(AboutActivity.this);
                builder.setTitle("Source of Images");

                //set builder Message to URL. String folder
                builder.setMessage(R.string.credit_cards);

                builder.setPositiveButton("EXIT", new DialogInterface.OnClickListener() {
                    public void onClick (DialogInterface dialog, int id) {
                        dialog.cancel();

                    }
                });


                AlertDialog alertDialog = builder.create();
                alertDialog.show();

                //Allows link to be clicked
                Linkify.addLinks((TextView) alertDialog.findViewById(android.R.id.message), Linkify.ALL);



            } //end of onClickListener
        }); // end od credit_buttton declaration








    }

}


// check this out