/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author 0084158
 */
public class Agenda {

    @Override
    public String toString() {
        return "Agenda{" + "id=" + id + ", usuario=" + usuario + ", exame=" + exame + ", medico=" + medico + ", data=" + data + ", hora=" + hora + '}';
    }

    
    private int id;
    private static int idProximo=0;
    private static int getIdProximo() {
        return idProximo++;
    }
    private Usuario usuario;
    private Exame exame;
    private Medico medico;
    private LocalDate data;
    private LocalTime hora;

    public int getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Exame getExame() {
        return exame;
    }

    public Medico getMedico() {
        return medico;
    }

    public LocalDate getData() {
        return data;
    }

    public LocalTime getHora() {
        return hora;
    }
    
    public String getDataString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(formatter);
    }

    public String getHoraString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return hora.format(formatter);
    }

    public Agenda(Usuario usuario, Exame exame, Medico medico, String data, String Hora) {
        this.id = getIdProximo();
        this.usuario = usuario;
        this.exame = exame;
        this.medico = medico;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(data, formatter);
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime time = LocalTime.parse(Hora, formatter2);
        this.data = date;
        this.hora = time;
    }
}
