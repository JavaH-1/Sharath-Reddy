<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Person Form</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <!-- Font Awesome Icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <!-- Animate.css -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .container {
            margin-top: 50px;
        }
        .card {
            border-radius: 15px;
        }
        .form-control {
            border-radius: 10px;
        }
        .btn-custom {
            background-color: #007bff;
            color: white;
            border-radius: 10px;
            transition: 0.3s;
        }
        .btn-custom:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card shadow-lg animate__animated animate__fadeInUp">
                <div class="card-header bg-primary text-white text-center">
                    <h3><i class="fas fa-user"></i> Person Form</h3>
                </div>
                <div class="card-body">
                    <form:form modelAttribute="person" action="person" method="post">
                        <div class="mb-3">
                            <label class="form-label"><i class="fas fa-user"></i> Name:</label>
                            <form:input path="name" cssClass="form-control" placeholder="Enter Name"/>
                        </div>
                        <div class="mb-3">
                            <label class="form-label"><i class="fas fa-calendar"></i> Age:</label>
                            <form:input path="age" type="number" cssClass="form-control" placeholder="Enter Age"/>
                        </div>
                        <div class="mb-3">
                            <label class="form-label"><i class="fas fa-phone"></i> Phone:</label>
                            <form:input path="phoneNumber" cssClass="form-control" placeholder="Enter Phone"/>
                        </div>
                        <div class="mb-3">
                            <label class="form-label"><i class="fas fa-envelope"></i> Email:</label>
                            <form:input path="emailId" cssClass="form-control" placeholder="Enter Email"/>
                        </div>
                        <div class="mb-3">
                            <label class="form-label"><i class="fas fa-tint"></i> Blood Group:</label>
                            <form:input path="bloodGroup" cssClass="form-control" placeholder="Enter Blood Group"/>
                        </div>
                        <button type="submit" class="btn btn-custom w-100"><i class="fas fa-paper-plane"></i> Submit</button>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
