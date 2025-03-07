<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Person Details</title>
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
        .btn-custom {
            background-color: #28a745;
            color: white;
            border-radius: 10px;
            transition: 0.3s;
        }
        .btn-custom:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card shadow-lg animate__animated animate__zoomIn">
                <div class="card-header bg-success text-white text-center">
                    <h3><i class="fas fa-user-check"></i> Person Details</h3>
                </div>
                <div class="card-body">
                    <p><i class="fas fa-user"></i> <strong>Name:</strong> ${person.name}</p>
                    <p><i class="fas fa-calendar"></i> <strong>Age:</strong> ${person.age}</p>
                    <p><i class="fas fa-phone"></i> <strong>Phone:</strong> ${person.phoneNumber}</p>
                    <p><i class="fas fa-envelope"></i> <strong>Email:</strong> ${person.emailId}</p>
                    <p><i class="fas fa-tint"></i> <strong>Blood Group:</strong> ${person.bloodGroup}</p>
                </div>
                <div class="card-footer text-center">
                    <a href="person" class="btn btn-custom"><i class="fas fa-arrow-left"></i> Go Back</a>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
