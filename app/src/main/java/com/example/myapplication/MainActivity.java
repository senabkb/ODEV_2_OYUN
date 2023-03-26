package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView time; //textview
    TextView score;
    ImageView []images;

    int skor;  //lokal değişken oldğu için java otomatik sıfır değerini veriyor


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        time=findViewById(R.id.textView);
        score=findViewById(R.id.textView2);

        images= new ImageView[]{findViewById(R.id.imageView),findViewById(R.id.imageView2),
                findViewById(R.id.imageView3),findViewById(R.id.imageView4),
        findViewById(R.id.imageView5),findViewById(R.id.imageView6)};

        new CountDownTimer(10000,1000) { //geçiş süresi
            @Override
            public void onTick(long millisUntilFinished) {

                hideImage();

                Random random= new Random();
                int uretilen=random.nextInt(6);
                images[uretilen].setVisibility(View.VISIBLE);



                time.setText("Time:"+millisUntilFinished/1000);

            }

            @Override
            public void onFinish() {
                hideImage();


            }
        }.start();
    }
    public void hideImage(){

        for(ImageView gezici : images){
            gezici.setVisibility(View.INVISIBLE);
        }
    }
    public void catchAgent(View view){
        skor++;
        score.setText("Score:"+skor);

    }

}