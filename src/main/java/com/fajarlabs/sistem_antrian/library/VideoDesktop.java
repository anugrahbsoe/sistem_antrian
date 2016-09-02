package com.fajarlabs.sistem_antrian.library;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.videosurface.CanvasVideoSurface;
import uk.co.caprica.vlcj.runtime.windows.WindowsCanvas;

import com.sun.jna.NativeLibrary;

@SuppressWarnings("deprecation")
public class VideoDesktop {

    // Create a media player factory
    private MediaPlayerFactory mediaPlayerFactory;

    // Create a new media player instance for the run-time platform
    private EmbeddedMediaPlayer mediaPlayer;

	private WindowsCanvas canvas;
    
    static {
    	NativeLibrary.addSearchPath("libvlc", "C:\\Program Files\\VideoLAN\\VLC");
    }

	public VideoDesktop(JPanel panel, String url,int width, int height){
        panel.setBackground(Color.BLACK);

        /* Creating the canvas and adding it to the panel */
        canvas = new WindowsCanvas();
        canvas.setSize(width, height);
        panel.add(canvas,BorderLayout.CENTER);
        panel.revalidate();
        panel.repaint();

        /* Creation a media player  */
        mediaPlayerFactory = new MediaPlayerFactory();
        mediaPlayer = mediaPlayerFactory.newEmbeddedMediaPlayer();
        CanvasVideoSurface videoSurface = mediaPlayerFactory.newVideoSurface(canvas);
        mediaPlayer.setVideoSurface(videoSurface);

        /* Playing the video */
        mediaPlayer.playMedia(url);
    }
}