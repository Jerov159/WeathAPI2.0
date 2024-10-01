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

@WebServlet("/clima")
public class WeatherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // URL de la API con la clave proporcionada por el usuario para Medellín
        String urlString = "https://my.meteoblue.com/packages/basic-day?apikey=1pXSnYPqmyHINgxK&lat=6.25184&lon=-75.5636&asl=1405&format=json";
        HttpURLConnection con = null;
        StringBuilder content = new StringBuilder();

        try {
            // Realizar la conexión a la API de Meteoblue
            URL url = new URL(urlString);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            // Leer la respuesta de la API
            try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
            }

            // Parsear la respuesta JSON
            JSONObject json = new JSONObject(content.toString());

            // Verificar si `data_day` es un objeto y contiene la información climática
            if (json.has("data_day")) {
                JSONObject dataDay = json.getJSONObject("data_day");

                // Obtener la temperatura máxima del día (si está disponible)
                if (dataDay.has("temperature_max")) {
                    String temperatureMax = dataDay.get("temperature_max").toString();
                    request.setAttribute("temperatureMax", temperatureMax);
                } else {
                    request.setAttribute("error", "No se encontró la temperatura máxima en los datos.");
                }
            } else {
                request.setAttribute("error", "No se pudo obtener el clima. Verifica los datos de la API.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Ocurrió un error al conectar con la API: " + e.getMessage());
        } finally {
            if (con != null) {
                con.disconnect();
            }
        }

        // Redirigir a la página JSP correspondiente
        request.getRequestDispatcher("weather.jsp").forward(request, response);
    }
}
