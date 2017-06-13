package br.imd.visao;

import java.awt.Window;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.ui.RefineryUtilities;

public class GeradorHistograma{

	static String line = null;
	static BufferedReader stream = null;
	static ArrayList<String> csvData = new ArrayList<String>();
	
	public GeradorHistograma(String title) throws IOException {
		JPanel chartPanel = crearPanel();
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 475));
		setContentPane(chartPanel);
	}

	private void setContentPane(JPanel chartPanel) {
		// TODO Auto-generated method stub
		
	}

	private static IntervalXYDataset crearDataset() throws IOException {
		HistogramDataset dataset = new HistogramDataset();
		
		try {
			stream = new BufferedReader(new FileReader("Dados/device.csv"));
			while ((line = stream.readLine()) != null) {
				String[] splitted = line.split(",");
				ArrayList<String> dataLine = new ArrayList<String>(splitted.length);
				for (String data : splitted)
					dataLine.add(data);
				csvData.addAll(dataLine);
			}
		} finally {
			if (stream != null)
				stream.close();
		}
		return dataset;
	}
	private static JFreeChart crearChart(IntervalXYDataset dataset) {
		JFreeChart chart = ChartFactory.createHistogram(
				"Histograma", null, null, dataset, PlotOrientation.VERTICAL,
				true, true,false);
		
		XYPlot plot = (XYPlot) chart.getPlot();
		XYBarRenderer renderer = (XYBarRenderer) plot.getRenderer();
		renderer.setDrawBarOutline(false);
		try{
			ChartUtilities.saveChartAsJPEG(new File("histograma.jpg"), chart, 500, 475);
		}
		catch(IOException e){
			System.out.println("Erro ao abrir o arquivo");
		}
		return chart;
	}
	
	public static JPanel crearPanel() throws IOException {
		JFreeChart chart = crearChart(crearDataset());
		return new ChartPanel(chart);
	}
}