package BD;

import Models.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.List;

public class CtrlBancoDeDados {
    
    static public List<Usuario> getUsuarios() {
        return BancoDeDados.usuarios;
    }
    
    static public void addUsuario(Usuario usuario) {
        BancoDeDados.usuarios.add(usuario);
    }
    
    static public List<Exame> getExames() {
        return BancoDeDados.exames;
    }
    
    static public Agenda getAgendaByDataEHora(String data, String hora) {
        Iterator<Agenda> iteratorAgenda = BancoDeDados.agenda.iterator();
        Agenda a=null;
        while(iteratorAgenda.hasNext()) {
            a = iteratorAgenda.next();
            if( a.getDataString().equals(data) && a.getHoraString().equals(hora) ) break;
        }        
        return a;
    }
    
    static public Exame getExameById(int id) {
        Iterator<Exame> iteratorExame = BancoDeDados.exames.iterator();
        Exame e=null;
        while(iteratorExame.hasNext()) {
            e = iteratorExame.next();
            if( e.getId() == id ) break;
        }        
        return e;
    }
    
    static public Medico getMedicoById(int id) {
        Iterator<Medico> iteratorMedico = BancoDeDados.medicos.iterator();
        Medico e = null;
        while (iteratorMedico.hasNext()) {
            e = iteratorMedico.next();
            if (e.getId() == id) {
                break;
            }
        }
        return e;
    }
    
    static public void addExame(Exame exame) {
        BancoDeDados.exames.add(exame);
    }
    
    static public List<Medico> getMedicos() {
        return BancoDeDados.medicos;
    }
    
    static public void addMedico(Medico medico) {
        BancoDeDados.medicos.add(medico);
    }
    
    static public List<Agenda> getAgenda() {
        return BancoDeDados.agenda;
    }
    
    static public void addAgenda(Agenda agenda) {
        BancoDeDados.agenda.add(agenda);
    }
    
    //http://www.tutorialspoint.com/java/java_serialization.htm
    static public void salvarParaArquivo() {
        try {
            System.out.println("Começou a salvar");
            FileOutputStream arquivo = new FileOutputStream("c:\\temp\\BancoDedados.rplb");
            ObjectOutputStream out = new ObjectOutputStream(arquivo);
            out.writeObject(new BancoDeDados());
            out.close();
            arquivo.close();
            System.out.println("Salvo para arquivo com sucesso!");
        } catch(IOException i) {
            i.printStackTrace();
        }
    }
    
    static public void abrirDeArquivo() {
        try {
            System.out.println("Começou a abrir");
            FileInputStream arquivo = new FileInputStream("c:\\temp\\BancoDedados.rplb");
            ObjectInputStream in = new ObjectInputStream(arquivo);
            BancoDeDados bancoDeDados = (BancoDeDados) in.readObject();
            BancoDeDados.usuarios = bancoDeDados.usuarios;
            BancoDeDados.exames = bancoDeDados.exames;
            BancoDeDados.medicos = bancoDeDados.medicos;
            BancoDeDados.agenda = bancoDeDados.agenda;
            in.close();
            arquivo.close();
            System.out.println("Aberto de arquivo com sucesso!");
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Objeto não encontrado");
            c.printStackTrace();
            return;
        }
    }
    
}
