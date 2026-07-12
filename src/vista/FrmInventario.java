package vista;

import controlador.InventarioController;
import controlador.ProductoController;
import modelo.Producto;

import java.util.List;
import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmInventario extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmInventario.class.getName());
    
    private InventarioController controller = new InventarioController();
    private ProductoController productoController = new ProductoController();
    private int idInventarioSeleccionado = 0;

    
    public FrmInventario() {
        initComponents();
    aplicarEstilo();
    cargarProductos();
    listarInventario();

    tblInventario.getSelectionModel().addListSelectionListener(evt -> {
        if (!evt.getValueIsAdjusting() && tblInventario.getSelectedRow() != -1) {
            seleccionarFila();
        }
    });
    setLocationRelativeTo(null);
    }

    private void aplicarEstilo() {
        Color naranja = new Color(200, 110, 30);
        Color fondo = new Color(252, 240, 227);

        getContentPane().setBackground(fondo);
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        jLabel1.setForeground(naranja);

        for (javax.swing.JButton b : new javax.swing.JButton[]{btnGuardar, btnEditar, btnEliminar, btnNuevo}) {
            b.setBackground(naranja);
            b.setForeground(Color.WHITE);
            b.setFocusPainted(false);
        }

        tblInventario.getTableHeader().setBackground(naranja);
        tblInventario.getTableHeader().setForeground(Color.WHITE);
    }

    private void cargarProductos() {

    cbProducto.removeAllItems();

    List<Producto> lista = productoController.listarProductos();

    for (Producto p : lista) {
        cbProducto.addItem(p.getCodProducto());
    }

}
    
    private void seleccionarFila() {
    int fila = tblInventario.getSelectedRow();

    idInventarioSeleccionado = (int) tblInventario.getValueAt(fila, 0);
    int cantidad = (int) tblInventario.getValueAt(fila, 2);
    String codProducto = (String) tblInventario.getValueAt(fila, 3);

    cbProducto.setSelectedItem(codProducto);
    txtCantidad.setText(String.valueOf(cantidad));
}
    
    private void listarInventario() {

    DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    modelo.addColumn("ID");
    modelo.addColumn("Producto");
    modelo.addColumn("Cantidad");
    modelo.addColumn("CodProducto");

    List<Object[]> lista = controller.listarInventario();

    for (Object[] fila : lista) {
        modelo.addRow(fila);
    }

    tblInventario.setModel(modelo);

    tblInventario.getColumnModel().getColumn(3).setMinWidth(0);
    tblInventario.getColumnModel().getColumn(3).setMaxWidth(0);
    tblInventario.getColumnModel().getColumn(3).setWidth(0);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Producto = new javax.swing.JLabel();
        cbProducto = new javax.swing.JComboBox<>();
        Cantidad = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInventario = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("GESTION DE INVENTARIO");

        Producto.setText("Producto : ");

        Cantidad.setText("Cantidad : ");

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

        tblInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "PRODUCTO", "CANTIDAD"
            }
        ));
        jScrollPane1.setViewportView(tblInventario);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(Cantidad)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtCantidad))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(Producto)
                                    .addGap(18, 18, 18)
                                    .addComponent(cbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGuardar)
                                .addGap(39, 39, 39)
                                .addComponent(btnEditar)
                                .addGap(44, 44, 44)
                                .addComponent(btnEliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnNuevo)))))
                .addGap(26, 26, 26))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Producto)
                    .addComponent(cbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cantidad)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar)
                    .addComponent(btnNuevo))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
       
        String codigoProducto = cbProducto.getSelectedItem().toString();
    int cantidad = Integer.parseInt(txtCantidad.getText());

    boolean respuesta = controller.guardarInventario(codigoProducto, cantidad);

    if (respuesta) {

        JOptionPane.showMessageDialog(this, "Inventario registrado correctamente");

        listarInventario();

        btnNuevoActionPerformed(null);

    } else {

        JOptionPane.showMessageDialog(this, "Error al registrar inventario");

    }
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        
        
    if (idInventarioSeleccionado == 0) {
        JOptionPane.showMessageDialog(this, "Seleccione una fila de la tabla.");
        return;
    }

    String codigoProducto = cbProducto.getSelectedItem().toString();
    int cantidad = Integer.parseInt(txtCantidad.getText());

    boolean respuesta = controller.editarInventario(idInventarioSeleccionado, codigoProducto, cantidad);

    if (respuesta) {
        JOptionPane.showMessageDialog(this, "Inventario actualizado correctamente");
        listarInventario();
        btnNuevoActionPerformed(null);
    } else {
        JOptionPane.showMessageDialog(this, "Error al actualizar inventario");
    }
        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
       
        if (idInventarioSeleccionado == 0) {
        JOptionPane.showMessageDialog(this, "Seleccione una fila de la tabla.");
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(this,
            "¿Está seguro de eliminar este registro?", "Confirmar",
            JOptionPane.YES_NO_OPTION);

    if (confirm == JOptionPane.YES_OPTION) {
        boolean respuesta = controller.eliminarInventario(idInventarioSeleccionado);

        if (respuesta) {
            JOptionPane.showMessageDialog(this, "Registro eliminado correctamente");
            listarInventario();
            btnNuevoActionPerformed(null);
        } else {
            JOptionPane.showMessageDialog(this, "Error al eliminar el registro");
        }
    }
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
     
        idInventarioSeleccionado = 0;
    cbProducto.setSelectedIndex(0);
    txtCantidad.setText("");
    tblInventario.clearSelection();
        
    }//GEN-LAST:event_btnNuevoActionPerformed

    
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(() -> new FrmInventario().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cantidad;
    private javax.swing.JLabel Producto;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cbProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblInventario;
    private javax.swing.JTextField txtCantidad;
    // End of variables declaration//GEN-END:variables
}
