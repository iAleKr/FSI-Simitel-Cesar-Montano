
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author ialek
 */
public class FMedicos extends javax.swing.JFrame {

    Conexion2 cnx;
    String todo = "SELECT * FROM medicos";
    ImageIcon foto;
    String archivoFoto;

    public FMedicos() {
        initComponents();
        setLocationRelativeTo(this);
        setTitle("Médicos");

        TConsultas.setRowHeight(100);

        cnx = new Conexion2();
        if (cnx.conectar("localhost", "simitel", "root", "") == 1) {
            cnx.entablar(todo, TConsultas);

            cnx.seleccionar("SELECT DISTINCT especialidad FROM medicos ORDER BY especialidad", CBEspecialidad);
            cnx.seleccionar("SELECT DISTINCT sexom FROM medicos", CBSexo);
            cnx.seleccionar("SELECT DISTINCT estadom FROM medicos", CBEstado);
        } else {
            JOptionPane.showMessageDialog(this, "Sin conexion a la BD");
            System.exit(0);
        }
    }

    private void cargarMedicoPorSelect(String cedulaBuscada) {
        String sql = "SELECT cedula, nombrem, especialidad, sexom, fecha_nac_m, estadom "
                + "FROM medicos WHERE cedula = '" + cedulaBuscada + "'";

        String[][] datos = cnx.consultar2Array(sql);

        if (datos != null && datos.length > 1) {
            txtCedula.setText(datos[1][0]);
            txtNombre.setText(datos[1][1]);
            CBEspecialidad.setSelectedItem(datos[1][2]);
            CBSexo.setSelectedItem(datos[1][3]);
            txtFecha_de_Nacimiento.setText(datos[1][4]);
            CBEstado.setSelectedItem(datos[1][5]);
        }
    }

