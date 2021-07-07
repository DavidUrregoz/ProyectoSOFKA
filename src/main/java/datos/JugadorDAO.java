
package datos;

import java.sql.*;
import static datos.Conexion.*;
import domain.Jugador;

public class JugadorDAO {

    private static final String SQL_SELECT = "SELECT id, nombre, numero_victorias, pass FROM carros_consola.ganadores";   
    private static final String SQL_INSERT = "INSERT INTO carros_consola.ganadores (nombre, numero_victorias,pass) VALUES(?,?,?)";
    private static final String SQL_UPDATE = "UPDATE carros_consola.ganadores SET   numero_victorias=?  WHERE nombre=?";
    private static final String SQL_DELETE = "DELETE FROM carros_consola.ganadores WHERE nombre=?";

    public JugadorDAO(){        
    }    
    
    public void desicion(Jugador jugador){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean bandera=false ;
        int numero_victorias=0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                int pass = rs.getInt("pass");
                if(jugador.getNombreJugador().equals(nombre) && jugador.getIdJgador()== pass){
                    bandera=true;
                    numero_victorias = rs.getInt("numero_victorias");                   
                }                
            }
            if(bandera == true){
                actualizar(jugador, numero_victorias);               
            }
            else{
                insertar(jugador);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }    
    }

    public void seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("ID, Nombre, numero de victorias");
                System.out.print(rs.getInt("id")+"  "); 
                System.out.print(rs.getString("nombre")+"  ");
                System.out.println(rs.getInt("numero_victorias"));                
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }

    public int insertar(Jugador jugador) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, jugador.getNombreJugador());            
            stmt.setInt(2, 1);
            stmt.setInt(3, jugador.getIdJgador());            
            registros = stmt.executeUpdate(); //PARA EJECUTAR SENTENCIAS DE DE ACTUALIZACIONDE BASE DE DATOS
            //ESTE METODO PUEDE EJECUTAR SENTENCIAS DE INSERT UPDATE O DELETE

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int actualizar(Jugador jugador,int n_victo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, n_victo+1);
            stmt.setString(2, jugador.getNombreJugador());
            registros = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return registros;
    }   
        public int eliminar(Jugador jugador) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, jugador.getNombreJugador());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
}

    

