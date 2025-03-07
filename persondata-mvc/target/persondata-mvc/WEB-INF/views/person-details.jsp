<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Person Details</title>
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
            transition: transform 0.3s, box-shadow 0.3s;
        }
        .card:hover {
            transform: scale(1.05);
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2);
        }
    </style>
</head>
<body class="bg-light">

<div class="container">
    <div class="card p-4 text-center">
        <h2 class="mb-4 text-success"><i class="fas fa-user"></i> Person Details</h2>
        <ul class="list-group list-group-flush">
            <li class="list-group-item"><strong>Name:</strong> ${person.name}</li>
            <li class="list-group-item"><strong>Age:</strong> ${person.age}</li>
            <li class="list-group-item"><strong>Phone Number:</strong> ${person.phoneNumber}</li>
            <li class="list-group-item"><strong>Email ID:</strong> ${person.emailId}</li>
            <li class="list-group-item"><strong>Blood Group:</strong> ${person.bloodGroup}</li>
        </ul>
        <div class="mt-3">
            <a href="person" class="btn btn-secondary"><i class="fas fa-arrow-left"></i> Go Back</a>
        </div>
    </div>
</div>

</body>
</html>
