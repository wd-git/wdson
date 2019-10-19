// jquery
$(document).ready(function () {
	var formObj = $("form[role='form']");
	
	$(".modBtn").on("click", function () {
		formObj.attr("action", "/board/modify");
		formObj.attr("method", "get");
		formObj.submit();
	});
	
	$(".delBtn").on("click", function() {
		formObj.attr("action", "board/remove");
		formObj.submit();
	});
	
	$(".listBtn").on("click", function() {
		self.location = "/board/list"
	});
	
});