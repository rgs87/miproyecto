/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.sql.*;
import conexion.Conexion;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ruben
 */
public class FrameVehiculos extends javax.swing.JFrame {

    Connection con = null;
    Conexion connect = new Conexion();

    public FrameVehiculos() {
        initComponents();
        con = connect.getConnection();
        rellenarPropietarios();
        mostrarVehiculos("vehiculos", null);
        tableVehiculos.getTableHeader().setReorderingAllowed(false);//quita la opcion de mover las columnas
        tableVehiculos.setFocusable(false);

        tableVehiculos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                // do some actions here, for example
                // print first column value from selected row
                int idVehiculo = Integer.parseInt(tableVehiculos.getValueAt(tableVehiculos.getSelectedRow(), 0).toString());
                System.out.println("El id es el " + idVehiculo);
            }
        });

        //Evento que para cuando haces doble click
        tableVehiculos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (me.getClickCount() == 2) {     // to detect doble click events
                    JTable target = (JTable) me.getSource();
                    int row = target.getSelectedRow(); // select a row
                    int column = target.getSelectedColumn(); // select a column
                    JOptionPane.showMessageDialog(null, tableVehiculos.getValueAt(row, 0)); // get the value of a row and column.
                }
            }
        });

    }
    
    public void rellenarPropietarios(){
        comboNombre.removeAllItems();
        comboNombre.addItem("Todos");
        
        String sql;
        sql = "SELECT nombre FROM propietarios";
        Statement st;
        Connection con = null;
        con = connect.getConnection();
        
        //try{
            
        //} catch (SQLException ex) {
         //   Logger.getLogger(FrameVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        //}
       
    }

    /*Muestra los datos de los vehículos en la tabla*/
    public void mostrarVehiculos(String tabla, String nombrePropietario) {
        String sql;
        if (nombrePropietario == null) {
            sql = "SELECT v.Id, v.matricula, v.marca, v.modelo, v.kilometraje, p.nombre "
                    + "FROM vehiculos v "
                    + "JOIN propietarios p ON p.Id = v.propietario;";
        }
        else {
            sql = "SELECT v.Id, v.matricula, v.marca, v.modelo, v.kilometraje, p.nombre "
                    + "FROM vehiculos v "
                    + "JOIN propietarios p ON p.Id = v.propietario "
                    + "WHERE p.nombre = '" +nombrePropietario+"';";
        }
        

        Statement st;
        Connection con = null;
        Conexion connect = new Conexion();
        con = connect.getConnection();
        System.out.println(sql);

        DefaultTableModel model = new DefaultTableModel() {
            //Hace que las celdas no sean editalbes
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.addColumn("ID");
        model.addColumn("Matrícula");
        model.addColumn("Marca");
        model.addColumn("Modelo");
        model.addColumn("Kilómetros");
        model.addColumn("Propietario");
        tableVehiculos.setModel(model);

        String[] datos = new String[6];

        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            int c = 1;
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(6));
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                model.addRow(datos);

            }
        } catch (SQLException ex) {
            Logger.getLogger(FrameVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableVehiculos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        comboNombre = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tableVehiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        )
    );
    tableVehiculos.setToolTipText("");
    tableVehiculos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    tableVehiculos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    tableVehiculos.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tableVehiculosMouseClicked(evt);
        }
    });
    tableVehiculos.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            tableVehiculosKeyReleased(evt);
        }
    });
    jScrollPane1.setViewportView(tableVehiculos);

    jLabel1.setText("Filtrar por nombre ");

    comboNombre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(79, 79, 79)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(comboNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(102, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap(119, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1)
                .addComponent(comboNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(29, 29, 29))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        //String directoryName = System.getProperty("user.dir");
        //	System.out.println("La ruta actual es = " +directoryName);
    }//GEN-LAST:event_formWindowClosing

    //Acción cuando seleccionamos una fila con el teclado
    private void tableVehiculosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableVehiculosKeyReleased

    }//GEN-LAST:event_tableVehiculosKeyReleased

    //Acción cuando seleccionamos una fila con el ratón
    private void tableVehiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableVehiculosMouseClicked

    }//GEN-LAST:event_tableVehiculosMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameVehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameVehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameVehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameVehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameVehiculos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tableVehiculos;
    // End of variables declaration//GEN-END:variables
}
