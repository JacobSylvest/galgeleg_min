package com.example.galgeleg_min;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class Galgelogik {
    /** AHT afprøvning er muligeOrd synlig på pakkeniveau */
    ArrayList<String> muligeOrd = new ArrayList<String>();
    private String ordet;
    private ArrayList<String> brugteBogstaver = new ArrayList<String>();
    private String synligtOrd;
    private int antalForkerteBogstaver;
    private boolean sidsteBogstavVarKorrekt;
    private boolean spilletErVundet;
    private boolean spilletErTabt;

    public Galgelogik() {
        muligeOrd.add("galgeleg");
        muligeOrd.add("information");
        muligeOrd.add("elskov");
        muligeOrd.add("pandekage");
        muligeOrd.add("akademisk");
        muligeOrd.add("litteratur");
        muligeOrd.add("princippet");
        muligeOrd.add("syndrom");
        muligeOrd.add("had");
        muligeOrd.add("gavtyv")

        startNytSpil();
    }
}
