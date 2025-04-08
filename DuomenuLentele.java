package org.example.emiolija.grafikai;

public class DuomenuLentele {
    private final int menesis;
    private final double bendraImoka;
    private final double palukanos;
    private final double pagrindineImoka;

    public DuomenuLentele(int menesis, double bendraImoka, double palukanos, double pagrindineImoka) {
        this.menesis = menesis;
        this.bendraImoka = bendraImoka;
        this.palukanos = palukanos;
        this.pagrindineImoka = pagrindineImoka;
    }

    public int getMenesis() {
        return menesis;
    }

    public double getBendraImoka() {
        return bendraImoka;
    }

    public double getPalukanos() {
        return palukanos;
    }

    public double getPagrindineImoka() {
        return pagrindineImoka;
    }
}

