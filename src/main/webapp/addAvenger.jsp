<%-- 
    Document   : addAvenger - Get avenger info and call the servlet to add avenger to the database
    Created on : 1-Nov-2019, 11:00:59 PM
    Author     : Rishabh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="ps" uri="/WEB-INF/tlds/avenger_library.tld" %><%-- get custom tag handle created --%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Avenger</title>
        <link rel="stylesheet" href="CSS/main.css">
        <link href='https://fonts.googleapis.com/css?family=Paprika' rel='stylesheet'>

    </head>
    <body>
        <h1><img src="assets/marvel.png" alt="marvel studios" height="120" width="600"></h1>
        <div id="addAvg-container">
            <!--Form to add avenger and send data to servlet-->
            <h2>Add an Avenger</h2>
            <form action="AddAvenger.do" method="POST"> <!--Sending form data to AddAvenger.do using method POST-->
                Name: <input type="text" name="name" required><br><br>
                Description: <input type="text" name="description" required><br><br>
                Power Source: <ps:powerSource /> <br><br><!--accessing the custom tag using prefix declared-->
                <input type="submit" value="Add"><br><br>
            </form>
        </div><br><br><br>
        <!--Link to take back to the index page-->
        <a href="index.html" style="margin-left:130px">Main Page</a>
    </body>
</html>
