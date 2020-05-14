"use strict";

(function($, utils) {
	const App = {
		init: function(){
			
			//movie information
			this.movieName = $("#movieName");
			this.purchaseDate = $("#purchaseDate");
			this.expiryDate = $("#expiryDate");
			this.tokenId = $("#tokenId");
			
			const code=utils.getParameterByName("code");
			//console.log(code);
			this.tokenId.text(code);
			this.loadData(code);
		},
		loadData: function(code){
			const myRequest = new Request('thankyoudata?token=' + code , {
			        method: 'GET',
			      });
			  fetch(myRequest)
			      .then(response => response.json())
			      .then(data => this.renderView(data));
		},
		renderView: function(data){
			this.movieName.text(data[1].movie.title);
			//this.purchaseDate.text(utils.formatDateByUs(data[0].order.dateOrdered));
			this.purchaseDate.text(moment(data[0].order.dateOrdered).format("L"));
			this.tokenId.text(data[0].order.token);
			this.expiryDate.text(moment(utils.expiryDate(1)).format("L")); // expire 1 month
		}
			
			
			
	}

	App.init();

})(jQuery, UTILS);


