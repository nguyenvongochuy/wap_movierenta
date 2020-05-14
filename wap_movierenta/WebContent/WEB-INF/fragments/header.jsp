<nav class="navbar navbar-expand-lg navbar-dark navbar-collapse custom-header">
	<a class="navbar-brand active" href="movies">The eMovie</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto text-white">
			<li class='nav-item' id="home"><a class='nav-link vertical' href='movies'>Home</a></li>
			<li class='nav-item' id="report"><a class='nav-link vertical' href='report' >Report</a></li>
		</ul>
		<span class="text-white" id="userInfo">Welcome, Guest&nbsp;&nbsp;</span>
		 
		<form id="loginForm" class="form-inline my-2 my-lg-0" action="login">
			<button class="btn btn-outline-success my-2 my-sm-0 btn-dark text-white" type="submit">Login</button>
		</form>
		<form id="logoutForm" class="form-inline my-2 my-lg-0" action="logout">
			<button class="btn btn-outline-success my-2 my-sm-0 btn-dark text-white" type="submit">Logout</button>
		</form>
	</div>
</nav>