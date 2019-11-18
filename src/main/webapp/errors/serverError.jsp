<%-- 
    Document   : serverError, The custom error Page for error 500
    Created on : 21-Sep-2019, 9:41:05 AM
    Author     : Deep Shah
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/error.css">

        <link href='https://fonts.googleapis.com/css?family=Paprika' rel='stylesheet'>

        <title>Error Page</title>
    </head>
    <body id="errorBody">  
        <h1 id="error500"> ERROR 500 </h2>
        <div id="errorDiv">
            <img src="assets/thanos.png" alt="thanos" width="350" height="400">

            <div class="errorText">
                <h1 id="errorH1">OOPS!Something went wrong!</h1>
                <br>
                <!-- The message which notifies user that they are missing something-->
                <h2 id="errorH2"> Hey Nick Fury, it seems you forgot something!<br>
                        Please make Sure to enter every necessary information for the 
                        avenger or else Thnaos will snap his finger and make every avenger 
                        disappear again!
                        
                </h2><br>

                <!-- link taking user back to the startOrder page-->
                <a href="addAvenger.jsp">Go Back </a>
            </div>
        </div>
</body>
</html>
