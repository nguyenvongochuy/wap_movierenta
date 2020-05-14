<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>

<t:masterlayout>
  <jsp:attribute name="headSection">
    <title>Report</title>
    <link href="css/report.css" type="text/css" rel="stylesheet" />
    <link href="css/common.css" type="text/css" rel="stylesheet" />
    <link href="css/header.css" type="text/css" rel="stylesheet" />
    <link href="css/footer-fix.css" type="text/css" rel="stylesheet" />
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
    <!-- Chart -->
    <script src="https://code.highcharts.com/highcharts.js"></script>
    <script src="https://code.highcharts.com/modules/exporting.js"></script>
    <script src="https://code.highcharts.com/modules/export-data.js"></script>
    <script src="https://code.highcharts.com/modules/accessibility.js"></script>
        
    <script src="js/header.js" type="text/javascript"></script>
  	<script src="js/report.js"></script>
  </jsp:attribute>

 <jsp:body>
	<main id="main-container">
		<div class="row">
			<div class="col-md-3">
				<form class="report-form" id="form">
					<p class="chart-title">Charts</p>
		            <label class="label-group">Type data:</label>
		            <div class="form-group">
		            	<div class="custom-control custom-radio">
		            		<input required type="radio" name="radioData" id="radioDataDemand" checked value="demand">
		            		<label for="radioDataDemand">Demand</label>
		            	</div>
		            	<div class="custom-control custom-radio">
		            		<input required type="radio" name="radioData" id="radioDataRating" value="rating">
		            		<label for="radioDataRating">Rating</label>
		            	</div>
		            </div>
		            <label class="label-group">Type chart:</label>
		            <div class="form-group">
		            	<div class="custom-control custom-radio">
		            		<input required type="radio" name="radioType" id="radioTypeColumn" value="column" checked>
		            		<label for="radioTypeColumn">Column chart</label>
		            	</div>
		            	<div class="custom-control custom-radio">
		            		<input required type="radio" name="radioType" id="radioTypePie" value="pie">
		            		<label for="radioTypePie">Pie chart</label>
		            	</div>
		            </div>
		        </form>
			</div>
			<div class="col-md-9">
				<figure class="highcharts-figure">
	                <div id="container"></div>
		        </figure>
			</div>
		</div>
		
   		
            
   </main>
  </jsp:body>
  
</t:masterlayout>