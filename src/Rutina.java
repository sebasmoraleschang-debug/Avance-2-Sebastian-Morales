import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Rutina {
    private int idRutina;
    private int idUsuario;
    private String nombreRutina;
    private LocalDate fechaCreacion;
    private List<DetalleRutina> detalles;

    public Rutina(int idRutina, int idUsuario, String nombreRutina) {
        this.idRutina = idRutina;
        this.idUsuario = idUsuario;
        this.nombreRutina = nombreRutina;
        this.fechaCreacion = LocalDate.now();
        this.detalles = new ArrayList<>();
    }

    public void agregarEjercicio(Ejercicio e, int series, int reps) {
        for (DetalleRutina dr : detalles) {
            if (dr.ejercicio.getNombre().equals(e.getNombre())) {
                throw new IllegalArgumentException("El ejercicio ya existe en la rutina");
            }
        }
        int nuevoOrden = detalles.size() + 1;
        detalles.add(new DetalleRutina(nuevoOrden, series, reps, e));
    }
    
    public int getTotalEjercicios() { return detalles.size(); }
    public boolean validar() { return nombreRutina != null && !nombreRutina.isEmpty() && !detalles.isEmpty(); }
}