package com.example.apiweath;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@WebServlet("/rickandmorty")
public class RickAndMortyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String apiUrl = "https://rickandmortyapi.com/api/character/1"; // Cambia el ID si es necesario

        // Manejo de la conexión
        HttpURLConnection con = null;
        StringBuilder content = new StringBuilder();

        try {
            URL url = new URL(apiUrl);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            // Manejar la respuesta
            try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
            }

            // Procesar la respuesta JSON
            JSONObject json = new JSONObject(content.toString());
            String characterName = json.getString("name");

            // Pasar el nombre del personaje a la JSP
            request.setAttribute("character", characterName);
        } catch (Exception e) {
            request.setAttribute("error", "Error al obtener el personaje de Rick & Morty");
        } finally {
            if (con != null) {
                con.disconnect();
            }
        }

        // Redirigir a la página JSP
        request.getRequestDispatcher("rick.jsp").forward(request, response);
    }
}
