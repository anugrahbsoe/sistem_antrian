package com.fajarlabs.sistem_antrian.library;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SuaraAntrian {
    /* size of the byte buffer used to read/write the audio stream */
    private static final int BUFFER_SIZE = 4096;
    
    private final String AUDIO_FOLDER = "resources/";
    
    /* Dapatkan audio berdasar angka */
    private char[] splitAudioByInteger(int number) {
    	/* Convert integer ke array char */
    	char[] data = (""+number).toCharArray();
    	
    	return data;
    }
    
    /* Metode untuk terbilang angka menjadi suara */
    @SuppressWarnings("rawtypes")
	private List<String> terbilang(int angka) {
    	@SuppressWarnings("unchecked")
		final List<String> stack = new ArrayList();
    	
    	/* 0 - 99 */
    	if((angka > 0) && (angka < 100)) {
    		
	    	/* 1 s/d 11 */
	    	if((angka > 0) && (angka < 12)) {
	    		stack.add(getAudio(angka));
	    	}
	    	
	    	/* 12 s/d 19 */
	    	if((angka > 11) && (angka < 20)) {
	    		char[] c = splitAudioByInteger(angka);
	    		int b = Character.getNumericValue(c[1]);
	    		if(b < 2)
	    			stack.add(getAudio(angka));
	    		
	    		if(b > 1) {
	    			stack.add(getAudio(b));
	    			stack.add(AUDIO_FOLDER+"belas.wav"); /* Satuan */
	    		}
	
	    	}
	    	
	    	/* 20 s/d 99 */
	    	if((angka > 19) && (angka < 100)) {
	    		char[] chrArray = splitAudioByInteger(angka);
	    		int a = Character.getNumericValue(chrArray[0]);
	    		int b = Character.getNumericValue(chrArray[1]);
	    		if(b < 1) {
	    			stack.add(getAudio(a));
	    			stack.add(AUDIO_FOLDER+"puluh.wav");
	    		}
	    		
	    		if(b > 0) {
	    			stack.add(getAudio(a));
	    			stack.add(AUDIO_FOLDER+"puluh.wav");
	    			stack.add(getAudio(b));
	    		}
	    	}
    	}
    	
    	/* 100 - 199 */
    	if((angka > 99) && (angka < 200)) {
    		char[] chrArray = splitAudioByInteger(angka);
    		int b = Character.getNumericValue(chrArray[1]);
    		int c = Character.getNumericValue(chrArray[2]);
    		int point = Integer.parseInt(""+b+c); /* concat B+C to integer */
    		
    		stack.add(AUDIO_FOLDER+"seratus.wav");
        	if((point > 0) && (point < 12)) {
        		stack.add(getAudio(point));
        	}
        	
        	if((point > 11) && (point < 20)) {
        		char[] chrArray2 = splitAudioByInteger(point);
        		int b2 = Character.getNumericValue(chrArray2[1]);
        		if(b2 < 2)
        			stack.add(getAudio(point));
        		
        		if(b2 > 1) {
        			stack.add(getAudio(b2));
        			stack.add(AUDIO_FOLDER+"belas.wav"); /* Satuan */
        		}
        	}
        		
	    	/* 20 s/d 99 */
	    	if((point > 19) && (point < 100)) {
	    		char[] chrArray3 = splitAudioByInteger(point);
	    		int a3 = Character.getNumericValue(chrArray3[0]);
	    		int b3 = Character.getNumericValue(chrArray3[1]);
	    		if(b3 < 1) {
	    			stack.add(getAudio(a3));
	    			stack.add(AUDIO_FOLDER+"puluh.wav");
	    		}
	    		
	    		if(b3 > 0) {
	    			stack.add(getAudio(a3));
	    			stack.add(AUDIO_FOLDER+"puluh.wav");
	    			stack.add(getAudio(b3));
	    		}
	    	}
    	}
 	
    	if((angka > 199) && (angka < 1000)) {
    		char[] chrArray = splitAudioByInteger(angka);
    		int a = Character.getNumericValue(chrArray[0]);
    		int b = Character.getNumericValue(chrArray[1]);
    		int c = Character.getNumericValue(chrArray[2]);
    		int point = Integer.parseInt(""+b+c); /* concat B+C to integer */
    		
    		if((a > 1) && (a < 10)) {
    			stack.add(getAudio(a));
    			stack.add(AUDIO_FOLDER+"ratus.wav");
    		}
    		
        	if((point > 0) && (point < 12)) {
        		stack.add(getAudio(point));
        	}
        	
        	if((point > 11) && (point < 20)) {
        		char[] chrArray2 = splitAudioByInteger(point);
        		int b2 = Character.getNumericValue(chrArray2[1]);
        		if(b2 < 2)
        			stack.add(getAudio(point));
        		
        		if(b2 > 1) {
        			stack.add(getAudio(b2));
        			stack.add(AUDIO_FOLDER+"belas.wav"); /* Satuan */
        		}
        	}
        		
	    	/* 20 s/d 99 */
	    	if((point > 19) && (point < 100)) {
	    		char[] chrArray3 = splitAudioByInteger(point);
	    		int a3 = Character.getNumericValue(chrArray3[0]);
	    		int b3 = Character.getNumericValue(chrArray3[1]);
	    		if(b3 < 1) {
	    			stack.add(getAudio(a3));
	    			stack.add(AUDIO_FOLDER+"puluh.wav");
	    		}
	    		
	    		if(b3 > 0) {
	    			stack.add(getAudio(a3));
	    			stack.add(AUDIO_FOLDER+"puluh.wav");
	    			stack.add(getAudio(b3));
	    		}
	    	}
    	}
    	
    	return stack;
    }
    
    public List<String> formatTerbilang(int nomorAntrian, int nomorLoket) {
    	final List<String>stack = new ArrayList();
    	/* Pembuka kata */
    	stack.add(AUDIO_FOLDER+"nada-pembuka.wav");
    	stack.add(AUDIO_FOLDER+"nomor-urut.wav");
    	stack.addAll(terbilang(nomorAntrian));
    	stack.add(AUDIO_FOLDER+"loket.wav");
    	stack.addAll(terbilang(nomorLoket));
    	stack.add(AUDIO_FOLDER+"nada-penutup.wav");
    	
    	return stack;
    }
    
    /* Dapatkan audio dasar */
    private String getAudio(int s) {
    	String output = "";
    	switch(s) {
	    	case 1 :
	    		output = AUDIO_FOLDER+"satu.wav";
	    		break;
	    	case 2 :
	    		output = AUDIO_FOLDER+"dua.wav";
	    		break;
	    	case 3 :
	    		output = AUDIO_FOLDER+"tiga.wav";
	    		break;
	    	case 4 :
	    		output = AUDIO_FOLDER+"empat.wav";
	    		break;
	    	case 5 :
	    		output = AUDIO_FOLDER+"lima.wav";
	    		break;
	    	case 6 :
	    		output = AUDIO_FOLDER+"enam.wav";
	    		break;
	    	case 7 :
	    		output = AUDIO_FOLDER+"tujuh.wav";
	    		break;
	    	case 8 :
	    		output = AUDIO_FOLDER+"delapan.wav";
	    		break;
	    	case 9 :
	    		output = AUDIO_FOLDER+"sembilan.wav";
	    		break;
	    	case 10 :
	    		output = AUDIO_FOLDER+"sepuluh.wav";
	    		break;
	    	case 11 :
	    		output = AUDIO_FOLDER+"sebelas.wav";
	    		break;
    	}
    	
    	return output;
    }
     
    /* Metode untuk memutas file audio wav */
    public void play(String audioFilePath) {
    	
        File audioFile = new File(audioFilePath);
        
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
            SourceDataLine audioLine = (SourceDataLine) AudioSystem.getLine(info);
            audioLine.open(format);
            audioLine.start();
             
            /* System.out.println("Playback mulai."); */
             
            byte[] bytesBuffer = new byte[BUFFER_SIZE];
            int bytesRead = -1;
 
            while ((bytesRead = audioStream.read(bytesBuffer)) != -1)
                audioLine.write(bytesBuffer, 0, bytesRead);
             
            audioLine.drain();
            audioLine.close();
            audioStream.close();
             
            /* System.out.println("Playback selesai."); */
             
        } catch (UnsupportedAudioFileException ex) {
            System.out.println("File audio tidak mendukung.");
            ex.printStackTrace();
        } catch (LineUnavailableException ex) {
            System.out.println("Audio tidak tersedia.");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Error saat memutar audio.");
            ex.printStackTrace();
        }      
    }
}
