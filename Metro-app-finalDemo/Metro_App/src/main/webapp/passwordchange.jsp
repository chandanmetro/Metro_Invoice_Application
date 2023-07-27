<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Metro Invoice Application</title>
    <link rel="stylesheet" href="./index.css">
    <script>
        function validateForm() {
            var newPassword = document.getElementById("newpassword").value;
            var confirmPassword = document.getElementById("confirmpassword").value;

            if (newPassword !== confirmPassword) {
                alert("New Password and Confirm New Password do not match..!!");
                return false;
            }

            return true;
        }
    </script>
</head>
<body>
    <%
        String storeID = (String) request.getSession().getAttribute("StoreId");
    %>
    <h2 style="color:green; text-align: center;"> Welcome to Password Change Page For Store Number : <%= storeID %></h2>
    <section>
        <form action="resetpassword.jsp" method="post" onsubmit="return validateForm();">
            <div class="imgcontainer">
                <img src="Metro_logo.png" alt="Metro" style="width:205px;height:80px;" class="">
            </div>
            <div class="container">
                <label for="username"><b style="color:red; font-size:18px;">Enter Metro Store Email ID </b></label>
                <input type="email" placeholder="Enter Email Id" name="username" required/>
                <br>
                <br>
                <br>
                <label for="newpassword"><b style="color:red; font-size:18px;"> Enter New Password</b></label>
                <input type="password" placeholder="Enter New Password" id="newpassword" name="newpassword" required/>
                <br>
                <br>
                <br>
                <label for="confirmpassword"><b style="color:red; font-size:18px;"> Confirm New Password</b></label>
                <input type="password" placeholder="Confirm New Password" id="confirmpassword" name="confirmpassword" required/>
                <br>
                <br>
                <button type="submit">Reset Password</button>
            </div>
        </form>
        <br>
        
    </section>
    <div style="text-align: center;">
        <a href="index2.jsp">Click here to Go Back</a>
    </div>
    <br>
   
    <div style="text-align: center;">
        <a href="logout.jsp">Click here to Logout</a>
    </div>
</body>
</html>
