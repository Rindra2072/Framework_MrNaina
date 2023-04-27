<%-- 
    Document   : addEmp
    Created on : 31 mars 2023, 05:47:44
    Author     : rindra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>AddEMp</h1>
        <form method="post" action="emp-add"> 
            Id:<input type="text" name="id"><br>
            Nom:<input type="text" name="nom"><br>
            Temps:<input type="text" name="temps"><br>
            nb:<input type="text" name="nb"><br>
            Date:<input type="date" name="date"><br>
            <input type="submit" value="Valider">
        </form>
    </body>
</html>
