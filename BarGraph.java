import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.ui.ApplicationFrame;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

public class BarGraph {

    public static void plotYearlyAttacks(ArrayList<MaritimeAttack> attacks) {
        DefaultCategoryDataset dataset = createDataset(attacks);
        JFreeChart chart = createChart(dataset);
        displayChartInFrame(chart);
    }

    private static DefaultCategoryDataset createDataset(ArrayList<MaritimeAttack> attacks) {
        Map<Integer, Integer> yearCountMap = new HashMap<>();
        for (MaritimeAttack attack : attacks) {
            int year = getYearFromDate(attack.getDate());
            yearCountMap.put(year, yearCountMap.getOrDefault(year, 0) + 1);
        }
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Map.Entry<Integer, Integer> entry : yearCountMap.entrySet()) {
            dataset.addValue(entry.getValue(), "Attacks", String.valueOf(entry.getKey()));
        }
        return dataset;
    }

    private static JFreeChart createChart(DefaultCategoryDataset dataset) {
        JFreeChart barChart = ChartFactory.createBarChart(
                "Number of Attacks per Year",
                "Year",
                "Number of Attacks",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false);

        CategoryPlot plot = barChart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setBaseItemLabelsVisible(true);
        renderer.setSeriesPaint(0, Color.BLUE);

        CategoryAxis xAxis = (CategoryAxis) plot.getDomainAxis();
        xAxis.setCategoryLabelPositions(CategoryLabelPositions.DOWN_45);

        return barChart;
    }

    private static void displayChartInFrame(JFreeChart chart) {
        JFrame frame = new JFrame("Data Lab Project");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        frame.getContentPane().add(chartPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static int getYearFromDate(String date) {
        return Integer.parseInt(date.split("-")[0]);
    }
}