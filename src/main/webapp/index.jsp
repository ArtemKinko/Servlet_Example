<style>
    <%@include file="/css/signin.css"%>
</style>
<head>
    <title>Login to secret...</title>
</head>
<body>
<div id="wrapper">
    <form id="signin" method="post" action="login" autocomplete="off">
        <h1>Sign In Form</h1>
        <h2/>
        <input type="text" id="user" name="user" placeholder="username" />
        <input type="password" id="pass" name="pass" placeholder="password" />
        <button type="submit">&#xf0da;</button>
        <p>forgot your password? <a href="restore">click here</a></p>
        <p>need to sign up? <a href="register">click here</a></p>
    </form>
</div>
</body>