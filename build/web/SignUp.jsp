<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Sign Up</title>
        <script src="https://kit.fontawesome.com/0fe1b51407.js"></script>
        <!-- Font Icon -->
        <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

        <!-- Main css -->
        <link rel="stylesheet" href="css/login.css">
        <style>
            .back{
                margin: 20px;
                color: black;
                font-size: 10px;
                border: 2px solid;
                border-radius: 10px;
            }
        </style>
    </head>
    <body>
        <input type="hidden" id="status" value="<%= request.getAttribute("status")%>">
        <div class="main">
            <!-- Sign up form -->
            <section class="signup">
                <div class="container">
                    <a class="back" href="home">
                        <i class="fa-solid fa-house fa-xl">Back to HomePage</i>
                    </a>
                    <div class="signup-content">
                        <div class="signup-form">
                            <h2 class="form-title">Sign up</h2>
                            <form method="post" class="register-form" id="register-form" action="signup">
                                <div class="form-group">
                                    <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                    <input type="text" name="user" id="name" placeholder="Your Username" required="required"/>
                                </div>
                                <div class="form-group">
                                    <label for="email"><i class="zmdi zmdi-email"></i></label>
                                    <input type="email" name="email" id="email" placeholder="Your Email" required="required"/>
                                </div>
                                <div class="form-group">
                                    <label for="pass"><i class="zmdi zmdi-lock"></i></label>
                                    <input type="password" name="pass" id="pass" placeholder="Password" required="required"/>
                                </div>
                                <div class="form-group">
                                    <label for="re-pass"><i class="zmdi zmdi-lock-outline"></i></label>
                                    <input type="password" name="re_pass" id="re_pass" placeholder="Repeat your password" required="required"/>
                                </div>
                                <div class="form-group form-button">
                                    <input type="submit" name="signup" id="signup" class="form-submit" value="Register"/>
                                </div>
                            </form>
                        </div>
                        <div class="signup-image">
                            <figure><img src="images/signup-image.jpg" alt="sing up image"></figure>
                            <a href="Login.jsp" class="signup-image-link">I am already member</a>
                        </div>
                    </div>
                </div>
            </section>
        </div>
        <!-- JS -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="js/main.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">
        <script type="text/javascript">
            var status = document.getElementById("status").value;
            if(status === "success"){
                swal("Congrats","Account created successfully","success");
            }
            else if(status === "Invalid username"){
                swal("Sorry","Please enter username","error");
            }
            else if(status === "Invalid email"){
                swal("Sorry","Please enter email","error");
            }
            else if(status === "Invalid password"){
                swal("Sorry","Please enter password","error");
            }
            else if(status === "Invalid repass"){
                swal("Sorry","Please enter repassword","error");
            }
            else if(status === "Wrong repass"){
                swal("Sorry","RePassword must be the same as Password","error");
            }
            else if(status === "failed"){
                swal("Sorry","Username already exist","error");
            }
            else if(status === "emailExist"){
                swal("Sorry","Email already bind to an account","error");
            }
            
        </script>
        
    </body>
</html>
