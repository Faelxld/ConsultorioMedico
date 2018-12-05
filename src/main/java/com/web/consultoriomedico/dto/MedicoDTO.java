package com.web.consultoriomedico.dto;

import com.web.consultoriomedico.model.Consulta;
import com.web.consultoriomedico.model.Medico;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

public class MedicoDTO {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "cpf")
    private String cpf;
    @Basic(optional = false)
    @Column(name = "especialidade")
    private String especialidade;
    @Basic(optional = false)
    @Column(name = "CRM")
    private String crm;
    @Basic(optional = false)
    @Column(name = "senha")
    private String senha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codMedico")
    private List<Consulta> consultaList;

    public MedicoDTO() {
    }

    public MedicoDTO(Integer codigo) {
        this.codigo = codigo;
    }

    public MedicoDTO(Medico obj) {
        this.codigo        = obj.getCodigo();
        this.nome          = obj.getNome();
        this.cpf           = obj.getCpf();
        this.especialidade = obj.getEspecialidade();
        this.crm           = obj.getCrm();
        this.senha         = obj.getSenha();
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

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
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
        hash    += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medico)) {
            return false;
        }
        MedicoDTO other = (MedicoDTO) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[codigo=" + codigo + " ]";
    }
}
