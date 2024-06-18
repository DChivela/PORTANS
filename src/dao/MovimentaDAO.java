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
import model.Movimenta;

/**
 *
 * @author domin
 */
public class MovimentaDAO {

    //Método construtor
    private Connection conn;

    public MovimentaDAO() {
        this.conn = new ConexaoBanco().pegarConexao();
    }

    public void Salvar(Movimenta obj) {
        try {
            //1º Criar o SQL
            String sql = "insert into Movimentacoes_Carga (IDMov, IDContainer, Data, tipoMov, LocalOrigem, LocalDestino)"
                    + "values(?,?,?,?,?,?)";
            //2ºPreparar a conexão SQL para se conectar com o Banco
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, obj.getIDMov());
            stmt.setInt(2, obj.getConteiner().getId_container());
            stmt.setString(3, obj.getData());
            stmt.setString(4, obj.getTipoMov());
            stmt.setString(5, obj.getLocalOrigem());
            stmt.setString(6, obj.getLocalDestino());
            //3ºExecutar 
            stmt.execute();
            //4ºFechar conexão
            stmt.close();
            JOptionPane.showMessageDialog(null, "Movimentação registada com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao registar movimentação" + e);
        }
    }

    public void Editar(Movimenta obj) {
        try {
            //1º Criar o SQL
            String sql = "update Movimentacoes_Carga set IDMov=?, IDContainer=?, Data=?, tipoMov=?, LocalOrigem=?, LocalDestino=?, where IDMov=?";
            //2ºPreparar a conexão SQL para se conectar com o Banco
            PreparedStatement stmt = conn.prepareStatement(sql);
            //3º Inserir os dados
            stmt.setInt(1, obj.getIDMov());
            stmt.setInt(2, obj.getConteiner().getId_container());
            stmt.setString(3, obj.getData());
            stmt.setString(4, obj.getTipoMov());
            stmt.setString(5, obj.getLocalOrigem());
            stmt.setString(6, obj.getLocalDestino());
            //3ºExecutar 
            stmt.execute();
            //4ºFechar conexão
            stmt.close();
            JOptionPane.showMessageDialog(null, "Movimentação editada com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar a movimentação" + e);
        }
    }

    public void Excluir(Movimenta obj) {
        try {
            String sql = "delete from Movimentacoes_Carga where IDMov=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, obj.getIDMov());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Movimentação exluida com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir a movimentação" + e);
        }
    }

//   public Movimenta BuscarMovTipo(String Tipo){
//       try {
//           String sql = "select * from Movimentacoes_Carga where IDMov = ?";
//           PreparedStatement stmt = conn.prepareStatement(sql);
//           stmt.setString(1, Tipo);
//           ResultSet rs = stmt.executeQuery();
//           Movimenta obj = new Movimenta();
//           if(rs.next()){
//               obj.setIDMov(rs.getInt("IDMov"));
//               obj.setIDContainer(rs.getInt("IDContainer"));
//               obj.setData(rs.getString("Data"));
//               obj.setTipoMov(rs.getString("tipoMov"));
//               obj.setLocalOrigem(rs.getString("LocalOrigem"));
//               obj.setLocalDestino(rs.getString("LocalDestino")); 
//           }//Fechamento do preechimento automático
//           return obj; //Retornar o objecto Cliente após a busca
//           
//       } catch (SQLException erro) { //Caso alguma coisa deia errado
//           JOptionPane.showMessageDialog(null, "Erro ao buscar a movimentação"+ erro);
//       }
//       return null;
//    }
    //Método para listar os clientes do Banco
    public List<Movimenta> Listar() {
        List<Movimenta> lista = new ArrayList<>();
        try {
            String sql = "SELECT m.IDMov, m.IDContainer, m.Data, m.tipoMov, m.LocalOrigem, m.LocalDestino, c.numContainer"
                    + " FROM Movimentacoes_Carga AS m INNER JOIN conteineres AS c ON (M.IDContainer = c.id_container)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Movimenta obj = new Movimenta();
                Containeres c = new Containeres();
                obj.setIDMov(rs.getInt("IDMov"));
                c.setNumContainer(rs.getString("c.numContainer"));
                obj.setConteiner(c);
                obj.setData(rs.getString("Data"));
                obj.setTipoMov(rs.getString("tipoMov"));
                obj.setLocalOrigem(rs.getString("LocalOrigem"));
                obj.setLocalDestino(rs.getString("LocalDestino"));
                lista.add(obj);//A variável lista servirá para adicionar o obj dentro da lista criada.
            }
            return lista; //Retorno do que estiver dentro da lista.
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar a lista." + e);
        }
        return null;
    }

    public List<Movimenta> Filtrar(String nome) {
        List<Movimenta> lista = new ArrayList<>();
        try {
            String sql = "SELECT m.IDMov, m.IDContainer, m.Data, m.tipoMov, m.LocalOrigem, m.LocalDestino, c.numContainer"
                    + " FROM Movimentacoes_Carga AS m INNER JOIN conteineres AS c ON (M.IDContainer = c.id_container) WHERE m.tipoMov like ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Movimenta obj = new Movimenta();
                Containeres c = new Containeres();
                obj.setIDMov(rs.getInt("m.IDMov"));
                c.setNumContainer(rs.getString("c.numContainer")); //Número do Conteiner
                obj.setData(rs.getString("m.Data"));
                obj.setTipoMov(rs.getString("m.tipoMov"));
                obj.setLocalOrigem(rs.getString("m.LocalOrigem"));
                obj.setLocalDestino(rs.getString("m.LocalDestino"));
                
                obj.setConteiner(c);
                lista.add(obj);//A variável lista servirá para adicionar o obj dentro da lista criada.
            }
            return lista; //Retorno do que estiver dentro da lista.
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar a lista." + e);
        }
        return null;
    }

}
