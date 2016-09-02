package com.fajarlabs.sistem_antrian.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class GroupPanelNoAntrian {
	
	private JPanel PNoLeft;
	private JPanel PHNoAntrian;
	private JLabel LHNoAntrian;
	private JPanel PLNomorAntrian;
	private JLabel LNomor;
	private JPanel PConRightTitle;
	private JPanel PCDivListAntrian;
	private JPanel panel;
	private JLabel LLNoAntrian;
	private JTable table;
	private JPanel PConRight;
	private JLabel LAntrian;
	private JPanel PNoContainer;
	private JPanel PNomorAntrian;
	private DefaultTableCellRenderer rightRenderer;
	
	public GroupPanelNoAntrian(JPanel PNomorAntrian) {
		this.PNomorAntrian = PNomorAntrian;
	}
	
	public void groupPanel(SettingGroupPanel settingGroupPanel) {
		PNoContainer = new JPanel();
		PNoContainer.setBackground(settingGroupPanel.getcNoContainer());
		PNoContainer.setBorder(new LineBorder(new Color(255, 255, 255)));
		PNoContainer.setLayout(new BorderLayout(0, 0));
		PNoContainer.setPreferredSize(new Dimension(400, 190));
		PNomorAntrian.add(PNoContainer);
		
		PNoLeft = new JPanel();
		PNoLeft.setBackground(settingGroupPanel.getcPNoLeft());
		PNoLeft.setBorder(null);
		PNoContainer.add(PNoLeft, BorderLayout.WEST);
		PNoLeft.setLayout(new BorderLayout(0, 0));
		
		PHNoAntrian = new JPanel();
		PHNoAntrian.setBorder(new LineBorder(settingGroupPanel.getLnPHNoAntrian(), 5));
		PHNoAntrian.setBackground(settingGroupPanel.getcPHnoAntrian());
		PNoLeft.add(PHNoAntrian, BorderLayout.NORTH);
		PHNoAntrian.setLayout(new BorderLayout(0, 0));
		
		LHNoAntrian = new JLabel(settingGroupPanel.getLoket());
		LHNoAntrian.setHorizontalAlignment(SwingConstants.CENTER);
		LHNoAntrian.setForeground(new Color(0, 0, 0));
		LHNoAntrian.setFont(new Font("Tahoma", Font.BOLD, 27));
		PHNoAntrian.add(LHNoAntrian, BorderLayout.NORTH);
		
		PLNomorAntrian = new JPanel();
		PLNomorAntrian.setBorder(new LineBorder(settingGroupPanel.getlPlnNoAntrian(), 7));
		PLNomorAntrian.setBackground(settingGroupPanel.getcPlnNoAntrian());
		PNoLeft.add(PLNomorAntrian, BorderLayout.CENTER);
		PLNomorAntrian.setLayout(new BorderLayout(0, 0));
		
		LNomor = new JLabel(settingGroupPanel.getAntrian());
		LNomor.setForeground(new Color(0, 0, 0));
		LNomor.setFont(new Font("Arial", Font.BOLD, 45));
		LNomor.setHorizontalAlignment(SwingConstants.CENTER);
		PLNomorAntrian.add(LNomor, BorderLayout.CENTER);
		
		LLNoAntrian = new JLabel("Nomor Antrian");
		LLNoAntrian.setHorizontalAlignment(SwingConstants.CENTER);
		LLNoAntrian.setFont(new Font("Tahoma", Font.BOLD, 17));
		PLNomorAntrian.add(LLNoAntrian, BorderLayout.NORTH);
		
		PConRight = new JPanel();
		PConRight.setBorder(null);
		PConRight.setBackground(new Color(204, 51, 0));
		PNoContainer.add(PConRight, BorderLayout.CENTER);
		PConRight.setLayout(new BorderLayout(0, 0));
		
		PCDivListAntrian = new JPanel();
		PCDivListAntrian.setBackground(new Color(70, 130, 180));
		PCDivListAntrian.setPreferredSize(new Dimension(200,100));
		PConRight.add(PCDivListAntrian, BorderLayout.CENTER);
		PCDivListAntrian.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		table.setBorder(null);
		table.setForeground(new Color(255, 255, 255));
		table.setBackground(new Color(70, 130, 180));
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
        table.setRowHeight(33);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
		table.setFont(new Font("Tahoma", Font.BOLD, 21));
		table.setGridColor(Color.WHITE);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"LOKET 1 - A0001"},
				{"LOKET 2 - A0002"},
				{"LOKET 3 - A0003"},
				{"LOKET 4 - A0004"},
			},
			new String[] {
				"no_antrian"
			}
		));
		
		/* Ubah posisi cell value berada ketengah */
		rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
		
		PCDivListAntrian.add(table, BorderLayout.NORTH);
		
		panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		PNoContainer.add(panel, BorderLayout.NORTH);
		
		PConRightTitle = new JPanel();
		panel.add(PConRightTitle);
		PConRightTitle.setBackground(new Color(0, 0, 0));
		PConRightTitle.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		PConRightTitle.setLayout(new BorderLayout(0, 0));
		
		LAntrian = new JLabel(settingGroupPanel.getStrTitle());
		LAntrian.setBackground(Color.LIGHT_GRAY);
		LAntrian.setHorizontalAlignment(SwingConstants.CENTER);
		PConRightTitle.add(LAntrian);
		LAntrian.setForeground(new Color(255, 255, 255));
		LAntrian.setFont(new Font("Tahoma", Font.BOLD, 33));
	}
	
	public void groupPanelGreen(String strTitle, String loket, String antrian) {
		groupPanel(new SettingGroupPanel(Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, loket, antrian, strTitle));
	}
	
	public void groupPanelYellow(String strTitle, String loket, String antrian) {
		groupPanel(new SettingGroupPanel(Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, loket, antrian, strTitle));
	}
	
	class SettingGroupPanel {
		
		Color cNoContainer = Color.GRAY; 
		Color cPNoLeft = Color.GRAY;
		Color lnPHNoAntrian = Color.GRAY;
		Color cPHnoAntrian = Color.GRAY;
		Color lPlnNoAntrian = Color.GRAY; 
		Color cPlnNoAntrian = Color.GRAY;
		String loket = "Default";
		String antrian = "Defult";
		String strTitle = "Default";
		
		public SettingGroupPanel() {}
		
		public SettingGroupPanel(Color cNoContainer, Color cPNoLeft,
				Color lnPHNoAntrian, Color cPHnoAntrian, Color lPlnNoAntrian,
				Color cPlnNoAntrian, String loket, String antrian,
				String strTitle) {
			super();
			this.cNoContainer = cNoContainer;
			this.cPNoLeft = cPNoLeft;
			this.lnPHNoAntrian = lnPHNoAntrian;
			this.cPHnoAntrian = cPHnoAntrian;
			this.lPlnNoAntrian = lPlnNoAntrian;
			this.cPlnNoAntrian = cPlnNoAntrian;
			this.loket = loket;
			this.antrian = antrian;
			this.strTitle = strTitle;
		}
		public Color getcNoContainer() {
			return cNoContainer;
		}
		public void setcNoContainer(Color cNoContainer) {
			this.cNoContainer = cNoContainer;
		}
		public Color getcPNoLeft() {
			return cPNoLeft;
		}
		public void setcPNoLeft(Color cPNoLeft) {
			this.cPNoLeft = cPNoLeft;
		}
		public Color getLnPHNoAntrian() {
			return lnPHNoAntrian;
		}
		public void setLnPHNoAntrian(Color lnPHNoAntrian) {
			this.lnPHNoAntrian = lnPHNoAntrian;
		}
		public Color getcPHnoAntrian() {
			return cPHnoAntrian;
		}
		public void setcPHnoAntrian(Color cPHnoAntrian) {
			this.cPHnoAntrian = cPHnoAntrian;
		}
		public Color getlPlnNoAntrian() {
			return lPlnNoAntrian;
		}
		public void setlPlnNoAntrian(Color lPlnNoAntrian) {
			this.lPlnNoAntrian = lPlnNoAntrian;
		}
		public Color getcPlnNoAntrian() {
			return cPlnNoAntrian;
		}
		public void setcPlnNoAntrian(Color cPlnNoAntrian) {
			this.cPlnNoAntrian = cPlnNoAntrian;
		}
		public String getLoket() {
			return loket;
		}
		public void setLoket(String loket) {
			this.loket = loket;
		}
		public String getAntrian() {
			return antrian;
		}
		public void setAntrian(String antrian) {
			this.antrian = antrian;
		}
		public String getStrTitle() {
			return strTitle;
		}
		public void setStrTitle(String strTitle) {
			this.strTitle = strTitle;
		}
		
	}
}
