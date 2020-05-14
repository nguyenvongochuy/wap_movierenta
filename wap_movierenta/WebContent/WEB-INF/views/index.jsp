<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>

<t:masterlayout>
  <jsp:attribute name="headSection">
    <title>Movies</title>
    <link href="css/movies.css" type="text/css" rel="stylesheet" />
    <link href="css/header.css" type="text/css" rel="stylesheet" />
    <link href="css/header-movies.css" type="text/css" rel="stylesheet" />
    <link href="css/common.css" type="text/css" rel="stylesheet" />
    <link href="css/footer.css" type="text/css" rel="stylesheet" />
  </jsp:attribute>

  <jsp:attribute name="header">
    <%@include file="/WEB-INF/fragments/header.jsp"%>
  </jsp:attribute>

  <jsp:attribute name="footer">
    <%@include file="/WEB-INF/fragments/footer.jsp"%>
  </jsp:attribute>

  <jsp:attribute name="scriptsSection">
    <script src="js/jquery-3.5.0.js"></script>
    <script
			src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
			integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
			crossorigin="anonymous" type="text/javascript"></script>
    <script
			src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
			integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous" type="text/javascript"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.loadtemplate/1.5.10/jquery.loadTemplate.min.js" integrity="sha256-mF3k3rmuuGVi/6GhJ5atwMd7JsTsQhULB6GyLaFPrMU=" crossorigin="anonymous"></script>
    <script src='https://kit.fontawesome.com/a076d05399.js'></script>
  	
  	<script src="js/header.js" type="text/javascript"></script>
  	<script src="js/movie-tour.js"></script>
  </jsp:attribute>

 <jsp:body>
	<main id="main-container">
            <!-- Slideshow container -->
            <div id="slideshow-container">
            </div>

             <!-- Page control -->
             <div id="page-control" style="text-align:center">
            </div>
            
            <!-- Movies container -->
            <div id="movies-container">
                <ul id="grid-container">
                </ul>
            </div>
            
   </main>
        <!--
        <footer>
            <div class="text-muted">O.Kalu ::: CS472-WAP</div>
            <div class="text-muted">@ April 2020</div>
        </footer>
        -->
        <!-- Templates -->
        <!-- Movies slideshow-->
        <script id="slideshow-template" type="text/html">
            <div class="mySlides fade">
                <a data-link="movieLink">
                    <img data-src="cover" style="width:100%">
                    <div class="movie-description">
                        <div class="caption" data-content="title">Caption Text</div>
                        <div class="text" data-content="overview">Caption Text</div>
                    </div>
                </a>
                
            </div>
        </script>
        <!-- Movie template-->
        <script id="movie-template" type="text/html">
            <li class="movie">
                <div>
                    <a data-link="movieLink" class="movie-link">
                        <img data-src="poster_path" data-alt="poster">
                        <div class="movie-title">
                            <span class="title" data-content="title"></span>
                        </div>
                    </a>
                    
                    <div class="movie-detail">
                        <div class="grid-item-controls">
                            <a data-link="movieLink" class="movie-link">
                                <div class="grid-item-control">
                                    <img class="shopping-cart" src="image/shopping-icon.png" alt="">
                                </div>
                            </a>
                        </div>
                        <a data-link="movieLink" class="movie-link">
                            <div>
                                <span data-content="year" class="year"></span>
                                <i class='fas fa-thumbs-up'></i>
                                <span data-content="vote_average"></span>
                            </div>
                            <div>
                                <span class="description" data-content="description"></span>
                                <span class="description">MORE</span>
                            </div>
                        </a>
                    </div>
                </div>
                
            </li>
        </script>

        <!-- Dot page control pattern-->
        <script id="page-item-template" type="text/html">
            <span class="dot" data-id="index"></span>
        </script>
  </jsp:body>
  
</t:masterlayout>