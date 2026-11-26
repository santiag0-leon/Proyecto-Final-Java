package Vista;

import Modelo.*;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UsaProyecto extends javax.swing.JFrame {

    public UsaProyecto() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(400, 300);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new UsaProyecto().setVisible(true));
    }

    public static ArrayList<Proyecto> registrarProyecto(ArrayList<Proyecto> datos) {
        String codigo = generarCodigoProyecto(datos);
        String titulo = JOptionPane.showInputDialog("Ingrese el título del proyecto: ");
        LocalDate fechaInicio = LocalDate.parse(JOptionPane.showInputDialog("Fecha de inicio: "));
        String unidadDuracion = JOptionPane.showInputDialog("Unidad de duración: ");
        byte duracionEstimada = Byte.parseByte(JOptionPane.showInputDialog("Duración estimada: "));

        Proyecto nuevo = new Proyecto(codigo, titulo, fechaInicio, unidadDuracion, duracionEstimada, null, null, "EN CURSO");
        datos.add(nuevo);
        JOptionPane.showMessageDialog(null, "Proyecto registrado exitosamente: " + codigo);
        return datos;
    }

    public static String generarCodigoProyecto(ArrayList<Proyecto> datos) {
        return LocalDate.now().getYear() + "-" + String.format("%03d", datos.size() + 1);
    }

    public static String consultarTodosProyectos(ArrayList<Proyecto> datos) {
        if (datos == null || datos.isEmpty()) {
            return "La lista de proyectos está vacía";
        }
        String resultado = "--- TODOS LOS PROYECTOS ---\n";
        for (Proyecto p : datos) {
            resultado += p.toString() + "\n";
        }
        return resultado;
    }

    public static String consultarProyectosEnCurso(ArrayList<Proyecto> datos) {
        if (datos == null || datos.isEmpty()) {
            return "La lista de proyectos está vacía.";
        }
        String resultado = "--- PROYECTOS EN CURSO ---\n";
        for (Proyecto p : datos) {
            if (p.getEstado().equalsIgnoreCase("EN CURSO")) {
                resultado += p.toString() + "\n";
            }
        }
        return resultado;
    }
}
