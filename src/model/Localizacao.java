/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author domin
 */
public class Localizacao {
    private int id;
    private Containeres conteiner;
    private String Data;
    private String localizacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Containeres getConteiner() {
        return conteiner;
    }

    public void setConteiner(Containeres conteiner) {
        this.conteiner = conteiner;
    }

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
    


}
