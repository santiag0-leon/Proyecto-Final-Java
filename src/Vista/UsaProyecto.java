package Vista;

import Modelo.*;
import java.awt.GridLayout;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class UsaProyecto extends javax.swing.JFrame {

    private ArrayList<Proyecto> listaProyectos = new ArrayList<>();

    public UsaProyecto() {
        setTitle("Gestión de Proyectos");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(400, 320);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1, 10, 10));

        JButton btnRegistrar = new JButton("1. Registrar Proyecto");
        JButton btnConsultarTodos = new JButton("2. Consultar Todos los Proyectos");
        JButton btnConsultarCurso = new JButton("3. Consultar Proyectos en Curso");
        JButton btnGuardar = new JButton("4. Guardar Proyectos en Archivo");
        JButton btnCargar = new JButton("5. Cargar Proyectos desde Archivo");

        btnRegistrar.addActionListener(e -> registrarProyecto(listaProyectos));

        btnConsultarTodos.addActionListener(e ->
            JOptionPane.showMessageDialog(this, consultarTodosProyectos(listaProyectos))
        );

        btnConsultarCurso.addActionListener(e ->
            JOptionPane.showMessageDialog(this, consultarProyectosEnCurso(listaProyectos))
        );

        btnGuardar.addActionListener(e -> guardarProyectos(listaProyectos));

        btnCargar.addActionListener(e -> listaProyectos = cargarProyectos());

        add(btnRegistrar);
        add(btnConsultarTodos);
        add(btnConsultarCurso);
        add(btnGuardar);
        add(btnCargar);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new UsaProyecto().setVisible(true));
    }

    public static ArrayList<Proyecto> registrarProyecto(ArrayList<Proyecto> datos) {
        String codigo = generarCodigoProyecto(datos);
        String titulo = JOptionPane.showInputDialog("Ingrese el título del proyecto: ");
        LocalDate fechaInicio = LocalDate.parse(JOptionPane.showInputDialog("Fecha de inicio (AAAA-MM-DD): "));
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

    public static void guardarProyectos(ArrayList<Proyecto> datos) {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("datosProyectos"))) {
            salida.writeObject(datos);
            JOptionPane.showMessageDialog(null, "Proyectos guardados correctamente en 'datosProyectos'.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar proyectos: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Proyecto> cargarProyectos() {
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("datosProyectos"))) {
            ArrayList<Proyecto> datos = (ArrayList<Proyecto>) entrada.readObject();
            JOptionPane.showMessageDialog(null, "Proyectos cargados correctamente (" + datos.size() + " registros).");
            return datos;
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "No se pudo cargar el archivo: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
