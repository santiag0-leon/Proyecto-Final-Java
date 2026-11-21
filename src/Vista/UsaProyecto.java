/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Modelo.Empleado;
import Modelo.Empresa;
import Modelo.PersonaNatural;
import Modelo.Proyecto;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author santiago leon (2250617)
 */ 

public class UsaProyecto extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(UsaProyecto.class.getName());

    public UsaProyecto() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new UsaProyecto().setVisible(true));
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

//1
    public ArrayList<Proyecto> registrarProyecto(ArrayList<Proyecto> losProyectos) {
        boolean entradaInvalida = false;
        String msgEntrasInvalidas = "Causas:\n";

        String codigo = generarCodigoProyecto(losProyectos);
        String titulo = null;
        LocalDate fechaInicio = null;
        String unidadDuracion = null;
        byte duracionEstimada = 0;

        titulo = jTextFieldTitulo.getText();
        if (titulo.isBlank() || titulo.isEmpty()) {
            msgEntrasInvalidas += " - Título: entrada inválida, valor vacío.\n";
            entradaInvalida = true;
        } else if (titulo.trim().length() < 20 || titulo.trim().length() > 100) {
            msgEntrasInvalidas += " - Título: entrada inválida, debe tener entre 20 y 100 caracteres.\n";
            entradaInvalida = true;
        }

        try {
            fechaInicio = LocalDate.parse(jTextFieldFechaInicio.getText().trim());
        } catch (DateTimeParseException ex) {
            msgEntrasInvalidas += " - Fecha de inicio: entrada inválida, formato incorrecto (aaaa-mm-dd) " + ex.getMessage() + "\n";
            entradaInvalida = true;
        }

        unidadDuracion = jComboBoxUnidadDuracion.getSelectedItem().toString();
        if (!unidadDuracion.equalsIgnoreCase("semanas")
                && !unidadDuracion.equalsIgnoreCase("meses")
                && !unidadDuracion.equalsIgnoreCase("años")) {
            msgEntrasInvalidas += " - Unidad de duración: entrada inválida, valor incorrecto\n";
            entradaInvalida = true;
        }

        try {
            duracionEstimada = Byte.parseByte(jTextFieldDuracionEstimada.getText().trim());
            if (duracionEstimada <= 0) {
                msgEntrasInvalidas += " - Duración estimada: entrada inválida, debe ser mayor a 0\n";
                entradaInvalida = true;
            }
        } catch (NumberFormatException ex) {
            msgEntrasInvalidas += " - Duración estimada: entrada inválida, formato incorrecto " + ex.getMessage() + "\n";
            entradaInvalida = true;
        }

        if (entradaInvalida) {
            JOptionPane.showMessageDialog(null, "Operación fallida \n" + msgEntrasInvalidas, "REGISTRO", JOptionPane.ERROR_MESSAGE);
            return losProyectos;
        }

        Proyecto objeto = new Proyecto(codigo, titulo.trim(), fechaInicio, unidadDuracion, duracionEstimada, null, null);
        losProyectos.add(objeto);
        JOptionPane.showMessageDialog(null, "Operación exitosa \nCódigo asignado: " + codigo, "REGISTRO", JOptionPane.INFORMATION_MESSAGE);

        return losProyectos;
    }

    public static String generarCodigoProyecto(ArrayList<Proyecto> losProyectos) {
        int anio = LocalDate.now().getYear();
        int consecutivo = losProyectos.size() + 1;
        return anio + "-" + String.format("%03d", consecutivo);
    }

    //2
    public String consultarTodosProyectos(ArrayList<Proyecto> losProyectos) {
        String resultado = "CONSULTA DE TODOS LOS PROYECTOS \n";
        if (losProyectos.isEmpty()) {
            resultado += "No hay proyectos registrados.";
            return resultado;
        }
        for (Proyecto objeto : losProyectos) {
            resultado += objeto.toString();
            resultado += ", fecha de finalización=" + objeto.determinarFechaFinalizacion();
            resultado += "\n";
        }
        return resultado;
    }

    //3
    public String consultarProyectosEnCurso(ArrayList<Proyecto> losProyectos) {
        String resultado = "CONSULTA DE PROYECTOS EN CURSO \n";
        if (losProyectos.isEmpty()) { 
            resultado += "No hay proyectos registrados";
            return resultado;
        }
        boolean proyectoExiste = false;
        for (Proyecto objeto : losProyectos) {
            if (objeto.getEstado().equalsIgnoreCase("EN CURSO")) {
                proyectoExiste = true;
                resultado += objeto.toString();
                resultado += "fecha de finalización = " + objeto.determinarFechaFinalizacion();
                resultado += "\n";
            }
        }
        if (!proyectoExiste) {
            resultado += "No hay proyectos en curso registrados";
        }
        return resultado;
    }

    //4
    public String consultarPrimerProyecto(ArrayList<Proyecto> losProyectos) {
        String resultado = "CONSULTA DEL PRIMER PROYECTO \n";
        if (losProyectos.isEmpty()) {
            resultado += "No hay proyectos registrados";
            return resultado;
        }
        Proyecto objeto = losProyectos.getFirst();
        resultado += objeto.toString();
        resultado += "fecha de finalización = " + objeto.determinarFechaFinalizacion();
        resultado += "\n";
        return resultado;
    }
    



    //Puntos del 9 al 12 INICIO
    //9.1
    public String consultarProyectosDadoNumIDECliente(
        ArrayList<Proyecto> datos, String numIDECliente) {

        String resultado = "CONSULTA DE PROYECTOS DE UN CLIENTE\n";

        if (datos.isEmpty()) {
        return resultado + "No hay proyectos registrados.";
        }

        boolean existe = false;

        for (Proyecto objeto : datos) {

            if (objeto.getSuCliente() != null
                && objeto.getSuCliente().getNumeroIdentificacion()
                        .equalsIgnoreCase(numIDECliente)) {

            existe = true;

            resultado += objeto.toString();
            resultado += "\nFecha de finalización: "
                    + objeto.determinarFechaFinalizacion();
            resultado += "\n";
            }
        }

        if (!existe) {
         resultado += "No existen proyectos registrados para ese cliente.";
        }

          return resultado;
    }
    
    
    //9.2
    public String consultarProyectosDadoTipoCliente(
            ArrayList<Proyecto> datos, String tipoCliente) {

        String resultado = "CONSULTA DE PROYECTOS POR TIPO DE CLIENTE\n";

        if (datos.isEmpty()) {
            return resultado + "No hay proyectos registrados.";
        }

        boolean existe = false;

        for (Proyecto objeto : datos) {

            if (objeto.getSuCliente() != null) {

                if ((tipoCliente.equalsIgnoreCase("Empresa")
                        && objeto.getSuCliente() instanceof Empresa)
                        || (tipoCliente.equalsIgnoreCase("PersonaNatural")
                        && objeto.getSuCliente() instanceof PersonaNatural)) {

                    existe = true;

                    resultado += objeto.toString();
                    resultado += "\nFecha de finalización: "
                            + objeto.determinarFechaFinalizacion();
                    resultado += "\n";
                }
            }
        }

        if (!existe) {
            resultado += "No existen proyectos registrados para ese tipo de cliente.";
        }

        return resultado;
    }
    
    
        //10
    public String registrarIntegranteProyectoDadoCodigo(
            ArrayList<Proyecto> datos, String codigoProyecto) {

        if (datos.isEmpty()) {
         return "No hay proyectos registrados.";
        }

        for (Proyecto objeto : datos) {

         if (objeto.getCodigo().equalsIgnoreCase(codigoProyecto)) {

                String numeroIdentificacion = JOptionPane.showInputDialog(
                        "Número de identificación:"
             );

             String nombreCompleto = JOptionPane.showInputDialog(
                        "Nombre completo:"
                );

                String tituloProfesional = JOptionPane.showInputDialog(
                        "Título profesional:"
                );

                byte aniosExperiencia = Byte.parseByte(
                      JOptionPane.showInputDialog("Años de experiencia:")
                );

                Empleado integrante = new Empleado(
                        numeroIdentificacion,
                        nombreCompleto,
                        tituloProfesional,
                        aniosExperiencia
                );

                objeto.agregarIntegrante(integrante);

                return "Integrante registrado exitosamente.";
            }
    }

    return "No existe un proyecto con el código indicado.";
}
    
    //11
