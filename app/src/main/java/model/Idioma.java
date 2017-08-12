package model;

/**
 * Created by junio on 12/08/2017.
 */

public class Idioma {
    private String lingua;
    private String nivel;

    public Idioma(){}

    public Idioma(String lingua, String nivel) {
        this.lingua = lingua;
        this.nivel = nivel;
    }

    public String getLingua() {
        return lingua;
    }

    public void setLingua(String lingua) {
        this.lingua = lingua;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
}
