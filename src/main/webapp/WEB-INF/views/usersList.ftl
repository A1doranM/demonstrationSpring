<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Users</title>
</head>
<body>
<table>
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Age</th>
    </tr>
<#list users as user>
    <tr>
        <td><a href="/user/${user.name}">${user.name}</a></td>
        <td>${user.name}</td>
        <td>${user.email}</td>
        <td><a href="/delete/${user.name}">Delete</a></td>
        <td><a href="/update/${user.name}">Update</a></td>
    </tr>
</#list>
</table>
<a href="/addUser">Create user</a>
</body>
</html>