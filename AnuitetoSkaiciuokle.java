package org.example.emiolija.paslaugos;

import java.util.ArrayList;
import java.util.List;

public class AnuitetoSkaiciuokle {

    public static List<Double>[] skaiciuotiAnuiteta(double suma, double metProcentas, int visoMenesiu, int atidejimoMenesiai) {
        List<Double> imokos = new ArrayList<>();
        List<Double> palukanos = new ArrayList<>();
        List<Double> likuciai = new ArrayList<>();

        double menProcentas = metProcentas / 12 / 100;
        double likutis = suma;

        // Jei yra atidėjimas, taikome tik palūkanų mokėjimus
        for (int i = 0; i < atidejimoMenesiai; i++) {
            double palukanuDalis = likutis * menProcentas;
            imokos.add(palukanuDalis); // Mokamos tik palūkanos
            palukanos.add(palukanuDalis);
            likuciai.add(likutis);
        }

        // Apskaičiuojame anuiteto įmokas likusiam laikotarpiui
        int likutinisMenesiai = visoMenesiu - atidejimoMenesiai;
        double anuitetoKoef = (menProcentas * Math.pow(1 + menProcentas, likutinisMenesiai)) /
                (Math.pow(1 + menProcentas, likutinisMenesiai) - 1);
        double menesineImoka = likutis * anuitetoKoef;

        for (int i = 0; i < likutinisMenesiai; i++) {
            double palukanuDalis = likutis * menProcentas;
            double grynojiImoka = menesineImoka - palukanuDalis;
            likutis -= grynojiImoka;

            imokos.add(menesineImoka);
            palukanos.add(palukanuDalis);
            likuciai.add(likutis);
        }

        return new List[]{imokos, palukanos, likuciai};
    }
}
