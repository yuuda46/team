<%-- 共通部分JSP --%>
<%@ page contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>

<%-- 文字化けの対策 --%>
<% request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="../css/style.css">
</head>

<body>
<div class="wrapper">
	<div class="top_menu">
		<h1 class="toptitle">掲示板(仮)</h1>
		<ul class="top_url">
			<li class="top_list"><a href="menu">メニュー</a></li>
			<li class="top_list"><a href="notice">お知らせ</a></li>
			<li class="top_list"><a href="post">投稿</a></li>
			<li class="top_list"><a href="collect">集金</a></li>
		</ul>
	</div>

${param.scripts}
${param.content}
</div>
</body>

<footer>
		<small>&copy; 2024 Team_F</small>
</footer>

</html>