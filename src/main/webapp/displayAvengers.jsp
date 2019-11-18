<%-- 
    Document   : displayAvengers - Display all avengers
    Created on : 1-Nov-2019, 11:01:12 PM
    Author     : Rishabh, Deep
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.rishabh_deep.rishabh_deep_a2.model.Avenger"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--Using jstl core custom tag library-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display Avengers</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="CSS/main.css">
        <link href='https://fonts.googleapis.com/css?family=Paprika' rel='stylesheet'>

    </head>
    <body>
        <audio class="audio" controls autoplay>     
            <source src="assets/avengers.mp3" type="audio/mpeg">
        </audio>
        <!--Display error attribute if found-->
        <h1>${error}</h1>
        <h1><img src="assets/marvel.png" alt="marvel studios" height="120" width="600"></h1><br>
        <h2 id="left" style="color:white">Avengers...Assemble!</h2><br><br>
        <% // get avengers arrayList as a request attribute
            ArrayList<Avenger> avengers = (ArrayList) request.getAttribute("avengers");
            request.setAttribute("avengers", avengers);
        %>
        <%-- Using jstl core library java bean to display avenger data --%>
        <div class="card-columns">
            <%-- Using forEach tag to display each avenger data one by one --%>
            <c:forEach var="avengers" items="${avengers}"> 
                <div class="card" style="width:500px">
                    <div class="card-body">
                        <h4 class="card-title">${avengers.name}, ${avengers.description}</h4>
                        <p class="card-text">Power Source: ${avengers.powerSource.description}</p>
                    </div> 
                </div>
                </c:forEach>
            </div><br><br>
            <!--Link to take back to index page-->
            <a href="index.html" class="fade">Main Page</a>
    </body>
</html>
