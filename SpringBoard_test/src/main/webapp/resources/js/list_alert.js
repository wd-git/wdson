/**
 * 
 */

var result = "${msg}";
if(result == "regSuccess") {
	alert("게시글 등록이 완료 되었습니다.");
} else if (result == "modSuccess") {
	alert("게시글 수정이 완료 되었습니다.");
} else if (result == "delSuccess") {
	alert("게시글 삭제가 완료 되었습니다.");
}