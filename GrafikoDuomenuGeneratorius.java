package org.example.emiolija.grafikai;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import java.util.List;

public class GrafikoDuomenuGeneratorius {

    public static void pridetiDuomenisGrafikui(List<Double>[] duomenys, LineChart<Number, Number> grafikas) {
        grafikas.getData().clear();

        XYChart.Series<Number, Number> bendraSerija = new XYChart.Series<>();
        bendraSerija.setName("Bendra įmoka");

        XYChart.Series<Number, Number> palukanuSerija = new XYChart.Series<>();
        palukanuSerija.setName("Palūkanos");

        XYChart.Series<Number, Number> pagrindinesSerija = new XYChart.Series<>();
        pagrindinesSerija.setName("Paskolos grąžinimas");

        for (int i = 0; i < duomenys[0].size(); i++) {
            bendraSerija.getData().add(new XYChart.Data<>(i + 1, duomenys[0].get(i)));
            palukanuSerija.getData().add(new XYChart.Data<>(i + 1, duomenys[1].get(i)));
            pagrindinesSerija.getData().add(new XYChart.Data<>(i + 1, duomenys[2].get(i)));
        }

        grafikas.getData().addAll(bendraSerija, palukanuSerija, pagrindinesSerija);
    }
}