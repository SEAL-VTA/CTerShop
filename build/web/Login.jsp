<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Sign In</title>
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
                padding: 1px;
            }
        </style>
    </head>
    <body>
        <input type="hidden" id="status" value="<%= request.getAttribute("status")%>">
            
        <div class="main">
            <!-- Sign in  Form -->
            <section class="sign-in">
                <div class="container">
                    <a class="back" href="home">
                        <i class="fa-solid fa-house fa-xl">Back to HomePage</i>
                    </a>
                    <div class="signin-content">
                        <div class="signin-image">
                            <figure><img src="images/signin-image.jpg" alt="sing up image"></figure>
                            <a href="SignUp.jsp" class="signup-image-link">Create an account</a>
                        </div>
                        <div class="signin-form">
                            <h2 class="form-title">Sign in</h2>
                            <form method="post" class="register-form" id="login-form" action="login">
                                <!--<p style="font-size: 140%; color: red">${mess}</p>-->
                                <div class="form-group">
                                    <label for="your_name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                    <input type="text" name="user" id="your_name" placeholder="Your Username" required="required"/>
                                </div>
                                <div class="form-group">
                                    <label for="your_pass"><i class="zmdi zmdi-lock"></i></label>
                                    <input type="password" name="pass" id="your_pass" placeholder="Password" required="required"/>
                                </div>
                                <div class="form-group">
                                    <a href="forgotPassword.jsp">Forgot Password?</a>
                                </div>
                                <div class="form-group form-button">
                                    <input type="submit" name="signin" id="signin" class="form-submit" value="Log in"/>
                                </div>
                            </form>
                            <div class="social-login">
                                <span class="social-label">Or login with</span>
                                <ul class="socials">
                                    <li><a href="#"><i class="display-flex-center zmdi zmdi-facebook"></i></a></li>
                                    <li><a href="#"><i class="display-flex-center zmdi zmdi-twitter"></i></a></li>
                                    <li><a href="#"><i class="display-flex-center zmdi zmdi-google"></i></a></li>
                                </ul>
                            </div>
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
            if(status === "failed"){
                swal("Sorry","Wrong username or password","error");
            }
            else if(status === "Invalid username"){
                swal("Sorry","Please enter username","error");
            }
            else if(status === "Invalid password"){
                swal("Sorry","Please enter password","error");
            }
            else if(status === "resetSuccess"){
                swal("Congrats","Reset password successfully","success");
            }
            else if(status === "resetFailed"){
                swal("Sorry","Reset password failed","error");
            }
        </script>
    </body>
</html>