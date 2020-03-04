<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>

<h1>hello freemarker</h1>

<p>遍历map需要指定keys/values，且遍历的元素无序</p>
<ul>
    <#--map遍历的形式和list相同-->
    <#list map?keys as key>
        <li>${key?counter} ${key}: ${map[key]}</li>
    </#list>

</ul>

</body>
</html>