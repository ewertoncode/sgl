/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.sgpl.apresentacao;

import br.edu.ifnmg.psc.sgpl.aplicacao.Aplicacao;
import br.edu.ifnmg.psc.sgpl.aplicacao.Fornecedor;
import br.edu.ifnmg.psc.sgpl.aplicacao.FornecedorRepositorio;
import br.edu.ifnmg.psc.sgpl.aplicacao.ItemPedido;
import br.edu.ifnmg.psc.sgpl.aplicacao.ItemPedidoRepositorio;
import br.edu.ifnmg.psc.sgpl.aplicacao.Pedido;
import br.edu.ifnmg.psc.sgpl.aplicacao.Produto;
import br.edu.ifnmg.psc.sgpl.aplicacao.ProdutoRepositorio;
import br.edu.ifnmg.psc.sgpl.aplicacao.Repositorio;
import br.edu.ifnmg.psc.sgpl.aplicacao.Usuario;
import br.edu.ifnmg.psc.sgpl.aplicacao.UsuarioRepositorio;
import br.edu.ifnmg.psc.sgpl.aplicacao.ViolacaoRegraDeNegocioException;
import br.edu.ifnmg.psc.sgpl.persistencia.PedidoDao;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Emerson Pereira
 */
public class PedidoEditar extends TelaEdicao<Pedido> {

    private List<Vector> listaUsuarios = new Vector();
    private List<Vector> listaProdutos = new Vector();
    private List<Vector> listaFornecedores1 = new Vector();
    private List<Vector> listaFornecedores2 = new Vector();
    private List<Vector> listaFornecedores3 = new Vector();
    private List<Vector> listaItensPedido = new Vector();        
    
    private List<Vector> listaSalvaItens = new Vector();
    /**
     * Creates new form PedidoEditar
     */
    
    public PedidoEditar() {    
        initComponents();                       
        
        entidade = new Pedido();              
        
        DefaultTableModel modelo = new DefaultTableModel();
                
        modelo.addColumn("Produto");
        modelo.addColumn("Quantidade");
        modelo.addColumn("Fornecedor 1");
        modelo.addColumn("Valor");
        modelo.addColumn("Fornecedor 2");
        modelo.addColumn("Valor");
        modelo.addColumn("Fornecedor 3");                
        modelo.addColumn("Valor");

        tblItem.setModel(modelo);
        
        List<Usuario> usuarios = this.getUsuarios();                                                        
        ComboBoxModel modelUsuario = new DefaultComboBoxModel(usuarios.toArray());
        cbxUsuario.setModel(modelUsuario);             
        
        List<Produto> produtos = this.getProdutos();                                           
        ComboBoxModel modelProduto = new DefaultComboBoxModel(produtos.toArray());
        cbxProduto.setModel(modelProduto);

        List<Fornecedor> fornecedores1 = this.getFornecedores();        
        ComboBoxModel modelFornecedor1 = new DefaultComboBoxModel(fornecedores1.toArray());
        cbxFornecedor1.setModel(modelFornecedor1);

        List<Fornecedor> fornecedores2 = this.getFornecedores();        
        ComboBoxModel modelFornecedor2 = new DefaultComboBoxModel(fornecedores2.toArray());
        cbxFornecedor2.setModel(modelFornecedor2);

        List<Fornecedor> fornecedores3 = this.getFornecedores();        
        ComboBoxModel modelFornecedor3 = new DefaultComboBoxModel(fornecedores3.toArray());
        cbxFornecedor3.setModel(modelFornecedor3);        
        
    }
    
    private List getUsuarios() {

        Usuario filtroUsuario = new Usuario();

        Repositorio<Usuario> repositorioUsuario = Repositorios.getUsuarioRepositorio();

        List<Usuario> usuarios = repositorioUsuario.Buscar(filtroUsuario);

        return usuarios;
    }
    
    private List setUsuarioInList(Vector usuario) {
        
        listaUsuarios.add(usuario);
        
        return this.listaUsuarios;
    }

    private List getProdutos() {

        Produto filtroProduto = new Produto();

        Repositorio<Produto> repositorioProduto = Repositorios.getProdutoRepositorio();

        List<Produto> produtos = repositorioProduto.Buscar(filtroProduto);

        return produtos;
    }
    
