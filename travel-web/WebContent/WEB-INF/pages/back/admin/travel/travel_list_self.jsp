<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/WEB-INF/pages/plugins/back/back_header.jsp"/>
<%!
	public static final String TRAVEL_SUBMIT_URL = "pages/back/admin/travel/submit.action" ;
	public static final String TRAVEL_EDIT_URL = "pages/back/admin/travel/edit_pre.action" ;
	public static final String TRAVEL_DELETE_URL = "pages/back/admin/travel/delete.action" ;
	public static final String TRAVEL_USER_URL = "pages/back/admin/travel/user_edit_pre.action" ;
	public static final String TRAVEL_COST_URL = "pages/back/admin/travel/cost_edit_pre.action" ;
%>
<script type="text/javascript" src="js/pages/back/admin/travel/travel_list_self.js"></script>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="2"/>
			<jsp:param name="msi" value="23"/>
		</jsp:include>
		<div class="content-wrapper text-left">
			<div class="panel panel-success">
				<div class="panel-heading">
					<strong><span class="glyphicon glyphicon-list"></span>&nbsp;我的出差申请信息列表</strong>
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
								<th class="text-center"><strong>申请时间</strong></th>
								<th class="text-center"><strong>出差人数</strong></th>
								<th class="text-center"><strong>差旅费用</strong></th>
								<th class="text-center"><strong>操作</strong></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${allTravels}" var="travel">
								<tr id="travel-1">
									<td class="text-center"><span class="text-danger"><span class="glyphicon glyphicon-flag"></span>&nbsp;</span></td>
									<td class="text-center">
										<span id="showBtn-1" onmouseover="this.style.cursor='hand'">${travel.title}</span>
									</td>
									<td class="text-center"><fmt:formatDate value="${travel.sdate}" pattern="yyyy-MM-dd"/></td>
									<td class="text-center"></td>
									<td class="text-center"></td>
									<td class="text-center">
										<a type="button" class="btn btn-primary btn-xs" href="<%=TRAVEL_SUBMIT_URL%>">
											<span class="glyphicon glyphicon-cloud-upload"></span>&nbsp;提交申请</a>
										<a type="button" class="btn btn-warning btn-xs" href="<%=TRAVEL_USER_URL%>">
											<span class="glyphicon glyphicon-user"></span>&nbsp;出差人员</a>
										<a type="button" class="btn btn-warning btn-xs" href="<%=TRAVEL_COST_URL%>">
											<span class="glyphicon glyphicon-credit-card"></span>&nbsp;出差费用</a>
										<a type="button" class="btn btn-info btn-xs" href="<%=TRAVEL_EDIT_URL%>?tid=${travel.tid}">
											<span class="glyphicon glyphicon-edit"></span>&nbsp;编辑</a>
										<a type="button" class="btn btn-danger btn-xs" href="<%=TRAVEL_DELETE_URL%>">
											<span class="glyphicon glyphicon-remove"></span>&nbsp;删除</a>
									</td>
								</tr> 
							</c:forEach>
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
	<jsp:include page="/WEB-INF/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/WEB-INF/pages/plugins/back/back_footer.jsp"/>
