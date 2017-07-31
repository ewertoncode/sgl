/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.sgpl.apresentacao;

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
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Emerson Pereira
 */
public class PedidoEditar extends TelaEdicao<Pedido> {

    private List<Vector> listaUsuarios = new Vector();
    private List<Vector> listaProdutos = new Vector();
    private List<Vector> listaFornecedores = new Vector();
    private List<Vector> listaItensPedido = new Vector();

    /**
     * Creates new form PedidoEditar
     */
    
    public PedidoEditar() {
        initComponents();       
        
        List<Usuario> usuarios = this.getUsuarios();                        
        ComboBoxModel modeloUsuarios = new DefaultComboBoxModel(usuarios.toArray());
        cbxUsuario.setModel(modeloUsuarios);
        
        for (Usuario p : usuarios) {
            cbxUsuario.addItem(p.toString());
        }
        
        List<Produto> produtos = this.getProdutos();                        
        ComboBoxModel modeloProdutos = new DefaultComboBoxModel(produtos.toArray());
        cbxProduto.setModel(modeloProdutos);                

        for (Produto p : produtos) {
            cbxProduto.addItem(p.toString());
        }

        List<Fornecedor> fornecedores1 = this.getFornecedores();
        ComboBoxModel modeloFornecedores1 = new DefaultComboBoxModel(fornecedores1.toArray());
        cbxFornecedor1.setModel(modeloFornecedores1);
        
        for (Fornecedor f : fornecedores1) {
            cbxFornecedor1.addItem(f.toString());
        }

        List<Fornecedor> fornecedores2 = this.getFornecedores();
        ComboBoxModel modeloFornecedores2 = new DefaultComboBoxModel(fornecedores2.toArray());
        cbxFornecedor2.setModel(modeloFornecedores2);
        
        for (Fornecedor f : fornecedores2) {
            cbxFornecedor2.addItem(f.toString());
        }

        List<Fornecedor> fornecedores3 = this.getFornecedores();
        ComboBoxModel modeloFornecedores3 = new DefaultComboBoxModel(fornecedores3.toArray());
        cbxFornecedor3.setModel(modeloFornecedores3);
        
        for (Fornecedor f : fornecedores3) {
            cbxFornecedor3.addItem(f.toString());
        }
        
        
        
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

    private List getFornecedores() {

        Fornecedor filtroFornecedor = new Fornecedor();

        Repositorio<Fornecedor> repositorioFornecedor = Repositorios.getFornecedorRepositorio();

        List<Fornecedor> fornecedores = repositorioFornecedor.Buscar(filtroFornecedor);

        return fornecedores;
    }
    
    private List setFornecedorInList(Vector fornecedor) {
        
        listaFornecedores.add(fornecedor);
        
        return this.listaFornecedores;
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

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnCancelar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnApagar)
                                        .addGap(124, 124, 124))
                                    .addGroup(layout.createSequentialGroup()
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
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtValor3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtValor3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnAdicionar))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(33, 33, 33))
                                    .addComponent(txtValor2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtValor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnSalvar)
                    .addComponent(btnApagar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
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
        salvar();
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
        
        String produto = String.valueOf(cbxProduto.getSelectedItem());
        String[] split = produto.split("-");                
        linha.add(split[1]);
        linha.add(txtQuantidade.getText()); 
        
        String forn1 = String.valueOf(cbxFornecedor1.getSelectedItem());        
        String[] fornecedor1 = forn1.split("-");                
        linha.add(fornecedor1[2]);        
        String valor1 = String.valueOf(txtValor1.getText());        
        linha.add(txtValor1.getText());
                
        String forn2 = String.valueOf(cbxFornecedor2.getSelectedItem());        
        String[] fornecedor2 = forn2.split("-");                
        linha.add(fornecedor2[2]);        
        String valor2 = String.valueOf(txtValor2.getText());       
        linha.add(txtValor2.getText());
                
        String forn3 = String.valueOf(cbxFornecedor3.getSelectedItem());        
        String[] fornecedor3 = forn3.split("-");                
        linha.add(fornecedor3[2]);
        String valor3 = String.valueOf(txtValor3.getText());        
        linha.add(txtValor3.getText());
        
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

    //UsuarioRepositorio usuarios;
    //ItemPedidoRepositorio itensPedidos;
    //FornecedorRepositorio fornecedores;
    //ProdutoRepositorio produtos;
    @Override
    public void carregaCampos() {

        /*       
        cbxUsuario.setSelectedItem(entidade.getUsuario().getId());
        
        cbxFornecedor1.setSelectedItem(fornecedores.Abrir(entidade.getId()));
        cbxFornecedor2.setSelectedItem(fornecedores.Abrir(entidade.getId()));        
        cbxFornecedor3.setSelectedItem(fornecedores.Abrir(entidade.getId()));                        
        cbxProduto.setSelectedItem(produtos.Abrir(entidade.getId()));
        
        //txtQuantidade.setText(String.valueOf(itensPedidos.Abrir(entidade.getId())));
        //((itensPedidos.Abrir(entidade.getId())));        
        //txtValor1.setText(Double.toString(itensPedidos.Abrir(entidade.getId())));
        //txtValor2.setText(Double.toString(itensPedidos.Abrir(entidade.getId())));
        //txtValor3.setText(Double.toString(itensPedidos.Abrir(entidade.getId())));        
         */
    }

    @Override
    public void carregaObjeto() throws ViolacaoRegraDeNegocioException {

        //Pegar data do sistema
        //entidade.setData("");
        //entidade.setUsuario((Usuario)cbxUsuario.getSelectedItem());
        //entidade.getUsuario().setUsuario((Usuario)cbxUsuario.getSelectedItem());
        //entidade.getPedido().setId();
        //entidade.getSetor().setNome(txtNome.getText());
    }

    @Override
    public boolean verificarCamposObrigatorios() {
        return true;
    }
    
}
