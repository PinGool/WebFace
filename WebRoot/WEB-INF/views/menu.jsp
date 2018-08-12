<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>ECSHOP Menu</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- 引入公用页面 -->
<jsp:include page="/WEB-INF/views/common.jsp"/>

<style type="text/css">
body {
  background: #80BDCB;
}
#tabbar-div {
  background:#278296;
  padding-left:10px;
  height:21px;
  padding-top:0px;
}
#tabbar-div p {
  margin:1px 0 0 0;
}
.tab-front {
  background:#80BDCB;
  line-height:20px;
  font-weight:bold;
  padding:4px 15px 4px 18px;
  border-right:2px solid #335b64;
  cursor:hand;
  cursor:pointer;
}
.tab-back {
  color:#F4FAFB;
  line-height:20px;
  padding:4px 15px 4px 18px;
  cursor:hand;
  cursor:pointer;
}
.tab-hover {
  color:#F4FAFB;
  line-height:20px;
  padding:4px 15px 4px 18px;
  cursor:hand;
  cursor:pointer;
  background:#2F9DB5;
}
#top-div
{
  padding:3px 0 2px;
  background:#BBDDE5;
  margin:5px;
  text-align:center;
}
#main-div {
  border:1px solid #345C65;
  padding:5px;
  margin:5px;
  background:#FFF;
}
#menu-list {
  padding:0;
  margin:0;
}
#menu-list ul {
  padding:0;
  margin:0;
  list-style-type: none;
  color:#335B64;
}
#menu-list li {
  padding-left:16px;
  line-height:16px;
  cursor:hand;
  cursor:pointer;
}
#main-div a:visited, #menu-list a:link, #menu-list a:hover {
  color:#335B64
  text-decoration:none;
}
#menu-list a:active {
  color:#EB8A3D;
}
.explode {
  background:url(./Images/menu_minus.gif) no-repeat 0px 3px;
  font-weight:bold;
}
.collapse {
  background:url(./Images/menu_plus.gif) no-repeat 0px 3px;
  font-weight:bold;
}
.menu-item {
  background:url(./Images/menu_arrow.gif) no-repeat 0px 3px;
  font-weight:normal;
}
#help-title {
  font-size:14px;
  color:#000080;
  margin:5px 0;
  padding:0px;
}
#help-content {
  margin:0;
  padding:0;
}
.tips {
  color:#CC0000;
}
.link {
  color:#000099;
}
</style>

  <!-- 引入ztree组件 -->
<link rel="stylesheet" href="${path}/JQuery-zTree-v3.4/css/demo.css" type="text/css"/>
	<link rel="stylesheet" href="${path}/JQuery-zTree-v3.4/css/zTreeStyle/zTreeStyle.css" type="text/css"/>
	<script type="text/javascript" src="${path}/JQuery-zTree-v3.4/js/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="${path}/JQuery-zTree-v3.4/js/jquery.ztree.core-3.4.js"></script>


</head>
<body>
<div id="tabbar-div">
    <p>
        <span class="tab-front" id="menu-tab">菜单</span>
    </p>
</div>
<div id="main-div">
    <div id="menu-list">
        <ul id="menu-ul">       
        	<div class="zTreeDemoBackground left">
	    	   <ul id="treeDemo" class="ztree"></ul>
	        </div>        	
        </ul>
    </div>
</div>


<script language="JavaScript">

		<!--
		var setting = {
			view: {
				showLine: false  
			}
		};
		var zNodes =[
			{ name:"核心模块", open:true,iconOpen:"${path}/JQuery-zTree-v3.4/css/zTreeStyle/img/diy/1_open.png", iconClose:"${path}/JQuery-zTree-v3.4/css/zTreeStyle/img/diy/1_close.png",
				children: [
					 { name:"客户资料",icon:"${path}/JQuery-zTree-v3.4/css/zTreeStyle/img/diy/5.png",url:"${path}/customer_list.action",  target:"main-frame"},
					 { name:"客户跟进历史", url:"${path}/traceHistory_list.action", target:"main-frame"},
					 { name:"客户移交记录",url:"${path}/transferHistory_list.action", target:"main-frame"},
					 { name:"客户资源池",url:"${path}/customer_findByStatus.action", target:"main-frame"},
				]},
			{ name:"系统管理",
				children: [
					{ name:"部门管理",url:"${path}/dept_list.action", target:"main-frame"},
					{ name:"员工管理",url:"${path}/emp_list.action", target:"main-frame"}					
				]}

		];

		$(document).ready(function(){
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
		});
		//-->
	

</script>
</body>
</html>