package com.example.stevo.testzadatak;

/**
 * Created by Stevo on 13.1.2016..
 */

//klasa za vrijednosti slika, texta i raiting-a te s geterima dohvacanje istih
public class Ponuda {
    private int imgID;
    private String naslov;
    private String ulica;
    private String pb;
    private int rating;

    public Ponuda(int imgID, String naslov, String ulica, String pb, int rating)
    {
        super();
        this.imgID = imgID;
        this.naslov = naslov;
        this.ulica = ulica;
        this.pb = pb;
        this.rating = rating;
    }

    public String getNaslov() {
        return naslov;
    }


    public int getImgID() {
        return imgID;
    }


    public String getUlica() {
        return ulica;
    }


    public String getPb() {
        return pb;
    }

    public int getRating(){
        return rating; }

}
