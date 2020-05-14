<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/"%>

<t:masterlayout>
	<jsp:attribute name="headSection">
    <title>Thank you</title>
    <link href="css/common.css" type="text/css" rel="stylesheet" />
    <link href="css/header.css" type="text/css" rel="stylesheet" />
	<link href="css/footer-fix.css" type="text/css" rel="stylesheet" />
	
    <link href="css/thankyou.css" type="text/css" rel="stylesheet" />
  </jsp:attribute>

	<jsp:attribute name="header">
    <%@include file="/WEB-INF/fragments/header.jsp"%>
  </jsp:attribute>

	<jsp:attribute name="footer">
    <%@include file="/WEB-INF/fragments/footer.jsp"%>
  </jsp:attribute>


  <jsp:attribute name="scriptsSection">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
			integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
			crossorigin="anonymous" type="text/javascript"></script>
    <script
			src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
			integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
			crossorigin="anonymous" type="text/javascript"></script>
    <script
			src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
			integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
			crossorigin="anonymous" type="text/javascript"></script>
	 <script src="//cdnjs.cloudflare.com/ajax/libs/moment.js/2.7.0/moment.min.js" type="text/javascript"></script>
	 <script src="js/utils.js" type="text/javascript"></script>
	 <script src="js/header.js" type="text/javascript"></script>
    <script src="js/thankyou.js" type="text/javascript"></script>
  </jsp:attribute>

 <jsp:body>
	<div class='main-container border'>
		
					<p class='h2'>Thanks for your purchasing movies!</p>
					<div>Movie name:<p class='h5 text-muted' id="movieName"></p></div>
					<div>Purchase Date:<p class='h4 text-muted' id="purchaseDate"></p></div>
					<div>Expiry Date:<p class='h4 text-muted' id="expiryDate"></p></div>
					<div>Token Id:<p class='h4 text-muted' id="tokenId"></p></div>
			
					<br/><p>Please use token above to watch movies</p>
					
					<p>Continue to buy <a href='movies'>another movie</a>.</p>
			
		
	</div>
  </jsp:body>
  
</t:masterlayout>