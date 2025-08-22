package Backend;

import org.example.hotelmanager.Cliente;

import java.time.LocalDate;

public class Reservacion {

    private int idReservacion;
    private Habitacion habitacion;
    private Cliente cliente;
    private LocalDate fechaReservacion;
    private String fechaSalida;
    private LocalDate fechaLlegada;
    private int cantidadNoches;
    private double precioTotal; /// cantidad de noches * precio de habitacion
    private double descuento;

    public int getIdReservacion() {
        return idReservacion;
    }

    public void setIdReservacion(int idReservacion) {
        this.idReservacion = idReservacion;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFechaReservacion() {
        return fechaReservacion;
    }

    public void setFechaReservacion(LocalDate fechaReservacion) {
        this.fechaReservacion = fechaReservacion;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public LocalDate getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(LocalDate fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public int getCantidadNoches() {
        return cantidadNoches;
    }

    public void setCantidadNoches(int cantidadNoches) {
        this.cantidadNoches = cantidadNoches;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal() {
        /// calculo de totalidad por noche y el precio total de la habitacion
        this.precioTotal = cantidadNoches * habitacion.getPrecio();
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public Reservacion(int idReservacion, Habitacion habitacion, Cliente cliente, LocalDate fechaLlegada, double precioTotal, int cantidadNoches) {
        this.idReservacion = idReservacion;
        this.habitacion = habitacion;
        this.cliente = cliente;
        this.fechaLlegada = fechaLlegada;
        this.precioTotal = precioTotal;
        this.cantidadNoches = cantidadNoches;
    }
}
