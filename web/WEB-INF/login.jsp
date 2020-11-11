<%-- 
    Document   : login
    Created on : Nov 11, 2020, 11:00:38 AM
    Author     : 794980
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="post">
            <label>
            Username: <input type="text" name="username"><br>
            </label>
            <label>
            Password: <input type="password" name="password">
            </label><br>
            <input type="submit" value="Login">
        </form>
    <p>${message}</p>
    </body>
</html>
