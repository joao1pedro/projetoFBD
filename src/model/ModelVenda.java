/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author joao
 */
public class ModelVenda {
    private int idVenda;
    private int idItem;
    private String cpfCliente;
    private String nomeCliente;
    private int qtdItens;
    private float subTotal;
    private String metodoPgto;
    private String dataHora;

    public ModelVenda() {
        
    }

    public ModelVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public ModelVenda(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public ModelVenda(String cpfCliente, String nomeCliente, int qtdItens, float subTotal, String metodoPgto, String dataHora) {
        this.cpfCliente = cpfCliente;
        this.nomeCliente = nomeCliente;
        this.qtdItens = qtdItens;
        this.subTotal = subTotal;
        this.metodoPgto = metodoPgto;
        this.dataHora = dataHora;
    }

    public ModelVenda(int idVenda, int idItem, String cpfCliente, String nomeCliente, int qtdItens, float subTotal, String metodoPgto) {
        this.idVenda = idVenda;
        this.idItem = idItem;
        this.cpfCliente = cpfCliente;
        this.nomeCliente = nomeCliente;
        this.qtdItens = qtdItens;
        this.subTotal = subTotal;
        this.metodoPgto = metodoPgto;
    }
    
    public ModelVenda(int idVenda, int idItem, String cpfCliente, String nomeCliente, int qtdItens, float subTotal) {
        this.idVenda = idVenda;
        this.idItem = idItem;
        this.cpfCliente = cpfCliente;
        this.nomeCliente = nomeCliente;
        this.qtdItens = qtdItens;
        this.subTotal = subTotal;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }
    
    public String getMetodoPgto() {
        return metodoPgto;
    }

    public void setMetodoPgto(String metodoPgto) {
        this.metodoPgto = metodoPgto;
    }
    
    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getQtdItens() {
        return qtdItens;
    }

    public void setQtdItens(int qtdItens) {
        this.qtdItens = qtdItens;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }
    
    
}
