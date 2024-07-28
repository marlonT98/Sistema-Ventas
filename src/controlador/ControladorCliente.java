package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Cliente;

public class ControladorCliente {

    //***********metodo para guardar un nuevo cliente***************
    public boolean guardar(Cliente objeto) {

        boolean respuesta = false;
        Connection cn = Conexion.conectar();

        try {

            PreparedStatement consulta = cn.prepareStatement("insert into tb_cliente values(?,?,?,?,?,?,?)");
            consulta.setInt(1, 0);//id
            consulta.setString(2, objeto.getNombre());
            consulta.setString(3, objeto.getApellido());
            consulta.setString(4, objeto.getCedula());
            consulta.setString(5, objeto.getTelefono());
            consulta.setString(6, objeto.getDireccion());
            consulta.setInt(7, objeto.getEstado());

            //ose si se ejecutor nos devuelve 1 que es mayor que cero
            if (consulta.executeUpdate() > 0) {

                respuesta = true;
            }

            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al guardar cliente: " + e);
        }

        return respuesta;

    }

    //***************metodo para consultar si el producto ya existe en la bdd************
    public boolean existeCliente(String cedula) {

        boolean respuesta = false;

        String sql = "select cedula from tb_cliente where cedula='" + cedula + "'";
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
            System.out.println("Error al consultar cliente: " + e);
        }

        return respuesta;

    }

    //****metodo para actualizar un cliente***
    public boolean actualizar(Cliente objeto, int idCliente) {

        boolean respuesta = false;
        Connection cn = Conexion.conectar();

        try {

            PreparedStatement consulta = cn.prepareStatement(
                    "update tb_cliente set nombre=? , apellido=? ,  cedula=? , telefono=? , direccion=?,estado=?  where idCliente = '" + idCliente + "'");

            consulta.setString(1, objeto.getNombre());
            consulta.setString(2, objeto.getApellido());
            consulta.setString(3, objeto.getCedula());
            consulta.setString(4, objeto.getTelefono());
            consulta.setString(5, objeto.getDireccion());
            consulta.setInt(6, objeto.getEstado());
           

            //ose si se ejecutor nos devuelve 1 que es mayor que cero
            if (consulta.executeUpdate() > 0) {

                respuesta = true;
            }

            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al actualizar cliente: " + e);
        }

        return respuesta;

    }

    //****metodo para eliminar un cliente***
    public boolean eliminar(int idCliente) {

        boolean respuesta = false;
        Connection cn = Conexion.conectar();

        try {

            PreparedStatement consulta = cn.prepareStatement("delete from tb_cliente where idCliente=?");

            // Utilizar parámetros preparados para evitar inyección SQL
            consulta.setInt(1, idCliente);

            // Ejecutar la consulta y verificar si se eliminó algún registro
            if (consulta.executeUpdate() > 0) {

                respuesta = true;
            }

            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al eliminar cliente: " + e);
        }

        return respuesta;

    }

}
