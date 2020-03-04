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
    <#--if判断 可以完成筛选-->
    <#list list as item>
    <#--<ul>${item_index}: ${item}</ul>-->
        <#if item?is_odd_item>
            <ul>${item?is_odd_item?c}: ${item?counter}</ul>
        <#--同样 if中包含 elseif和else 用法和java相同-->
        <#elseif item?is_even_item>
            <ul>${item?is_odd_item?c}: ${item?counter}</ul>
        <#else>
            <ul>${item?is_odd_item?c}: ${item?counter}</ul>
        </#if>
    </#list>
</li>

</body>
</html>