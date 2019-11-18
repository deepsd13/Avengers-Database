<%-- 
    Document   : addPowersource - Get PowerSource from user and add to database
    Created on : 12-Nov-2019, 5:00:27 PM
    Author     : Deep Shah
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/main.css">
        <link href='https://fonts.googleapis.com/css?family=Paprika' rel='stylesheet'>


        <title>Add PowerSource</title>
    </head>
    <body>
        <!--Form to get power source to add and send the parameters to AddPowerSource.do using POST method-->
        <form action="AddPowerSource.do" method="POST">
            <h1><img src="assets/marvel.png" alt="marvel studios" height="120" width="600"></h1>
            <div id="nav-container">
                <h2>What PowerSource do you have in mind?</h2>
                <input type="text" name="powersource" required>
                <input type="submit" value ="Add PowerSource"><!--Submit button-->
            </div><br><br><br>
            <!--Link to take back to index page-->
            <a href="index.html" style="margin-left:130px">Main Page</a>

        </form>
    </body>
</html>
