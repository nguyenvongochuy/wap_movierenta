"use strict";

(function($, utils) {
	const App = {
		init: function(){
			
			//movie information
			this.movieId = $("#movieId");
			this.movieTitle = $("#movieTitle");
			this.moviePoster = $("#moviePoster");
			this.voteAverage = $("#voteAverage");
			this.duration = $("#duration");
			this.releaseDate = $("#releaseDate");
			this.expirationDate = $("#expiration");
			this.overview = $("#overview");
			this.buyMovieButton = $("#btnBuyMovie");
			this.playmovie = $("#playmovie");
			this.playmovieLink = $("#playmovieLink");
			
			this.loadMovieData();
			this.bindEvents();
			
			
		},
		bindEvents: function(){
			this.buyMovieButton.on("click", this.buyMovie.bind(this))
		},
		loadMovieData: function(){
			const movieId=utils.getParameterByName("id"); 
			const token = utils.getToken();
			const myRequest = new Request('moviedata?id=' + movieId, {
			        method: 'GET',
			        headers: Object.assign({
			        	'Content-Type': 'application/json'
			        }, token ? { 'Authorization': 'Bearer '+ token.token } : {})
			      });
			  fetch(myRequest)
			      .then(response => response.json())
			      .then(data => this.renderMovieView(data));
		},
		renderMovieView: function(data){
			if (data) {
				if (data.error) {
					alert(data.error);
					if (data.error==="Do not login") {
						window.location="login";
						return;
					}
					window.location = "home";
				} else {
					this.movieId.val(data[1].movie.id);
					this.movieTitle.text(data[1].movie.title);
					this.moviePoster.attr("src", data[1].movie.poster_path);
					this.voteAverage.text(data[1].movie.vote_average);
					this.releaseDate.text(moment(data[1].movie.release_date).format("L"));
					this.duration.text(data[1].movie.duration + " min");
					this.overview.text(data[1].movie.overview);
					
					this.expirationDate.text(moment(utils.expiryDate(1)).format("L")); // expire 1 month
					
					//check user bought movieId or not to show playMovie
					if (data[0].isBought){ //already bought movie
						this.playmovie.attr("src", "image/playvideo.png");
						this.playmovie.attr("alt", "play video");
						//change button
						this.buyMovieButton.html("Bought!!!");
						this.buyMovieButton.off('click');
						
						this.playmovieLink.attr("href", "https://www.youtube.com/watch?v=szby7ZHLnkA"); //for demo only
					} else {
						this.buyMovieButton.html("Buy Movie");
						this.buyMovieButton.on('click');
					}
				}
			}
		},
		buyMovie: function() {
			const movieId=utils.getParameterByName("id");
			const token = utils.getToken();
			if (token) {
				const myRequest = new Request('addorder', {
			        method: 'POST',
			        headers: {
			        	'Authorization': 'Bearer '+ token.token,
			        	'Content-Type': 'application/json'
			        },
			        body: JSON.stringify({movieId})
			      });
			  fetch(myRequest)
			      .then(response => response.json())
			      .then(data => {
			    	  if (data.error){
			    		  if (data.error==="Movie does not exist") {
			    			  alert("Movie does not exist");
			    			  return;
			    		  }
			    		  if (data.error==="Do not login") {
			    			  window.location = 'login';
			    			  return;
			    		  }
			    	  } else {
			    		  window.location = 'thankyou?code='+data.token;
			    	  }
			    	  
			      });
			} else {
				window.location = 'login?returnUrl=' + window.encodeURIComponent(window.location.pathname + window.location.search);
			}
		}
			
	}

	App.init();

})(jQuery, UTILS);


