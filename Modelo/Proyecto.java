/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
/**
 *
 * @author Eltip
 */
public class Proyecto {
    private String codigo;
    private String titulo;      
    private LocalDate fechaInicio;      
    private String unidadDuracion;     
    private byte duracionEstimada;       
    private Cliente suCliente;      
    private Empleado suGerente;      
    private ArrayList<Empleado> suEquipo;      
    private String estado;

    public Proyecto(String codigo, String titulo, LocalDate fechaInicio, String unidadDuracion, byte duracionEstimada, Cliente suCliente, Empleado suGerente, ArrayList suEquipo, String estado) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.fechaInicio = fechaInicio;
        this.unidadDuracion = unidadDuracion;
        this.duracionEstimada = duracionEstimada;
        this.suCliente = suCliente;
        this.suGerente = suGerente;
        this.suEquipo = suEquipo;
        this.estado = estado;
    }

    
    //Parámetros sin equipo
    public Proyecto(String codigo, String titulo, LocalDate fechaInicio, String unidadDuracion, byte duracionEstimada, Cliente suCliente, Empleado suGerente, String estado) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.fechaInicio = fechaInicio;
        this.unidadDuracion = unidadDuracion;
        this.duracionEstimada = duracionEstimada;
        this.suCliente = suCliente;
        this.suGerente = suGerente;
        this.suEquipo = new ArrayList<>();
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getUnidadDuracion() {
        return unidadDuracion;
    }

    public void setUnidadDuracion(String unidadDuracion) {
        this.unidadDuracion = unidadDuracion;
    }

    public byte getDuracionEstimada() {
        return duracionEstimada;
    }

    public void setDuracionEstimada(byte duracionEstimada) {
        this.duracionEstimada = duracionEstimada;
    }

    public Cliente getSuCliente() {
        return suCliente;
    }

    public void setSuCliente(Cliente suCliente) {
        this.suCliente = suCliente;
    }

    public Empleado getSuGerente() {
        return suGerente;
    }

    public void setSuGerente(Empleado suGerente) {
        this.suGerente = suGerente;
    }

    public ArrayList getSuEquipo() {
        return suEquipo;
    }

    public void setSuEquipo(ArrayList suEquipo) {
        this.suEquipo = suEquipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Proyecto{" + "codigo=" + codigo + ", titulo=" + titulo + ", fechaInicio=" + fechaInicio + ", unidadDuracion=" + unidadDuracion + ", duracionEstimada=" + duracionEstimada + ", suCliente=" + suCliente + ", suGerente=" + suGerente + ", suEquipo=" + suEquipo + ", estado=" + estado + '}';
    }
    
    public LocalDate determinarFechaFinalizacion() {

    switch (unidadDuracion.toLowerCase()) {

        case "dias":
            return fechaInicio.plusDays(duracionEstimada);

        case "semanas":
            return fechaInicio.plusWeeks(duracionEstimada);

        case "meses":
            return fechaInicio.plusMonths(duracionEstimada);

        case "años":
            return fechaInicio.plusYears(duracionEstimada);

        default:
            return null;
    }
    }
    
    public void agregarIntegrante(Empleado nuevoIntegrante) {

    suEquipo.add(nuevoIntegrante);

    }
    
    public Empleado eliminarIntegrante(String numeroIdentificacion) {

    for (Empleado empleado : suEquipo) {

        if (empleado.getNumeroIdentificacion()
                .equals(numeroIdentificacion)) {

            suEquipo.remove(empleado);
            return empleado;
        }
    }

    return null;
    }
       
}
