/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sigest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import sigest.jdbc.ConexaoBanco;
import sigest.model.Clientes;
import sigest.model.Conteineres;
import sigest.model.Produtos;

/**
 *
 * @author domin
 */
public class ProdutosDAO {
   private Connection conn;
   
   public ProdutosDAO(){
       this.conn = new ConexaoBanco().pegarConexao();  
   }
   
   public void Salvar(Produtos obj){
       try {
           //1º Criar o SQL
           String sql = "insert into tb_produtos (descricao, preco, qtd_stock, for_id)"
                   + "values(?,?,?,?)";
           //2ºPreparar a conexão SQL para se conectar com o Banco
           PreparedStatement stmt = conn.prepareStatement(sql);
           stmt.setString(1,obj.getDescricao());
           stmt.setDouble(2,obj.getPreco());
           stmt.setInt(3,obj.getStock());
           stmt.setInt(4,obj.getFornecedor().getId());

           //3ºExecutar 
           stmt.execute();
           //4ºFechar conexão
           stmt.close();
           JOptionPane.showMessageDialog(null, "Produto registado com sucesso!");
       } catch (SQLException erro) {
           JOptionPane.showMessageDialog(null, "Erro ao salvar o produto"+erro);
       }
   }
   
      public void Editar(Produtos obj){
       try {
           //1º Criar o SQL
           String sql = "update tb_produtos set descricao=?, preco=?, qtd_stock=?, for_id=? where id=?";
           //2ºPreparar a conexão SQL para se conectar com o Banco
           PreparedStatement stmt = conn.prepareStatement(sql);
           stmt.setString(1,obj.getDescricao());
           stmt.setDouble(2,obj.getPreco());
           stmt.setInt(3,obj.getStock());
           stmt.setInt(4,obj.getFornecedor().getId());
           stmt.setInt(5,obj.getId());
           //3ºExecutar 
           stmt.execute();
           //4ºFechar conexão
           stmt.close();
           JOptionPane.showMessageDialog(null, "Produto editado com sucesso!");
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "Erro ao editar o produto"+e);
       }
   }
      
      public void Excluir(Produtos obj){
          try {
              String sql = "delete from tb_produtos where id=?";
              PreparedStatement stmt = conn.prepareStatement(sql);
              stmt.setInt(1, obj.getId());
              stmt.execute();
              stmt.close();
              JOptionPane.showMessageDialog(null, "Produto exluido com sucesso!");
          } catch (SQLException e) {
              JOptionPane.showMessageDialog(null,"Erro ao excluir o produto"+e);
          }
      }
   
   public Produtos BuscarProdutos(String nome){
       try {
           String sql = "Select p.id, p.descricao, p.preco, p.qtd_stock, f.nome from tb_Produtos as p inner join"
                   + " tb_fornecedores as f on(p.for_id=f.id) where p.descricao = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            Produtos obj = new Produtos();
            Conteineres f = new Conteineres();
            if(rs.next()){
                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setStock(rs.getInt("p.Qtd_Stock"));
                
                f.setNome(rs.getString("f.nome"));
                obj.setFornecedor(f);
            }   
            return obj;
           
       } catch (SQLException erro) { //Caso alguma coisa deia errado
           JOptionPane.showMessageDialog(null, "Erro ao buscar o produto"+ erro);
       }
       return null;
    }
   
   public Produtos BuscarProdutosCodigo(int id){
       try {
           String sql = "Select p.id, p.descricao, p.preco, p.qtd_stock, f.nome from tb_Produtos as p inner join"
                   + " tb_fornecedores as f on(p.for_id=f.id) where p.id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Produtos obj = new Produtos();
            Conteineres f = new Conteineres();
            if(rs.next()){
                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setStock(rs.getInt("p.Qtd_Stock"));
                
                f.setNome(rs.getString("f.nome"));
                obj.setFornecedor(f);
            }   
            return obj;
           
       } catch (SQLException erro) { //Caso alguma coisa deia errado
           JOptionPane.showMessageDialog(null, "Erro ao buscar o produto"+ erro);
       }
       return null;
    }
   
   //Método para listar os produtos  do Banco de Dados
   public List<Produtos>Listar(){
       List<Produtos> lista = new ArrayList<>();
       try {
           String sql = "Select p.id, p.descricao, p.preco, p.qtd_stock, f.nome from tb_Produtos as p inner join tb_fornecedores as f on(p.for_id=f.id)";
           PreparedStatement stmt = conn.prepareStatement(sql);
           ResultSet rs = stmt.executeQuery();
           
           while(rs.next()){
               Produtos obj = new Produtos();
               Conteineres f = new Conteineres();
               obj.setId(rs.getInt("id"));
               obj.setDescricao(rs.getString("Descricao"));
               obj.setPreco(rs.getDouble("Preco"));
               obj.setStock(rs.getInt("Qtd_Stock"));
               f.setNome(rs.getString("f.nome")); 
               obj.setFornecedor(f);
               lista.add(obj);//A variável lista servirá para adicionar o obj dentro da lista criada.
           }
           return lista; //Retorno do que estiver dentro da lista.
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "Erro ao criar a lista."+e);
       }
       return null;
   }
      public List<Produtos>Filtrar(String nome){
       List<Produtos> lista = new ArrayList<>();
       try {
           String sql = "Select p.id, p.descricao, p.preco, p.qtd_stock, f.nome from tb_Produtos as p inner join "
                   + "tb_fornecedores as f on(p.for_id = f.id) where p.descricao like ?";
           PreparedStatement stmt = conn.prepareStatement(sql);
           stmt.setString(1, nome);
           ResultSet rs = stmt.executeQuery();
           
           while(rs.next()){
               Produtos obj = new Produtos();
               Conteineres f = new Conteineres();
               obj.setId(rs.getInt("id"));
               obj.setDescricao(rs.getString("descricao"));
               obj.setPreco(rs.getDouble("preco"));
               obj.setStock(rs.getInt("qtd_stock"));
               f.setNome(rs.getString("f.nome"));
               obj.setFornecedor(f);
               lista.add(obj);//A variável lista servirá para adicionar o obj dentro da lista criada.
           }
           return lista; //Retorno do que estiver dentro da lista.
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "Erro ao criar a lista."+e);
       }
       return null;
   }


      public void adicionarStock(int id, int StockNovo){
          try {
              String sql = "update tb_produtos set qtd_stock=? where id=?";
              PreparedStatement stmt = conn.prepareStatement(sql);
              stmt.setInt(1, StockNovo);
              stmt.setInt(2, id);
              stmt.execute();
              stmt.close();
              JOptionPane.showMessageDialog(null, "Nova quantidade adicionada ao stock!");
          } catch (Exception e) {
              JOptionPane.showMessageDialog(null, "Erro ao adicionar ao stock"+e);
          }
        }
      
            public void baixarStock(int id, int StockNovo){
          try {
              String sql = "update tb_produtos set qtd_stock=? where id=?";
              PreparedStatement stmt = conn.prepareStatement(sql);
              stmt.setInt(1, StockNovo);
              stmt.setInt(2, id);
              stmt.execute();
              stmt.close();
              JOptionPane.showMessageDialog(null, "Baixa no stock efectuada com sucesso!");
            }catch (Exception e) {
              JOptionPane.showMessageDialog(null, "Erro na baixa do stock");
            }
    }
    public int retornaQTDActualStock(int id){
        try {
            int StockActual = 0; //Valor inicial da variável StockActual
            String sql = "Select qtd_stock from tb_produtos where id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id); //Para dar baixa consoante o ID do produto.
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                StockActual = (rs.getInt("qtd_stock")); //Acessando apenas a coluna do Stock.
            }
            return StockActual;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao retornar o stock actual!"+e);
        }
    }
      
}

