$(document).ready(function (){
		$(".writeBtn").on("click", function() {
			document.location.href='/write'; 
		});
	});

	var result = "${msg}";

	if (result == "regSucess") {
		alert("게시글 등록이 완료되었습니다.");
	} else if (result == "modeSuccess") {
		alert("게시글 수정이 완료되었습니다."); 
	} else if (result == "delSuccess") {
		alert("게시글 삭제가 완료되었습니다.");
	}