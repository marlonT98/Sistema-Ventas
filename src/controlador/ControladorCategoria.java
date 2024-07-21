package controlador;

import java.sql.*;
import conexion.Conexion;
import modelo.Categoria;

public class ControladorCategoria {

    //metodo para registrar una categoria
    public boolean guardar(Categoria objeto) {

        boolean respuesta = false;
        Connection cn = Conexion.conectar();

        try {

            PreparedStatement consulta = cn.prepareStatement("insert into tb_categoria values(?,?,?)");
            consulta.setInt(1, 0);
            consulta.setString(2, objeto.getDescripcion());
            consulta.setInt(3, objeto.getEstado());

            //ose si se ejecutor nos devuelve 1 que es mayor que cero
            if (consulta.executeUpdate() > 0) {

                respuesta = true;
            }

            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al guardar categoria: " + e);
        }

        return respuesta;

    }

    //metodo para consultar si existe ya esa categoria
    public boolean existeCategoria(String categoria) {

        boolean respuesta = false;

        String sql = "select descripcion from tb_categoria where descripcion='"+categoria+"'";
        Statement st;

        try {

            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            //miestras el resultado sea el siguiente
            while (rs.next()) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar categoria: " + e);
        }

        return respuesta;

    }

}
