<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传文件页面</title>
<style type="text/css">
	div{
		text-align:center;
	}
</style>
</head>
<body>
	<div>
		<h1>SpringMVC文件上传练习</h1>
		<h2>请选择上传文件(文件大小在30M内)</h2>
		<form action="do_upload" method="post" enctype="multipart/form-data">
			<input type="file" name="file" /> <input type="submit" value="提交" />
			<input type="reset" value="重置 " />
		</form>
	</div>

</body>
</html>