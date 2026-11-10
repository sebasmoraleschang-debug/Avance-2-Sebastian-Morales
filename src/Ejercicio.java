public class Ejercicio {
    private int idEjercicio;
    private String nombre;
    private GrupoMuscular grupoMuscular;
    private String instruccionesEjecucion;

    public Ejercicio(int idEjercicio, String nombre, GrupoMuscular grupoMuscular, String instruccionesEjecucion) {
        this.idEjercicio = idEjercicio;
        this.nombre = nombre;
        this.grupoMuscular = grupoMuscular;
        this.instruccionesEjecucion = instruccionesEjecucion;
    }

    public String consultarDetalles() { return instruccionesEjecucion; }
    public GrupoMuscular obtenerGrupoMuscular() { return grupoMuscular; }
    public boolean coincideCon(String texto) { return nombre.toLowerCase().contains(texto.toLowerCase()); }
    public String getNombre() { return nombre; }
}