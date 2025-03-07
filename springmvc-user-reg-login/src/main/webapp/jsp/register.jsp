<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Registration</title>

    <!-- Bootstrap 5 CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome for Icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <!-- Custom CSS -->
    <style>
        body {
            background: linear-gradient(to right, #00c6ff, #0072ff);
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .register-card {
            background: white;
            border-radius: 10px;
            padding: 30px;
            box-shadow: 0px 5px 15px rgba(0, 0, 0, 0.2);
            transition: transform 0.3s ease-in-out;
        }
        .register-card:hover {
            transform: scale(1.02);
        }
        .form-control {
            border-radius: 20px;
            padding-left: 40px;
        }
        .register-btn {
            border-radius: 20px;
            transition: background 0.3s ease-in-out;
        }
        .register-btn:hover {
            background: #0072ff;
            color: white;
        }
        .icon {
            position: absolute;
            margin-left: 10px;
            margin-top: 10px;
            color: gray;
        }
        .message {
            color: red;
            font-style: italic;
            text-align: center;
            margin-top: 10px;
        }
    </style>
</head>
<body>

    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-5">
                <div class="card register-card">
                    <div class="card-body text-center">
                        <h3 class="card-title">Register</h3>
                        <p class="text-muted">Fill in the details to create an account</p>

                        <form:form id="regForm" modelAttribute="user" action="registerProcess" method="post">
                            
                            <div class="mb-3 position-relative">
                                <i class="fa fa-user icon"></i>
                                <form:input path="username" name="username" id="username" class="form-control ps-4" placeholder="Username"/>
                            </div>
                            
                            <div class="mb-3 position-relative">
                                <i class="fa fa-lock icon"></i>
                                <form:password path="password" name="password" id="password" class="form-control ps-4" placeholder="Password"/>
                            </div>

                            <div class="mb-3 position-relative">
                                <i class="fa fa-user icon"></i>
                                <form:input path="firstname" name="firstname" id="firstname" class="form-control ps-4" placeholder="First Name"/>
                            </div>

                            <div class="mb-3 position-relative">
                                <i class="fa fa-user icon"></i>
                                <form:input path="lastname" name="lastname" id="lastname" class="form-control ps-4" placeholder="Last Name"/>
                            </div>

                            <div class="mb-3 position-relative">
                                <i class="fa fa-envelope icon"></i>
                                <form:input path="email" name="email" id="email" class="form-control ps-4" placeholder="Email"/>
                            </div>

                            <div class="mb-3 position-relative">
                                <i class="fa fa-map-marker-alt icon"></i>
                                <form:input path="address" name="address" id="address" class="form-control ps-4" placeholder="Address"/>
                            </div>

                            <div class="mb-3 position-relative">
                                <i class="fa fa-phone icon"></i>
                                <form:input path="phone" name="phone" id="phone" class="form-control ps-4" placeholder="Phone"/>
                            </div>

                            <button type="submit" class="btn btn-primary w-100 register-btn">
                                <i class="fas fa-user-plus"></i> Register
                            </button>
                        </form:form>

                        <div class="message">${message}</div>

                        <div class="mt-3">
                            <a href="home.jsp" class="text-decoration-none">
                                <i class="fas fa-home"></i> Home
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
