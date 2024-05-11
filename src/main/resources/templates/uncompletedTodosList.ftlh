<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Uncompleted TODO List</title>
</head>
<body>
<h2>Uncompleted TODO List</h2>
<ul>
    <#list todos as todo>
        <li>${todo.title}</li>
    </#list>
</ul>
<p>Complete these tasks to stay on track!</p>
</body>
</html>
