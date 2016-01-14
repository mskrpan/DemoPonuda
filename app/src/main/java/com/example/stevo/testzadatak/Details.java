package com.example.stevo.testzadatak;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.elmargomez.typer.Font;
import com.elmargomez.typer.Typer;


/**
 * Created by Stevo on 13.1.2016..
 */


public class Details extends AppCompatActivity {

    int img;
    String naslov;
    String ulica;
    String posta;
    int rating;
    String opis;
    int redBr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        //postavlja UP button(strelicu) za povratak na MainActivity
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        defPosPreuzimanje();
    }

    //metoda za definiciju imgview,txtview,ratingbar te preuzimanje iz Mainactivity i postavljanje
    public void defPosPreuzimanje() {

        //definiranje texview, imageview,ratingbara
        ImageView imageView = (ImageView) findViewById(R.id.velikaSlika);
        ImageView imageView2 = (ImageView) findViewById(R.id.malaSlika1);
        ImageView imageView3 = (ImageView) findViewById(R.id.malaSlika2);
        ImageView imageView4 = (ImageView) findViewById(R.id.malaSlika3);
        TextView txNaslov = (TextView) findViewById(R.id.txtDetailsNaslov);
        TextView txUlica = (TextView) findViewById(R.id.txtDetailsUlica);
        TextView txPosta = (TextView) findViewById(R.id.txtDetailsPosta);
        TextView txOpis = (TextView) findViewById(R.id.txtOpis);
        RatingBar starBar = (RatingBar) findViewById(R.id.ratingBar);


        //postavljanje style texta povlacenjem iz assets foldera
        txNaslov.setTypeface(Typer.set(Details.this).getFont(Font.ROBOTO_BOLD));
        txUlica.setTypeface(Typer.set(Details.this).getFont(Font.ROBOTO_REGULAR));
        txPosta.setTypeface(Typer.set(Details.this).getFont(Font.ROBOTO_REGULAR));
        txOpis.setTypeface(Typer.set(Details.this).getFont(Font.ROBOTO_REGULAR));

        //preuzimanje podataka iz MainActivity
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            //preuzimanje
            redBr = extras.getInt("redBr");
            img = extras.getInt("img");
            naslov = extras.getString("naslov");
            ulica = extras.getString("ulica");
            posta = extras.getString("posta");
            rating = extras.getInt("rating");
            opis = extras.getString("opisPonude");

            //postavljanje imena Activitya na temelju odabrane ponude
            setTitle(naslov);

            //postavljanje
            imageView.setImageResource(img);
            txNaslov.setText(naslov);
            txUlica.setText(ulica);
            txPosta.setText(posta);
            starBar.setRating(rating);
            txOpis.setText(opis);

            /*switch pregledom redBr dobiven iz position u MainActivity te provjerava
            koja je pozicija pritisnuta i postavlja slike*/
            switch (redBr) {
                case 0:
                    imageView2.setImageResource(R.drawable.slika_1);
                    imageView3.setImageResource(R.drawable.slika_2);
                    imageView4.setImageResource(R.drawable.slika_3);
                    break;
                case 1:
                    imageView2.setImageResource(R.drawable.slika_4);
                    imageView3.setImageResource(R.drawable.slika_5);
                    imageView4.setImageResource(R.drawable.slika_6);
                    break;
                case 2:
                    imageView2.setImageResource(R.drawable.slika_7);
                    imageView3.setImageResource(R.drawable.slika_8);
                    imageView4.setImageResource(R.drawable.slika_9);
                    break;
                case 3:
                    imageView2.setImageResource(R.drawable.slika_10);
                    imageView3.setImageResource(R.drawable.slika_11);
                    imageView4.setImageResource(R.drawable.slika_12);
                    break;
            }
        }
    }
}
