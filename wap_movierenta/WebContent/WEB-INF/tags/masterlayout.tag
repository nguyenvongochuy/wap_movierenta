<%@tag description="Master Layout template" pageEncoding="UTF-8"%>
<%@attribute name="headSection" fragment="true" %>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<%@attribute name="scriptsSection" fragment="true" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="keywords" content="HTML,CSS,bootstrap" />
    <meta name="description" content="Website shows the assignments of course CS472 - Web Application Programming" />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link href="css/footer-n-more.css" type="text/css" rel="stylesheet" />
    <jsp:invoke fragment="headSection"/>
  </head>
  <body>
    <jsp:invoke fragment="header"/>
    <jsp:doBody/>
    <jsp:invoke fragment="footer"/>
    <jsp:invoke fragment="scriptsSection"/>
  </body>
</html>