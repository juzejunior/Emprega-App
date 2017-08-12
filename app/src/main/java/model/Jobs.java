package model;

/**
 * Created by junio on 11/08/2017.
 */

public class Jobs {
    private String cargo, empresa, situacao;
    private float salario;

    public Jobs(String cargo, String empresa, String situacao, float salario) {
        this.cargo = cargo;
        this.empresa = empresa;
        this.situacao = situacao;
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
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

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
}
