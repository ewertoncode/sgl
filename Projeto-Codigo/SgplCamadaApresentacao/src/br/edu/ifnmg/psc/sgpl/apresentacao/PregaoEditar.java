/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.sgpl.apresentacao;

import br.edu.ifnmg.psc.sgpl.aplicacao.Aplicacao;
import br.edu.ifnmg.psc.sgpl.aplicacao.ItemPedido;
import br.edu.ifnmg.psc.sgpl.aplicacao.ItemPregao;
import br.edu.ifnmg.psc.sgpl.aplicacao.ItemPregaoRepositorio;
import br.edu.ifnmg.psc.sgpl.aplicacao.Pedido;
import br.edu.ifnmg.psc.sgpl.aplicacao.Pregao;
import br.edu.ifnmg.psc.sgpl.aplicacao.StatusPregao;
import br.edu.ifnmg.psc.sgpl.aplicacao.ViolacaoRegraDeNegocioException;
import java.util.List;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import br.edu.ifnmg.psc.sgpl.aplicacao.Produto;
import br.edu.ifnmg.psc.sgpl.aplicacao.Repositorio;
import br.edu.ifnmg.psc.sgpl.persistencia.ItemPregaoDao;
import br.edu.ifnmg.psc.sgpl.persistencia.PregaoDao;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ewertoncardoso
 */
public class PregaoEditar extends TelaEdicao<Pregao> {

