package model;

/**
 * Created by junio on 11/08/2017.
 */

public class Jobs {
    private String cargo, empresa, situacao;
    private String vagaId;
    private String salario;
    private String candidatoId;

    public Jobs(String cargo, String empresa, String situacao, String salario, String vagaId) {
        this.cargo = cargo;
        this.empresa = empresa;
        this.situacao = situacao;
        this.salario = salario;
        this.vagaId = vagaId;
    }

    public Jobs(String cargo, String empresa, String situacao, String salario, String vagaId, String candidatoId) {
        this.cargo = cargo;
        this.empresa = empresa;
        this.situacao = situacao;
        this.salario = salario;
        this.vagaId = vagaId;
        this.candidatoId = candidatoId;
    }

    public String getCargo() {
        return cargo;
    }

    public String getVagaId() {
        return vagaId;
    }

    public void setVagaId(String vagaId) {
        this.vagaId = vagaId;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getCandidatoId() {
        return candidatoId;
    }

    public void setCandidatoId(String candidatoId) {
        this.candidatoId = candidatoId;
    }
}
