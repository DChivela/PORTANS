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
import model.Atracacoes;

/**
 *
 * @author domin
 */
public class AtracacoesDAO {
    //Método construtor
    private Connection conn;
   
   public AtracacoesDAO(){
       this.conn = new ConexaoBanco().pegarConexao();  
   }
   
   public void Salvar(Atracacoes obj){
       try {
           //1º Criar o SQL
           String sql = "insert into atracacoes (id_navio, dataChegada, dataPartida, berco)"
                   + "values(?,?,?,?)";
           //2ºPreparar a conexão SQL para se conectar com o Banco
           PreparedStatement stmt = conn.prepareStatement(sql);
           stmt.setInt(1,obj.getId_navio());
           stmt.setString(2,obj.getDataChegada());
           stmt.setString(3,obj.getDataPartida());
           stmt.setString(4,obj.getBerco());

           //3ºExecutar 
           stmt.execute();
           //4ºFechar conexão
           stmt.close();
           JOptionPane.showMessageDialog(null, "Atracação registada com sucesso!");
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "Erro ao registar atracação"+e);
       }
   }
   
      public void Editar(Atracacoes obj){
       try {
           //1º Criar o SQL
           String sql = "update atracacoes set id_atracacao=?, id_navio=?, dataChegada=?, dataPartida=? where id_atracacoes=?";
           //2ºPreparar a conexão SQL para se conectar com o Banco
           PreparedStatement stmt = conn.prepareStatement(sql);
           //3º Inserir os dados
           stmt.setInt(1,obj.getId_navio());
           stmt.setString(2,obj.getDataChegada());
           stmt.setString(3,obj.getDataPartida());
           stmt.setString(4,obj.getBerco());
           stmt.setInt(14,obj.getId_atracacoes());
           //3ºExecutar 
           stmt.execute();
           //4ºFechar conexão
           stmt.close();
           JOptionPane.showMessageDialog(null, "Registo editado com sucesso!");
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "Erro ao editar o registo"+e);
       }
   }
      
      public void Excluir(Atracacoes obj){
          try {
              String sql = "delete from Atracacoes where id_atracacao=?";
              PreparedStatement stmt = conn.prepareStatement(sql);
              stmt.setInt(1, obj.getId_atracacoes());
              stmt.execute();
              stmt.close();
              JOptionPane.showMessageDialog(null, "Registo exluido com sucesso!");
          } catch (SQLException e) {
              JOptionPane.showMessageDialog(null,"Erro ao excluir o registo"+e);
          }
      }
   
   public Atracacoes BuscarAtracacoes(String nome){
       try {
           String sql = "select * from Atracacoes where berco =?";
           PreparedStatement stmt = conn.prepareStatement(sql);
           stmt.setString(1, nome);
           ResultSet rs = stmt.executeQuery();
           Atracacoes obj = new Atracacoes();
           if(rs.next()){
               obj.setId_atracacoes(rs.getInt("id_atracacao"));
               obj.setId_navio(rs.getInt("id_navio"));
               obj.setDataChegada(rs.getString("DataChegada"));
               obj.setDataPartida(rs.getString("DataPartida"));
               obj.setBerco(rs.getString("Berco"));

           }//Fechamento do preechimento automático
           return obj; //Retornar o objecto Cliente após a busca
           
       } catch (SQLException erro) { //Caso alguma coisa deia errado
           JOptionPane.showMessageDialog(null, "Erro ao buscar registo de atracação"+ erro);
       }
       return null;
    }
   
   public Atracacoes BuscarAtracacaoIdNavio(String IdNavio){
       try {
           String sql = "select * from atracacao where id_navio = ?";
           PreparedStatement stmt = conn.prepareStatement(sql);
           stmt.setString(1, IdNavio);
           ResultSet rs = stmt.executeQuery();
           Atracacoes obj = new Atracacoes();
           if(rs.next()){
               obj.setId_atracacoes(rs.getInt("id_atracacao"));
               obj.setId_navio(rs.getInt("id_navio"));
               obj.setDataChegada(rs.getString("DataChegada"));
               obj.setDataPartida(rs.getString("DataPartida"));
               obj.setBerco(rs.getString("Berco"));  
           }//Fechamento do preechimento automático
           return obj; //Retornar o objecto Cliente após a busca
           
       } catch (SQLException erro) { //Caso alguma coisa deia errado
           JOptionPane.showMessageDialog(null, "Erro ao buscar o registo"+ erro);
       }
       return null;
    }
   
   //Método para listar os clientes do Banco
   public List<Atracacoes>Listar(){
       List<Atracacoes> lista = new ArrayList<>();
       try {
           String sql = "Select * from atracacoes";
           PreparedStatement stmt = conn.prepareStatement(sql);
           ResultSet rs = stmt.executeQuery();
           
           while(rs.next()){
               Atracacoes obj = new Atracacoes();
               obj.setId_atracacoes(rs.getInt("id_atracacao"));
               obj.setId_navio(rs.getInt("Id_navio"));
               obj.setDataChegada(rs.getString("DataChegada"));
               obj.setDataPartida(rs.getString("DataPartida")); 
               obj.setBerco(rs.getString("Berco")); 
               lista.add(obj);//A variável lista servirá para adicionar o obj dentro da lista criada.
           }
           return lista; //Retorno do que estiver dentro da lista.
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "Erro ao criar a lista."+e);
       }
       return null;
   }
      public List<Atracacoes>Filtrar(String nome){
       List<Atracacoes> lista = new ArrayList<>();
       try {
           String sql = "Select * from atracacoes where berco like ?";
           PreparedStatement stmt = conn.prepareStatement(sql);
           stmt.setString(1, nome);
           ResultSet rs = stmt.executeQuery();
           
           while(rs.next()){
               Atracacoes obj = new Atracacoes();
               obj.setId_atracacoes(rs.getInt("id_atracacao"));
               obj.setId_navio(rs.getInt("Id_navio"));
               obj.setDataChegada(rs.getString("DataChegada"));
               obj.setDataPartida(rs.getString("DataPartida")); 
               obj.setBerco(rs.getString("Berco")); 
               lista.add(obj);//A variável lista servirá para adicionar o obj dentro da lista criada.
           }
           return lista; //Retorno do que estiver dentro da lista.
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "Erro ao criar a lista."+e);
       }
       return null;
   }


}