public String registrarEquipoProyectoDadoCodigo(
        ArrayList<Proyecto> datos, String codigoProyecto) {

    if (datos.isEmpty()) {
        return "No hay proyectos registrados.";
    }

    for (Proyecto objeto : datos) {

        if (objeto.getCodigo().equalsIgnoreCase(codigoProyecto)) {

            ArrayList<Empleado> equipo = new ArrayList<>();

            int opcion;

            do {

                String numeroIdentificacion = JOptionPane.showInputDialog(
                        "Número de identificación:"
                );

                String nombreCompleto = JOptionPane.showInputDialog(
                        "Nombre completo:"
                );

                String tituloProfesional = JOptionPane.showInputDialog(
                        "Título profesional:"
                );

                byte aniosExperiencia = Byte.parseByte(
                        JOptionPane.showInputDialog("Años de experiencia:")
                );

                Empleado integrante = new Empleado(
                        numeroIdentificacion,
                        nombreCompleto,
                        tituloProfesional,
                        aniosExperiencia
                );

                equipo.add(integrante);

                opcion = JOptionPane.showConfirmDialog(
                        null,
                        "¿Desea registrar otro integrante?",
                        "REGISTRO DE EQUIPO",
                        JOptionPane.YES_NO_OPTION
                );

            } while (opcion == JOptionPane.YES_OPTION);

            objeto.setSuEquipo(equipo);

            return "Equipo registrado exitosamente.";
        }
    }

    return "No existe un proyecto con el código indicado.";
}

//12
public void retirarIntegranteProyectoDadoCodigo(
        ArrayList<Proyecto> datos, String codigoProyecto) {

    if (datos.isEmpty()) {

        JOptionPane.showMessageDialog(
                null, "No hay proyectos registrados."
        );

        return;
    }

    for (Proyecto objeto : datos) {

        if (objeto.getCodigo().equalsIgnoreCase(codigoProyecto)) {

            String identificacion = JOptionPane.showInputDialog(
                    "Ingrese el número de identificación del integrante:"
            );

            Empleado eliminado = objeto.eliminarIntegrante(identificacion);

            if (eliminado != null) {

                JOptionPane.showMessageDialog(
                        null,
                        "Integrante retirado exitosamente:\n" + eliminado
                );

            } else {

                JOptionPane.showMessageDialog(
                        null,
                        "No se encontró el integrante en el equipo del proyecto."
                );
            }

            return;
        }
    }

    JOptionPane.showMessageDialog(
            null, "No existe un proyecto con el código indicado."
    );
}
}
    
    //FIN 9-12





