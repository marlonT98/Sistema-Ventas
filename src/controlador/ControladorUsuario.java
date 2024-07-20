package controlador;

import conexion.Conexion;
import modelo.Usuario;
import java.sql.*;
import javax.swing.JOptionPane;

public class ControladorUsuario {

    //metodo paraq iniciar sesion
    public boolean loginUser(Usuario objeto) {

        boolean respuesta = false;

        Connection cn = Conexion.conectar();
        String sql = "select usuario , password from tb_usuarios where usuario ='" + objeto.getUsuario() + "'  and password ='" + objeto.getPassword() + "'";
        Statement st;
        try {

            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {  //si existe el usuario cambiamos a true              

                respuesta = true;

            }

        } catch (SQLException e) {

            System.out.println("Error al iniciar sesion: " + e);
            JOptionPane.showMessageDialog(null, "Error al iniciar sesion");
        }
        
        
        return  respuesta;

    }

}
