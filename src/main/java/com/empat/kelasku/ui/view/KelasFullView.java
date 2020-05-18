package com.empat.kelasku.ui.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.empat.kelasku.Main;
import com.empat.kelasku.data.controller.LayoutController;
import com.empat.kelasku.data.model.KelasSocketModel;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.stream.IntStream;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class KelasFullView extends JFrame {

	private JPanel contentPane;
	private JPanel kelasKosongContainer;

	public KelasFullView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JLabel kelasKosongSaatLabel = new JLabel("Kelas Kosong Saat Ini");
		kelasKosongSaatLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				createKelasKosongFromSocket(Main.kelasSocket);
			}
		});
		kelasKosongSaatLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(kelasKosongSaatLabel, BorderLayout.NORTH);

		kelasKosongContainer = new JPanel();
		contentPane.add(kelasKosongContainer, BorderLayout.CENTER);
		kelasKosongContainer.setLayout(new GridLayout(0, 4, 0, 0));

		
	}
	
	public void createKelasKosongFromSocket(KelasSocketModel kelasSocket) {
		LayoutController.removePanelComponents(kelasKosongContainer);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ArrayList<String> kelasKosong = kelasSocket.getKelasKosong();
		System.out.println(kelasKosong.size());
		kelasKosong.forEach(n -> {
			kelasKosongContainer.add(createKelasKosongItem(n));
			kelasKosongContainer.revalidate();
			kelasKosongContainer.repaint();
		});
	}

	public JPanel createKelasKosongItem(String namaKelas) {
		JPanel kelasKosongItem = new JPanel();
		JLabel kelasKosongLabel = new JLabel(namaKelas);
		kelasKosongItem.add(kelasKosongLabel);
		return kelasKosongItem;
	}

	public JPanel getKelasKosongContainer() {
		return kelasKosongContainer;
	}
}
