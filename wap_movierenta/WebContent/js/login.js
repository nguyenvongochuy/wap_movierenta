(function($, utils) {
    const App = {
      init: function() {
        this.username = $('#txtUsername');
        this.password = $('#txtPassword');
        this.form = $('#form');
        this.error = $('#error');
        this.checkLogin();
        this.bindEvent();
        this.error.hide();
      },
      checkLogin(){
    	  try {
          	const authentication = localStorage.getItem('movie_authentication');
          	const user = JSON.parse(authentication);
          	if (user && user.token){
          		window.location = 'home';
          	}
          } catch (e) {}
      },
      bindEvent(){
    	  this.form.on("submit", this.login.bind(this));
      },
      login(evt){
    	  evt.preventDefault();
    	  const username = this.username.val();
    	  const password = this.password.val();
    	  
    	  const data = {
    			  username,
    			  password
    	  }

          this.error.hide();
    	  fetch('login', {
    		  method: 'POST',
    		  headers: { 'Content-Type': 'application/json' },
    		  body: JSON.stringify(data)
    	  })
          .then(response => response.json())
          .then(response => {
        	  if (response && response.error) {
        		  this.error.text(response.error);
        		  this.error.show();
        	  } else {
        		  utils.saveToken(response);
        		  let returnUrl = utils.getParameterByName("returnUrl");
        		  if (returnUrl){
        			  returnUrl = window.decodeURIComponent(returnUrl);
        		  }
        		  
        		  //window.location = returnUrl || 'home';
        		  if (returnUrl==null || returnUrl==="undefined") {
        			  window.location = 'home';
        		  } else {
        			  window.location = returnUrl;
        		  }
        			  
        		  
        	  }
          }); // response: { token } // login fail response:{ error }
    	  
      }
    }
    App.init();
  })(jQuery, UTILS);