"use strict";

window.UTILS = (function () {
	let today = new Date();

	const currentDate = function() {
		return formatDateByUs(this.today);
	};
	const expiryDate = function(num) {
		return formatDateByUs(today.setMonth(today.getMonth()+num));
	};
	const formatDateByUs = function(d) {
		const ye = new Intl.DateTimeFormat('en', { year: 'numeric' }).format(d)
		const mo = new Intl.DateTimeFormat('en', { month: 'numeric' }).format(d)
		const da = new Intl.DateTimeFormat('en', { day: '2-digit' }).format(d)
		return `${mo}-${da}-${ye}`;
	};
	function getParameterByName(name, url) {
	    if (!url) url = window.location.href;
	    name = name.replace(/[\[\]]/g, '\\$&');
	    var regex = new RegExp('[?&]' + name + '(=([^&#]*)|&|#|$)'),
	        results = regex.exec(url);
	    if (!results) return null;
	    if (!results[2]) return '';
	    return decodeURIComponent(results[2].replace(/\+/g, ' '));
	};
	function saveToken(token){
		localStorage.setItem("movie_authentication", JSON.stringify(token));
	}
	function getToken(){
		try{
			const authentication = localStorage.getItem('movie_authentication');
			if (authentication) {
				const user = JSON.parse(authentication);
				return user;
			}
		} catch(e) {
			return null;
		}
	}
	
	return {
		currentDate: currentDate,
		expiryDate: expiryDate,
		formatDateByUs: formatDateByUs,
		getParameterByName: getParameterByName,
		saveToken: saveToken,
		getToken: getToken
	  }
})();