<%-- 
    Document   : removeAvenger - display avengers to remove
    Created on : 9-Nov-2019, 9:08:01 AM
    Author     : Deep, Rishabh
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.rishabh_deep.rishabh_deep_a2.model.Avenger"%>
<%@page import="com.rishabh_deep.rishabh_deep_a2.model.AvengerDb"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Remove Avenger</title>
        <link rel="stylesheet" href="CSS/main.css">
        <link href='https://fonts.googleapis.com/css?family=Paprika' rel='stylesheet'>
    </head>
    <body>
        <h1><img src="assets/marvel.png" alt="marvel studios" height="120" width="600"></h1>
            <% //  get avenger as an arrayList
                ArrayList<Avenger> avengers = AvengerDb.getAvengers();
            %>
        <!--Form to display avenger name to remove-->
        <form action ="RemoveAvenger.do" method ="POST">
            <div id="nav-container">
                <h2>Which avenger you like to remove?</h2>
                <select name ="avenger">
                    <% for (int i = 0; i < avengers.size(); i++) {%>
                    <option value="<%=avengers.get(i).getName()%>"> <%=avengers.get(i).getName()%> </option>
                    <%}%>
                </select><br><br>
                <input type ="submit" value="Remove"><br><br>
            </div><br><br><br>
            <a href ="index.html" style="margin-left:130px"> Main Page</a>
        </form>
    </body>
</html>
