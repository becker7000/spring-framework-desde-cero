<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>

<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Mejor validación</title>
    <style>
        small {
            color: red;
        }
    </style>
</head>
<body>

    <h3>Formulario con mejor validación</h3>

    <form action="./validacion-mejor" method="post">
        <div>
            <label for="username">Nombre: </label>
            <input type="text" id="username" name="username" value="<%= request.getAttribute("username") != null ? request.getAttribute("username") : "" %>" />
            <%
                Map<String, String> errores = (Map<String, String>) request.getAttribute("errores");
                if (errores != null && errores.containsKey("username")) {
                    out.println("<br/><small>" + errores.get("username") + "</small>");
                }
            %>
        </div>

        <div>
            <label for="password">Contraseña: </label>
            <input type="password" id="password" name="password" value="<%= request.getAttribute("password") != null ? request.getAttribute("password") : "" %>" />
            <%
                if (errores != null && errores.containsKey("password")) {
                    out.println("<br/><small>" + errores.get("password") + "</small>");
                }
            %>
        </div>

        <div>
            <label for="email">Correo: </label>
            <input type="text" id="email" name="email" value="<%= request.getAttribute("email") != null ? request.getAttribute("email") : "" %>" />
            <%
                if (errores != null && errores.containsKey("email")) {
                    out.println("<br/><small>" + errores.get("email") + "</small>");
                }
            %>
        </div>

        <div>
            <label for="pais">País: </label>
            <select id="pais" name="pais">
                <option value="mexico" <%= "mexico".equals(request.getAttribute("pais")) ? "selected" : "" %>>México</option>
                <option value="colombia" <%= "colombia".equals(request.getAttribute("pais")) ? "selected" : "" %>>Colombia</option>
                <option value="argentina" <%= "argentina".equals(request.getAttribute("pais")) ? "selected" : "" %>>Argentina</option>
                <option value="brasil" <%= "brasil".equals(request.getAttribute("pais")) ? "selected" : "" %>>Brasil</option>
            </select>
            <%
                if (errores != null && errores.containsKey("pais")) {
                    out.println("<br/><small>" + errores.get("pais") + "</small>");
                }
            %>
        </div>

        <div>
            <div>
                <label>Idiomas: </label>
            </div>
            <div>
                <input type="checkbox" name="idioma" value="es" <%= (request.getAttribute("idioma") != null && ((String) request.getAttribute("idioma")).contains("es")) ? "checked" : "" %> />
                <label>Español</label>
            </div>
            <div>
                <input type="checkbox" name="idioma" value="en" <%= (request.getAttribute("idioma") != null && ((String) request.getAttribute("idioma")).contains("en")) ? "checked" : "" %> />
                <label>Inglés</label>
            </div>
            <div>
                <input type="checkbox" name="idioma" value="pg" <%= (request.getAttribute("idioma") != null && ((String) request.getAttribute("idioma")).contains("pg")) ? "checked" : "" %> />
                <label>Portugues</label>
            </div>
            <%
                if (errores != null && errores.containsKey("idioma")) {
                    out.println("<br/><small>" + errores.get("idioma") + "</small>");
                }
            %>
        </div>

        <div>
            <input type="submit" value="Enviar">
        </div>
    </form>

</body>
</html>
