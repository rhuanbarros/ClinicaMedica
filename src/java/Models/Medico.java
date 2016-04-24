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
public class Medico {
    private int id;

    public int getId() {
        return id;
    }
    private static int idProximo=0;
    private static int getIdProximo() {
        return idProximo++;
    }
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Medico(String nome) {
        this.id = getIdProximo();
        this.nome = nome;
    }
}
