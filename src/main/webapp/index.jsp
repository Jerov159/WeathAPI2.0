<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Consumo de APIs</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #1e1e1e;
            color: #f0f0f0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            background-color: #333;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.3);
            max-width: 500px;
            width: 100%;
            text-align: center;
        }
        h1 {
            color: #00bcd4;
            font-size: 24px;
            margin-bottom: 15px;
        }
        p {
            font-size: 16px;
            margin-bottom: 20px;
        }
        a {
            display: block;
            background-color: #00bcd4;
            color: #fff;
            padding: 12px;
            border-radius: 6px;
            margin-bottom: 10px;
            text-decoration: none;
            font-size: 18px;
            transition: background-color 0.3s ease;
        }
        a:hover {
            background-color: #008c9e;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Página de inicio - Consumo de APIs</h1>
    <p>Selecciona una de las siguientes opciones para ver el consumo de las APIs:</p>
    <a href="http://localhost:8080/APIweath_war_exploded/rickandmorty">Ver Personaje de Rick and Morty</a>
    <a href="http://localhost:8080/APIweath_war_exploded/clima">Ver Clima de la Ciudad</a>
    <a href="http://localhost:8080/APIweath_war_exploded/trm">Ver TRM de Colombia</a>
</div>
</body>
</html>


