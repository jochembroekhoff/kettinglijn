package nl.jochembroekhoff.kettinglijn.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextField;
import nl.jochembroekhoff.kettinglijn.Catenary;
import nl.jochembroekhoff.kettinglijn.DoublePoint;

public class ChartDisplay {

    @FXML
    private LineChart<Number, Number> chart;

    @FXML
    private TextField inpLeftX;

    @FXML
    private TextField inpLeftY;

    @FXML
    private TextField inpRightX;

    @FXML
    private TextField inpRightY;

    @FXML
    private TextField inpLength;

    private XYChart.Series<Number, Number> series;

    @FXML
    public void initialize() {
        series = new XYChart.Series<>();
        chart.getData().add(series);
    }

    @FXML
    protected void renderChart(ActionEvent renderChart) {
        double leftX = Double.parseDouble(inpLeftX.getText());
        double leftY = Double.parseDouble(inpLeftY.getText());
        double rightX = Double.parseDouble(inpRightX.getText());
        double rightY = Double.parseDouble(inpRightY.getText());

        DoublePoint A = new DoublePoint(leftX, leftY);
        DoublePoint B = new DoublePoint(rightX, rightY);
        double length = Double.parseDouble(inpLength.getText());

        Catenary line = new Catenary(A, B, length);

        series.getData().clear();

        for (double x = line.getPointA().getX(); x < line.getPointB().getX(); x += 0.1) {
            series.getData().add(new XYChart.Data<>(x, line.calculateY(x)));
        }

    }

}
