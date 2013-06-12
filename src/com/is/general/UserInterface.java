package com.is.general;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import javax.swing.JProgressBar;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JDesktopPane;
import javax.swing.border.EtchedBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class UserInterface extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7413631420807225473L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public UserInterface() {
		setTitle("ImageSimilarity");
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 716, 474);
		contentPane = new JPanel();
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setForeground(Color.RED);
		progressBar.setBounds(12, 49, 668, 14);
		panel.add(progressBar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(12, 5, 668, 33);
		panel.add(panel_1);
		
		JButton btnSelectImage = new JButton("Select Original Image");
		btnSelectImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel_1.add(btnSelectImage);
		
		JButton btnSelectImagesTo = new JButton("Select Images to Compare with");
		panel_1.add(btnSelectImagesTo);
		
		JButton btnStartImageSimilarity = new JButton("Calculate Image Similarity");
		panel_1.add(btnStartImageSimilarity);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(12, 74, 668, 340);
		panel.add(panel_2);
		panel_2.setLayout(null);
	}
}
