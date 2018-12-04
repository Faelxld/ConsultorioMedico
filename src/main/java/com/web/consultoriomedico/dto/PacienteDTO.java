package com.web.consultoriomedico.dto;

import com.web.consultoriomedico.model.Consulta;
import com.web.consultoriomedico.model.Paciente;

import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

public class PacienteDTO {
    private static final long serialVersionUID = 1L;
    private Integer codigo;
    private String nome;
    private String cpf;
    private String senha;
    private String telefone;
    private String email;
    private List<Consulta> consultaList;

    public PacienteDTO() {
    }

    public PacienteDTO(Integer codigo) {
        this.codigo = codigo;
    }

    public PacienteDTO(Paciente obj) {
        this.codigo = obj.getCodigo();
        this.nome = obj.getNome();
        this.cpf = obj.getCpf();
        this.telefone = obj.getTelefone();
        this.email = obj.getEmail();
        this.senha = obj.getSenha();
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @XmlTransient
    public List<Consulta> getConsultaList() {
        return consultaList;
    }

    public void setConsultaList(List<Consulta> consultaList) {
        this.consultaList = consultaList;
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
        if (!(object instanceof Paciente)) {
            return false;
        }
        PacienteDTO other = (PacienteDTO) object;
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
