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
public class Movimenta{
    private int IDMov;
    private Containeres conteiner;    
    private String Data;
    private String tipoMov;
    private String LocalOrigem;
    private String LocalDestino;

    public int getIDMov() {
        return IDMov;
    }

    public void setIDMov(int IDMov) {
        this.IDMov = IDMov;
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

    public String getTipoMov() {
        return tipoMov;
    }

    public void setTipoMov(String tipoMov) {
        this.tipoMov = tipoMov;
    }

    public String getLocalOrigem() {
        return LocalOrigem;
    }

    public void setLocalOrigem(String LocalOrigem) {
        this.LocalOrigem = LocalOrigem;
    }

    public String getLocalDestino() {
        return LocalDestino;
    }

    public void setLocalDestino(String LocalDestino) {
        this.LocalDestino = LocalDestino;
    }
        
}
