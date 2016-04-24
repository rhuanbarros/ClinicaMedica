<%@page import="Models.Agenda"%>
<%@page import="java.util.List"%>
<%@page import="Models.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Clínica Médica</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    </head>
    <body>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Clínica Médica</a>
                </div>
                <%
                    Usuario usuario = (Usuario) session.getAttribute("usuario.logado");
                    String usuariologin = "";
                %>                      
                <ul class="nav navbar-nav">
                    <li class="active"><a href="MarcarAgenda">Marcar exame</a></li>
                        <% if (usuario != null && (usuario.getTipo() == Usuario.UsuarioTipo.USUARIO_CLINICA || usuario.getTipo() == Usuario.UsuarioTipo.ADM)) {
                                usuariologin = usuario.getLogin();
                        %>
                    <li><a href="#">Médicos</a></li>
                    <li><a href="#">Exames</a></li>
                    <li><a href="Agenda">Agenda de exames</a></li>
                        <%}%>
                        <% if (usuario != null && usuario.getTipo() == Usuario.UsuarioTipo.ADM) {
                        %>
                    <li><a href="#">Administração - cadastrar usuários</a></li>
                        <%}%>
                </ul>

                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#"><span class="glyphicon glyphicon-user"></span> Usuário logado: <%=usuariologin%></a></li>
                    <li><a href="../Logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
                </ul>                      

            </div>
        </nav>

        <div class="container">
            <div class="row">
                <h3 class="page-header">Agenda</h3>
            </div>
            <div class="row">
                

                <%
                    List<Agenda> agenda = (List<Agenda>) request.getAttribute("agenda");
                %>

                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Data</th>
                            <th>Hora</th>
                            <th>Médico</th>
                            <th>Exame</th>
                            <th>Tipo de exame</th>
                            <th>Cliente</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for( Agenda a : agenda ) { 
                            String data = a.getDataString();
                            String hora = a.getHoraString();
                            String medico = a.getMedico().getNome();
                            String exame = a.getExame().getNome();
                            String exameTipo = a.getExame().getTipoString();
                            String cliente = a.getUsuario().getLogin();
                        %>
                        <tr>
                            <td><%=data%></td>
                            <td><%=hora%></td>
                            <td><%=medico%></td>
                            <td><%=exame%></td>
                            <td><%=exameTipo%></td>
                            <td><%=cliente%></td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>

            </div>
        </div>

    </body>
</html>