    private void limpiar() {
        txtCedula.setText("");
        txtNombre.setText("");
        txtFecha_de_Nacimiento.setText("");
        if (CBEspecialidad.getItemCount() > 0) {
            CBEspecialidad.setSelectedIndex(0);
        }
        if (CBSexo.getItemCount() > 0) {
            CBSexo.setSelectedIndex(0);
        }
        if (CBEstado.getItemCount() > 0) {
            CBEstado.setSelectedIndex(0);
        }
        LFoto.setIcon(null);
        archivoFoto = null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TConsultas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        BInsertar = new javax.swing.JButton();
        BActualizar = new javax.swing.JButton();
        BBorrar = new javax.swing.JButton();
        txtCedula = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        CBEspecialidad = new javax.swing.JComboBox<>();
        LFoto = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        CBSexo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        CBEstado = new javax.swing.JComboBox<>();
        txtFecha_de_Nacimiento = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TConsultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TConsultas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TConsultasMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(TConsultas);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Cedula:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Especialidad:");

        jToolBar1.setBackground(new java.awt.Color(204, 204, 204));
        jToolBar1.setRollover(true);

        BInsertar.setBackground(new java.awt.Color(51, 105, 52));
        BInsertar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BInsertar.setText("INSERTAR");
        BInsertar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        BInsertar.setFocusable(false);
        BInsertar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BInsertar.setMaximumSize(new java.awt.Dimension(120, 60));
        BInsertar.setMinimumSize(new java.awt.Dimension(120, 60));
        BInsertar.setPreferredSize(new java.awt.Dimension(120, 60));
        BInsertar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BInsertarActionPerformed(evt);
            }
        });
        jToolBar1.add(BInsertar);

        BActualizar.setBackground(new java.awt.Color(255, 246, 19));
        BActualizar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BActualizar.setText("ACTUALIZAR");
        BActualizar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        BActualizar.setFocusable(false);
        BActualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BActualizar.setMaximumSize(new java.awt.Dimension(120, 60));
        BActualizar.setMinimumSize(new java.awt.Dimension(120, 60));
        BActualizar.setPreferredSize(new java.awt.Dimension(120, 60));
        BActualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BActualizarActionPerformed(evt);
            }
        });
        jToolBar1.add(BActualizar);

        BBorrar.setBackground(new java.awt.Color(204, 0, 51));
        BBorrar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BBorrar.setText("BORRAR");
        BBorrar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        BBorrar.setFocusable(false);
        BBorrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BBorrar.setMaximumSize(new java.awt.Dimension(120, 60));
        BBorrar.setMinimumSize(new java.awt.Dimension(120, 60));
        BBorrar.setPreferredSize(new java.awt.Dimension(120, 60));
        BBorrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BBorrarActionPerformed(evt);
            }
        });
        jToolBar1.add(BBorrar);

        LFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        LFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LFotoMousePressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Sexo:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Fecha de Nacimiento:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Estado:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(CBEspecialidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(CBSexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(CBEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtFecha_de_Nacimiento)))))
                        .addGap(18, 18, 18)
                        .addComponent(LFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(CBEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CBSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtFecha_de_Nacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(CBEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 15, Short.MAX_VALUE))
                    .addComponent(LFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LFotoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LFotoMousePressed

        JFileChooser fc = new JFileChooser(System.getProperty("user.dir") + "/imagenes/");
        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            archivoFoto = fc.getSelectedFile().getPath();
            foto = new ImageIcon(archivoFoto);
            LFoto.setIcon(new ImageIcon(Conexion2.escalarImagen(foto.getImage(), LFoto.getWidth(), LFoto.getHeight())));
        }


    }//GEN-LAST:event_LFotoMousePressed

    private void BInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BInsertarActionPerformed

        try {
            byte[] bytesFoto = (archivoFoto != null && !archivoFoto.isEmpty())
                    ? Files.readAllBytes(Path.of(archivoFoto))
                    : null;

            Object[] res = cnx.ejecutarCRUD(
                    "insertar_medico",
                    new Object[]{
                        txtCedula.getText(),
                        txtNombre.getText(),
                        CBEspecialidad.getSelectedItem().toString(),
                        CBSexo.getSelectedItem().toString(),
                        txtFecha_de_Nacimiento.getText(),
                        CBEstado.getSelectedItem().toString(),
                        bytesFoto
                    }
            );
            JOptionPane.showMessageDialog(this, "Estado: " + res[0] + "\nMensaje: " + res[1]);
            if (Integer.parseInt(res[0].toString()) == 1) {
                cnx.entablar(todo, TConsultas);
                limpiar();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "No se pudo cargar la imagen");
        }


    }//GEN-LAST:event_BInsertarActionPerformed

    private void BActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BActualizarActionPerformed
        // TODO add your handling code here:

        try {
            byte[] bytesFoto = (archivoFoto != null && !archivoFoto.isEmpty())
                    ? Files.readAllBytes(Path.of(archivoFoto))
                    : null;

            Object[] res = cnx.ejecutarCRUD(
                    "actualizar_medico",
                    new Object[]{
                        txtCedula.getText(),
                        txtNombre.getText(),
                        CBEspecialidad.getSelectedItem().toString(),
                        CBSexo.getSelectedItem().toString(),
                        txtFecha_de_Nacimiento.getText(),
                        CBEstado.getSelectedItem().toString(),
                        bytesFoto
                    }
            );
            JOptionPane.showMessageDialog(this, "Estado: " + res[0] + "\nMensaje: " + res[1]);
            if (Integer.parseInt(res[0].toString()) == 1) {
                cnx.entablar(todo, TConsultas);
                limpiar();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "No se pudo cargar la imagen");
        }


    }//GEN-LAST:event_BActualizarActionPerformed

    private void BBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BBorrarActionPerformed
        // TODO add your handling code here:
        int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que deseas borrar al médico " + txtCedula.getText() + "?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (resp == JOptionPane.YES_OPTION) {
            Object[] res = cnx.ejecutarCRUD(
                    "borrar_medico",
                    new Object[]{
                        txtCedula.getText()
                    }
            );
            JOptionPane.showMessageDialog(this, "Estado: " + res[0] + "\nMensaje: " + res[1]);
            if (Integer.parseInt(res[0].toString()) == 1) {
                cnx.entablar(todo, TConsultas);
                limpiar();
            }
        }


    }//GEN-LAST:event_BBorrarActionPerformed

    private void TConsultasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TConsultasMousePressed
        // TODO add your handling code here:

        int fila = TConsultas.getSelectedRow();
        if (fila >= 0) {
            String cedula = TConsultas.getValueAt(fila, 0).toString();
            cargarMedicoPorSelect(cedula);

            archivoFoto = null;
            Object valorFoto = TConsultas.getValueAt(fila, 6);
            if (valorFoto instanceof ImageIcon) {
                ImageIcon icono = (ImageIcon) valorFoto;
                LFoto.setIcon(new ImageIcon(Conexion2.escalarImagen(icono.getImage(), LFoto.getWidth(), LFoto.getHeight())));
            } else {
                LFoto.setIcon(null);
            }
        }

    }//GEN-LAST:event_TConsultasMousePressed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(FMedicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FMedicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FMedicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FMedicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FMedicos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BActualizar;
    private javax.swing.JButton BBorrar;
    private javax.swing.JButton BInsertar;
    private javax.swing.JComboBox<String> CBEspecialidad;
    private javax.swing.JComboBox<String> CBEstado;
    private javax.swing.JComboBox<String> CBSexo;
    private javax.swing.JLabel LFoto;
    private javax.swing.JTable TConsultas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtFecha_de_Nacimiento;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
