package org.example.emiolija.paslaugos;

public class Mokejimas {
    private String data; // Mokėjimo data (YYYY-MM-DD)
    private double suma; // Mokėjimo suma

    public Mokejimas(String data, double suma) {
        this.data = data;
        this.suma = suma;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getSuma() {
        return suma;
    }

    public void setSuma(double suma) {
        this.suma = suma;
    }

    @Override
    public String toString() {
        return "Mokejimas{" +
                "data='" + data + '\'' +
                ", suma=" + suma +
                '}';
    }
}

