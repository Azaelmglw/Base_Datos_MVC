package models;

import java.sql.*;
import javax.swing.JOptionPane;
        
/**
 *
 * @author Azaelmglw
 */

public class ModelPersonas {
    private Connection sql_connection;
    private Statement sql_statement;
    private PreparedStatement sql_prepared_statement;
    private ResultSet sql_result_set;
    private String sql;
    
    private String id_persona;
    private String nombre_persona;
    private String telefono_persona;
    private String email_persona;
    
    
    public void Connect(){
        try{
            Class.forName("org.postgresql.Driver");
            sql_connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/PersonasDB", "postgres", "");
            sql_statement = sql_connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos: " + e);
        }
        catch(ClassNotFoundException f){
            JOptionPane.showMessageDialog(null, "Error: " + f);
        }
    }
    
    public void Consultar_Personas(){
        try{
            Connect();
            sql = "SELECT * FROM Personas ORDER BY PersonaID ASC";
            sql_result_set = sql_statement.executeQuery(sql);
            sql_result_set.first();
            sql_connection.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al consultar tabla Personas: " + e);
        }    
    }
    
    public void Asignar_Datos(){
        try{
            id_persona = sql_result_set.getString("PersonaID");
            nombre_persona = sql_result_set.getString("Nombre");
            telefono_persona = sql_result_set.getString("Teléfono");
            email_persona = sql_result_set.getString("Email");
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al asignar valores de la consulta: " + e);
        }
        
    }
    
    
    public void Insertar_Persona(){
        try{
            Connect();
            sql = "INSERT INTO Personas (Nombre, Teléfono, Email) VALUES(?, ?, ?);";
            sql_prepared_statement = sql_connection.prepareStatement(sql);
            sql_prepared_statement.setString(1, nombre_persona);
            sql_prepared_statement.setString(2, telefono_persona);
            sql_prepared_statement.setString(3, email_persona);
            sql_prepared_statement.executeUpdate();
            sql_connection.close();
        }
        catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Error al insertar nueva persona: " + e);
        } 
    }
    
    public void Modificar_Persona(){
       try{
           Connect();
           sql = "UPDATE Personas SET Nombre = (?), Teléfono = (?), Email = (?) WHERE PersonaID = (?);";
           sql_prepared_statement = sql_connection.prepareStatement(sql);
           sql_prepared_statement.setString(1, nombre_persona);
           sql_prepared_statement.setString(2, telefono_persona);
           sql_prepared_statement.setString(3, email_persona);
           sql_prepared_statement.setInt(4, Integer.parseInt(id_persona));
           sql_prepared_statement.executeUpdate();
           sql_connection.close();
           
       }
       catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Error al modificar persona: " + e);
       }
        
    }
    
    public void Eliminar_Persona(){
        try{
            Connect();
            sql = "DELETE FROM Personas WHERE PersonaID = (?);";
            sql_prepared_statement = sql_connection.prepareStatement(sql);
            sql_prepared_statement.setInt(1, Integer.parseInt(id_persona));
            sql_prepared_statement.executeUpdate();
            sql_connection.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al eliminar persona: " + e);
        }
    }
    
    
    public void Mover_Primero(){
        try{
            if (sql_result_set.isFirst() == false) {
                sql_result_set.first();
                Asignar_Datos();
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al Mover el cursor al primer registro: " + e);
        }
    }
    
    public void Mover_Anterior(){
        try {
            if (sql_result_set.isFirst() == false) {
                sql_result_set.previous();
                Asignar_Datos();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al Mover el cursor al primer registro: " + e);
        }
    }
    
    public void Mover_Siguiente(){
        try {
            if (sql_result_set.isLast() == false) {
                sql_result_set.next();
                Asignar_Datos();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al Mover el cursor al primer registro: " + e);
        }
    }
    
    public void Mover_Ultimo(){
        try {
            if (sql_result_set.isLast() == false) {
                sql_result_set.last();
                Asignar_Datos();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al Mover el cursor al primer registro: " + e);
        }
    }
    
    public String getID_Persona(){
        return id_persona;
    }
    
    public String getNombre_Persona(){
        return nombre_persona;
    }
    
    public String getTelefono_Persona(){
        return telefono_persona;
    }
    
    public String getEmail_Persona(){
        return email_persona;
    }
    
    public void setID_Persona(String id_persona){
        this.id_persona = id_persona;
    }
    
    public void setNombre_Persona(String nombre_persona){
        this.nombre_persona = nombre_persona;
    }
    
    public void setTelefono_Persona(String telefono_persona){
        this.telefono_persona = telefono_persona;
    }
    
    public void setEmail_Persona(String email_persona){
        this.email_persona = email_persona;
    }
}
