<%-- 
    Document   : removePowersource - JSP Page to get power source to remove
    Created on : 12-Nov-2019, 4:59:41 PM
    Author     : Deep, Rishabh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="ps" uri="/WEB-INF/tlds/avenger_library.tld" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Remove PowerSource </title>
        <link rel="stylesheet" href="CSS/main.css">
        <link href='https://fonts.googleapis.com/css?family=Paprika' rel='stylesheet'>
    </head>
    <body>
        <!--Form to get power source to remove and send power source to RemovePowerSource.do using POST method-->
        <form action="RemovePowerSource.do" method="POST">
            <h1><img src="assets/marvel.png" alt="marvel studios" height="120" width="600"></h1>
            <div id="nav-container">
                <h2>Which PowerSource you want to remove?</h2>
                Power Source: <ps:powerSource /> <br><br><!--Using custom tag handler to display power sources available-->
                <input type="submit" value="Remove PowerSource"><br><br>
            </div> <br><br><br>
            <a href ="index.html" style="margin-left:130px"> Main Page</a>
        </form>
    </body>
</html>
