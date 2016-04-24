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
                    <li class="active"><a href="#">Marcar exame</a></li>
                        <% if (usuario != null && (usuario.getTipo() == Usuario.UsuarioTipo.USUARIO_CLINICA || usuario.getTipo() == Usuario.UsuarioTipo.ADM)) {
                                usuariologin = usuario.getLogin();
                        %>
                    <li><a href="#">Médicos</a></li>
                    <li><a href="#">Exames</a></li>
                    <li><a href="#">Agenda de exames</a></li>
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
                <h3 class="page-header">Médicos</h3>
            </div>
            <div class="row">
                <form method="post" action="ControllerCursos?ctrl=cadastrarcurso">
                    <!--<input type="hidden" value="cadastrarcurso" id="ctrl">-->
                    <div class="form-group" >
                        <label for="nome">Nome do curso</label>
                        <input type="text" class="form-control" name="nome">
                    </div>
                    <hr>
                    <button class="btn btn-primary">Cadastrar</button>
                </form>
            </div>
            <div class="row">
                <hr>

                <%
                    //List<Curso> cursos = (List<Curso>) request.getAttribute("cursos");
                %>

                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Nome do curso</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% //for( Curso c : cursos ) { %>
                        <tr>
                            <td><%//=c.getNome()%></td>
                        </tr>
                        <%//}%>
                    </tbody>
                </table>

            </div>
        </div>

    </body>
</html>

