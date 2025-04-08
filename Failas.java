/*import javafx.fxml.FXML;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@FXML
private Button eksportuotiButton;

@FXML
private void eksportuotiDuomenis() {
    String failoPavadinimas = "paskolos_duomenys.txt";

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(failoPavadinimas))) {
        // Rašome duomenis į failą
        writer.write("Būsto paskolos skaičiavimai\n");
        writer.write("===========================\n");
        writer.write("Paskolos suma: " + paskolosSuma.getText() + " EUR\n");
        writer.write("Metų kiekis: " + metai.getText() + "\n");
        writer.write("Mėnesių kiekis: " + menesiai.getText() + "\n");
        writer.write("Metinis procentas: " + metinisProcentas.getText() + "%\n");
        writer.write("Apskaičiuota mėnesio įmoka: " + atsakymas.getText() + " EUR\n");

        writer.write("\nDetalūs mokėjimai:\n");
        for (DuomenuLentele duomenys : duomenuLentele.getItems()) {
            writer.write("Mėnuo: " + duomenys.getMenesis() +
                    ", Bendra įmoka: " + duomenys.getBendraImoka() + " EUR" +
                    ", Palūkanos: " + duomenys.getPalukanos() + " EUR" +
                    ", Grąžinama suma: " + duomenys.getPagrindineImoka() + " EUR\n");
        }

        klaiduPranesimas.setText("Duomenys sėkmingai eksportuoti į: " + failoPavadinimas);
    } catch (IOException e) {
        klaiduPranesimas.setText("Klaida eksportuojant duomenis.");
        e.printStackTrace();
    }
}
*/