package com.example.stevo.testzadatak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.elmargomez.typer.Font;
import com.elmargomez.typer.Typer;
import java.util.ArrayList;
import java.util.List;




public class MainActivity extends AppCompatActivity {

    //kreiranje liste prema Ponuda klasi
    private List<Ponuda> ponuda = new ArrayList<Ponuda>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //postavljanje imena Activitya na temelju odabrane ponude
        setTitle("Smještaj");

        popuniListu();
        popuniListView();
        pregledClick();

    }

    //metoda za popunjavanje list s slikama, naslovima i raiting zvjezdice koja će tek biti prikazana u Ditails activity-u
    private void popuniListu() {
        ponuda.add(new Ponuda(R.drawable.marija, "Pansion Villa Maria", "Dr. Franje Tuđmana 14", "34000 Požega", 3));
        ponuda.add(new Ponuda(R.drawable.majetic, "OPG Majetić", "Venje 2", "34340 Kutjevo", 4));
        ponuda.add(new Ponuda(R.drawable.vinarija_sontacchi, "Vinarija Sontacchi", "Trg graševine 4", "34340 Kutjevo", 2));
        ponuda.add(new Ponuda(R.drawable.zlatni_lug, "Zlatni lug", "Donji Emovci 32", "34000 Požega", 5));
    }

    //metoda za popunjavanje listView-a
    private void popuniListView() {
        ArrayAdapter<Ponuda> adapter = new MyAdapter();
        ListView lista = (ListView) findViewById(R.id.lvPonuda);
        lista.setAdapter(adapter);
    }

    //moja custom klasa adapter
    private class MyAdapter extends ArrayAdapter<Ponuda>{
        public MyAdapter(){
            super(MainActivity.this, R.layout.row_layout1, ponuda);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View itemView = convertView;
            if(itemView == null){
                itemView = getLayoutInflater().inflate(R.layout.row_layout1, parent, false);
            }
            // pronaći ponude
            Ponuda trenutnaPonuda = ponuda.get(position);
            //popuniti ponude
            ImageView imageView = (ImageView)itemView.findViewById(R.id.lvSlika);
            imageView.setImageResource(trenutnaPonuda.getImgID());

            TextView txtNaslov = (TextView)itemView.findViewById(R.id.tvNaslov);
            txtNaslov.setText(trenutnaPonuda.getNaslov());
            
            TextView txtUlica = (TextView)itemView.findViewById(R.id.tvUlica);
            txtUlica.setText(trenutnaPonuda.getUlica());

            TextView txtPosta = (TextView)itemView.findViewById(R.id.tvPosta);
            txtPosta.setText(trenutnaPonuda.getPb());

            //postavlja stila texta povlačenjem iz assets foldera
            txtNaslov.setTypeface(Typer.set(MainActivity.this).getFont(Font.ROBOTO_BOLD));
            txtUlica.setTypeface(Typer.set(MainActivity.this).getFont(Font.ROBOTO_REGULAR));
            txtPosta.setTypeface(Typer.set(MainActivity.this).getFont(Font.ROBOTO_REGULAR));

            return itemView;
        }
    }

    //metoda za provjeru gdje je kliknutu unutra listView-a
    private void pregledClick() {
        final ListView lista = (ListView) findViewById(R.id.lvPonuda);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Ponuda odabranaPonuda = ponuda.get(position);

                //spremanje vrijednosti u varijable za slanje info u Ditails activity
                int redBr = position;
                int imgID = odabranaPonuda.getImgID();
                String naslov = odabranaPonuda.getNaslov();
                String ulica = odabranaPonuda.getUlica();
                String posta = odabranaPonuda.getPb();
                int rating = odabranaPonuda.getRating();

                //povlačenje opisa iz strings.xml-a i spremanje u opisPonude
                String[] opis = getResources().getStringArray(R.array.opis_ponude);
                final String opisPonude = opis[position];

                //slanje svega spremljenog putem intenta u Ditals activity
                Intent intent = new Intent(getApplicationContext(), Details.class);
                intent.putExtra("redBr", redBr);
                intent.putExtra("img", imgID);
                intent.putExtra("naslov", naslov);
                intent.putExtra("ulica", ulica);
                intent.putExtra("posta", posta);
                intent.putExtra("rating", rating);
                intent.putExtra("opisPonude", opisPonude);

                startActivity(intent);

                /*String msg = "Odabrali ste " + position + "koji je " + odabranaPonuda.getNaslov();

                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();*/

            }
        });
    }

}
