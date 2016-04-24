package BD;


import Models.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BancoDeDados implements Serializable {
    
    static public List<Usuario> usuarios = new ArrayList<Usuario>();
    static public List<Exame> exames = new ArrayList<Exame>();
    static public List<Medico> medicos = new ArrayList<Medico>();
    static public List<Agenda> agenda = new ArrayList<Agenda>();
    
    static {
        final Usuario usuarioAdm = new Usuario("adm", "adm", Usuario.UsuarioTipo.ADM );
        final Usuario usuarioClinica = new Usuario("clinica", "clinica", Usuario.UsuarioTipo.USUARIO_CLINICA );
        final Usuario usuarioWeb = new Usuario("web", "web", Usuario.UsuarioTipo.USUARIO_WEB );
        usuarios.add(usuarioAdm);
        usuarios.add(usuarioClinica);
        usuarios.add(usuarioWeb);

        final Exame exameHdl = new Exame("HDL-COLESTEROL", "para todas as idades, jejum mínimo necessário de 4 horas e máximo de 16 horas.", "o cliente deve manter sua dieta habitual nos cinco dias que antecedem a realização deste exame, mas sem ingerir bebidas alcoólicas nas últimas 72 horas.\n" +
                "Caso tenha de fazer algum procedimento que necessite de dieta específica e/ou de preparo intestinal, o cliente precisa realizar este exame antes de iniciar o preparo ou três dias após o procedimento.", Exame.ExameTipo.ATENCAO);
        final Exame exameCalcio = new Exame("CÁLCIO – Ca++", "todas as idades, jejum mínimo necessário de 3 horas.", "N/A", Exame.ExameTipo.LEVE);
        final Exame exameAlfa = new Exame("ALFA-FETOPROTEÍNA", "para todas as idades jejum mínimo necessário de 3 horas.", "em gestantes, o ideal é que a coleta seja feita entre a 15ª e a 21ª semana de gestação. Anotar medicamento(s) do(s) último(s): 30 dias(s).", Exame.ExameTipo.ATENCAO);
        final Exame exameAlbumina = new Exame("ALBUMINA", "para todas as idades jejum mínimo necessário de 3 horas.", "a recomendação é que a coleta seja realizada pela manhã, por causa das flutuações nos níveis de albumina ao longo do dia.", Exame.ExameTipo.LEVE);
        final Exame exameBili = new Exame("BILIRRUBINAS", "para todas as idades, jejum mínimo necessário de 3 horas.", "em lactentes, a coleta deve ser feita antes da próxima mamada.", Exame.ExameTipo.LEVE);
        exames.add(exameHdl);
        exames.add(exameCalcio);
        exames.add(exameAlfa);
        exames.add(exameAlbumina);
        exames.add(exameBili);

        final Medico medicoJoao = new Medico("João");
        final Medico medicoMaria = new Medico("Maria");
        final Medico medicoJose = new Medico("José");
        medicos.add(medicoJoao);
        medicos.add(medicoMaria);
        medicos.add(medicoJose);
        
        agenda.add(new Agenda(usuarioWeb, exameHdl, medicoJoao, LocalDateTime.of(2016, Month.MAY, 1, 13, 0) ));
        agenda.add(new Agenda(usuarioWeb, exameBili, medicoMaria, LocalDateTime.of(2016, Month.MAY, 3, 10, 0) ));
        agenda.add(new Agenda(usuarioWeb, exameAlbumina, medicoJose, LocalDateTime.of(2016, Month.MAY, 1, 11, 0) ));
        agenda.add(new Agenda(usuarioWeb, exameAlbumina, medicoJose, LocalDateTime.of(2016, Month.MAY, 1, 12, 0) ));
    }
    
}
