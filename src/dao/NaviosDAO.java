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
import model.Navios;

/**
 *
 * @author domin
 */
public class NaviosDAO {
    //Método construtor
    private Connection conn;
   
   public NaviosDAO(){
       this.conn = new ConexaoBanco().pegarConexao();  
   }
   
   public void Salvar(Navios obj){
       try {
           //1º Criar o SQL
           String sql = "insert into Navios (IDNavio, nome, bandeira, tipoNavio, capacidadeCarga, companhia, infoContato )"
                   + "values(?,?,?,?,?,?,?)";
           //2ºPreparar a conexão SQL para se conectar com o Banco
           PreparedStatement stmt = conn.prepareStatement(sql);
           stmt.setInt(1,obj.getId());
           stmt.setString(2,obj.getNome());
           stmt.setString(3,obj.getBandeira());
           stmt.setString(4,obj.getTipoNavio());
           stmt.setDouble(5,obj.getCapacidade());
           stmt.setString(6,obj.getCompanhia());
           stmt.setString(7,obj.getContacto());

           //3ºExecutar 
           stmt.execute();
           //4ºFechar conexão
           stmt.close();
           JOptionPane.showMessageDialog(null, "Navio registado com sucesso!");
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "Erro ao registar o navio"+e);
       }
   }
   
      public void Editar(Navios obj){
       try {
           //1º Criar o SQL
           String sql = "update Navios set IDNavio=?, nome=?, bandeira=?, tipoNavio=?, capacidadeCarga, companhia, infoContato, where IDNavio=?";
           //2ºPreparar a conexão SQL para se conectar com o Banco
           PreparedStatement stmt = conn.prepareStatement(sql);
           //3º Inserir os dados
           stmt.setInt(1,obj.getId());
           stmt.setString(2,obj.getNome());
           stmt.setString(3,obj.getBandeira());
           stmt.setString(4,obj.getTipoNavio());
           stmt.setDouble(5,obj.getCapacidade());
           stmt.setString(6,obj.getCompanhia());
           stmt.setString(7,obj.getContacto());
           //3ºExecutar 
           stmt.execute();
           //4ºFechar conexão
           stmt.close();
           JOptionPane.showMessageDialog(null, "Registo editado com sucesso!");
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "Erro ao editar o dado do navio"+e);
       }
   }
      
      public void Excluir(Navios obj){
          try {
              String sql = "delete from Navios where IDNavio=?";
              PreparedStatement stmt = conn.prepareStatement(sql);
              stmt.setInt(1, obj.getId());
              stmt.execute();
              stmt.close();
              JOptionPane.showMessageDialog(null, "Registo exluido com sucesso!");
          } catch (SQLException e) {
              JOptionPane.showMessageDialog(null,"Erro ao excluir o registo"+e);
          }
      }
   
   public Navios BuscarNavio(String nome){
       try {
           String sql = "select * from Navios where nome =?";
           PreparedStatement stmt = conn.prepareStatement(sql);
           stmt.setString(1, nome);
           ResultSet rs = stmt.executeQuery();
           Navios obj = new Navios();
           if(rs.next()){
               obj.setId(rs.getInt("IDNavio"));
               obj.setNome(rs.getString("Nome"));
               obj.setBandeira(rs.getString("Bandeira"));
               obj.setTipoNavio(rs.getString("tipoNavio"));
               obj.setCapacidade(rs.getDouble("CapacidadeCarga"));
               obj.setCompanhia(rs.getString("Companhia"));
               obj.setContacto(rs.getString("infoContato"));

           }//Fechamento do preechimento automático
           return obj; //Retornar o objecto Cliente após a busca
           
       } catch (SQLException erro) { //Caso alguma coisa deia errado
           JOptionPane.showMessageDialog(null, "Erro ao buscar o nome do navio"+ erro);
       }
       return null;
    }
   
   public Navios BuscarNavioNome(String IdNavio){
       try {
           String sql = "select * from Navios where IDNavio = ?";
           PreparedStatement stmt = conn.prepareStatement(sql);
           stmt.setString(1, IdNavio);
           ResultSet rs = stmt.executeQuery();
           Navios obj = new Navios();
           if(rs.next()){
               obj.setId(rs.getInt("IDNavio"));
               obj.setNome(rs.getString("Nome"));
               obj.setBandeira(rs.getString("Bandeira"));
               obj.setTipoNavio(rs.getString("tipoNavio"));
               obj.setCapacidade(rs.getDouble("CapacidadeCarga"));
               obj.setCompanhia(rs.getString("Companhia"));
               obj.setContacto(rs.getString("infoContato"));
           }//Fechamento do preechimento automático
           return obj; //Retornar o objecto Cliente após a busca
           
       } catch (SQLException erro) { //Caso alguma coisa deia errado
           JOptionPane.showMessageDialog(null, "Erro ao buscar o registo"+ erro);
       }
       return null;
    }
   
   //Método para listar os clientes do Banco
   public List<Navios>Listar(){
       List<Navios> lista = new ArrayList<>();
       try {
           String sql = "Select * from Navios";
           PreparedStatement stmt = conn.prepareStatement(sql);
           ResultSet rs = stmt.executeQuery();
           
           while(rs.next()){
               Navios obj = new Navios();
               obj.setId(rs.getInt("IDNavio"));
               obj.setNome(rs.getString("Nome"));
               obj.setBandeira(rs.getString("Bandeira"));
               obj.setTipoNavio(rs.getString("tipoNavio"));
               obj.setCapacidade(rs.getDouble("CapacidadeCarga"));
               obj.setCompanhia(rs.getString("Companhia"));
               obj.setContacto(rs.getString("infoContato"));
               lista.add(obj);//A variável lista servirá para adicionar o obj dentro da lista criada.
           }
           return lista; //Retorno do que estiver dentro da lista.
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "Erro ao criar a lista."+e);
       }
       return null;
   }
      public List<Navios>Filtrar(String nome){
       List<Navios> lista = new ArrayList<>();
       try {
           String sql = "Select * from Navios where nome like ?";
           PreparedStatement stmt = conn.prepareStatement(sql);
           stmt.setString(1, nome);
           ResultSet rs = stmt.executeQuery();
           
           while(rs.next()){
               Navios obj = new Navios();
               obj.setId(rs.getInt("IDNavio"));
               obj.setNome(rs.getString("Nome"));
               obj.setBandeira(rs.getString("Bandeira"));
               obj.setTipoNavio(rs.getString("tipoNavio"));
               obj.setCapacidade(rs.getDouble("CapacidadeCarga"));
               obj.setCompanhia(rs.getString("Companhia"));
               obj.setContacto(rs.getString("infoContato")); 
               lista.add(obj);//A variável lista servirá para adicionar o obj dentro da lista criada.
           }
           return lista; //Retorno do que estiver dentro da lista.
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "Erro ao criar a lista."+e);
       }
       return null;
   }


}

