public class DetalleRutina {
    private int orden;
    private int series;
    private int repeticiones;
    private Ejercicio ejercicio;

    public DetalleRutina(int orden, int series, int repeticiones, Ejercicio ejercicio) {
        this.orden = orden;
        this.setSeries(series);
        this.setRepeticiones(repeticiones);
        this.ejercicio = ejercicio;
    }

    public void setSeries(int s) {
        if (s < 1 || s > 10) throw new IllegalArgumentException("Series deben estar entre 1 y 10");
        this.series = s;
    }

    public void setRepeticiones(int r) {
        if (r < 1 || r > 100) throw new IllegalArgumentException("Repeticiones deben estar entre 1 y 100");
        this.repeticiones = r;
    }
}