    private List<Vector> listaProdutos = new Vector();
    /**
     * Creates new form PregaoEditar
     */
    public PregaoEditar() {
        initComponents();

        entidade = new Pregao();

        ComboBoxModel model = new DefaultComboBoxModel(StatusPregao.values());
        selStatus.setModel(model);

        DefaultTableModel modelo = new DefaultTableModel();

        // Informa quais as colunas da tabela 
        modelo.addColumn("Cod");
        modelo.addColumn("Produto");
        modelo.addColumn("Quantidade");
        modelo.addColumn("Valor Referência");

        tblProdutos.setModel(modelo);

        List<Produto> produtos = this.getProdutos();
        ComboBoxModel modelProduto = new DefaultComboBoxModel(produtos.toArray());
        selProduto.setModel(modelProduto);

        List<Pedido> pedidos = this.getPedidos();
        ComboBoxModel modelPedido = new DefaultComboBoxModel(pedidos.toArray());
        selPedido.setModel(modelPedido);

        selPedido.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if (selPedido.getSelectedItem() == null) {
                        return;
                    }
                    DefaultTableModel modelo = new DefaultTableModel();

                    modelo.addColumn("Cod");
                    modelo.addColumn("Produto");
                    modelo.addColumn("Quantidade");
                    modelo.addColumn("Valor Referência");

                    Repositorio<Pedido> repositorioPedido = Repositorios.getPedidoRepositorio();

                    Pedido pedido = repositorioPedido.Abrir(((Pedido) selPedido.getSelectedItem()).getId());

                    List<ItemPedido> itens = pedido.getItens();

                    //List<ItemPedido> itens = ((Pedido)selPedido.getSelectedItem()).getItens();
                    if (itens != null) {

                        for (ItemPedido item : itens) {
                            Vector linha = new Vector();
                            linha.add(item.getProduto().getId());
                            linha.add(item.getProduto().getNome());
                            linha.add(item.getQuantidade());

                            double media = (item.getValorFornecedor1() + item.getValorFornecedor2() + item.getValorFornecedor3()) / 3;
                            linha.add(media);

                            modelo.addRow(linha);
                            setProdutoInList(linha);

                        }
                    }

                    tblProdutos.setModel(modelo);
                }
            }

        });
        
        

    }

    private List getProdutos() {

        Repositorio<Produto> repositorioProduto = Repositorios.getProdutoRepositorio();

        List<Produto> produtos = repositorioProduto.Buscar(null);

        return produtos;
    }

    private List getPedidos() {

        Repositorio<Pedido> repositorioPedido = Repositorios.getPedidoRepositorio();

        List<Pedido> pedidos = repositorioPedido.Buscar(null);

        return pedidos;
    }

    private List setProdutoInList(Vector item) {

        listaProdutos.add(item);

        return this.listaProdutos;
    }


    @Override
    public void carregaCampos() {
        selPedido.setSelectedItem(entidade.getPedido());
        cmpQtdDias.setValue(entidade.getDiasEntrega());
        selStatus.setSelectedItem(entidade.getStatus());
    }

    @Override
    public void carregaObjeto() throws ViolacaoRegraDeNegocioException {
        //DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        java.sql.Date d = new java.sql.Date(date.getTime());
        entidade.setData(d);
        entidade.setDiasEntrega((Integer) cmpQtdDias.getValue());
        entidade.setStatus((StatusPregao) selStatus.getSelectedItem());
        //entidade.setUsuario(Aplicacao.getUsuario());
    }

    @Override
    public boolean verificarCamposObrigatorios() {
        return !listaProdutos.isEmpty();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        selPedido = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        selProduto = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtQtd = new javax.swing.JTextField();
        btnAdicionar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        selStatus = new javax.swing.JComboBox<>();
        cmpQtdDias = new javax.swing.JSpinner();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtValReferencia = new javax.swing.JTextField();
        alterarSituacao = new javax.swing.JButton();

        setClosable(true);
        setTitle("SGPL - Editar Pregão");

        jLabel1.setText("Pedido");

        selPedido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        selPedido.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                selPedidoItemStateChanged(evt);
            }
        });
        selPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selPedidoActionPerformed(evt);
            }
        });

        jLabel2.setText("Quantidade dias p/ entrega");

        jLabel3.setText("Itens do pedido");

        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblProdutos);

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel4.setText("Adicionar mais produtos ao pregão");

        jLabel5.setText("Produto");

        jLabel6.setText("Quantidade");

        txtQtd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtdActionPerformed(evt);
            }
        });

        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/psc/sgpl/apresentacao/adicionar.png"))); // NOI18N
        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        jLabel7.setText("Status");

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/psc/sgpl/apresentacao/salvar.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/psc/sgpl/apresentacao/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");

        btnDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/psc/sgpl/apresentacao/apagar.png"))); // NOI18N
        btnDeletar.setText("Deletar");

        jLabel8.setText("Val. Ref");

        alterarSituacao.setText("Alterar Situação do item");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(selProduto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtValReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(23, 23, 23))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel8)
                                        .addGap(71, 71, 71)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnAdicionar))
                                    .addComponent(jLabel6))))
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(selPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(cmpQtdDias, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(selStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDeletar)
                .addGap(18, 18, 18)
                .addComponent(alterarSituacao)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmpQtdDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(selProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtValReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar)
                    .addComponent(btnDeletar)
                    .addComponent(alterarSituacao))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtQtdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQtdActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("Cod");
        modelo.addColumn("Produto");
        modelo.addColumn("Quantidade");
        modelo.addColumn("Valor Referência");

        Vector linha = new Vector();

        String produto = String.valueOf(selProduto.getSelectedItem());
        String[] split = produto.split("-");
        linha.add(((Produto) selProduto.getSelectedItem()).getId());
        linha.add(((Produto) selProduto.getSelectedItem()).getNome());
        linha.add(txtQtd.getText());
        linha.add(txtValReferencia.getText());

        this.setProdutoInList(linha);

        for (Vector v : this.listaProdutos) {
            modelo.addRow(v);
        }
        tblProdutos.setModel(modelo);

    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (!verificarCamposObrigatorios()) {
            JOptionPane.showMessageDialog(rootPane, "Todos os campos são de preenchimento obrigatório!");
            return;
        }

        if (JOptionPane.showConfirmDialog(rootPane, "Deseja realmente salvar o pregao?") == 0) {

            try {
                carregaObjeto();

            } catch (ViolacaoRegraDeNegocioException ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
                return;
            }

            if (repositorio.Salvar(entidade)) {

                
                Pregao last = null;
                
                try {
                    PregaoDao pregaoDao = new PregaoDao();
                    last = pregaoDao.getLast();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(PregaoEditar.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(PregaoEditar.class.getName()).log(Level.SEVERE, null, ex);
                }
                
               
                
                //Salvar itens
   
                for (Vector v : this.listaProdutos) {
                    Repositorio<Produto> repositorioProduto = Repositorios.getProdutoRepositorio();
                    Produto produto = repositorioProduto.Abrir((int) v.get(0));
                    ItemPregaoRepositorio daoItemPregao;
                    try {
                        daoItemPregao = new ItemPregaoDao();
                        ItemPregao itemPregao = new ItemPregao(0, (double) v.get(2), (double) v.get(3), last, produto, null, null);
                        boolean salvarItem = daoItemPregao.Salvar(itemPregao);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(PregaoEditar.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(PregaoEditar.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    
                }

                JOptionPane.showMessageDialog(rootPane, "Registro salvo com sucesso!");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Falha ao salvar o registro!");
            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "Operação Cancelada!");
        }
        cancelar();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void selPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selPedidoActionPerformed

    }//GEN-LAST:event_selPedidoActionPerformed


    private void selPedidoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_selPedidoItemStateChanged

        
    }//GEN-LAST:event_selPedidoItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alterarSituacao;
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JSpinner cmpQtdDias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> selPedido;
    private javax.swing.JComboBox<String> selProduto;
    private javax.swing.JComboBox<String> selStatus;
    private javax.swing.JTable tblProdutos;
    private javax.swing.JTextField txtQtd;
    private javax.swing.JTextField txtValReferencia;
    // End of variables declaration//GEN-END:variables

}
