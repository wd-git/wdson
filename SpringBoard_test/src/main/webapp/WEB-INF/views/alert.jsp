<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 알림 전용 페이지  -->
<!-- 내용 : msg 다음페이지 url -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
	<body>
		<script type="text/javascript">
			alert('${msg}');
			document.location.href = '${url}';
		</script>
	</body>
</html>