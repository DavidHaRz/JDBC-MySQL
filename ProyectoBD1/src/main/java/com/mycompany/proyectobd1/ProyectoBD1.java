/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectobd1;


import java.sql.*;

/**
 *
 * @author David
 */
public class ProyectoBD1 {
        //Datos de conexión a la base de datos
        static final String DB_URL = "jdbc:mysql://localhost:3306/jcvd";    //jdbc:mysql://ip:puerto/base_datos
        static final String USER = "david";
        static final String PASS = "1234";
        static final String QUERY = "SELECT * FROM videojuegos";
        static final String QUERY2 = "INSERT INTO `videojuegos` (`id`, `Nombre`, `Categoría`, `FechaLanzamiento`, `Compañía`, `Precio`) VALUES (NULL, 'Minecraft', 'Mundo Abierto', '2009-05-17', 'Mojang Studios', '0')";
        static final String QUERY3 = "DELETE FROM `videojuegos` WHERE id = 7";

    public static void main(String[] args) throws SQLException {
        //Abre la conexión
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(QUERY);){
            //Extrae la información del set de resultados
            while (rs.next()){
                //Obtiene la información según el nombre de la columna
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", Nombre: " + rs.getString("Nombre"));
                System.out.print(", Categoría: " + rs.getString("Categoría"));
                System.out.print(", FechaLanzamiento: " + rs.getDate("FechaLanzamiento"));
                System.out.print(", Compañía: " + rs.getString("Compañía"));
                System.out.println(", Precio: " + rs.getFloat("Precio"));                
            }
            
            //Insertar un nuevo juego
            //stmt.executeUpdate(QUERY2);
            
            //Borrar un juego
            //stmt.executeUpdate(QUERY3);

            stmt.close();
            
       } catch (SQLException e){
           e.printStackTrace();
       }
    }
}
