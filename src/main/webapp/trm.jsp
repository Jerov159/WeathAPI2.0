<%--
  Created by IntelliJ IDEA.
  User: Usuario
  Date: 30/09/2024
  Time: 8:43 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Consulta TRM</title>
    <link rel="stylesheet" href="style/estilos.css">
</head>
<body>
<div class="container">
    <h1>Consulta TRM de Colombia</h1>
    <form action="trm" method="get">
        <label for="date">Fecha:</label>
        <input type="date" id="date" name="date" value="2023-12-31">
        <button type="submit">Consultar</button>
    </form>
    <div class="result">
        <h2>Valor del TRM:</h2>
        <p><%= request.getAttribute("trm") %></p>
        <p><%= request.getAttribute("error") %></p>
    </div>
</div>
</body>
</html>


