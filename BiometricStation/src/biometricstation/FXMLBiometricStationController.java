/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biometricstation;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author kaatje
 */
public class FXMLBiometricStationController implements Initializable {

    @FXML
    private LineChart lineChartTemperature;
    @FXML
    private LineChart lineChartHaertbeat;
    @FXML
    private LineChart lineChartAccelerometer;
    @FXML
    private Button DataGen;

    private XYChart.Series temperatureValues;
    private XYChart.Series acceleroValues;
    private XYChart.Series haertValues;

    private int xValueAcel = 0;
    private int xValueTemp = 0;
    private int xValueHeart = 0;

    final NumberAxis xAxisHaert = new NumberAxis();
    final NumberAxis yAxisHaert = new NumberAxis();

    final NumberAxis xAxisAcel = new NumberAxis();
    final NumberAxis yAxisAcel = new NumberAxis();

    final NumberAxis xAxisTemp = new NumberAxis();
    final NumberAxis yAxisTemp = new NumberAxis();

    private Random dataGenerator = new Random();

    private final int MAXIMUM_TEMPERATURE = 30;
    private final int MINIMUM_TEMPERATURE = 15;

    private final int MAXIMUM_ACCELERO = 50;
    private final int MINIMUM_ACCELERO = 0;

    private final int MAXIMUM_HAERT = 200;
    private final int MINIMUM_HAERT = 30;

    @FXML
    private void generateRandomDataHandler(ActionEvent event) {
        double randomTemperature = dataGenerator.nextDouble()
                * (MAXIMUM_TEMPERATURE - MINIMUM_TEMPERATURE + 1) + MINIMUM_TEMPERATURE;
        temperatureValues.getData().add(new XYChart.Data(xValueTemp, randomTemperature));
        xValueTemp++;

        double randomAccel = dataGenerator.nextDouble()
                * (MAXIMUM_ACCELERO - MINIMUM_ACCELERO + 1) + MINIMUM_ACCELERO;
        acceleroValues.getData().add(new XYChart.Data(xValueAcel, randomAccel));
        xValueAcel++;

        double randomHeart = dataGenerator.nextDouble()
                * (MAXIMUM_HAERT - MINIMUM_HAERT + 1) + MINIMUM_HAERT;
        haertValues.getData().add(new XYChart.Data(xValueHeart, randomHeart));
        xValueHeart++;

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        temperatureValues = new XYChart.Series();
        temperatureValues.setName("temperature_Meassurements");
        lineChartTemperature.getData().add(temperatureValues);

        acceleroValues = new XYChart.Series();
        acceleroValues.setName("accelero_Meassurements");
        lineChartAccelerometer.getData().add(acceleroValues);

        haertValues = new XYChart.Series();
        haertValues.setName("haertbeat_Maessurements");
        lineChartHaertbeat.getData().add(haertValues);

        // Set Axis
        lineChartTemperature.getYAxis().setLabel("Temperature [celcius]");
        lineChartTemperature.getXAxis().setLabel("Measurement");

        lineChartAccelerometer.getYAxis().setLabel("speed [meter/seconds] ");
        lineChartAccelerometer.getXAxis().setLabel("Measurement");

        lineChartHaertbeat.getYAxis().setLabel("bbm [beats per minit]");
        lineChartHaertbeat.getXAxis().setLabel("Measurement");

    }

}
