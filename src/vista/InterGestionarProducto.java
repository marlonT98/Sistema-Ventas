package vista;

import conexion.Conexion;
import controlador.ControladorProducto;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Producto;

public class InterGestionarProducto extends javax.swing.JInternalFrame {
    
    private int idProducto;
    int obtenerIdCategoriaCombo = 0;
    
    public InterGestionarProducto() {
        initComponents();
        this.setSize(new Dimension(900, 500));
        this.setTitle("Gestionar productos");
        //cargar tabla de categorias
        this.cargarTablaProductos();
        this.cargarComboCategorias();

        //insertar imagen en nuestro jLabel
        ImageIcon wallpaper = new ImageIcon("src/img/fondo3.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(900, 500, WIDTH));
        jLabel_wallpaper.setIcon(icono);
        this.repaint();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_productos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton_actualizar = new javax.swing.JButton();
        jButton_eliminar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jComboBox_categoria = new javax.swing.JComboBox<>();
        jComboBox_iva = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_precio = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        txt_cantidad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_descripcion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Administrar Productos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_productos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable_productos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 710, 250));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 730, 270));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton_actualizar.setBackground(new java.awt.Color(51, 204, 0));
        jButton_actualizar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton_actualizar.setText("Actualizar");
        jButton_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_actualizarActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jButton_eliminar.setBackground(new java.awt.Color(255, 51, 51));
        jButton_eliminar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton_eliminar.setText("Eliminar");
        jButton_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminarActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 90, 20));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 50, 130, 270));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox_categoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione categoria:", "1", "2", "3" }));
        jPanel3.add(jComboBox_categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 40, 170, -1));

        jComboBox_iva.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione iva:", "No grava iva", "12%", "14%" }));
        jPanel3.add(jComboBox_iva, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, 170, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Cantidad:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 70, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Precio:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 60, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Categoria: ");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, 80, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Nombre:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, -1));
        jPanel3.add(txt_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 190, -1));
        jPanel3.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 200, -1));

        txt_cantidad.setEnabled(false);
        jPanel3.add(txt_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 200, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Descripcion:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 90, -1));
        jPanel3.add(txt_descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, 190, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("IVA:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, 50, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 870, 100));
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -20, 900, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_actualizarActionPerformed

         //instanciamos
        Producto producto = new Producto();
        ControladorProducto controladorProducto = new ControladorProducto();

        //variables seleccionables (combo box)
        String iva = "";
        String categoria = "";

        //asignamos lo que tenga seleccionado
        iva = jComboBox_iva.getSelectedItem().toString().trim();
        categoria = jComboBox_categoria.getSelectedItem().toString().trim();

        //validar campos
        if (txt_nombre.getText().isEmpty() || txt_cantidad.getText().isEmpty()
                || txt_precio.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Complete todos los campos");
            txt_nombre.setBackground(Color.red);
            txt_cantidad.setBackground(Color.red);
            txt_precio.setBackground(Color.red);
            txt_descripcion.setBackground(Color.red);

        } else {


                //si iva es igual a este texto
                if (iva.equalsIgnoreCase("Seleccione iva:")) {

                    JOptionPane.showMessageDialog(null, "Seleccione iva");

                } else {

                    if (categoria.equalsIgnoreCase("Seleccione categoria:")) {

                        JOptionPane.showMessageDialog(null, "Seleccione categoria");
                    } else {

                        try {
                            producto.setNombre(txt_nombre.getText().trim());
                            producto.setCantidad(Integer.parseInt(txt_cantidad.getText().trim()));

                            String precioTxt = "";
                            double precio = 0.0;

                            precioTxt = txt_precio.getText().trim();
                            boolean aux = false;

                            //si el usuario ingresa ,(coma ) como punto decimal,
                            //lo transformamos a punto
                            for (int i = 0; i < precioTxt.length(); i++) {
                                if (precioTxt.charAt(i) == ',') {

                                    String precioNuevo = precioTxt.replace(",", ".");
                                    precio = Double.parseDouble(precioNuevo);
                                    aux = true;
                                }

                            }
                            //evaluar la condicion
                            if (aux) {
                                producto.setPrecio(precio);
                            } else {
                                precio = Double.parseDouble(precioTxt);
                                producto.setPrecio(precio);

                            }

                            producto.setDescripcion(txt_descripcion.getText().trim());

                            //porcentaje de iva
                            if (iva.equalsIgnoreCase("No grava iva")) {
                                producto.setPorcentajeIva(0);
                            } else if (iva.equalsIgnoreCase("12%")) {
                                producto.setPorcentajeIva(12);
                            } else if (iva.equalsIgnoreCase("14")) {
                                producto.setPorcentajeIva(14);
                            }

                            //enviar el id de la categoria - cargar un metodo que obtiene el 
                            //id de la categoria
                            //esto es para que nos cargue esa variable que estamos pasando
                            this.idCategoria();
                            producto.setIdCategoria(obtenerIdCategoriaCombo);

                            producto.setEstado(1);

                            if (controladorProducto.actualizar(producto , idProducto)) {

                                JOptionPane.showMessageDialog(null, "Registro Actualizado");
                                this.cargarComboCategorias();//para que se quede como antes
                                this.cargarTablaProductos();
                                this.jComboBox_iva.setSelectedItem("Seleccione iva:");//al inicio
                                this.limpiar();

                            } else {
                                JOptionPane.showMessageDialog(null, "Error al actualizar");
                            }

                        } catch (HeadlessException | NumberFormatException e) {
                            System.out.println("error en  = " + e);

                        }
                    }

                }



        }



    }//GEN-LAST:event_jButton_actualizarActionPerformed

    private void jButton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminarActionPerformed
        
        ControladorProducto controladorProducto = new ControladorProducto();
        if (idProducto == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un  producto");
        } else {
            if (controladorProducto.eliminar(idProducto)) {
                
                JOptionPane.showMessageDialog(null, "Producto eliminado");
                //se ejecutaran una vez mas
                this.cargarTablaProductos();
                this.cargarComboCategorias();

                //limpiamos los campos
                this.limpiar();
                
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar  producto");
            }
            
        }
        

    }//GEN-LAST:event_jButton_eliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_actualizar;
    private javax.swing.JButton jButton_eliminar;
    private javax.swing.JComboBox<String> jComboBox_categoria;
    private javax.swing.JComboBox<String> jComboBox_iva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_productos;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_descripcion;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_precio;
    // End of variables declaration//GEN-END:variables

    /*
            ---metodo para limpiar---
    
     */
    public void limpiar() {

        //receteamos los campos
        txt_nombre.setText("");
        txt_cantidad.setText("");
        txt_precio.setText("");
        txt_descripcion.setText("");
        jComboBox_iva.setSelectedItem("Seleccione iva:");
        jComboBox_categoria.setSelectedItem("Seleccione categoria:");
        
    }

    /*
    
            ---metodo para cragar las categorias en el jComboBox---
    
     */
    private void cargarComboCategorias() {
        
        Connection cn = Conexion.conectar();
        String sql = "select * from tb_categoria";
        Statement st;
        
        try {
            
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            jComboBox_categoria.removeAllItems();
            jComboBox_categoria.addItem("Seleccione categoria:");
            while (rs.next()) {
                
                jComboBox_categoria.addItem(rs.getString("descripcion"));
                
            }
            
        } catch (SQLException e) {
            
            System.out.println("error al cargar categorias = " + e);
        }
        
    }

    /*
    metodo para mostrar todos los productos registrados
     */
    String descripcionCategoria = "";
    double precio = 0.0;
    int porcentajeIva = 0;
    double IVA = 0.0;
    
    private void cargarTablaProductos() {
        
        Connection con = Conexion.conectar();
        DefaultTableModel model = new DefaultTableModel();
        String sql = "select p.idProducto , p.nombre ,p.cantidad, p.precio, p.descripcion , p.porcentajeIva , p.idCategoria , p.estado from tb_producto as p ,  tb_categoria as c where p.idCategoria = c.idCategorias";
        Statement st;
        
        try {
            
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            InterGestionarProducto.jTable_productos = new JTable(model);
            InterGestionarProducto.jScrollPane1.setViewportView(InterGestionarProducto.jTable_productos);
            
            model.addColumn("Nº");//id
            model.addColumn("nombre");
            model.addColumn("cantidad");
            model.addColumn("precio");
            model.addColumn("descripcion");
            model.addColumn("iva");
            model.addColumn("categoria");
            model.addColumn("estado");
            
            while (rs.next()) {
                precio = rs.getDouble("precio");
                porcentajeIva = rs.getInt("porcentajeIva");
                
                Object fila[] = new Object[8];
                
                for (int i = 0; i < 8; i++) {
                    
                    if (i == 5) {
                        
                        this.calcularIva(precio, porcentajeIva);
                        fila[i] = IVA;
                        rs.getObject(i + 1);
                        
                    } else {
                        
                        fila[i] = rs.getObject(i + 1);
                        
                    }
                    
                }
                model.addRow(fila);
            }
            
            con.close();
            
        } catch (SQLException e) {
            
            System.out.println("Error al llenar la tabla productos: " + e);
            
        }

        //esto es cuando pasamos el mause por esa celda
        jTable_productos.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                
                int fila_point = jTable_productos.rowAtPoint(e.getPoint());
                int columna_point = 0;
                
                if (fila_point > -1) {
                    idProducto = (int) model.getValueAt(fila_point, columna_point);
                    enviarDatosProductoSeleccionado(idProducto);
                }
            }
            
        });
        
    }
    
    private double calcularIva(double precio, int iva) {
        
        int p_iva = iva;
        
        switch (p_iva) {
            case 0:
                IVA = 0.0;                
                break;
            case 12:
                IVA = precio * 0.12;
                break;
            case 14:
                IVA = precio * 0.14;
                break;
            
            default:
            
        }

        //redondear los decimales
        IVA = (double) Math.round(IVA * 100) / 100;//con solo dos decimales
        
        return IVA;
        
    }

    //metodo que envia datos seleccionados en los txt
    public void enviarDatosProductoSeleccionado(int idProducto) {
        
        try {
            //hacemos la conexion a nuestra bdd local
            Connection con = Conexion.conectar();
            //creamos la sentencia sql buscamos idCategoria por su id
            PreparedStatement pst = con.prepareStatement(
                    "select * from tb_producto where idProducto = '" + idProducto + "'");

            //ejecutamos la consulta
            ResultSet rs = pst.executeQuery();

            //si existe tal consulta enviamos a nuestro txt
            if (rs.next()) {
                txt_nombre.setText(rs.getString("nombre"));
                txt_cantidad.setText(rs.getString("cantidad"));
                txt_precio.setText(rs.getString("precio"));
                txt_descripcion.setText(rs.getString("descripcion"));
                int iva = rs.getInt("porcentajeIva");
                switch (iva) {
                    case 0:
                        jComboBox_iva.setSelectedItem("No grava iva");
                        break;
                    case 12:
                        jComboBox_iva.setSelectedItem("12%");
                        break;
                    case 14:
                        jComboBox_iva.setSelectedItem("14%");
                        break;
                    
                    default:
                    
                }
                
                int idCate = rs.getInt("idCategoria");
                jComboBox_categoria.setSelectedItem(relacionarCategoria(idCate));
                
            }

            //cerramos la conexion
            con.close();
            
        } catch (SQLException e) {
            
            System.out.println("Error al seleccionar producto: " + e);
        }
        
    }

    //metodo para relacionar categorias
    private String relacionarCategoria(int idCategoria) {
        
        String sql = "select  descripcion from  tb_categoria where idCategorias= '" + idCategoria + "'";
        Statement st;
        
        try {
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                
                descripcionCategoria = rs.getString("descripcion");
                
            }
            
        } catch (SQLException e) {
            
            System.out.println("error al obtner el id de la categoria= " + e);
        }
        
        return descripcionCategoria;
        
    
    }
    
    
        //2.-Metodo para obtner el id de la categoria
    private int idCategoria() {

        String sql = "select * from tb_categoria  where descripcion ='" + this.jComboBox_categoria.getSelectedItem() + "'";

        Statement st;

        try {

            Connection con = Conexion.conectar();
            st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                obtenerIdCategoriaCombo = rs.getInt("idCategorias");

            }

        } catch (SQLException e) {

            System.out.println("Error al obtener el id de la categoria: " + e);
        }

        return obtenerIdCategoriaCombo;

    }
    
    
    
    
    
}
