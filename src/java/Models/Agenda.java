/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.time.LocalDateTime;

/**
 *
 * @author 0084158
 */
public class Agenda {
    private int id;
    private static int idProximo=0;
    private static int getIdProximo() {
        return idProximo++;
    }
    private Usuario usuario;
    private Exame exame;
    private Medico medico;
    private LocalDateTime dataHora;

    public Agenda(Usuario usuario, Exame exame, Medico medico, LocalDateTime dataHora) {
        this.id = getIdProximo();
        this.usuario = usuario;
        this.exame = exame;
        this.medico = medico;
        this.dataHora = dataHora;
    }
}
