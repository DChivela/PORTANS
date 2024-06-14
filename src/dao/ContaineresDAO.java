/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.ConexaoBanco;
import model.Containeres;

/**
 *
 * @author domin
 */
public class ContaineresDAO {
   private Connection conn;
   
   public ContaineresDAO(){
       this.conn = new ConexaoBanco().pegarConexao();  
   }
   
   public void Salvar(Containeres obj){
       try {
           //1º Criar o SQL
           String sql = "insert into conteineres (numContainer, tipoContainer, peso, dimensoes, origem, destino)"
                   + "values(?,?,?,?,?,?)";
           //2ºPreparar a conexão SQL para se conectar com o Banco
           PreparedStatement stmt = conn.prepareStatement(sql);
           //2.1. Inserceção dos dados
           stmt.setString(1,obj.getNumContainer());
           stmt.setString(2,obj.getTipoContainer());
           stmt.setDouble(3,obj.getPeso());
           stmt.setString(4,obj.getDimensoes());
           stmt.setString(5,obj.getOrigem());
           stmt.setString(6,obj.getDestino());
           //3ºExecutar 
           stmt.execute();
           //4ºFechar conexão
           stmt.close();
           JOptionPane.showMessageDialog(null, "Container cadastrado com sucesso!");
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "Erro ao salvar o novo container"+e);
       }
   }
   
      public void Editar(Containeres obj){
       try {
           //1º Criar o SQL
           String sql = "update Containeres set id_container=?, numContainer=?, tipoContainer=?, peso=?, dimensoes=?, origem=?, destino=? where id_container=?";
           //2ºPreparar a conexão SQL para se conectar com o Banco
           PreparedStatement stmt = conn.prepareStatement(sql);
           stmt.setString(1,obj.getNumContainer());
           stmt.setString(2,obj.getTipoContainer());
           stmt.setDouble(3,obj.getPeso());
           stmt.setString(4,obj.getDimensoes());
           stmt.setString(5,obj.getOrigem());
           stmt.setString(6,obj.getDestino());
           stmt.setInt(13,obj.getId_container());
           //3ºExecutar 
           stmt.execute();
           //4ºFechar conexão
           stmt.close();
           JOptionPane.showMessageDialog(null, "Container editado com sucesso!");
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "Erro ao editar o Container"+e);
       }
   }
      
      public void Excluir(Containeres obj){
          try {
              String sql = "delete from Conteineres where id_container=?";
              PreparedStatement stmt = conn.prepareStatement(sql);
              stmt.setInt(1, obj.getId_container());
              stmt.execute();
              stmt.close();
              JOptionPane.showMessageDialog(null, "Container exluido com sucesso!");
          } catch (SQLException e) {
              JOptionPane.showMessageDialog(null,"Erro ao excluir o Container"+e);
          }
      }
   
   public Containeres BuscarContaineres(String numContainer){
       try {
           String sql = "select * from Conteineres where numContainer =?";
           PreparedStatement stmt = conn.prepareStatement(sql);
           stmt.setString(1, numContainer);
           ResultSet rs = stmt.executeQuery();
           Containeres obj = new Containeres();
           if(rs.next()){
               obj.setId_container(rs.getInt("id_container"));
               obj.setNumContainer(rs.getString("numContainer"));
               obj.setTipoContainer(rs.getString("tipoContainer"));
               obj.setPeso(rs.getDouble("Peso"));
               obj.setDimensoes(rs.getString("Dimensoes"));
               obj.setOrigem(rs.getString("Origem"));
               obj.setDestino(rs.getString("Destino"));

           }//Fechamento do preechimento automático
           return obj; //Retornar o objecto Cliente após a busca
           
       } catch (SQLException erro) { //Caso alguma coisa deia errado
           JOptionPane.showMessageDialog(null, "Erro ao buscar o container"+ erro);
       }
       return null;
    }
   //Método para listar os clientes do Banco
   public List<Containeres>Listar(){
       List<Containeres> lista = new ArrayList<>();
       try {
           String sql = "Select * from Conteineres";
           PreparedStatement stmt = conn.prepareStatement(sql);
           ResultSet rs = stmt.executeQuery();
           
           while(rs.next()){
               Containeres obj = new Containeres();
               obj.setId_container(rs.getInt("id_container"));
               obj.setNumContainer(rs.getString("numContainer"));
               obj.setTipoContainer(rs.getString("tipoContainer"));
               obj.setPeso(rs.getDouble("Peso"));
               obj.setDimensoes(rs.getString("Dimensoes"));
               obj.setOrigem(rs.getString("Origem"));
               obj.setDestino(rs.getString("Destino"));
               lista.add(obj);//A variável lista servirá para adicionar o obj dentro da lista criada.
           }
           return lista; //Retorno do que estiver dentro da lista.
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "Erro ao criar a lista de for."+e);
       }
       return null;
   }
      public List<Containeres>Filtrar(String nome){
       List<Containeres> lista = new ArrayList<>();
       try {
           String sql = "Select * from Conteineres where numContainer like ?";
           PreparedStatement stmt = conn.prepareStatement(sql);
           stmt.setString(1, nome);
           ResultSet rs = stmt.executeQuery();
           
           while(rs.next()){
               Containeres obj = new Containeres();
               obj.setId_container(rs.getInt("id_container"));
               obj.setNumContainer(rs.getString("numContainer"));
               obj.setTipoContainer(rs.getString("tipoContainer"));
               obj.setPeso(rs.getDouble("Peso"));
               obj.setDimensoes(rs.getString("Dimensoes"));
               obj.setOrigem(rs.getString("Origem"));
               obj.setDestino(rs.getString("Destino"));
               lista.add(obj);//A variável lista servirá para adicionar o obj dentro da lista criada.
           }
           return lista; //Retorno do que estiver dentro da lista.
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "Erro ao criar a lista."+e);
       }
       return null;
   }


}

