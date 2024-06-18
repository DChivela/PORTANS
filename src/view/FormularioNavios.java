/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.ContaineresDAO;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import dao.LocalizacaoDAO;
import dao.NaviosDAO;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.Containeres;
import model.Localizacao;
import model.Navios;

import sigest.utilitarios.Utilitarios;

/**
 *
 * @author domin
 */
public class FormularioNavios extends javax.swing.JFrame {

    /**
     * Creates new form FormularioClientes
     */
    public void listar() {
        NaviosDAO dao = new NaviosDAO();
        List<Navios> lista = dao.Listar();
        DefaultTableModel dados = (DefaultTableModel) tabela.getModel();
        dados.setNumRows(0);
        for (Navios n : lista) {
            dados.addRow(new Object[]{
                n.getId(),
                n.getNome(),
                n.getBandeira(),
                n.getTipoNavio(),
                n.getCapacidade(),
                n.getCompanhia(),
                n.getContacto()
            });
        }
    }

    public FormularioNavios() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Painel_Guias = new javax.swing.JTabbedPane();
        painelDadosPessoais = new javax.swing.JPanel();
        btnPesquisar = new javax.swing.JButton();
        txtCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtBandeira = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTipo = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        txtCapacidade = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtComp = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtContacto = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        txtPesquisaNome = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        btnPesquisaNome = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ficha de Navios");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ficha de Navios");

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Pesquisar_4.png"))); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        txtCodigo.setEditable(false);
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        jLabel2.setText("Código");

        jLabel3.setText("Nome");

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });
        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNomeKeyPressed(evt);
            }
        });

        jLabel4.setText("Bandeira");

        txtBandeira.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBandeiraActionPerformed(evt);
            }
        });

        jLabel7.setText("Tipo de Navio");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Capacidade de Carga");

        txtCapacidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCapacidadeActionPerformed(evt);
            }
        });

        jLabel14.setText("Companhia Marítima");

        txtComp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCompActionPerformed(evt);
            }
        });

        jLabel11.setText("Dados de Contacto");

        txtContacto.setColumns(20);
        txtContacto.setRows(5);
        jScrollPane2.setViewportView(txtContacto);

        javax.swing.GroupLayout painelDadosPessoaisLayout = new javax.swing.GroupLayout(painelDadosPessoais);
        painelDadosPessoais.setLayout(painelDadosPessoaisLayout);
        painelDadosPessoaisLayout.setHorizontalGroup(
            painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosPessoaisLayout.createSequentialGroup()
                .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelDadosPessoaisLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(painelDadosPessoaisLayout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtBandeira, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(painelDadosPessoaisLayout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(painelDadosPessoaisLayout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtTipo)))
                            .addGroup(painelDadosPessoaisLayout.createSequentialGroup()
                                .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCapacidade, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                                    .addComponent(txtComp))))
                        .addGap(33, 33, 33)
                        .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(painelDadosPessoaisLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(157, Short.MAX_VALUE))
        );

        painelDadosPessoaisLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtBandeira, txtNome, txtTipo});

        painelDadosPessoaisLayout.setVerticalGroup(
            painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDadosPessoaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtBandeira, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelDadosPessoaisLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(8, 8, 8)
                        .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCapacidade, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(painelDadosPessoaisLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtComp, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(29, 29, 29))
        );

        painelDadosPessoaisLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel10, jLabel11, jLabel14, jLabel3, jLabel4, jLabel7});

        painelDadosPessoaisLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtBandeira, txtNome, txtTipo});

        Painel_Guias.addTab("Info. Gerais", painelDadosPessoais);

        txtPesquisaNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisaNomeActionPerformed(evt);
            }
        });
        txtPesquisaNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPesquisaNomeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaNomeKeyReleased(evt);
            }
        });

        jLabel15.setText("Nome");

        btnPesquisaNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Pesquisar_4.png"))); // NOI18N
        btnPesquisaNome.setText("Pesquisar");
        btnPesquisaNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaNomeActionPerformed(evt);
            }
        });

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Bandeira", "Tipo Navio", "Capacidade", "Companhia Mar.", "Info. Contacto"
            }
        ));
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtPesquisaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btnPesquisaNome))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisaNome))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        Painel_Guias.addTab("Consultar Navios", jPanel3);

        btnNovo.setText("NOVO");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSalvar.setText("SALVAR");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setText("EXCLUIR");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnImprimir.setText("IMPRIMIR");
        btnImprimir.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(btnNovo)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalvar)
                        .addGap(29, 29, 29)
                        .addComponent(btnEditar)
                        .addGap(27, 27, 27)
                        .addComponent(btnExcluir)
                        .addGap(32, 32, 32)
                        .addComponent(btnImprimir))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(Painel_Guias, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Painel_Guias, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnSalvar)
                    .addComponent(btnEditar)
                    .addComponent(btnExcluir)
                    .addComponent(btnImprimir))
                .addGap(52, 52, 52))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        Utilitarios util = new Utilitarios();
        util.LimpaTela(painelDadosPessoais);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void txtPesquisaNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaNomeActionPerformed
        String nome = "%" + txtPesquisaNome.getText() + "%";
        NaviosDAO dao = new NaviosDAO();
        List<Navios> lista = dao.Filtrar(nome);
        DefaultTableModel dados = (DefaultTableModel) tabela.getModel();
        dados.setNumRows(0);
        for (Navios n : lista) {
            dados.addRow(new Object[]{
                n.getId(),
                n.getNome(),
                n.getBandeira(),
                n.getTipoNavio(),
                n.getCapacidade(),
                n.getCompanhia(),
                n.getContacto()

            });
        }
    }//GEN-LAST:event_txtPesquisaNomeActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        Navios obj = new Navios();
        obj.setNome(txtNome.getText());
        obj.setBandeira(txtBandeira.getText());
        obj.setTipoNavio(txtTipo.getText());
        obj.setCapacidade(Double.valueOf(txtCapacidade.getText()));
        obj.setCompanhia(txtComp.getText());
        obj.setContacto(txtContacto.getText());
        NaviosDAO dao = new NaviosDAO();
        dao.Salvar(obj);
        Utilitarios util = new Utilitarios();
        util.LimpaTela(painelDadosPessoais);

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
       String nome = txtNome.getText();
       Navios obj = new Navios();
       NaviosDAO dao = new NaviosDAO();
       
       obj = dao.BuscarNavio(nome);
       if(obj.getNome() != null ){
           txtCodigo.setText(String.valueOf(obj.getId()));
           txtNome.setText(obj.getNome());
           txtBandeira.setText(obj.getBandeira());
           txtTipo.setText(obj.getTipoNavio());
           txtTipo.setText(obj.getTipoNavio());
           txtCapacidade.setText(String.valueOf(obj.getCapacidade()));
           txtComp.setText(obj.getCompanhia());
           txtContacto.setText(obj.getContacto());

       }else{
           JOptionPane.showMessageDialog(null,"Navio não encontrado!");
       }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // Parte priorizada antes ser executada qualquer coisa no código.
        listar();
    }//GEN-LAST:event_formWindowActivated

    private void btnPesquisaNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaNomeActionPerformed
        // Método para pesquisar e filtrar os dados da tabela pelo botão Pesquisar.
        String nome = "%" + txtPesquisaNome.getText() + "%";
        NaviosDAO dao = new NaviosDAO();
        List<Navios> lista = dao.Filtrar(nome);
        DefaultTableModel dados = (DefaultTableModel) tabela.getModel();
        dados.setNumRows(0);
        for (Navios n : lista) {
            dados.addRow(new Object[]{
                n.getId(),
                n.getNome(),
                n.getBandeira(),
                n.getTipoNavio(),
                n.getCapacidade(),
                n.getCompanhia(),
                n.getContacto()

            });
        }
    }//GEN-LAST:event_btnPesquisaNomeActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        Navios obj = new Navios();
        Navios n = new Navios();
        obj.setNome(txtNome.getText());
        obj.setBandeira(txtBandeira.getText());
        obj.setTipoNavio(txtTipo.getText());
        obj.setCapacidade(Double.valueOf(txtCapacidade.getText()));
        obj.setCompanhia(txtComp.getText());
        obj.setContacto(txtContacto.getText());
        obj.setId(Integer.valueOf(txtCodigo.getText()));

        NaviosDAO daop = new NaviosDAO();
        daop.Editar(obj);
        Utilitarios util = new Utilitarios();
        util.LimpaTela(painelDadosPessoais);

    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        Navios obj = new Navios();
        obj.setId(Integer.valueOf(txtCodigo.getText()));
        NaviosDAO daop = new NaviosDAO();
        daop.Excluir(obj);
        Utilitarios util = new Utilitarios();
        util.LimpaTela(painelDadosPessoais);
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        //Preencher o editor das localizações com as informações da tabela
        Painel_Guias.setSelectedIndex(0);
        txtCodigo.setText(tabela.getValueAt(tabela.getSelectedRow(), 0).toString());
        txtNome.setText(tabela.getValueAt(tabela.getSelectedRow(), 1).toString());
        txtBandeira.setText(tabela.getValueAt(tabela.getSelectedRow(), 2).toString());
        txtTipo.setText(tabela.getValueAt(tabela.getSelectedRow(), 3).toString());
        txtCapacidade.setText(tabela.getValueAt(tabela.getSelectedRow(), 4).toString());
        txtComp.setText(tabela.getValueAt(tabela.getSelectedRow(), 5).toString());
        txtContacto.setText(tabela.getValueAt(tabela.getSelectedRow(), 6).toString());

    }//GEN-LAST:event_tabelaMouseClicked

    private void txtPesquisaNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaNomeKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisaNomeKeyPressed

    private void txtPesquisaNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaNomeKeyReleased
        //Método para pesquisar e filtrar os dados da tabela pelo botão Pesquisar.
        String nome = "%" + txtPesquisaNome.getText() + "%";
        NaviosDAO dao = new NaviosDAO();
        List<Navios> lista = dao.Filtrar(nome);
        DefaultTableModel dados = (DefaultTableModel) tabela.getModel();
        dados.setNumRows(0);
        for (Navios n : lista) {
            dados.addRow(new Object[]{
                n.getId(),
                n.getNome(),
                n.getBandeira(),
                n.getTipoNavio(),
                n.getCapacidade(),
                n.getCompanhia(),
                n.getContacto()

            });
        }
    }//GEN-LAST:event_txtPesquisaNomeKeyReleased

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String nome = txtNome.getText();
            Navios obj = new Navios();
            NaviosDAO dao = new NaviosDAO();

            obj = dao.BuscarNavio(nome);
            if (obj.getNome() != null) {
                txtCodigo.setText(String.valueOf(obj.getId()));
                txtNome.setText(obj.getNome());
                txtComp.setText(obj.getCompanhia());
                txtTipo.setText(obj.getTipoNavio());
                txtBandeira.setText(obj.getBandeira());
                txtCapacidade.setText(String.valueOf(obj.getCapacidade())); //Tratamento do Double
                txtComp.setText(obj.getCompanhia());
                txtContacto.setText(obj.getContacto());
            } else {
                JOptionPane.showMessageDialog(null, "Navio não encontrado!");
            }

        }
    }//GEN-LAST:event_txtNomeKeyPressed

    private void txtBandeiraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBandeiraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBandeiraActionPerformed

    private void txtCapacidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCapacidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCapacidadeActionPerformed

    private void txtCompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCompActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCompActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormularioNavios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioNavios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioNavios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioNavios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioNavios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTabbedPane Painel_Guias;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisaNome;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel painelDadosPessoais;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtBandeira;
    private javax.swing.JTextField txtCapacidade;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtComp;
    private javax.swing.JTextArea txtContacto;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPesquisaNome;
    private javax.swing.JFormattedTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}