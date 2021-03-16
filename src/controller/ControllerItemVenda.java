/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DAOItemVenda;
import dao.DAOProduto;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.ModelItemVenda;
import model.ModelProduto;
import view.ViewVendaProdutoConsulta;

/**
 *
 * @author joao
 */
public class ControllerItemVenda {

    private ViewVendaProdutoConsulta vpc;

    public ControllerItemVenda(ViewVendaProdutoConsulta vpc) {
        this.vpc = vpc;
    }

    public void consultaProduto() throws SQLException {
        DAOItemVenda dao = new DAOItemVenda();
        if (dao.consultaProduto() == null) {
            vpc.table.setNumRows(0);
        } else {
            for (ModelItemVenda i : dao.consultaProduto()) {
                vpc.table.addRow(new Object[]{
                    i.getIdProduto(),
                    i.getNomeProduto(),
                    i.getQtdItens(),
                    i.getValorTotal()
                });
            }
        }
    }

    public void procurar() throws SQLException {
        String nome = vpc.getjTFnome().getText();
        DAOItemVenda dao = new DAOItemVenda();
        ModelItemVenda item = new ModelItemVenda(nome);

        if (dao.procurar(item) == null) {
            consultaProduto();
        } else {
            for (ModelItemVenda i : dao.procurar(item)) {
                vpc.table.addRow(new Object[]{
                    i.getIdProduto(),
                    i.getNomeProduto(),
                    i.getQtdItens(),
                    i.getValorTotal()
                });
            }
        }
    }

    public void pegaCamposTabelaItens() throws SQLException {
        int row = vpc.getjTable1().getSelectedRow();

        String nome = vpc.getjTable1().getValueAt(row, 1).toString();
        int quantidade = (int) vpc.getjTable1().getValueAt(row, 2);
        float valorUnitario = (float) vpc.getjTable1().getValueAt(row, 3);
        float valorTotal = valorUnitario * quantidade;

        vpc.jTFnmProduto.setText(nome);
        vpc.jTFnome.setText(nome);
        vpc.jTFquantidade.setText(String.valueOf(quantidade));
        vpc.jTFvalorUnitario.setText(String.valueOf(valorUnitario));
        vpc.jTFvalorTotal.setText(String.valueOf(valorTotal));
    }

    public void insert() throws SQLException {
        int row = vpc.getjTable1().getSelectedRow();
        int idProduto = (int) vpc.getjTable1().getValueAt(row, 0);
        int qtdEstoque = (int) vpc.getjTable1().getValueAt(row, 2);
        String nome = vpc.jTFnome.getText();
        int quantidadeDesejada = Integer.parseInt(vpc.jTFquantidade.getText());
        float valorUnitario = Float.parseFloat(vpc.jTFvalorUnitario.getText());
        float valorTotal = valorUnitario * quantidadeDesejada;

        DAOItemVenda dao = new DAOItemVenda();

        int idVenda = dao.getMaxIdVenda() + 1;
        ModelItemVenda item = new ModelItemVenda(idProduto, idVenda, nome, quantidadeDesejada, valorTotal);

        try {
            if (quantidadeDesejada > qtdEstoque) {
                JOptionPane.showMessageDialog(null, "Não é possível vender mais itens do que a quantidade em estoque!");
            } else {
                //int quantidade = qtdEstoque - quantidadeDesejada;
                dao.insert(item);
                dao.updateProduto(item, qtdEstoque - quantidadeDesejada);
                JOptionPane.showMessageDialog(null, "Produto inserido com sucesso!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerItemVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
