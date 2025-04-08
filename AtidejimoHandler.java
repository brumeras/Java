package org.example.emiolija.paslaugos;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class AtidejimoHandler {

    @FXML
    private Label klaiduPranesimas;
    @FXML
    private Label atidetiLabel;
    @FXML
    private TextField atidetiMetai;
    @FXML
    private TextField atidetiMenesiai;
    @FXML
    private Button patvirtintiAtidejima;

    private int atidejimoMenesiai = 0;

    public AtidejimoHandler(Label klaiduPranesimas, Label atidetiLabel, TextField atidetiMetai, TextField atidetiMenesiai, Button patvirtintiAtidejima) {
        this.klaiduPranesimas = klaiduPranesimas;
        this.atidetiLabel = atidetiLabel;
        this.atidetiMetai = atidetiMetai;
        this.atidetiMenesiai = atidetiMenesiai;
        this.patvirtintiAtidejima = patvirtintiAtidejima;
        if (atidetiLabel != null) {
            pasleptiAtidejimoLaukus();
        }
    }

    public int gautiAtidejimoMenesius() {
        return atidejimoMenesiai;
    }

    @FXML
    public void atidetiImokas() {
        if (atidetiLabel != null) {
            atidetiLabel.setVisible(true);
            atidetiMetai.setVisible(true);
            atidetiMenesiai.setVisible(true);
            patvirtintiAtidejima.setVisible(true);
        }
    }

    @FXML
    public void patvirtintiAtidejima() {
        try {
            int metai = Integer.parseInt(atidetiMetai.getText());
            int menesiai = Integer.parseInt(atidetiMenesiai.getText());
            atidejimoMenesiai = (metai * 12) + menesiai;

            if (klaiduPranesimas != null) {
                klaiduPranesimas.setText("Atidėjimas nustatytas: " + atidejimoMenesiai + " mėn.");
            }

            pasleptiAtidejimoLaukus();
        } catch (NumberFormatException e) {
            if (klaiduPranesimas != null) {
                klaiduPranesimas.setText("Klaida! Patikrinkite atidėjimo duomenis.");
            }
        }
    }

    @FXML
    public void griztiBeAtidejimo() {
        atidejimoMenesiai = 0;
        if (klaiduPranesimas != null) {
            klaiduPranesimas.setText("Atidėjimas atšauktas.");
        }
        pasleptiAtidejimoLaukus();
    }

    private void pasleptiAtidejimoLaukus() {
        if (atidetiLabel != null) {
            atidetiLabel.setVisible(false);
            atidetiMetai.setVisible(false);
            atidetiMenesiai.setVisible(false);
            patvirtintiAtidejima.setVisible(false);
        }
    }
}
