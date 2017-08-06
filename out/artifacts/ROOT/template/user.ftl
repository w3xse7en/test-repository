<html lang="en-US">
    <head>
        <meta charset="UTF-8">
        <title>userInfo</title>
    </head>
    <body>
    <p>Hello </p>
    <#if user??>
    <p>Welcome ${user.userName}</p>
    <p> ${user.password}</p>
    <#else>
    <p>Bad ${user.userName}</p>
    </#if>
    </body>
</html>