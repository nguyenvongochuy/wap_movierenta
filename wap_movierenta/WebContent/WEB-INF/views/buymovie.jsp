<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/"%>

<t:masterlayout>
	<jsp:attribute name="headSection">
    <title>Purchase Movie</title>
    <link rel="stylesheet" type="text/css" href="css/buymovie.css" />
    
    <link href="css/common.css" type="text/css" rel="stylesheet" />
    <link href="css/header.css" type="text/css" rel="stylesheet" />
    <link href="css/footer-fix.css" type="text/css" rel="stylesheet" />
    <link href="css/buymovie.css" type="text/css" rel="stylesheet"/>
    
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
    <script src="js/order.js" type="text/javascript"></script>
  </jsp:attribute>

	<jsp:body>
	<div class='main-container'>
        <div id="buyMovieForm">
        			<div class="row">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <div class="form-group"
								class="alignImg">
                                    <img id="moviePoster"
									class="poster-image" alt="movie Poster" src="">
                                </div>
                                </div>
                            </div>
                            <div class="col-md-8">
                                <div class="form-group h3">
                                    <p id="movieTitle"></p>
                                </div>
                              <div class="form-group">
                                    <p id="overview"></p>
                                </div>  
                                
                                <div class="row">
	                                <div class="col-md-2">
		                                <div class="form-group text-muted">
		                                    <label for="voteAverage">RATING</label>
		                                    <p id="voteAverage"></p>
		                                </div>
		                             </div>
		                             <div class="col-md-3 text-muted">
		                                <div class="form-group">
		                                    <label for="releaseDate">RELEASED</label>
		                                    <p id="releaseDate"></p>
		                                </div>
		                             </div>
		                             <div class="col-md-2 text-muted">
		                                <div class="form-group">
		                                    <label for="duration">DURATION</label>
		                                    <p id="duration"></p>
		                                </div>
		                             </div>
		                             <div class="col-md-3 text-muted">   
		                                <div class="form-group">
		                                    <label for="duration">EXPIRATION</label>
		                                    <p id="expiration"></p>
		                                </div>
		                             </div>   
	                                </div>
                                
                                <div class="rightfloat">
                                <button tabindex="10" id="btnBuyMovie" class="btn btn-outline-success">Buy Movie</button>
                                <a id="playmovieLink" target="_blank"><img id="playmovie" class="smallIconPlayVideo"></img></a>
                                </div>
                                 </div>
                            </div>
                                
                            </div>
    	</div>

  </jsp:body>

</t:masterlayout>