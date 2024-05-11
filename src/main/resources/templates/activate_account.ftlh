<#--
<!DOCTYPE html>
<html lang="en" xmlns:text-align="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>Activate</title>
</head>
<body style="background-color: floralwhite; margin: 0;padding: 0 ">
<h1 style="text-align: center; color: green"> Hello ${username}</h1>
<h3>You have successfully registered !!!</h3>
<h3>In order to activate your account please click the link below</h3>
&lt;#&ndash;<a href="http://localhost:8080/activate?email=${token}">Activate</a>&ndash;&gt;
</body>
</html>-->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Activate Your Account</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            color: #007bff;
        }
        h3 {
            color: #555;
        }
        .activation-link {
            display: inline-block;
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            text-decoration: none;
            border-radius: 5px;
            margin-top: 20px;
        }
        .activation-link:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>HI ${username}</h1>
    <h3>You have successfully registered!</h3>
    <h3>In order to activate your account, please click the link below:</h3>
    <a class="activation-link" href="http://localhost:8080/activate?email=${token}">Activate</a>
</div>
</body>
</html>
