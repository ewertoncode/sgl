/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.sgpl.apresentacao;

import br.edu.ifnmg.psc.sgpl.aplicacao.Pedido;
import br.edu.ifnmg.psc.sgpl.aplicacao.Pregao;
import br.edu.ifnmg.psc.sgpl.aplicacao.Repositorio;
import br.edu.ifnmg.psc.sgpl.aplicacao.Setor;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ewertoncardoso
 */
public class PregaoBuscar extends TelaBusca<Pregao> {
 
    /**
     * Creates new form PregaoBuscar
     */
    public PregaoBuscar(Repositorio<Pregao> repositorio, Class tipo_tela) {
        super(repositorio, tipo_tela);
        initComponents();     
        filtro = new Pregao();
        buscar();
        
    }
    
    @Override
    public int retornaIdSelecionado() {
        int linha = tblBusca.getSelectedRow();
        
        if(tblBusca.getModel().getRowCount() > 0) {
            int id = Integer.parseInt( tblBusca.getModel().getValueAt(linha, 0).toString() );
            return id;
        } else {
            return 0;
        }
        
        
        
    }

    @Override
    public void preencheFiltro() {
        try {    
            filtro.setId(0);
            filtro.setPedido(null);
            if(!txtCodPregao.getText().isEmpty())
               filtro.setId(Integer.parseInt(txtCodPregao.getText()));
            
            if(!txtCodPedido.getText().isEmpty()) {
                Repositorio<Pedido> repositorioPedido = Repositorios.getPedidoRepositorio();
                Pedido pedido = repositorioPedido.Abrir(Integer.parseInt(txtCodPedido.getText()));
                filtro.setPedido(pedido);    
            }
               
                        
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());                        
        }  
    }

    @Override
    public void preencheTabela(List<Pregao> listagem) {
        DefaultTableModel modelo = new DefaultTableModel();
        
        // Informa quais as colunas da tabela        
        modelo.addColumn("Cód. Pregão");
        modelo.addColumn("Qtd Itens"); 
        modelo.addColumn("Pedido"); 
        modelo.addColumn("Data"); 
        modelo.addColumn("Dias entrega");  
        
        // Adiciona as linhas da tabela        
        for(Pregao s : listagem){                        
            
            
            
            Pregao pregao = repositorio.Abrir(s.getId());
            int qtdItens = 0;
            if(pregao.getItens() != null) {
                qtdItens = pregao.getItens().size();
            }
            SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");  
            Vector linha = new Vector();
            
            int pedidoId = 0;
            
            if(pregao.getPedido() != null)
                pedidoId = pregao.getPedido().getId();
            
            linha.add(s.getId());
            linha.add(qtdItens);
            linha.add((pedidoId > 0) ? pedidoId : "");  
            linha.add(fmt.format(s.getData()));
            linha.add(s.getDiasEntrega());
                                                
            modelo.addRow(linha);
        }
        
        tblBusca.setModel(modelo);
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
        txtCodPregao = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBusca = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        txtCodPedido = new javax.swing.JTextField();

        setClosable(true);
        setTitle("SGPL - Pregões");

        jLabel1.setText("Cód. Pregão");

        txtCodPregao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodPregaoActionPerformed(evt);
            }
        });

        jLabel2.setText("Cód. Pedido");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tblBusca.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblBusca);

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/psc/sgpl/apresentacao/novo.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/psc/sgpl/apresentacao/editar.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtCodPregao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCodPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscar)))
                        .addGap(298, 377, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNovo)
                                .addGap(18, 18, 18)
                                .addComponent(btnEditar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 17, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodPregao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(btnNovo))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodPregaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodPregaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodPregaoActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        novo();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        editar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscar();
    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBusca;
    private javax.swing.JTextField txtCodPedido;
    private javax.swing.JTextField txtCodPregao;
    // End of variables declaration//GEN-END:variables

    
}
