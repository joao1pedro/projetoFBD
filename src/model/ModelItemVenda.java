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
public class ModelItemVenda {
    private int idItem;
    private int idProduto;
    private int idVenda;
    private String nomeProduto;
    private int qtdItens;
    private float valorTotal;

    public ModelItemVenda() {
        
    }

    public ModelItemVenda(int idItem) {
        this.idItem = idItem;
    }

    public ModelItemVenda(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public ModelItemVenda(int idVenda, String nomeProduto, int qtdItens, float valorTotal) {
        this.idVenda = idVenda;
        this.nomeProduto = nomeProduto;
        this.qtdItens = qtdItens;
        this.valorTotal = valorTotal;
    }

    public ModelItemVenda(int idProduto, int idVenda, String nomeProduto, int qtdItens, float valorTotal) {
        this.idProduto = idProduto;
        this.idVenda = idVenda;
        this.nomeProduto = nomeProduto;
        this.qtdItens = qtdItens;
        this.valorTotal = valorTotal;
    }
    
    public ModelItemVenda(int idItem, int idProduto, int idVenda) {
        this.idItem = idItem;
        this.idProduto = idProduto;
        this.idVenda = idVenda;
    }
    
    public ModelItemVenda(int idItem, int idProduto, int idVenda, String nomeProduto, int qtdItens, float valorTotal) {
        this.idItem = idItem;
        this.idProduto = idProduto;
        this.idVenda = idVenda;
        this.nomeProduto = nomeProduto;
        this.qtdItens = qtdItens;
        this.valorTotal = valorTotal;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getQtdItens() {
        return qtdItens;
    }

    public void setQtdItens(int qtdItens) {
        this.qtdItens = qtdItens;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    
}
