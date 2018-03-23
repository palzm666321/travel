<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/WEB-INF/pages/plugins/back/back_header.jsp"/>
<script type="text/javascript" src="js/pages/back/admin/travel/travel_user_edit.js"></script>
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
					<strong><span class="glyphicon glyphicon-list"></span>&nbsp;出差人员列表</strong>
				</div>
				<div class="panel-body">
					<button class="btn btn-danger btn-lg" id="addBtn">
						<span class="glyphicon glyphicon-plus-sign"></span>&nbsp;增加出差人员</button>
					<table class="table table-condensed">
						<thead>
							<tr>
								<th class="text-center"><strong>照片</strong></th>
								<th class="text-center"><strong>雇员编号</strong></th>
								<th class="text-center"><strong>姓名</strong></th>
								<th class="text-center"><strong>工资</strong></th>
								<th class="text-center"><strong>级别</strong></th>
								<th class="text-center"><strong>部门</strong></th>
								<th class="text-center"><strong>操作</strong></th>
							</tr>
						</thead>
						<tbody>
							<tr id="travel-1">
								<td class="text-center">
									<img src="upload/member/nophoto.png" style="width:20px;"/> 
								</td>
								<td class="text-center">7369</td>
								<td class="text-center">老李</td>
								<td class="text-center">￥8923.23</td>
								<td class="text-center">一级员工</td>
								<td class="text-center">开发部</td>
								<td class="text-center">
									<button class="btn btn-danger btn-xs" id="remove-1">
										<span class="glyphicon glyphicon-remove"></span>&nbsp;移除</button>
								</td>
							</tr> 
						</tbody>
					</table>
					<div id="splitBarDiv" style="float:right">
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
	
<div class="modal fade" id="userInfo"  tabindex="-1" aria-labelledby="modalTitle" aria-hidden="true" data-keyboard="true">
	<div class="modal-dialog" style="width: 1000px">
		<div class="modal-content">
			<div class="modal-header">
				<button class="close" type="button" data-dismiss="modal" aria-hidden="true">&times;</button>
				<div class="form-group" id="didDiv">
					<!-- 定义表单提示文字 -->
					<label class="col-md-2 control-label" for="did">员工所在部门：</label>
					<div class="col-md-5">
						<select id="did" name="did" class="form-control">
							<option value="">====== 请选择雇员所在部门 ======</option>
							<option value="10">开发部</option>
							<option value="10">市场部</option>
							<option value="10">财务部</option>
						</select>
					</div>
				</div>
			</div>
			<div class="modal-body">
				<div id="memberBasicInfo">
					<table class="table table-condensed table-hover" id="empTable">
						<thead>
							<tr>
								<th class="text-center"><strong>照片</strong></th>
								<th class="text-center"><strong>雇员编号</strong></th>
								<th class="text-center"><strong>姓名</strong></th>
								<th class="text-center"><strong>工资</strong></th>
								<th class="text-center"><strong>级别</strong></th>
								<th class="text-center"><strong>操作</strong></th>
							</tr>
						</thead>
						<tbody>
							<tr id="travel-1">
								<td class="text-center">
									<img src="upload/member/nophoto.png" style="width:20px;"/> 
								</td>
								<td class="text-center">7369</td>
								<td class="text-center">老李</td>
								<td class="text-center">￥8923.23</td>
								<td class="text-center">一级员工</td>
								<td class="text-center">
									<button class="btn btn-danger btn-xs" id="remove-1">
										<span class="glyphicon glyphicon-plus-sign"></span>&nbsp;增加</button>
								</td>
							</tr> 
						</tbody>
					</table>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭窗口</button>
			</div>
		</div>
	</div>
</div>
	
	<jsp:include page="/WEB-INF/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/WEB-INF/pages/plugins/back/back_footer.jsp"/>
