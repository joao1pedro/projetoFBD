/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DAOProduto;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.ModelProduto;
import view.ViewCadastrarProduto;
import view.ViewConsultarProduto;

/**
 *
 * @author joao
 */
public class ControllerProduto {

    private ViewCadastrarProduto view;
    private ViewConsultarProduto viewConsultarP;

    public ControllerProduto(ViewConsultarProduto viewConsultarP) {
        this.viewConsultarP = viewConsultarP;
    }

    public ControllerProduto(ViewCadastrarProduto view) {
        this.view = view;
    }

    public void registraProduto() {
        String nome = view.getjTFNome().getText();
        int quantidade = Integer.parseInt(view.getjTFQuantidade().getText());
        float custo = Float.parseFloat(view.getjTFCusto().getText());
        float valor = Float.parseFloat(view.getjTFValor().getText());

        ModelProduto produto = new ModelProduto(nome, quantidade, custo, valor);
        try {
            DAOProduto daoProduto = new DAOProduto();
            daoProduto.insert(produto);

            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(ViewCadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void consultaProduto() {
        try {
            DAOProduto daop = new DAOProduto();

            if (daop.consultaProduto() == null) {
                viewConsultarP.table.setNumRows(0);
            } else {

                for (ModelProduto p : daop.consultaProduto()) {
                    viewConsultarP.table.addRow(new Object[]{
                        p.getId(),
                        p.getNome(),
                        p.getQuantidade(),
                        p.getCusto(),
                        p.getValor()
                    });
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ViewConsultarProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void procurar() throws SQLException {
        String nome = viewConsultarP.getjTFNmProduto().getText();

        ModelProduto produto = new ModelProduto(nome);
        DAOProduto daop = new DAOProduto();

        if (!daop.verificaProduto(produto)) {
            consultaProduto();
        } else {
            try {
                for (ModelProduto p : daop.procurar(produto)) {
                    viewConsultarP.table.addRow(new Object[]{
                        p.getId(),
                        p.getNome(),
                        p.getQuantidade(),
                        p.getCusto(),
                        p.getValor()
                    });
                }
            } catch (SQLException ex) {
                Logger.getLogger(ControllerProduto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void removeProduto() {
        int row = viewConsultarP.jTableProdutos.getSelectedRow();
        int id = (int) viewConsultarP.table.getValueAt(row, 0);

        ModelProduto produto = new ModelProduto(id);

        try {
            DAOProduto daop = new DAOProduto();
            daop.removeProduto(produto);
            JOptionPane.showMessageDialog(null, "Produto deletado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(ControllerProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateProduto() {

        String nome = viewConsultarP.jTFnm.getText();
        float custo = Float.parseFloat(viewConsultarP.jTFcusto.getText());
        float valor = Float.parseFloat(viewConsultarP.jTFvalor.getText());
        int id = Integer.parseInt(viewConsultarP.jTFid.getText());

        ModelProduto produto = new ModelProduto(nome, custo, valor, id);

        try {
            DAOProduto daop = new DAOProduto();
            daop.updateProduto(produto);
            JOptionPane.showMessageDialog(null, "Produto alterado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(ControllerProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void selecionaLinha() {
        int row = viewConsultarP.jTableProdutos.getSelectedRow();

        int id = (int) viewConsultarP.table.getValueAt(row, 0);
        String nome = viewConsultarP.table.getValueAt(row, 1).toString();
        float custo = (float) viewConsultarP.table.getValueAt(row, 3);
        float valor = (float) viewConsultarP.table.getValueAt(row, 4);

        String stringCusto = String.valueOf(custo);
        String stringValor = String.valueOf(valor);
        String stringId = String.valueOf(id);

        viewConsultarP.jTFnm.setText(nome);
        viewConsultarP.jTFcusto.setText(stringCusto);
        viewConsultarP.jTFvalor.setText(stringValor);
        viewConsultarP.jTFid.setText(stringId);
    }
}
