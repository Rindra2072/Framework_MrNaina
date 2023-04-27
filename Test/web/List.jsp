<%-- 
    Document   : List.jsp
    Created on : 30 mars 2023, 22:38:57
    Author     : rindra
--%>

<%@page import="java.util.Vector"%>
<%@page import="model.Emp"%>
<% Vector<Emp> vect = (Vector<Emp>) (request.getAttribute("emp"));%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LIst employe</title>
    </head>
    <body>
        <h1> Liste Emp</h1>
        <table border="1">
            <tr>
                <th>Id</th>
                 <th>Nom</th>
                
            </tr>
        <% for (int i = 0; i < vect.size(); i++) { %>
        <tr>
                
            <td><% out.print(vect.elementAt(i).getId());%></td>
            <td><% out.print(vect.elementAt(i).getNom());%></td>
        </tr>
                 
            
            <% }%>
        </table>
    </body>
</html>
