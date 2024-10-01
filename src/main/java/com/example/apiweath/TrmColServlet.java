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

@WebServlet("/trm")
public class TrmColServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String date = request.getParameter("date"); // Permitir que la fecha sea un parámetro
        if (date == null || date.isEmpty()) {
            date = "2024-03-10"; // Valor por defecto si no se proporciona fecha
        }

        String apiUrl = String.format("https://trm-colombia.vercel.app/?date=%s", date);
        HttpURLConnection con = null;
        StringBuilder content = new StringBuilder();

        try {
            URL url = new URL(apiUrl);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            // Leer la respuesta
            try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
            }

            // Procesar la respuesta JSON
            JSONObject json = new JSONObject(content.toString());
            JSONObject data = json.getJSONObject("data");
            double trmValue = data.getDouble("value");

            // Pasar el TRM a la JSP
            request.setAttribute("trm", trmValue);
        } catch (Exception e) {
            request.setAttribute("error", "Error al obtener el TRM para la fecha: " + date);
        } finally {
            if (con != null) {
                con.disconnect();
            }
        }

        // Redirigir a la página JSP
        request.getRequestDispatcher("trm.jsp").forward(request, response);
    }
}

