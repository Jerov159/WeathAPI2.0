<%--
  Created by IntelliJ IDEA.
  User: Usuario
  Date: 30/09/2024
  Time: 8:44 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Personajes de Rick & Morty</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f4;
      color: #333;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      margin: 0;
    }
    .container {
      background-color: white;
      padding: 30px;
      border-radius: 8px;
      box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
      max-width: 500px;
      width: 100%;
      text-align: center;
    }
    h1 {
      color: #27ae60;
      margin-bottom: 20px;
    }
    .result {
      font-size: 18px;
    }
    p {
      margin: 10px 0;
    }
    .error {
      color: red;
    }
  </style>
</head>
<body>
<div class="container">
  <h1>Personajes de Rick & Morty</h1>
  <div class="result">
    <h2>Personajes:</h2>
    <!-- Aquí se muestran los personajes si se obtienen correctamente -->
    <p><%= request.getAttribute("character") %></p>

    <!-- Si ocurre un error, se muestra este mensaje -->
    <p class="error"><%= request.getAttribute("rickAndMortyError") %></p>
    <!-- Nota pequeña para cambiar el personaje en el código -->
    <p class="small-note">Si quieres cambiar el personaje, cámbialo desde el código desde String apiUrl y cambia el ultimo número.</p>
  </div>
</div>
</body>
</html>


