package org.example.emiolija;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.emiolija.paslaugos.AtidejimoHandler;
import org.example.emiolija.paslaugos.AnuitetoSkaiciuokle;
import org.example.emiolija.grafikai.DuomenuLentele;
import org.example.emiolija.grafikai.GrafikoDuomenuGeneratorius;
//import org.example.emiolija.paslaugos.Failas;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SkaiciuotiController implements Initializable {

    @FXML
    private Button mygtukasSkaiciuoti;
    @FXML
    private TextField paskolosSuma;
    @FXML
    private TextField metai;
    @FXML
    private TextField menesiai;
    @FXML
    private TextField metinisProcentas;
    @FXML
    private TextField atsakymas;
    @FXML
    private Label klaiduPranesimas;
    @FXML
    private LineChart<Number, Number> grafikas;
    @FXML
    private TableView<DuomenuLentele> duomenuLentele;
    @FXML
    private TableColumn<DuomenuLentele, Integer> stulpelisMenesis;
    @FXML
    private TableColumn<DuomenuLentele, Double> stulpelisBendra;
    @FXML
    private TableColumn<DuomenuLentele, Double> stulpelisPalukanos;
    @FXML
    private TableColumn<DuomenuLentele, Double> stulpelisPagrindine;
    @FXML
    private Label atidetiLabel;
    @FXML
    private TextField atidetiMetai;
    @FXML
    private TextField atidetiMenesiai;
    @FXML
    private Button patvirtintiAtidejima;

    private AtidejimoHandler atidejimoHandler;
    private ObservableList<DuomenuLentele> duomenuSarasas = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Teisingai inicijuoti AtidejimoHandler su esamais FXML komponentais
        atidejimoHandler = new AtidejimoHandler(klaiduPranesimas, atidetiLabel, atidetiMetai, atidetiMenesiai, patvirtintiAtidejima);

        stulpelisMenesis.setCellValueFactory(new PropertyValueFactory<>("menesis"));
        stulpelisBendra.setCellValueFactory(new PropertyValueFactory<>("bendraImoka"));
        stulpelisPalukanos.setCellValueFactory(new PropertyValueFactory<>("palukanos"));
        stulpelisPagrindine.setCellValueFactory(new PropertyValueFactory<>("pagrindineImoka"));

        duomenuLentele.setItems(duomenuSarasas);
    }

    @FXML
    private void onSkaiciuotiButtonClick(ActionEvent event) {
        try {
            double suma = Double.parseDouble(paskolosSuma.getText());
            int laikotarpisMetai = Integer.parseInt(metai.getText());
            int laikotarpisMenesiai = Integer.parseInt(menesiai.getText());
            double metinisProcentasReiksme = Double.parseDouble(metinisProcentas.getText());

            int atidejimoMenesiai = atidejimoHandler.gautiAtidejimoMenesius();
            int visoMenesiu = (laikotarpisMetai * 12) + laikotarpisMenesiai + atidejimoMenesiai;

            List<Double>[] rezultatai = AnuitetoSkaiciuokle.skaiciuotiAnuiteta(suma, metinisProcentasReiksme, visoMenesiu, atidejimoMenesiai);
            atsakymas.setText(String.format("%.2f", rezultatai[0].get(0)));
            klaiduPranesimas.setText("");

            GrafikoDuomenuGeneratorius.pridetiDuomenisGrafikui(rezultatai, grafikas);

            duomenuSarasas.clear();
            for (int i = 0; i < rezultatai[0].size(); i++) {
                duomenuSarasas.add(new DuomenuLentele(
                        i + 1,
                        rezultatai[0].get(i),
                        rezultatai[1].get(i),
                        rezultatai[2].get(i)
                ));
            }
        } catch (NumberFormatException e) {
            klaiduPranesimas.setText("Klaida! Patikrinkite įvestus duomenis.");
        }
    }

    @FXML
    public void atidetiImokas() {
        atidejimoHandler.atidetiImokas();
    }

    @FXML
    public void patvirtintiAtidejima() {
        atidejimoHandler.patvirtintiAtidejima();
    }

    @FXML
    public void griztiBeAtidejimo() {
        atidejimoHandler.griztiBeAtidejimo();
    }
    /*@FXML
    public void eksportuotiDuomenis() {
        Failas.eksportuotiDuomenis(
                paskolosSuma.getText(),
                metai.getText(),
                menesiai.getText(),
                metinisProcentas.getText(),
                atsakymas.getText(),
                duomenuLentele.getItems()
        );

        klaiduPranesimas.setText("Duomenys sėkmingai eksportuoti.");
    }*/

}
