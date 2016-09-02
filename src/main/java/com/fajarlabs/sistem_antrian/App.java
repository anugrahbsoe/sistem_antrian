package com.fajarlabs.sistem_antrian;

import java.util.List;

import com.fajarlabs.sistem_antrian.library.SuaraAntrian;

public class App {
     
    public static void main(String[] args) {
        SuaraAntrian suaraAntrian = new SuaraAntrian();
        List<String> data = suaraAntrian.formatTerbilang(111,11);
        for(String o : data) {
        	System.out.println(o);
        	suaraAntrian.play(o);
        }
    }
}
