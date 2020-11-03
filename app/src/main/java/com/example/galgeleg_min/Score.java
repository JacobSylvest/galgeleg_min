package com.example.galgeleg_min;

public class Score {
    String ord;
    String spillerNavn;
    String antalGaet;

    public String getGaet(){
        return antalGaet;
    }
    public Score(String ord, String spillerNavn, String antalGæt) {
        this.ord = ord;
        this.spillerNavn = spillerNavn;
        this.antalGaet = antalGæt;
    }
    public String toString(){
        if (Integer.parseInt(antalGaet)==0){
            return spillerNavn + " Ordet der skulle gættes:  \"" + ord + "\" antal forkerte gæt. " + antalGaet;
        }
        if (Integer.parseInt(antalGaet) == 1) {
            return spillerNavn + " Ordet der skulle gættes:  \"" + ord + "\" antal forkerte gæt. " + antalGaet;
        } else
            return spillerNavn + " Ordet der skulle gættes:  \"" + ord + "\" antal forkerte gæt. " + antalGaet;
    }
}
