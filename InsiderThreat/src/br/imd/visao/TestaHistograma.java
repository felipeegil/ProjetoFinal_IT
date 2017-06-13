package br.imd.visao;

import java.io.IOException;
import javax.swing.JFrame;

public class TestaHistograma{


	public static void main (String[] args) throws IOException {
		GeradorHistograma g = new GeradorHistograma("Histograma");

		JFrame frame = new JFrame("Minha janela");
		frame.add(g.crearPanel());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

	}
}