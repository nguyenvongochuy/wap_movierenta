(function($){
	const App = {
		init: function() {
			this.navHome = $('#home');
			this.navReport = $('#report');
			this.userInfo = $('#userInfo');
			this.loginForm = $('#loginForm');
			this.logoutForm = $('#logoutForm');
			this.pathname = window.location.pathname.replace("/manage-ticket/", "");
			this.username = localStorage.getItem('movie_authentication');
			
			this.activeMenu();
			this.checkLogin();
			this.bindEvent();
		},
		activeMenu(){
			this.userInfo.text('Welcome, Guest');
			this.loginForm.show();
			this.logoutForm.hide();
			this.navReport.hide();
			
			if(this.pathname == "report"){
				this.navReport.addClass("active");
			} else {
				this.navHome.addClass("active");
			}
		},
		checkLogin(){
			try{
				if (this.username) {
					const user = JSON.parse(this.username);
					this.userInfo.text('Welcome, '+ user.fullname);
					this.loginForm.hide();
					this.logoutForm.show();
					if(user.isAdmin){
						this.navReport.show();
					}
				}
			} catch(e){
				
			}
		},
	    bindEvent(){
			this.logoutForm.on("submit", this.logout.bind(this));
	    },
		logout(evt){
	    	evt.preventDefault();
	    	localStorage.removeItem('movie_authentication');
	    	window.location = 'home';
		}
	}
    App.init();
})(jQuery);