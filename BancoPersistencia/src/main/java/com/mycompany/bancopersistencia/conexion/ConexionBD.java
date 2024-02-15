/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author caarl
 */
public class ConexionBD implements IConexionBD {
    
    private final String cadenaConexion;
    private final String usuario;
    private final String contrasenia;
    private static final Logger LOG = Logger.getLogger(ConexionBD.class.getName());

    public ConexionBD(String cadenaConexion, String usuario, String contrasenia) {
        this.cadenaConexion = cadenaConexion;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }


    public Connection crearConexion() throws SQLException {
        Connection c = DriverManager.getConnection(cadenaConexion, usuario, contrasenia);
        LOG.log(Level.INFO, "Conexion establecida", cadenaConexion);
        return c;
        
        
    }
    
    
    
}
