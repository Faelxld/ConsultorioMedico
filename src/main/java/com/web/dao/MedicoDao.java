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

import com.web.beans.Medico;
import jdbc.ConnectionFactory;

/**
 *
 * @author Igor
 */
public class MedicoDao {
    private Connection cn;
    
    public MedicoDao() {
        this.cn = new ConnectionFactory().connect();
    }
    
    public Medico EfetuarLogin(String cpf, String senha) throws SQLException {
        String query = " select * from medico where cpf=? and senha=? ";
        PreparedStatement stmt = cn.prepareStatement(query);

        stmt.setString(1, cpf);
        stmt.setString(2, senha);

        ResultSet rs = stmt.executeQuery();

        Medico medico = null;
        if (rs.next()) {
            medico = new Medico();
            medico.setCpf(rs.getString("cpf"));
            medico.setNome(rs.getString("nome"));
        }

        stmt.close();
        return medico;
    }
    
}
