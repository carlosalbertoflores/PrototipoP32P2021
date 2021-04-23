
package datos;
import java.sql.Date;
/**
 *
 * @author Diego Vásquez
 */

/**
 *
 * @author 9959/19/186
 */
public class Usuario {
  
    private String nombre_usuario;
 
    private String password_usuario;

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getPassword_usuario() {
        return password_usuario;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre_usuario=" + nombre_usuario + ", password_usuario=" + password_usuario + '}';
    }

    public void setPassword_usuario(String password_usuario) {
        this.password_usuario = password_usuario;
    }
  
    
  
}
