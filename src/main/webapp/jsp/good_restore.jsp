<style>
    <%@include file="/css/good_register.css"%>
</style>
<head>
    <title>Ready for secret!</title>
</head>
<body>
<div id="wrapper">
    <form id="signin" method="" action="" autocomplete="off">
        <h1><%= request.getAttribute("login")%> restored! Your password is 123456</h1>
        <p>Finally, now you can <a href="/Lab_1_war_exploded/">SIGN IN</a></p>
    </form>
</div>
</body>