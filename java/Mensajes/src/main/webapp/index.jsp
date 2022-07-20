<%-- 
    Document   : index
    Created on : 18/04/2022, 14:44:31
    Author     : mcarballo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" 
              rel="stylesheet" 
              integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" 
              crossorigin="anonymous">
    </head>
    <body>
        <!-- Modal -->

        <div class="modal-dialog">
            <div class="modal-content">
                <form action="index.jsp" method="POST">
                    <div class="modal-header">
                        <h5 class="modal-title" >Crear Mensaje</h5>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label>Ingrese un Mensaje</label>
                            <textarea class="form-control" name = "mensaje" rows="3"></textarea>
                        </div>
                        <div class="form-group">
                            <label>Autor</label>
                            <input type="text" name="autor" class="form-control" >
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-primary" name="enviar">Enviar</button>
                    </div>
                </form>
            </div>
        </div>

        <%
            String mensaje = request.getParameter("mensaje");
            String autor = request.getParameter("autor");
        %>
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" >Todos los Mensajes</h5>
                </div>
                <div class="modal-body">
                    <div class="card" ">
                        <div class="card-body">
                            <h5 class="card-title"><%=autor%></h5>

                            <p class="card-text"><%=mensaje%></p>
                            <p class="blockquote-footer"><cite>18/04/2022 16:20</cite></p>
                            <a href="#" class="card-link">Editar</a>
                            <a href="#" class="card-link">Eliminar</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
