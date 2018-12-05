/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.consultoriomedico.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Igor
 */
@Entity
@Table(name = "consulta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consulta.findAll", query = "SELECT c FROM Consulta c"),
    @NamedQuery(name = "Consulta.findByCodigo", query = "SELECT c FROM Consulta c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "Consulta.findByTipo", query = "SELECT c FROM Consulta c WHERE c.tipo = :tipo"),
    @NamedQuery(name = "Consulta.findByData", query = "SELECT c FROM Consulta c WHERE c.data = :data"),
    @NamedQuery(name = "Consulta.findByHoraInicial", query = "SELECT c FROM Consulta c WHERE c.horaInicial = :horaInicial"),
    @NamedQuery(name = "Consulta.findByHoraFinal", query = "SELECT c FROM Consulta c WHERE c.horaFinal = :horaFinal"),
    @NamedQuery(name = "Consulta.findByObservacoes", query = "SELECT c FROM Consulta c WHERE c.observacoes = :observacoes")})
public class Consulta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Basic(optional = false)
    @Column(name = "hora_inicial")
    @Temporal(TemporalType.TIME)
    private Date horaInicial;
    @Basic(optional = false)
    @Column(name = "hora_final")
    @Temporal(TemporalType.TIME)
    private Date horaFinal;
    @Basic(optional = false)
    @Column(name = "observacoes")
    private String observacoes;
    @JoinColumn(name = "cod_medico", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Medico codMedico;
    @JoinColumn(name = "cod_paciente", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Paciente codPaciente;

    public Consulta() {
    }

    public Consulta(Integer codigo) {
        this.codigo = codigo;
    }

    public Consulta(Integer codigo, String tipo, Date data, Date horaInicial, Date horaFinal, String observacoes) {
        this.codigo      = codigo;
        this.tipo        = tipo;
        this.data        = data;
        this.horaInicial = horaInicial;
        this.horaFinal   = horaFinal;
        this.observacoes = observacoes;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(Date horaInicial) {
        this.horaInicial = horaInicial;
    }

    public Date getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Date horaFinal) {
        this.horaFinal = horaFinal;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Medico getCodMedico() {
        return codMedico;
    }

    public void setCodMedico(Medico codMedico) {
        this.codMedico = codMedico;
    }

    public Paciente getCodPaciente() {
        return codPaciente;
    }

    public void setCodPaciente(Paciente codPaciente) {
        this.codPaciente = codPaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consulta)) {
            return false;
        }
        Consulta other = (Consulta) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ codigo=" + codigo + " ]";
    }
}
