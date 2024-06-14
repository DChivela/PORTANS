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
import model.Localizacao;

/**
 *
 * @author domin
 */
public class LocalizacaoDAO {

    //Método construtor
    private Connection conn;

    public LocalizacaoDAO() {
        this.conn = new ConexaoBanco().pegarConexao();
    }

    public void Salvar(Localizacao obj) {
        try {
            //1º Criar o SQL
            String sql = "insert into Localizacao_Conteineres (Id_container, data, localizacao)"
                    + "values(?,?,?)";
            //2ºPreparar a conexão SQL para se conectar com o Banco
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, obj.getConteiner().getId_container());
            stmt.setString(2, obj.getData());
            stmt.setString(3, obj.getLocalizacao());

            //3ºExecutar 
            stmt.execute();
            //4ºFechar conexão
            stmt.close();
            JOptionPane.showMessageDialog(null, "Localização adicionada com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar a localização" + e);
        }
    }

    public void Editar(Localizacao obj) {
        try {
            //1º Criar o SQL
            String sql = "update Localizacao_Conteineres set id_localizacao =?, Id_container=?, data=?, localizacao=?";
            //2ºPreparar a conexão SQL para se conectar com o Banco
            PreparedStatement stmt = conn.prepareStatement(sql);
            //3º Inserir os dados
            stmt.setInt(1, obj.getConteiner().getId_container());
            stmt.setString(2, obj.getData());
            stmt.setString(3, obj.getLocalizacao());
            //3ºExecutar 
            stmt.execute();
            //4ºFechar conexão
            stmt.close();
            JOptionPane.showMessageDialog(null, "Localização editada com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar a localização" + e);
        }
    }

    public void Excluir(Localizacao obj) {
        try {
            String sql = "delete from Localizacao_Conteineres where id_localizacao=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, obj.getId());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Localização exluida com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir a localização" + e);
        }
    }

    public Localizacao BuscarLocalizacao(String numConteiner) {
        try {
            String sql = "select l.id_localizacao, l.id_container, l.data, l.localizacao, c.numContainer from Localizacao_Conteineres, c.numContainer as p inner join"
                    + " conteineres as c on (l.id_container=c.id_container) where l.id_localizacao=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, numConteiner);
            ResultSet rs = stmt.executeQuery();
            Localizacao obj = new Localizacao();
            Containeres c = new Containeres();
            if (rs.next()) {
                obj.setId(rs.getInt("l.id_localizacao"));
                obj.setData(rs.getString("l.data"));
                obj.setLocalizacao(rs.getString("l.localizacao"));

                c.setNumContainer(rs.getString("c.numContainer"));
                obj.setConteiner(c);

            }//Fechamento do preechimento automático
            return obj; //Retornar o objecto Cliente após a busca

        } catch (SQLException erro) { //Caso alguma coisa deia errado
            JOptionPane.showMessageDialog(null, "Erro ao buscar a localização" + erro);
        }
           return null;
    }

    public Localizacao BuscarLocalizacaoConteiner(String numConteiner) {
//        try {
//            String sql = "select l.id_localizacao, l.id_container, l.data, l.localizacao, c.numContainer from Localizacao_Conteineres, c.numContainer as p inner join"
//                    + " conteineres as c on (l.id_container=c.id_container) where l.id_localizacao=?";
//            PreparedStatement stmt = conn.prepareStatement(sql);
//            stmt.setString(1, numConteiner);
//            ResultSet rs = stmt.executeQuery();
//            Localizacao obj = new Localizacao();
//            Containeres c = new Containeres();
//            if (rs.next()) {
//                obj.setId(rs.getInt("l.id_localizacao"));
//                obj.setData(rs.getString("l.data"));
//                obj.setLocalizacao(rs.getString("l.localizacao"));
//
//                c.setNumContainer(rs.getString("c.numContainer"));
//                obj.setConteiner(c);
//
//            }//Fechamento do preechimento automático
//            return obj; //Retornar o objecto Cliente após a busca
//
//        } catch (SQLException erro) { //Caso alguma coisa deia errado
//            JOptionPane.showMessageDialog(null, "Erro ao buscar a localização" + erro);
//        }
        return null;
    }

    //Método para listar os clientes do Banco
public List<Localizacao> Listar() {
    List<Localizacao> lista = new ArrayList<>();
         try {
            String sql = "SELECT l.id_localizacao, l.id_container, l.data, l.localizacao, c.numContainer " +
                            "FROM Localizacao_Conteineres as l INNER JOIN conteineres AS c ON (l.id_container = c.id_container)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Localizacao obj = new Localizacao();
                Containeres c = new Containeres();
                obj.setId(rs.getInt("id_localizacao"));
                c.setNumContainer(rs.getString("c.numContainer"));
                obj.setConteiner(c);
                obj.setData(rs.getString("Data"));
                obj.setLocalizacao(rs.getString("Localizacao"));
                lista.add(obj);//A variável lista servirá para adicionar o obj dentro da lista criada.
            }

        return lista;
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao listar: " + e.getMessage());
    }
    return null;
}


    public List<Localizacao> Filtrar(String nome) {
        List<Localizacao> lista = new ArrayList<>();
        try {
            String sql = "Select * from Localizacao_Conteineres where berco like ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Localizacao obj = new Localizacao();
                Containeres c = new Containeres();
                obj.setId(rs.getInt("l.id_localizacao"));
                obj.setData(rs.getString("l.data"));
                obj.setLocalizacao(rs.getString("l.localizacao"));

                c.setNumContainer(rs.getString("c.numContainer"));
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
