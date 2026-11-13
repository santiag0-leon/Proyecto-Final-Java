/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

/**
 *
 * @author manue
 */
public class UsaProyecto {
    
}

public static Arraylist<Proyecto> registrarProyecto(ArrayList<Proyecto> datos){
    String codigo = generarCodigoProyecto(datos);
    String titulo = JOptionPane.showInputDialog("Ingrese titulo del proyecto: ");
    LocalDate fechaInicio = Localdate.parse(JOptionPane.showInputDialog("Fecha de inicion (aaaa/mm/dd): "));
    String unidadDuracion = JOptionPane.showInputDialog("Unidad de duración): ");
    Byte.parseByte(JOptionPane.showInputDialog("Duración estimada: "));
    
    Proyecto nuevoProyecto = new Proyecto(codigo, titulo, fechaInicio, unidadDuracion, duracionEstimada, null, null);
        datos.add(nuevoProyecto);
    
    JOptionPane.showMessageDialog(null, "Proyecto registrado exitosamente con código: " + codigo);
        return datos;
}