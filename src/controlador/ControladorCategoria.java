package controlador;

import java.sql.*;
import conexion.Conexion;
import modelo.Categoria;

public class ControladorCategoria {

    //metodo para guardar una categoria
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

        String sql = "select descripcion from tb_categoria where descripcion='" + categoria + "'";
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

    //****metodo para actualizar una categoria***
    public boolean actualizar(Categoria objeto, int idCategoria) {

        boolean respuesta = false;
        Connection cn = Conexion.conectar();

        try {

            PreparedStatement consulta = cn.prepareStatement(
                    "update tb_categoria set descripcion=? where idCategorias = '" + idCategoria + "'");

            consulta.setString(1, objeto.getDescripcion());

            //ose si se ejecutor nos devuelve 1 que es mayor que cero
            if (consulta.executeUpdate() > 0) {

                respuesta = true;
            }

            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al actualizar categoria: " + e);
        }

        return respuesta;

    }

    //****metodo para eliminar una categoria***
    public boolean eliminar(int idCategoria) {

        boolean respuesta = false;
        Connection cn = Conexion.conectar();

        try {

            PreparedStatement consulta = cn.prepareStatement(
                    "delete from tb_categoria where idCategorias =?");

           // Utilizar parámetros preparados para evitar inyección SQL
             consulta.setInt(1, idCategoria);

          // Ejecutar la consulta y verificar si se eliminó algún registro
            if (consulta.executeUpdate() > 0) {

                respuesta = true;
            }

            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al eliminar categoria: " + e);
        }

        return respuesta;

    }

}
