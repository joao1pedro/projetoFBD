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
public class ModelProduto {
    private String nome;
    private int quantidade;
    private float custo;
    private float valor;
    private int id;

    public ModelProduto(){
        
    }
    
    public ModelProduto(String nome){
        this.nome = nome;
    }

    public ModelProduto(int id) {
        this.id = id;
    }

    public ModelProduto(String nome, int quantidade, float custo, float valor, int id) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.custo = custo;
        this.valor = valor;
        this.id = id;
    }
    
    public ModelProduto(String nome, int quantidade, float custo, float valor) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.custo = custo;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getCusto() {
        return custo;
    }

    public void setCusto(float custo) {
        this.custo = custo;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getInt() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
