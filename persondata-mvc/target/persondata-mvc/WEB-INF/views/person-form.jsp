<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Person Form</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
    <style>
        .container {
            max-width: 600px;
            margin-top: 50px;
        }
        .card {
            border-radius: 15px;
            box-shadow: 0 6px 15px rgba(0, 0, 0, 0.15);
            animation: fadeIn 1s ease-in-out;
        }
        @keyframes fadeIn {
            from { opacity: 0; transform: translateY(-20px); }
            to { opacity: 1; transform: translateY(0); }
        }
    </style>
</head>
<body class="bg-light">

<div class="container">
    <div class="card p-4">
        <h2 class="text-center mb-4 text-primary"><i class="fas fa-user-edit"></i> Enter Person Details</h2>
        
        <form:form modelAttribute="person" action="person" method="post">
            <div class="mb-3">
                <label class="form-label">Name:</label>
                <form:input path="name" class="form-control" required="true" placeholder="Enter your name"/>
            </div>
            <div class="mb-3">
                <label class="form-label">Age:</label>
                <form:input path="age" type="number" class="form-control" required="true" placeholder="Enter your age"/>
            </div>
            <div class="mb-3">
                <label class="form-label">Phone Number:</label>
                <form:input path="phoneNumber" class="form-control" required="true" placeholder="Enter phone number"/>
            </div>
            <div class="mb-3">
                <label class="form-label">Email ID:</label>
                <form:input path="emailId" type="email" class="form-control" required="true" placeholder="Enter email"/>
            </div>
            <div class="mb-3">
                <label class="form-label">Blood Group:</label>
                <form:input path="bloodGroup" class="form-control" required="true" placeholder="Enter blood group"/>
            </div>
            <button type="submit" class="btn btn-primary w-100"><i class="fas fa-paper-plane"></i> Submit</button>
        </form:form>
    </div>
</div>

</body>
</html>