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
public final class PersonaNatural extends Cliente implements Serializable{
    private String numeroTelefono;
    private String correoElectronico;

    public PersonaNatural(String numeroTelefono, String correoElectronico, String numeroIdentificacion, String nombre, String nombreCiudad) {
        super(numeroIdentificacion, nombre, nombreCiudad);
        this.numeroTelefono = numeroTelefono;
        this.correoElectronico = correoElectronico;
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
        return "PersonaNatural{" + "numeroTelefono=" + numeroTelefono + ", correoElectronico=" + correoElectronico + '}';
    }
    
    

}