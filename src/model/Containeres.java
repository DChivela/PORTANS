/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class Containeres {
    private int id_container;
    private String numContainer;
    private String tipoContainer;
    private Double peso;
    private String dimensoes;
    private String origem;
    private String destino;

    public int getId_container() {
        return id_container;
    }

    public void setId_container(int id_container) {
        this.id_container = id_container;
    }

    public String getNumContainer() {
        return numContainer;
    }

    public void setNumContainer(String numContainer) {
        this.numContainer = numContainer;
    }

    public String getTipoContainer() {
        return tipoContainer;
    }

    public void setTipoContainer(String tipoContainer) {
        this.tipoContainer = tipoContainer;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getDimensoes() {
        return dimensoes;
    }

    public void setDimensoes(String dimensoes) {
        this.dimensoes = dimensoes;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
    
}
