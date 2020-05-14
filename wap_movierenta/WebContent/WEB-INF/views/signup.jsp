<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:masterlayout>
  <jsp:attribute name="headSection">
    <title>Sign Up</title>
    <link rel="stylesheet" type="text/css" href="css/signup.css"/>
  </jsp:attribute>

  <jsp:attribute name="header">
  </jsp:attribute>

  <jsp:attribute name="footer">
  </jsp:attribute>

  <jsp:attribute name="scriptsSection">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
	
	<script src="js/utils.js"></script>
	<script src="js/signup.js"></script>
  </jsp:attribute>

 <jsp:body>
	<div class="container-signup">
        <form class="signup-form" id="form">
            <span class="signup-form-title">
                Sign Up
            </span>
            <div class="alert alert-danger" role="alert" id="error"></div>
            <div class="form-group">
              <input type="text" class="form-control" id="txtUsername" required placeholder="Username">
            </div>
            <div class="form-group">
              <input type="text" class="form-control" id="txtFullname" required placeholder="Fullname">
            </div>
            <div class="form-group">
              <input type="password" class="form-control" id="txtPassword" required placeholder="Password">
            </div>
            <div class="form-group">
              <input type="password" class="form-control" id="txtPasswordConfirm" required placeholder="Confirm Password">
            </div>
            <div class="container-signup-form-btn">
                <button type="submit" class="signup-form-btn">Sign Up</button>
            </div>
            <div class="message-center">
            	<p>Have an Account? <a href="login"> Login Now!</a></p>
            </div>
        </form>
    </div>
  </jsp:body>
</t:masterlayout>