package com.fajarlabs.sistem_antrian.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import com.fajarlabs.sistem_antrian.library.VideoDesktop;

public class DisplayAntrian extends JFrame {

	private JPanel contentPane;
	private JPanel PContainer;
	private JPanel PVideo;
	private JPanel PCenter;
	private JPanel PFooter;
	private JPanel PNomorAntrian;
	private JPanel PLogoHeader;
	private JPanel PBanner;
	private JPanel PMerek;
	
	/* Width 1366 x 1232 */
	
	private final int containerWidth = 1366;
	private final int containerHeight = 1232;
	
	/* Logo kiri */
	private final int logoWidth = 550;
	private final int logoHeight = 130;
	
	/* Video Kiri */
	private final int videoWidth = 550;
	private final int videoHeight = 200;
	
	/* Banner Kiri */
	private final int bannerWidth = 550;
	private final int bannerHeight = 200;
	
	/* Footer */
	private final int footerWidth = 1200;
	private final int footerHeight = 50;	
	
	/* Path video */
	private final String pathVideo = "D:\\ektp-bri.mp4";
	private final String pathBanner = "D:\\bpjs_banner.jpg";
	private final String pathLogo = "D:\\logo.jpg";
	
	private JPanel PRunningText;
	private JLabel LTime;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayAntrian frame = new DisplayAntrian();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DisplayAntrian() {
		/* Mode fullscreen */
		setUndecorated(true);
		setAlwaysOnTop(true);
		setResizable(false);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 855, 481);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		PContainer = new JPanel();
		PContainer.setPreferredSize(new Dimension(containerWidth,containerHeight));
		contentPane.add(PContainer);
		PContainer.setLayout(new BorderLayout(0, 0));
		
		JPanel PDivWest = new JPanel();
		PDivWest.setBackground(Color.WHITE);
		PContainer.add(PDivWest, BorderLayout.WEST);
		PDivWest.setLayout(new BorderLayout(0, 0));
		
		PLogoHeader = new ImagePanel(pathLogo);
		PLogoHeader.setPreferredSize(new Dimension(logoWidth, logoHeight));
		PLogoHeader.setBackground(Color.CYAN);
		PDivWest.add(PLogoHeader, BorderLayout.NORTH);
		PLogoHeader.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		PVideo = new JPanel();
		PVideo.setBackground(Color.BLACK);
		PVideo.setPreferredSize(new Dimension(videoWidth, videoHeight));
		PDivWest.add(PVideo,BorderLayout.CENTER);
		PVideo.setLayout(new BorderLayout(0, 0));
		setVisible(true);
		new VideoDesktop(PVideo, pathVideo,450,600);
		
		PBanner = new JPanel();
		PBanner.setBackground(Color.ORANGE);
		PBanner.setPreferredSize(new Dimension(bannerWidth,bannerHeight));
		PDivWest.add(PBanner, BorderLayout.SOUTH);
		PBanner.setLayout(new BorderLayout(0, 0));
		
		/*ImagePanel = new ImagePanel(pathBanner);
		ImagePanel.setLayout(new BoxLayout(ImagePanel, BoxLayout.X_AXIS));*/
		SlideEg slideEg = new SlideEg();
		PBanner.add(slideEg);
		
		PCenter = new JPanel();
		PCenter.setPreferredSize(new Dimension(816, 530));
		PContainer.add(PCenter, BorderLayout.CENTER);
		PCenter.setLayout(new BorderLayout(0, 0));
		
		PNomorAntrian = new JPanel();
		PNomorAntrian.setBackground(new Color(70, 130, 180));
		PCenter.add(PNomorAntrian, BorderLayout.CENTER);
		PNomorAntrian.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		GroupPanelNoAntrian groupPanelNoAntrian = new GroupPanelNoAntrian(PNomorAntrian);
		groupPanelNoAntrian.groupPanelGreen("PEMBAYARAN","LOKET 1","A-00001");
		groupPanelNoAntrian.groupPanelYellow("PENGAMBILAN","LOKET 2","A-00002");
		groupPanelNoAntrian.groupPanelGreen("PEMBAYARAN","LOKET 3","B-00002");
		groupPanelNoAntrian.groupPanelYellow("PENGAMBILAN","LOKET 4","B-00002");
		
		PFooter = new JPanel();
		PFooter.setForeground(new Color(255, 255, 255));
		PFooter.setBackground(new Color(0, 0, 0));
		PFooter.setPreferredSize(new Dimension(1366, 50));
		PFooter.setLayout(new BorderLayout(0, 0));
		PContainer.add(PFooter, BorderLayout.SOUTH);
		
		JLabel labelRunningText = new JLabel();
		labelRunningText.setForeground(new Color(255, 255, 255));
		labelRunningText.setFont(new Font("Times New Roman", Font.PLAIN, 32));
		labelRunningText.setHorizontalAlignment(SwingConstants.TRAILING);
		labelRunningText.setMaximumSize(new Dimension());
		PRunningText = new RunningTextPanel("e-KTP atau KTP Elektronik adalah dokumen kependudukan yang memuat sistem keamanan / pengendalian baik dari sisi administrasi ataupun teknologi informasi dengan berbasis pada database kependudukan nasional.",labelRunningText);
		PRunningText.setBackground(new Color(0, 0, 0));
		PRunningText.setPreferredSize(new Dimension(1200, footerHeight));
		PRunningText.setLayout(new BorderLayout(0, 0));
		PRunningText.add(labelRunningText, BorderLayout.CENTER);
		PFooter.add(PRunningText, BorderLayout.WEST);
		
		PMerek = new JPanel();
		PFooter.add(PMerek, BorderLayout.CENTER);
		PMerek.setBackground(new Color(25, 25, 112));
		PMerek.setLayout(new BorderLayout(0, 0));
		
		LTime = new JLabel("-");
		LTime.setForeground(new Color(255, 255, 255));
		LTime.setFont(new Font("Tahoma", Font.PLAIN, 17));
		LTime.setHorizontalAlignment(SwingConstants.CENTER);
		new ClockPanel(LTime).start();;
		PMerek.add(LTime);
		
	}
}
