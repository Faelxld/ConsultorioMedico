/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.controllers;

import com.web.beans.Consulta;
import com.web.dao.ConsultaDao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alunoces
 */
@WebServlet(name = "ServletListaConsulta", urlPatterns = {"/ServletListaConsulta"})
public class ServletListarConsulta extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
 
        ConsultaDao dao = new ConsultaDao();
        
        ResultSet rs  = dao.ListarConsulta(request.getParameter("cpf"));
        
       ArrayList<Consulta> result = new ArrayList<Consulta>();
 
       while (rs.next()) {
         Consulta consulta = new Consulta();
         consulta.setPaciente(rs.getString(1));
         consulta.setMedico(rs.getString(2));
         consulta.setTipo(rs.getString(3));
         consulta.setData(rs.getString(4));
         consulta.setHoraInicial(rs.getString(5));
         consulta.setHoraFinal(rs.getString(6));
         consulta.setObservacoes(rs.getString(7));
         result.add(consulta);
         
          
        }
        
        request.setAttribute("lista",result);  
        RequestDispatcher rd = request.getRequestDispatcher("/historico.jsp");
        rd.forward(request, response);
        
      
     
    }
     
     


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
             processRequest(request, response);
         } catch (SQLException ex) {
             Logger.getLogger(ServletListarConsulta.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
             processRequest(request, response);
         } catch (SQLException ex) {
             Logger.getLogger(ServletListarConsulta.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
