<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<form method="post" action="/users/signup"onsubmit="return checkForm()">
		<table border="1">
			<tr>
				<th>이름</th>
				<td><input type="text" name="uiName" id="uiName"></td>
			</tr>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="uiId" id="uiId"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="uiPwd" id="uiPwd"></td>
			</tr>
			<tr>
				<th>비밀번호확인</th>
				<td><input type="password" name="uiPwdCheck" id="uiPwdCheck"></td>
			</tr>
			<tr>
				<th colspan="2"><button>확인</button></th>
			</tr>
		</table>
	</form>
<script>
function checkForm() {
	var uiName = document.getElementById('uiName').value;
	if (uiName.trim().length < 2) {
		alert('이름은 2글자 이상이어야합니다.');
		document.getElementById('uiName').value = '';
		document.getElementById('uiName').focus();
		return false;
	}
	var uiIdObj = document.getElementById('uiId');
	if (uiIdObj.value.trim().length < 5) {
		alert('아이디는 5글자 이상입니다');
		uiIdObj.value = '';
		uiIdObj.focus();
		return false;
	}
	var uiPwdObj = document.getElementById('uiPwd');
	if (uiPwdObj.value.trim().length < 5) {
		alert('비밀번호는 5글자 이상입니다');
		uiPwdObj.value = '';
		uiPwdObj.focus();
		return false;
	}
	var uiPwdCheckObj = document.getElementById('uiPwdCheck');
	if (uiPwdObj.value != uiPwdCheckObj.value) {
		alert('비밀번호가 일치하지 않습니다');
		uiPwdCheckObj.value = '';
		uiPwdCheckObj.focus();
		return false;
	}
	return true;
}
</script>
</body>
</html>