package model;

/**
 * Created by junio on 11/08/2017.
 */

public class Candidato {

    private String bairro;
    private String cep;
    private String cpf;
    private String curso;
    private String dataNascimento;
    private String email;
    private String endereco;
    private String escolaridade;
    private String estado;
    private String userID;
    //experiencia
    //interesses
    //idiomas
    private String municipio;
    private String nome;
    private int numeroId;
    private String raca;

    public Candidato(){}

    public Candidato(String bairro, String cep, String cpf, String curso, String dataNascimento,
                     String email, String endereco, String escolaridade, String estado,
                     String municipio, String nome, int numeroId, String raca) {
        this.bairro = bairro;
        this.cep = cep;
        this.cpf = cpf;
        this.curso = curso;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.endereco = endereco;
        this.escolaridade = escolaridade;
        this.estado = estado;
        this.municipio = municipio;
        this.nome = nome;
        this.numeroId = numeroId;
        this.raca = raca;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroId() {
        return numeroId;
    }

    public void setNumeroId(int numeroId) {
        this.numeroId = numeroId;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
