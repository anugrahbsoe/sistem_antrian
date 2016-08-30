package com.fajarlabs.sistem_antrian;

import java.util.List;

public class App {
     
    public static void main(String[] args) {
        SuaraAntrian suaraAntrian = new SuaraAntrian();
        List<String> data = suaraAntrian.formatTerbilang(11,11);
        for(String o : data) {
        	System.out.println(o);
        	suaraAntrian.play(o);
        }
    }
}
