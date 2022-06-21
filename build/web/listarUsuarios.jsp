<!DOCTYPE html>
<%@page import="java.util.Iterator"%>
<%@page import="Entidad.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.UsuarioDAO"%>

<html>
    <head>
    </head>
    <body>
        <div class="container">
            <h1>Usuarios Registrados</h1>
            <br>
            <br>
            <table>
                <thead>
                    <tr>
                        <th class="text-center">DNI</th>
                        <th class="text-center">NOMBRES</th>
                        <th class="text-center">APELLIDOS</th>
                        <th class="text-center">LOGIN</th>
                        <th class="text-center">CLAVE</th>
                        <th class="text-center">TIPO</th>
                    </tr>
                </thead>
                <%
                    UsuarioDAO dao=new UsuarioDAO();
                    List<Usuario>list=dao.listar();
                    Iterator<Usuario>iter=list.iterator();
                    Usuario u=null;
                    while(iter.hasNext()){
                        u=iter.next();
                    
                %>
                <tbody>
                    <tr>
                        
                        <td class="text-center"><%= u.getNombre()%></td>
                        <td class="text-center"><%= u.getApellido()%></td>
                        <td class="text-center"><%= u.getUsuario()%></td>
                        <td class="text-center"><%= u.getPassword()%></td>
                        <td class="text-center"><%= u.getEmail()%></td>
                        <td class="text-center"><%= u.getTipo()%></td>
                        <!--<td class="text-center">  
                            <a class="btn btn-warning" href="ControladorUsuario?accion=editar&id=<%= u.getIdUsuario()%>">Editar</a>
                            <a class="btn btn-danger" href="ControladorUsuario?accion=eliminar&id=<%= u.getIdUsuario()%>">Remove</a>
                        </td>-->
                    </tr>
                    <%}%>
                </tbody>
            </table>

        </div>
    </body>
</html>
