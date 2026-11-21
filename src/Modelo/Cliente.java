/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.io.Serializable;


/**
 *
 * @author Eltip
 */
public abstract class Cliente implements Serializable {
    protected String numeroIdentificacion;
    protected String nombre;
    protected String nombreCiudad;

    public Cliente(String numeroIdentificacion, String nombre, String nombreCiudad) {
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombre = nombre;
        this.nombreCiudad = nombreCiudad;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    @Override
    public String toString() {
        return "Cliente{" + "numeroIdentificacion=" + numeroIdentificacion + ", nombre=" + nombre + ", nombreCiudad=" + nombreCiudad + '}';
    }
    
    
}
