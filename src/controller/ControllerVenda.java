/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DAOVenda;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.ModelItemVenda;
import model.ModelVenda;
import view.ViewRelatorioVendas;
import view.ViewVendas;

/**
 *
 * @author joao
 */
public class ControllerVenda {

    private ViewVendas v;
    private ViewRelatorioVendas vr;

    public ControllerVenda(ViewVendas v) {
        this.v = v;
    }

    public ControllerVenda(ViewRelatorioVendas vr) {
        this.vr = vr;
    }

    public void procurarItensVenda() throws SQLException {

        DAOVenda dao = new DAOVenda();

        int idVendaMax = dao.getMaxIdVenda();

        ModelItemVenda itemvenda = new ModelItemVenda(idVendaMax);

        if (dao.getMaxIdVenda() == 0) {
            v.table.setNumRows(0);
        } else {
            for (ModelItemVenda i : dao.selectItemVenda(itemvenda)) {
                v.table.addRow(new Object[]{
                    i.getIdItem(),
                    i.getIdProduto(),
                    i.getNomeProduto(),
                    i.getQtdItens(),
                    i.getValorTotal()
                });
            }
        }
    }

    public int qtdItens() throws SQLException {
        DAOVenda dao = new DAOVenda();
        int quantidade = dao.getQtdItens();
        return quantidade;
    }

    public float valorTotalItens() throws SQLException {
        DAOVenda dao = new DAOVenda();
        float valor = dao.getValorTotal();
        return valor;
    }

    public void getConteudoTable() throws SQLException {
        int quantidade = qtdItens();
        float valorTotal = valorTotalItens();

        v.jTFquantidade.setText(String.valueOf(quantidade));
        v.jTFvalorTotal.setText(String.valueOf(valorTotal));
    }

    public void insert() throws SQLException {
        int quantidade = qtdItens();
        float valorTotal = valorTotalItens();
        String metodoPgto = v.jCBxmetodoPgto.getSelectedItem().toString();
        String cpfCliente = v.jFTcpf.getText();

        DAOVenda dao = new DAOVenda();
        ModelVenda verifica = new ModelVenda(cpfCliente);

        if (!dao.verificaCliente(verifica)) {
            JOptionPane.showMessageDialog(null, "Cliente com o CPF informado não existe.");
        } else {
            String nomeCliente = dao.getNomeCliente(verifica);
            String dataHora = getDateTime();

            ModelVenda venda = new ModelVenda(cpfCliente, nomeCliente, quantidade, valorTotal, metodoPgto, dataHora);
            dao.insert(venda);
            JOptionPane.showMessageDialog(null, "Venda registrada com sucesso!");
                
            v.table.setNumRows(0);
            v.jFTcpf.setText(null);
            v.jTFquantidade.setText(null);
            v.jTFvalorTotal.setText(null);
        }
    }

    public void removeItem() {
        int row = v.jTableVendas.getSelectedRow();
        int id = (int) v.table.getValueAt(row, 0);

        ModelItemVenda item = new ModelItemVenda(id);

        try {
            DAOVenda dao = new DAOVenda();
            dao.removeProduto(item);
            JOptionPane.showMessageDialog(null, "Item deletado com sucesso!");
            v.readTable();
        } catch (SQLException ex) {
            Logger.getLogger(ControllerProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadTableVendas() throws SQLException {
        DAOVenda dao = new DAOVenda();
        if (dao.loadVendas() == null) {
            vr.table.setNumRows(0);
        } else {
            for (ModelVenda vendas : dao.loadVendas()) {
                vr.table.addRow(new Object[]{
                    vendas.getIdVenda(),
                    vendas.getCpfCliente(),
                    vendas.getNomeCliente(),
                    vendas.getQtdItens(),
                    vendas.getSubTotal(),
                    vendas.getMetodoPgto(),
                    vendas.getDataHora()
                });
            }
        }
    }
    
    public void loadTableItensVenda() throws SQLException {
        int row = vr.jTable1.getSelectedRow();
        int idVenda = (int) vr.table.getValueAt(row, 0);
        
        ModelItemVenda vendaItens = new ModelItemVenda(idVenda);
        DAOVenda dao = new DAOVenda();
        
        if (dao.loadItensVenda(vendaItens) == null) {
            vr.tableItens.setNumRows(0);
        } else {
            for (ModelItemVenda item : dao.loadItensVenda(vendaItens)) {
                vr.tableItens.addRow(new Object[]{
                    item.getIdProduto(),
                    item.getNomeProduto(),
                    item.getQtdItens(),
                    item.getValorTotal()
                });
            }
        }
    }
    
    protected String getDateTime() {
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	Date date = new Date();
	return dateFormat.format(date);
    }
}
