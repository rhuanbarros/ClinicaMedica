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
public class Exame {

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getJejum() {
        return jejum;
    }

    public void setJejum(String jejum) {
        this.jejum = jejum;
    }

    public String getOrientacoes() {
        return orientacoes;
    }

    public void setOrientacoes(String orientacoes) {
        this.orientacoes = orientacoes;
    }

    public ExameTipo getTipo() {
        return tipo;
    }

    public void setTipo(ExameTipo tipo) {
        this.tipo = tipo;
    }
    private int id;
    private static int idProximo=0;
    private static int getIdProximo() {
        return idProximo++;
    }
    private String nome;
    private String jejum;
    private String orientacoes;
    private ExameTipo tipo;

    public Exame(String nome, String jejum, String orientacoes, ExameTipo tipo) {
        this.id = getIdProximo();
        this.nome = nome;
        this.jejum = jejum;
        this.orientacoes = orientacoes;
        this.tipo = tipo;
    }
    
    public enum ExameTipo {
        LEVE, ATENCAO, CUIDADO;
    }
}
