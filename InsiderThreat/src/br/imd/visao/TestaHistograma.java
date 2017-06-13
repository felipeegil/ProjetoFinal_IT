package br.imd.visao;

import java.io.FileOutputStream;
import java.io.IOException;

public class TestaHistograma{

	public static void main (String[] args) throws IOException {

		SerieTemporal serie = GeradorDeSerie.criaSerie(1,2,3,4,5,6,7,8,8,9,9,4,3,2,
				1,2,2,4,5,6,7,8,9,10,11,10,6,3,2,6,7,8,9);

		GeradorHistograma g = new GeradorHistograma(serie, 3, 32);

		g.plotaMediaMovelSimples();

		g.salva(new FileOutputStream("histograma.png"));

	}
}