    private List setProdutoInList(Vector produto) {
        
        listaProdutos.add(produto);
        
        return this.listaProdutos;
    } 
    
    private List setSalvaItens(Vector ItensPedido) {
        
        listaSalvaItens.add(ItensPedido);
        
        return this.listaSalvaItens;
    } 
    
    
    

    private List getFornecedores() {

        Fornecedor filtroFornecedor = new Fornecedor();

        Repositorio<Fornecedor> repositorioFornecedor = Repositorios.getFornecedorRepositorio();

        List<Fornecedor> fornecedores = repositorioFornecedor.Buscar(filtroFornecedor);

        return fornecedores;
    }
    
    private List setFornecedor1InList(Vector fornecedor) {
        
        listaFornecedores1.add(fornecedor);
        
        return this.listaFornecedores1;
    }
    
    private List setFornecedor2InList(Vector fornecedor) {
        
        listaFornecedores2.add(fornecedor);
        
        return this.listaFornecedores2;
    }
    
    private List setFornecedor3InList(Vector fornecedor) {
        
        listaFornecedores3.add(fornecedor);
        
        return this.listaFornecedores3;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnApagar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbxProduto = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        btnAdicionar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblItem = new javax.swing.JTable();
        cbxUsuario = new javax.swing.JComboBox<>();
        cbxFornecedor1 = new javax.swing.JComboBox<>();
        cbxFornecedor2 = new javax.swing.JComboBox<>();
        cbxFornecedor3 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        txtValor1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtValor2 = new javax.swing.JTextField();
        txtValor3 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/psc/sgpl/apresentacao/salvar.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/psc/sgpl/apresentacao/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnApagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/psc/sgpl/apresentacao/apagar.png"))); // NOI18N
        btnApagar.setText("Apagar");
        btnApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApagarActionPerformed(evt);
            }
        });

        jLabel1.setText("Solicitante:");

        jLabel2.setText("Produto:");

        cbxProduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProdutoActionPerformed(evt);
            }
        });

        jLabel3.setText("Quantidade:");

        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/psc/sgpl/apresentacao/adicionar.png"))); // NOI18N
        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        tblItem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Produto", "Quantidade", "Fornecedor 1", "Valor", "Fornecedor 2", "Valor", "Formecedor 3", "Valor"
            }
        ));
        jScrollPane1.setViewportView(tblItem);

        cbxUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxUsuarioActionPerformed(evt);
            }
        });

        cbxFornecedor1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxFornecedor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxFornecedor1ActionPerformed(evt);
            }
        });

        cbxFornecedor2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxFornecedor3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("Fonecedor 1:");

        jLabel7.setText("Fornecedor 2:");

        jLabel8.setText("Fornecedor 3:");

        txtQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantidadeActionPerformed(evt);
            }
        });

        txtValor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValor1ActionPerformed(evt);
            }
        });

        jLabel9.setText("Valor 1:");

        jLabel10.setText("Valor 2:");

        txtValor2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValor2ActionPerformed(evt);
            }
        });

        jLabel11.setText("Valor 3:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cbxFornecedor1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbxFornecedor2, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel7)
                                        .addGap(194, 194, 194)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(cbxFornecedor3, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(cbxUsuario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel9)
                                    .addComponent(txtValor1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel10)
                                    .addComponent(txtValor2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(txtValor3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(240, 240, 240)
                                        .addComponent(btnSalvar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnCancelar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnApagar)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(38, 38, 38)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxFornecedor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxFornecedor2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxFornecedor3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAdicionar)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtValor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtValor2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtValor3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSalvar)
                            .addComponent(btnCancelar)
                            .addComponent(btnApagar)))
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxUsuarioActionPerformed

    private void txtQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantidadeActionPerformed

    private void txtValor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValor1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValor1ActionPerformed

    private void txtValor2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValor2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValor2ActionPerformed

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
                
                Pedido last = null;
                
                try {
                    PedidoDao pedidoDao = new PedidoDao();
                    last = pedidoDao.getLast();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(PedidoEditar.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(PedidoEditar.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                for (Vector v : this.listaSalvaItens) {

                    ItemPedido itemPedido = new ItemPedido();

                    itemPedido.setPedido(last);
                    itemPedido.setProduto((Produto) v.get(0));
                    itemPedido.setQuantidade(Double.parseDouble(v.get(1).toString()));
                    itemPedido.setFornecedor1((Fornecedor) v.get(2));
                    itemPedido.setValorFornecedor1(Double.parseDouble(v.get(3).toString()));
                    itemPedido.setFornecedor2((Fornecedor) v.get(4));
                    itemPedido.setValorFornecedor2(Double.parseDouble(v.get(5).toString()));
                    itemPedido.setFornecedor3((Fornecedor) v.get(6));
                    itemPedido.setValorFornecedor3(Double.parseDouble(v.get(7).toString()));

                    Repositorio<ItemPedido> repositorioItemPedido = Repositorios.getItemPedidoRepositorio();
                    try {
                        if (repositorioItemPedido.Salvar(itemPedido)) {
                            JOptionPane.showMessageDialog(rootPane, "Registro salvo com sucesso!");
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Falha ao salvar Registro!");
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(rootPane, e.getMessage());
                        return;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Falha ao salvar Registro!");
            }
        }

        cancelar();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        cancelar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarActionPerformed
        apagar();
    }//GEN-LAST:event_btnApagarActionPerformed

    private void cbxProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxProdutoActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed

        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("Produto");
        modelo.addColumn("Quantidade");
        modelo.addColumn("Fornecedor 1");
        modelo.addColumn("Valor");
        modelo.addColumn("Fornecedor 2");
        modelo.addColumn("Valor");
        modelo.addColumn("Fornecedor 3");
        modelo.addColumn("Valor");

        Vector linha = new Vector();
        Vector salvaItens = new Vector();

        linha.add(((Produto) cbxProduto.getSelectedItem()).getNome());
        linha.add(txtQuantidade.getText());
        linha.add(((Fornecedor) cbxFornecedor1.getSelectedItem()).getNomeFantasia());
        linha.add(txtValor1.getText());
        linha.add(((Fornecedor) cbxFornecedor2.getSelectedItem()).getNomeFantasia());
        linha.add(txtValor2.getText());
        linha.add(((Fornecedor) cbxFornecedor3.getSelectedItem()).getNomeFantasia());
        linha.add(txtValor3.getText());

        salvaItens.add(((Produto) cbxProduto.getSelectedItem()));
        salvaItens.add(txtQuantidade.getText());
        salvaItens.add(((Fornecedor) cbxFornecedor1.getSelectedItem()));
        salvaItens.add(txtValor1.getText()); 
        salvaItens.add(((Fornecedor)cbxFornecedor2.getSelectedItem()));
        salvaItens.add(txtValor2.getText()); 
        salvaItens.add(((Fornecedor)cbxFornecedor3.getSelectedItem()));
        salvaItens.add(txtValor3.getText());                         
        
        this.setSalvaItens(salvaItens);
        
        this.setProdutoInList(linha);
        
        for(Vector v : this.listaProdutos) {
            modelo.addRow(v);
        }                
        
        tblItem.setModel(modelo);                 
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void cbxFornecedor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxFornecedor1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxFornecedor1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnApagar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbxFornecedor1;
    private javax.swing.JComboBox<String> cbxFornecedor2;
    private javax.swing.JComboBox<String> cbxFornecedor3;
    private javax.swing.JComboBox<String> cbxProduto;
    private javax.swing.JComboBox<String> cbxUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblItem;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtValor1;
    private javax.swing.JTextField txtValor2;
    private javax.swing.JTextField txtValor3;
    // End of variables declaration//GEN-END:variables
    
               
    @Override
    public void carregaCampos() {  
        cbxUsuario.setSelectedItem(entidade.getUsuario());
        //Como retornar apenas um atributo(Quantidade)????
        txtQuantidade.setText(entidade.getItens().toString());
        //cbxFornecedor1.setSelectedItem(entidade.);
        
    }   

    List<Produto> produtos = this.getProdutos();        
    
    @Override
    public void carregaObjeto() throws ViolacaoRegraDeNegocioException {                
        
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String date = df.format(new Date());
        entidade.setData(date);
        entidade.setUsuario((Usuario)cbxUsuario.getSelectedItem());                
    }

    @Override
    public boolean verificarCamposObrigatorios() {
        return !listaProdutos.isEmpty();
    }    
}
