<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>

<html lang="en">
<head>
  <meta charset="UTF-8" />
  <title>Éxito</title>
</head>
<body>

<h3>Formulario enviado con éxito</h3>
<p>¡Gracias por enviar el formulario!</p>

<h4>Datos ingresados:</h4>
<ul>
  <li><strong>Nombre:</strong> <%= request.getAttribute("username") == null ? "No proporcionado" : request.getAttribute("username") %></li>
  <li><strong>Correo:</strong> <%= request.getAttribute("email") == null ? "No proporcionado" : request.getAttribute("email") %></li>
  <li><strong>País:</strong> <%= request.getAttribute("pais") == null ? "No proporcionado" : request.getAttribute("pais") %></li>
  <li><strong>Idiomas:</strong>
    <%
      String[] idiomas = (String[]) request.getAttribute("idioma");
      if (idiomas == null || idiomas.length == 0) {
    %>
        No proporcionado
    <%
      } else {
        for (int i = 0; i < idiomas.length; i++) {
    %>
        <%= idiomas[i] %><%
          if (i < idiomas.length - 1) { %>, <% }
        }
      }
    %>
  </li>
</ul>

<a href="./formulario">Volver al formulario</a>

</body>
</html>
