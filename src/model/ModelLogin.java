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
public class ModelLogin {
    private String username;
    private String password;
    private String nome;
    private int id;
    private boolean permissao;

    public ModelLogin() {
        
    }

    public ModelLogin(String username) {
        this.username = username;
    }

    public ModelLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public ModelLogin(String username, String password, String nome, boolean permissao) {
        this.username = username;
        this.password = password;
        this.nome = nome;
        this.permissao = permissao;
    }

    public ModelLogin(String username, String password, String nome, int id, boolean permissao) {
        this.username = username;
        this.password = password;
        this.nome = nome;
        this.id = id;
        this.permissao = permissao;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPermissao() {
        return permissao;
    }

    public void setPermissao(boolean permissao) {
        this.permissao = permissao;
    }
    
}
