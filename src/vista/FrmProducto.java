
package vista;

import controlador.ProductoController;
import modelo.Producto;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

public class FrmProducto extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmProducto.class.getName());
    private String codigoOriginal = null;

    
    public FrmProducto() {
        initComponents();
        aplicarEstilo();
        listarProductos();
        setLocationRelativeTo(null);
        
    }

    private void aplicarEstilo() {
        Color verde = new Color(46, 125, 87);
        Color fondo = new Color(234, 245, 238);

        getContentPane().setBackground(fondo);
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        jLabel1.setForeground(verde);

        for (javax.swing.JButton b : new javax.swing.JButton[]{btnGuardar, btnEditar, btnEliminar, btnNuevo}) {
            b.setBackground(verde);
            b.setForeground(Color.WHITE);
            b.setFocusPainted(false);
        }

        tblProductos.getTableHeader().setBackground(verde);
        tblProductos.getTableHeader().setForeground(Color.WHITE);
    }
    private ProductoController controller = new ProductoController();
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("GESTIÓN DE PRODUCTOS");

        jLabel2.setText("Código : ");

        jLabel3.setText("Nombre : ");

        jLabel4.setText("Precio : ");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Código", "Nombre", "Precio"
            }
        ));
        tblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProductos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(61, 61, 61)
                                        .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnEliminar)))
                                .addGap(40, 40, 40)
                                .addComponent(btnNuevo)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar)
                    .addComponent(btnNuevo))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
       
        String codigo = txtCodigo.getText();
        String nombre = txtNombre.getText();
        double precio = Double.parseDouble(txtPrecio.getText());

        boolean respuesta = controller.guardarProducto(codigo, nombre, precio);

        if (respuesta) {

          JOptionPane.showMessageDialog(this, "Producto registrado correctamente");

          listarProductos();

          btnNuevoActionPerformed(null);

        } else {

        JOptionPane.showMessageDialog(this, "Error al registrar");

        }
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        if (codigoOriginal == null) {
            JOptionPane.showMessageDialog(this, "Seleccione un producto de la tabla antes de editar.");
            return;
        }
        
        String codigoNuevo = txtCodigo.getText();
        String nombre = txtNombre.getText();
        double precio = Double.parseDouble(txtPrecio.getText());

        boolean respuesta = controller.editarProducto(codigoOriginal, codigoNuevo, nombre, precio);

        if (respuesta) {

        JOptionPane.showMessageDialog(this, "Producto actualizado correctamente");

        listarProductos();
        btnNuevoActionPerformed(null);

        } else {

        JOptionPane.showMessageDialog(this, "Error al actualizar. Verifique que el nuevo código no esté repetido y que el producto no tenga movimientos asociados.");

        }
        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
        if (codigoOriginal == null) {
            JOptionPane.showMessageDialog(this, "Seleccione un producto de la tabla antes de eliminar.");
            return;
        }

        int opcion = JOptionPane.showConfirmDialog(
        this,
        "¿Está seguro de eliminar este producto?",
        "Confirmar",
        JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {

        boolean respuesta = controller.eliminarProducto(codigoOriginal);

        if (respuesta) {

        JOptionPane.showMessageDialog(this, "Producto eliminado correctamente");

        listarProductos();
        btnNuevoActionPerformed(null);

        } else {

        JOptionPane.showMessageDialog(this, "Error al eliminar");

    }

}
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
       
        codigoOriginal = null;
        txtCodigo.setText("");
        txtNombre.setText("");
        txtPrecio.setText("");
        txtCodigo.requestFocus();
        
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void tblProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMouseClicked
        
        int fila = tblProductos.getSelectedRow();

        codigoOriginal = tblProductos.getValueAt(fila, 0).toString();
        txtCodigo.setText(tblProductos.getValueAt(fila, 0).toString());
        txtNombre.setText(tblProductos.getValueAt(fila, 1).toString());
        txtPrecio.setText(tblProductos.getValueAt(fila, 2).toString());
        
    }//GEN-LAST:event_tblProductosMouseClicked

    private void listarProductos() {

    DefaultTableModel modelo = (DefaultTableModel) tblProductos.getModel();

    modelo.setRowCount(0);

    List<Producto> lista = controller.listarProductos();

    for (Producto producto : lista) {

        modelo.addRow(new Object[]{
            producto.getCodProducto(),
            producto.getNombre(),
            producto.getPrecio()
        });

    }

    }
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> new FrmProducto().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
