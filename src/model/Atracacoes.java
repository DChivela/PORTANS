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
public class Atracacoes {
    private int id_atracacoes;
    private int id_navio;
    private String dataChegada;
    private String DataPartida;
    private String berco;

    public int getId_atracacoes() {
        return id_atracacoes;
    }

    public void setId_atracacoes(int id_atracacoes) {
        this.id_atracacoes = id_atracacoes;
    }

    public int getId_navio() {
        return id_navio;
    }

    public void setId_navio(int id_navio) {
        this.id_navio = id_navio;
    }

    public String getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(String dataChegada) {
        this.dataChegada = dataChegada;
    }

    public String getDataPartida() {
        return DataPartida;
    }

    public void setDataPartida(String DataPartida) {
        this.DataPartida = DataPartida;
    }

    public String getBerco() {
        return berco;
    }

    public void setBerco(String berco) {
        this.berco = berco;
    }

    
}
