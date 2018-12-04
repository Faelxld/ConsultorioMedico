package com.web.consultoriomedico.dto;

import com.web.consultoriomedico.model.Consulta;
import com.web.consultoriomedico.model.Medico;
import com.web.consultoriomedico.model.Paciente;

import javax.persistence.*;
import java.util.Date;

public class ConsultaDTO {
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

    public ConsultaDTO() {
    }

    public ConsultaDTO(Integer codigo) {
        this.codigo = codigo;
    }

    public ConsultaDTO(Consulta obj) {
        this.codigo = obj.getCodigo();
        this.tipo = obj.getTipo();
        this.data = obj.getData();
        this.horaInicial = obj.getHoraInicial();
        this.horaFinal = obj.getHoraFinal();
        this.observacoes = obj.getObservacoes();
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
        ConsultaDTO other = (ConsultaDTO) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.igor.mavenproject1.Consulta[ codigo=" + codigo + " ]";
    }

}
