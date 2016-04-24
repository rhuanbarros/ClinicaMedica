/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author 0084158
 */
public class Usuario {
    private int id;
    private static int idProximo=0;
    private static int getIdProximo() {
        return idProximo++;
    }
    private String login;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public UsuarioTipo getTipo() {
        return tipo;
    }

    public void setTipo(UsuarioTipo tipo) {
        this.tipo = tipo;
    }
    private String senha;
    private UsuarioTipo tipo;

    public Usuario(String login, String senha, UsuarioTipo tipo) {
        this.id = getIdProximo();
        this.login = login;
        this.senha = senha;
        this.tipo = tipo;
    }
    
    public enum UsuarioTipo {
        ADM, USUARIO_CLINICA, USUARIO_WEB;
    }
}
