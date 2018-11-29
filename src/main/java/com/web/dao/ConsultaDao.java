/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.web.beans.Consulta;
import jdbc.ConnectionFactory;

/**
 *
 * @author Lucas
 */
public class ConsultaDao {
    private Connection cn;

    public ConsultaDao() {
        this.cn = new ConnectionFactory().connect();
    }
    
    public void cadastrarConsulta(Consulta consulta) throws SQLException
    {
        String query = 
                " insert into consulta " + 
                "(cod_paciente, cod_medico, tipo, data, hora_inicial, hora_final, observacoes) " + 
                "values (?, ?, ?, ?, ?, ?, ?) ";
        
        PreparedStatement stmt = null;

            stmt = cn.prepareStatement(query);

            stmt.setString(1, consulta.getPaciente());
            stmt.setString(2, consulta.getMedico());
            stmt.setString(3, consulta.getTipo());
            stmt.setString(4, consulta.getData());
            stmt.setString(5, consulta.getHoraInicial());
            stmt.setString(6, consulta.getHoraFinal());
            stmt.setString(7, consulta.getObservacoes());
            stmt.execute();
            stmt.close();


    }
 
      public ResultSet listarConsulta(String cpf) throws SQLException
    {
        ResultSet rs;
        String query = 
                "select * from consulta "
                + "inner join paciente on paciente.id == consulta.idPaciente " 
                + "where paciente.cpf = ? ";
          
        PreparedStatement stmt = cn.prepareStatement(query);
        
        
        
        stmt.setString(1, cpf);
       
       rs =  stmt.executeQuery();
       stmt.close();
       
       
       
        return rs;
    }
    
    public boolean validarConsulta(Consulta consulta) throws SQLException {
        String query =
                "select * from consulta "
                        + "where cod_medico = ? and hora_inicial = ? and hora_final=? and data = ? ";
        PreparedStatement stmt = null;

        try {
            stmt = cn.prepareStatement(query);
            stmt.setString(1, consulta.getMedico());
            stmt.setString(2, consulta.getHoraInicial());
            stmt.setString(3, consulta.getHoraFinal());
            stmt.setString(4, consulta.getData());

            ResultSet rs = stmt.executeQuery();

            boolean status = false;

            if (!rs.next()) {
                status = true;
                cadastrarConsulta(consulta);
            }

            return status;
        }catch (SQLException ex){
            return false;
        }
    }



    
}
