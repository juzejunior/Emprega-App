package model;

import java.util.ArrayList;

/**
 * Created by junio on 12/08/2017.
 */

public class Vagas {
    private String CBO;
    private String Escolaridade;
    private String Ocupacao;
    private String bairro;
    private String beneficios;
    private String cidade;
    private String descricao;
    private String habilitacao;
    private String horaririoDeTrabalho;
    private String idEmpresa;
    private ArrayList<Interesse> mInteresses = new ArrayList<>();
    private String logradouro;
    private String nomeDaEmpresa;
    private String quantidadeDeVagas;
    private String quantidadeMaximaDeEncaminhamentos;
    private String referencia;
    private String salario;
    private String tempoExperiencia;
    private String vagaId;

    public Vagas(String CBO, String escolaridade, String ocupacao, String bairro, String beneficios,
                 String cidade, String descricao, String habilitacao, String horaririoDeTrabalho,
                 String idEmpresa, ArrayList<Interesse> mInteresses, String logradouro,
                 String nomeDaEmpresa, String quantidadeDeVagas,
                 String quantidadeMaximaDeEncaminhamentos, String referencia,
                 String salario, String tempoExperiencia) {
        this.CBO = CBO;
        Escolaridade = escolaridade;
        Ocupacao = ocupacao;
        this.bairro = bairro;
        this.beneficios = beneficios;
        this.cidade = cidade;
        this.descricao = descricao;
        this.habilitacao = habilitacao;
        this.horaririoDeTrabalho = horaririoDeTrabalho;
        this.idEmpresa = idEmpresa;
        this.mInteresses = mInteresses;
        this.logradouro = logradouro;
        this.nomeDaEmpresa = nomeDaEmpresa;
        this.quantidadeDeVagas = quantidadeDeVagas;
        this.quantidadeMaximaDeEncaminhamentos = quantidadeMaximaDeEncaminhamentos;
        this.referencia = referencia;
        this.salario = salario;
        this.tempoExperiencia = tempoExperiencia;
    }

    public Vagas(){}

    public String getCBO() {
        return CBO;
    }

    public void setCBO(String CBO) {
        this.CBO = CBO;
    }

    public String getEscolaridade() {
        return Escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        Escolaridade = escolaridade;
    }

    public String getOcupacao() {
        return Ocupacao;
    }

    public void setOcupacao(String ocupacao) {
        Ocupacao = ocupacao;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getHabilitacao() {
        return habilitacao;
    }

    public void setHabilitacao(String habilitacao) {
        this.habilitacao = habilitacao;
    }

    public String getHoraririoDeTrabalho() {
        return horaririoDeTrabalho;
    }

    public void setHoraririoDeTrabalho(String horaririoDeTrabalho) {
        this.horaririoDeTrabalho = horaririoDeTrabalho;
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public ArrayList<Interesse> getmInteresses() {
        return mInteresses;
    }

    public void setmInteresses(ArrayList<Interesse> mInteresses) {
        this.mInteresses = mInteresses;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNomeDaEmpresa() {
        return nomeDaEmpresa;
    }

    public void setNomeDaEmpresa(String nomeDaEmpresa) {
        this.nomeDaEmpresa = nomeDaEmpresa;
    }

    public String getQuantidadeDeVagas() {
        return quantidadeDeVagas;
    }

    public void setQuantidadeDeVagas(String quantidadeDeVagas) {
        this.quantidadeDeVagas = quantidadeDeVagas;
    }

    public String getQuantidadeMaximaDeEncaminhamentos() {
        return quantidadeMaximaDeEncaminhamentos;
    }

    public void setQuantidadeMaximaDeEncaminhamentos(String quantidadeMaximaDeEncaminhamentos) {
        this.quantidadeMaximaDeEncaminhamentos = quantidadeMaximaDeEncaminhamentos;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getTempoExperiencia() {
        return tempoExperiencia;
    }

    public void setTempoExperiencia(String tempoExperiencia) {
        this.tempoExperiencia = tempoExperiencia;
    }

    public String getVagaId() {
        return vagaId;
    }

    public void setVagaId(String vagaId) {
        this.vagaId = vagaId;
    }
}
