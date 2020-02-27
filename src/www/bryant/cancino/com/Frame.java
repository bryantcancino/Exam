package www.bryant.cancino.com;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Frame {

	public static void drawGraphic(ArrayList<Point> points) {

		XYSeries vertex = new XYSeries("Vertex");

		for (int i = 0; i < points.size(); i++) {
			vertex.add(points.get(i).x, points.get(i).y);
		}

		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(vertex);

		JFreeChart xylineChart = ChartFactory.createXYLineChart("Shape", "Height", "Wide", dataset,
				PlotOrientation.VERTICAL, true, true, false);

		XYPlot plot = xylineChart.getXYPlot();

		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

		renderer.setSeriesPaint(0, Color.BLACK);
		renderer.setSeriesStroke(0, new BasicStroke(3.0f));
		plot.setRenderer(renderer);

		ChartPanel panel = new ChartPanel(xylineChart);

		JFrame window = new JFrame("Graph");
		window.setVisible(true);
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		window.add(panel);

	}

}
