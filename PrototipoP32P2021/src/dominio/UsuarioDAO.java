package dominio;


import datos.Conexion;
import datos.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author OtakuGT
 */
public class UsuarioDAO extends Conexion {

    private static final String SQL_SELECT = "SELECT  * FROM usuario";
    private static final String SQL_INSERT = "INSERT INTO  usuario(Nombre, contraseña) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE usuario SET   contraseña=?,   WHERE Nombre =?";
    private static final String SQL_DELETE = "DELETE FROM usuario WHERE nombre=?";
    private static final String SQL_QUERY = "SELECT nombre, contraseña  FROM usuario WHERE nombre = ?";

    Conexion conectar = new Conexion();
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
  
    public List<Usuario> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;
        List<Usuario> usuarios = new ArrayList<Usuario>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
             
                String nombre = rs.getString("Nombre");
               
                String pass = rs.getString("contraseña");
            

                usuario = new Usuario();
             
                usuario.setNombre_usuario(nombre);
              
                usuario.setPassword_usuario(pass);
             

                usuarios.add(usuario);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return usuarios;
    }

    public Usuario query(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, usuario.getNombre_usuario());
            rs = stmt.executeQuery();
            while (rs.next()) {
              
                String nombre_usuario = rs.getString("Nombre");
              
                String password_usuario = rs.getString("contraseña");
             

                usuario = new Usuario();
              ;
                usuario.setNombre_usuario(nombre_usuario);
            
                usuario.setPassword_usuario(password_usuario);
           

                rows++;
            }
            System.out.println("Registros buscado:" + usuario);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return usuario;
    }

    public int delete(Usuario usuario) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, usuario.getNombre_usuario());
            rows = stmt.executeUpdate();
            //System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int update(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
        
            stmt.setString(1, usuario.getNombre_usuario());
           
            stmt.setString(2, usuario.getPassword_usuario());
           
         
            rows = stmt.executeUpdate();
            //System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int insert(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
        
            stmt.setString(1, usuario.getNombre_usuario());
         
            stmt.setString(2, usuario.getPassword_usuario());
         
            stmt.executeUpdate();
        } catch (Exception ex) {
            System.err.println(ex);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return 1;
    }

   
}