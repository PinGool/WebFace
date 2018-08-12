<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>ECSHOP 管理中心</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="Text/Javascript" language="JavaScript">

if (window.top != window) {
    window.top.location.href = document.location.href;
}
</script>

<!-- 引入公用页面 -->
<jsp:include page="/WEB-INF/views/common.jsp"/>

<frameset rows="76,*" framespacing="0" border="0">
    <frame src="${path}/main_top.action" id="header-frame" name="header-frame" frameborder="no" scrolling="no"></frame>
    <frameset cols="180,*" framespacing="0" border="0" id="frame-body">
        <frame src="${path}/main_menu.action" id="menu-frame" name="menu-frame" frameborder="no">
        <frame src="${path}/main_index.action" id="main-frame" name="main-frame" frameborder="no">
    </frameset>
</frameset>
</head>
</html>