<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/WEB-INF/pages/plugins/back/back_header.jsp"/>
<%!
	public static final String TRAVEL_AUDIT_URL = "pages/back/admin/travel/travel_audit.jsp" ;
%>
<script type="text/javascript" src="js/pages/back/admin/travelaudit/travel_list.js"></script>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="3"/>
			<jsp:param name="msi" value="32"/>
		</jsp:include>
		<div class="content-wrapper text-left">
			<div class="panel panel-success">
				<div class="panel-heading">
					<strong><span class="glyphicon glyphicon-list"></span>&nbsp;出差信息列表</strong>
				</div>
				<div class="panel-body">
					<div>
						<jsp:include page="/WEB-INF/pages/plugins/split_plugin_search_bar.jsp"/>
					</div>
					<table class="table table-condensed">
						<thead>
							<tr>
								<th class="text-center"><strong>状态</strong></th>
								<th class="text-center"><strong>申请标题</strong></th>
								<th class="text-center"><strong>申请人</strong></th>
								<th class="text-center"><strong>申请部门</strong></th>
								<th class="text-center"><strong>申请日期</strong></th>
								<th class="text-center"><strong>开始日期</strong></th>
								<th class="text-center"><strong>结束日期</strong></th>
								<th class="text-center"><strong>出差人数</strong></th>
								<th class="text-center"><strong>差旅费用</strong></th>
							</tr>
						</thead>
						<tbody>
							<tr id="travel-1">
								<td class="text-center"><span class="text-danger"><span class="glyphicon glyphicon-flag"></span>&nbsp;已完成</span></td>
								<td class="text-center">
									<span id="showBtn-1" onmouseover="this.style.cursor='hand'">XX公司CRM项目</span>
								</td>
								<td class="text-center"><span id="eid-7369" style="cursor:pointer;">老李</span></td>
								<td class="text-center">开发一部</td>
								<td class="text-center">2018-10-10</td>
								<td class="text-center">2018-10-10</td>
								<td class="text-center">2018-10-10</td>
								<td class="text-center">20人</td>
								<td class="text-center">￥8923.23</td>
							</tr> 
							<tr id="travel-2">
								<td class="text-center"><span class="text-warning"><span class="glyphicon glyphicon-flag"></span>&nbsp;进行中</span></td>
								<td class="text-center">
									<span id="showBtn-2" onmouseover="this.style.cursor='hand'">XX公司CRM项目</span>
								</td>
								<td class="text-center"><span id="eid-7369" style="cursor:pointer;">老李</span></td>
								<td class="text-center">开发一部</td>
								<td class="text-center">2018-10-10</td>
								<td class="text-center">2018-10-10</td>
								<td class="text-center">2018-10-10</td>
								<td class="text-center">20人</td>
								<td class="text-center">￥8923.23</td>
							</tr> 
							<tr id="travel-3">
								<td class="text-center"><span class="text-primary"><span class="glyphicon glyphicon-flag"></span>&nbsp;待提交</span></td>
								<td class="text-center">
									<span id="showBtn-3" onmouseover="this.style.cursor='hand'">XX公司CRM项目</span>
								</td>
								<td class="text-center"><span id="eid-7369" style="cursor:pointer;">老李</span></td>
								<td class="text-center">开发一部</td>
								<td class="text-center">2018-10-10</td>
								<td class="text-center">2018-10-10</td>
								<td class="text-center">2018-10-10</td>
								<td class="text-center">20人</td>
								<td class="text-center">￥8923.23</td>
							</tr> 
						</tbody>
					</table>
					<div id="splitBarDiv" style="float:right">
						<jsp:include page="/WEB-INF/pages/plugins/split_plugin_page_bar.jsp"/> 
					</div>
				</div>
				<div class="panel-footer">
					<jsp:include page="/WEB-INF/pages/plugins/include_alert.jsp"/>
				</div>
			</div>
		</div>
		<!-- 导入公司尾部认证信息 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_title_foot.jsp" />
		<!-- 导入右边工具设置栏 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_menu_sidebar.jsp" />
		<div class="control-sidebar-bg"></div>
	</div>
	<jsp:include page="/WEB-INF/pages/plugins/back/info/travel_info_modal.jsp"/>
	<jsp:include page="/WEB-INF/pages/plugins/back/info/emp_info_modal.jsp"/>
	<jsp:include page="/WEB-INF/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/WEB-INF/pages/plugins/back/back_footer.jsp"/>
