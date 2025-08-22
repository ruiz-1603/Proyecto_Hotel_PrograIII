package Backend;

public class Habitacion {

    private int id; // identifica al objeto dentro del programa y sirve para bases de datos que lo utilicen
    private int numero; // es mas especifico, ej: con cabana AC43
    private int tipoHabitacion;
    private String estado;
    private double precio;
    private int capacidad;

    //---------------------------------------------------------------------------------------------------------------------

    public Habitacion(int id, int numero, String estado, double precio){
        this.id = id;
        this.numero = numero;
        this.estado = estado;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(int tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCapacidad() { return capacidad; }

    public void setCapacidad(int capacidad) { this.capacidad = capacidad; }

}



