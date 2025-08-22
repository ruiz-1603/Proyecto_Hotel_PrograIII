package org.example.hotelmanager;

import java.time.LocalDate;
import java.time.Period;

public class Cliente {
    //------------------------------------------
    // hace n cantidad de reservas
    // y las reservas tienen n cantidad de habitaciones
    //------------------------------------------
    // si hay info sensible, hay que hacer una subclase para eso(gestor de datos) o Clase Miscelanea

    private int idCliente;
    private String identificacion; //como hay letras en IDs de otros paises usar string, pensar en utilidad futura
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private LocalDate fechaNacimiento;
    private int edad;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        // entregar la fecha para que la persona pueda tener solo 18 o mas anios
        LocalDate hoy = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, hoy);
        int edadCalculada = periodo.getYears();

        if (edadCalculada < 18) {
            throw new IllegalArgumentException("El cliente debe ser mayor de edad");
        }
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edadCalculada;
    }

    public int getEdad() {
        return edad ;
    }

    public void setEdad() {
        LocalDate fechActual = LocalDate.now();

        this.edad = Period.between(fechActual, this.fechaNacimiento).getYears();// el this para ESTA fecha de nacimiento
    }

    public Cliente(int idCliente, String identificacion, String nombre, String primerApellido, String segundoApellido, LocalDate fechaNacimiento, int edad) {
        this.idCliente = idCliente;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
    }
}
