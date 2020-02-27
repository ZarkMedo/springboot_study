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

<li>
    <#--list为传入的参数名-->
    <#--元素名_index 为list元素对应的索引-->
    <#--index-->
    <#list list as item>
       <ul>${item_index}: ${item}</ul>
    </#list>
</li>

</body>
</html>