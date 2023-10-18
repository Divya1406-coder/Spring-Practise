$(document).ready(function() {
	$("#logoutlink").on("click", function(e) {
		e.preventDefault();
		document.logoutForm.submit();
	});	
	customizeDropDownMenu();
});

function customizeDropDownMenu(){
	$(".navbar .dorpdown").hover(
		function(){
			$(this).find('.dropdown-menu').firt().stop(true,true).delay(250).slideDown();
		},
		function(){
			$(this).find('.dropdown-menu').firt().stop(true,true).delay(100).slideUp();
		}
	)
	$(".dropdown > a").click(function(){
		location.href = this.href;
	});
}