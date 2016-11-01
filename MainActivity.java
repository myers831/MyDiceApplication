package com.example.macky831.mydiceapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Timer timer = new Timer();

    int Player_score = 0;
    int Player_turn_score = 0;
    int Computer_score = 0;
    int Computer_turn_score = 0;

    int Point_holder = 0;

    int Turn_controller = 0;

    String temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final TextView tv3 = (TextView) findViewById(R.id.textView6);


        final Button bt1 = (Button) findViewById(R.id.button);

        bt1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                roll();
                Player_turn_score = Player_turn_score + Point_holder;
                tv3.setText(Integer.toString(Player_turn_score));

            }
        });


        final Button bt3 = (Button) findViewById(R.id.button3);

        bt3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Player_score = 0;
                Player_turn_score = 0;
                Computer_score = 0;
                Computer_turn_score = 0;

                Point_holder = 0;

                if(Turn_controller == 1){

                    Display();
                    Turn_controller = 0;
                    Display();
                    Turn_controller = 1;

                }

                if(Turn_controller == 0){

                    Display();
                    Turn_controller = 1;
                    Display();
                    Turn_controller = 0;

                }

                TextView tv5 = (TextView) findViewById(R.id.textView9);
                tv5.setText("");
                TextView tv4 = (TextView) findViewById(R.id.textView8);
                tv4.setText("0");
                tv3.setText("0");

            }
        });

        final Button bt2 = (Button) findViewById(R.id.button2);

        bt2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Control_turn();

                bt1.setEnabled(false);
                bt2.setEnabled(false);
                bt3.setEnabled(false);


            }
        });

        final Button bt4 = (Button) findViewById(R.id.button4);

        bt4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                bt1.setEnabled(true);
                bt2.setEnabled(true);
                bt3.setEnabled(true);


            }
        });


    }

    public void Display(){

        TextView tv1 = (TextView) findViewById(R.id.textView2);
        TextView tv2 = (TextView) findViewById(R.id.textView4);


        if(Turn_controller == 0) {

            tv1.setText(Integer.toString(Player_score));

        }

        if(Turn_controller == 1){

            tv2.setText(Integer.toString(Computer_score));

        }

    }

    public void Control_turn(){

        if(Turn_controller == 0) {

            Player_score = Player_score + Player_turn_score;
            Display();
            Player_turn_score = 0;
            Turn_controller = 1;
            Computer_logic();

        }

        if(Turn_controller == 1){

            Computer_score = Computer_score + Computer_turn_score;
            Display();
            Turn_controller = 0;
            Computer_turn_score = 0;

        }

    }

    public void Computer_logic(){


        TextView tv5 = (TextView) findViewById(R.id.textView9);
        Turn_controller = 1;

        if(Player_score >= 100){

            tv5.setText("Player Wins");

        }

        Recurce();

        Control_turn();

        if(Computer_score >= 100){

            tv5.setText("Computer Wins");

        }

        Turn_controller = 1;
        Control_turn();

    }

    public void Recurce(){

        TextView tv4 = (TextView) findViewById(R.id.textView8);

        roll();
        Computer_turn_score = Computer_turn_score + Point_holder;
        temp = Integer.toString(Computer_turn_score);
        delay();

        tv4.setText(temp);

       if(Computer_turn_score < 20) {
           if(Computer_turn_score == 0){
               return;
           }
           Recurce();
       }
    }

    public void delay(){

        runOnUiThread (new Thread(new Runnable() {

            public void run(){

                try {
                    Thread.sleep(50);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }));

    }



    public void Roll_one(){

        Button bt1 = (Button) findViewById(R.id.button);
        Button bt2 = (Button) findViewById(R.id.button2);
        Button bt3 = (Button) findViewById(R.id.button3);

        if(Turn_controller == 0) {

            bt1.setEnabled(false);
            bt2.setEnabled(false);
            bt3.setEnabled(false);


            Player_turn_score = 0;
            Control_turn();

        }

        if(Turn_controller == 1){

            Computer_turn_score = 0;
        }

    }

    public void roll(){

        ImageView iv1 = (ImageView) findViewById(R.id.imageView);

        Random rand = new Random();
        int Dice_face = rand.nextInt(6) + 1;

        switch(Dice_face){
            case 1 :
                iv1.setBackgroundDrawable(getResources().getDrawable(R.drawable.dice1));
                Roll_one();
                Point_holder = 0;
                break; //optional
            case 2 :
                iv1.setBackgroundDrawable(getResources().getDrawable(R.drawable.dice2));
                Point_holder = 2;
                break; //optional
            case 3 :
                iv1.setBackgroundDrawable(getResources().getDrawable(R.drawable.dice3));
                Point_holder = 3;
                break; //optional
            case 4 :
                iv1.setBackgroundDrawable(getResources().getDrawable(R.drawable.dice4));
                Point_holder = 4;
                break; //optional
            case 5 :
                iv1.setBackgroundDrawable(getResources().getDrawable(R.drawable.dice5));
                Point_holder = 5;
                break; //optional
            case 6 :
                iv1.setBackgroundDrawable(getResources().getDrawable(R.drawable.dice6));
                Point_holder = 6;
                break; //optional
            //You can have any number of case statements.
            default : //Optional
                //Statements
        }

    }

}
