package com.fajarlabs.sistem_antrian.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class SlideEg extends JPanel {
	
   private SlideContainer slideContainer = new SlideContainer();
   private static Boolean flag = false;

   public SlideEg() {
	   super();
      setLayout(new BorderLayout());
      add(slideContainer, BorderLayout.CENTER);
      if(!flag) {
    	  flag = true;
	      new Thread(new Runnable() {
			
			public void run() {
				while(true) {
			      JLabel helloLabel = new JLabel("Hello", SwingConstants.CENTER);
			      helloLabel.setOpaque(true);
			      helloLabel.setBackground(Color.CYAN);
			      helloLabel.setIcon(new ImageIcon("D:\\bpjs_banner.jpg"));
			      slideContainer.add(helloLabel);
			      try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			      JLabel helloLabel2 = new JLabel("TEST", SwingConstants.CENTER);
			      helloLabel2.setOpaque(true);
			      helloLabel2.setBackground(Color.BLUE);
			      helloLabel2.setIcon(new ImageIcon("D:\\bri-banner.jpg"));
			      slideContainer.add(helloLabel2);
				}
			}
		}).start();
      }

   }
}

class SlideContainer extends JLayeredPane {
   private static final int PREF_W = 563;
   private static final int PREF_H = 200;
   private static final int SLIDE_DELAY = 20;
   protected static final int DELTA_X = 2;
   Component oldComponent;

   public SlideContainer() {
      setLayout(null);
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   @Override
   public Component add(Component comp) {
      Component[] comps = getComponents();
      if (comps.length > 0) {
         oldComponent = comps[0];
      }
      if (oldComponent == comp) {
         return super.add(comp);
      }
      if (oldComponent != null) {
         putLayer((JComponent) oldComponent, JLayeredPane.DEFAULT_LAYER);
      }
      Component returnResult = super.add(comp);
      putLayer((JComponent) comp, JLayeredPane.DRAG_LAYER);
      comp.setSize(getPreferredSize());
      comp.setVisible(true);
      comp.setLocation(getPreferredSize().width, 0);
      slideFromRight(comp, oldComponent);
      return returnResult;
   }

   private void slideFromRight(final Component comp,
         final Component oldComponent2) {
      new Timer(SLIDE_DELAY, new ActionListener() {

         public void actionPerformed(ActionEvent aEvt) {
            int x = comp.getX();
            if (x <= 0) {
               comp.setLocation(0, 0);
               putLayer((JComponent) comp, JLayeredPane.DEFAULT_LAYER);
               if (oldComponent2 != null) {
                  remove(oldComponent2);
               }
               ((Timer) aEvt.getSource()).stop();
            } else {
               x -= DELTA_X;
               comp.setLocation(x, 0);
            }
            repaint();
         }
      }).start();
   }
}
