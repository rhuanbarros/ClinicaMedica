<%@page import="Models.Medico"%>
<%@page import="Models.Exame"%>
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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-combined.min.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" media="screen" href="http://tarruda.github.com/bootstrap-datetimepicker/assets/css/bootstrap-datetimepicker.min.css">
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
            <%
            String msg = request.getParameter("msg");
            if( msg != null && msg.equals("datahoraocupada")  ) {
            %>
            <br>
            <br>
            <div class="alert alert-warning">
                <strong>Atenção</strong> Data e hora não disponíveis para agendamento.
            </div>
            <% } %>

            <div class="row">
                <h3 class="page-header">Marcar exame</h3>
            </div>
            <div class="row">
                <div class="container">
                    <form class="form-horizontal" role="form" action="SalvarAgenda" method="post">

                        <div class="form-group">
                            <label class="col-xs-3 control-label">Exame</label>
                            <div class="col-xs-3 selectContainer">
                                <select class="form-control" name="exame">
                                    <%
                                        List<Exame> exames = (List<Exame>) request.getAttribute("exames");
                                        for (Exame e : exames) {
                                            int id = e.getId();
                                            String nome = e.getNome();
                                    %>
                                    <option value="<%=id %>"><%=nome%></option>
                                    <%}%>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3 control-label">Médico</label>
                            <div class="col-xs-3 selectContainer">
                                <select class="form-control" name="medico">
                                    <%
                                        List<Medico> medicos = (List<Medico>) request.getAttribute("medicos");
                                        for (Medico m : medicos) {
                                            int id = m.getId();
                                            String nome = m.getNome();
                                    %>
                                    <option value="<%=id %>"><%=nome%></option>
                                    <%}%>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-2" for="data">Data</label>
                            <div class="col-xs-3">
                                <div id="datetimepicker" class="input-append date">
                                    <input type="text" class="form-control" name="data"></input>
                                    <span class="add-on">
                                        <i data-time-icon="icon-time" data-date-icon="icon-calendar"></i>
                                    </span>
                                </div>
                            </div>
                        </div>


                        <div class="form-group">
                            <label class="col-xs-3 control-label">Horários disponíveis</label>
                            <div class="col-xs-3 selectContainer">
                                <select class="form-control" name="hora">
                                    <option value="01:00">09:00</option>
                                    <option value="02:00">10:00</option>
                                    <option value="11:00">11:00</option>
                                    <option value="12:00">12:00</option>
                                    <option value="13:00">13:00</option>
                                    <option value="14:00">14:00</option>
                                    <option value="15:00">15:00</option>
                                    <option value="16:00">16:00</option>
                                    <option value="17:00">17:00</option>
                                </select>
                            </div>
                        </div>


                        <div class="form-group">        
                            <div class="col-sm-offset-3 col-sm-10">
                                <button type="submit" class="btn btn-default">Solicitar</button>
                            </div>
                        </div>

                    </form>
                </div>

                <script>
                    $('#datepicker').datepicker({
                        format: 'mm-dd-yyyy'
                    });
                </script>
                <script type="text/javascript"
                        src="http://cdnjs.cloudflare.com/ajax/libs/jquery/1.8.3/jquery.min.js">
                </script> 
                <script type="text/javascript"
                        src="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/js/bootstrap.min.js">
                </script>
                <script type="text/javascript"
                        src="http://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.min.js">
                </script>
                <script type="text/javascript"
                        src="http://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.pt-BR.js">
                </script>
                <script type="text/javascript">
                    $('#datetimepicker').datetimepicker({
                        format: 'dd/MM/yyyy',
                        language: 'pt-BR'
                    });
                </script>

            </div>
        </div>
    </body>
</html>

