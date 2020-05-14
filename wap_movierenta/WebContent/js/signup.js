(function($, utils) {
    const App = {
      init: function() {
        this.username = $('#txtUsername');
        this.fullname = $('#txtFullname');
        this.password = $('#txtPassword');
        this.passwordConfirm = $('#txtPasswordConfirm');
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
    	  this.form.on("submit", this.signup.bind(this));
      },
      signup(evt){
    	  evt.preventDefault();
    	  const username = this.username.val();
    	  const fullname = this.fullname.val();
    	  const password = this.password.val();
    	  const passwordConfirm = this.passwordConfirm.val();
    	  
    	  if(password != passwordConfirm){
    		  this.error.text("The password confirmation does not match.");
    		  this.error.show();
    	  } else {
    		  const data = {
        			  username,
        			  fullname,
        			  password
        	  }

              this.error.hide();
        	  fetch('signup', {
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
            		  window.location = 'home';
            	  }
              }); // response: { token } // login fail response:{ error }
    	  }
      }
    }
    App.init();
  })(jQuery, UTILS);