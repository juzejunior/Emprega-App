package model;

/**
 * Created by junio on 12/08/2017.
 */

public class Experiencia{

    private String cbo;
    private String expDecla;
    private String tempoExp;

    public Experiencia(){}

    public Experiencia(String cbo, String expDecla, String tempoExp) {
        this.cbo = cbo;
        this.expDecla = expDecla;
        this.tempoExp = tempoExp;
    }

    public String getCbo() {
        return cbo;
    }

    public void setCbo(String cbo) {
        this.cbo = cbo;
    }

    public String getExpDecla() {
        return expDecla;
    }

    public void setExpDecla(String expDecla) {
        this.expDecla = expDecla;
    }

    public String getTempoExp() {
        return tempoExp;
    }

    public void setTempoExp(String tempoExp) {
        this.tempoExp = tempoExp;
    }
}
