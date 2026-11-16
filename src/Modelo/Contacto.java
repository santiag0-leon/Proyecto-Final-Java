/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Eltip
 */
public class Contacto {
    private String nombreCompleto; 
    private String cargo;
    private String numeroTelefono;
    private String correoElectronico;

    public Contacto(String nombreCompleto, String cargo, String numeroTelefono, String correoElectronico) {
        this.nombreCompleto = nombreCompleto;
        this.cargo = cargo;
        this.numeroTelefono = numeroTelefono;
        this.correoElectronico = correoElectronico;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    @Override
    public String toString() {
        return "Contacto{" + "nombreCompleto=" + nombreCompleto + ", cargo=" + cargo + ", numeroTelefono=" + numeroTelefono + ", correoElectronico=" + correoElectronico + '}';
    }
    
    
}
