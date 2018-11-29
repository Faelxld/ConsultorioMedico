/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.dao;

import com.web.beans.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lucas
 */
public class FuncionarioDao {
    private Connection cn;
    
    public Funcionario EfetuarLogin(String login, String senha) throws SQLException {
        String query = " select * from funcionario where login=? and senha=? ";
        PreparedStatement stmt = cn.prepareStatement(query);

        stmt.setString(1, login);
        stmt.setString(2, senha);

        ResultSet rs = stmt.executeQuery();
        
        Funcionario funcionario = null;
        if (rs.next()) {
            funcionario = new Funcionario();
            funcionario.setCodigo(rs.getInt("codigo"));
            funcionario.setNome(rs.getString("nome"));
            funcionario.setLogin(rs.getString("login"));
            funcionario.setSenha(rs.getString("senha"));
        }
        
        stmt.close();
        return funcionario;
    }
    
}
