<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/WEB-INF/pages/plugins/back/back_header.jsp"/>
<%!
	public static final String TRAVEL_ADD_URL = "pages/back/admin/travel/add.action" ;
%>
<script type="text/javascript" src="${basePath}js/my97date/WdatePicker.js"></script> 
<script type="text/javascript" src="js/pages/back/admin/travel/travel_add.js"></script>
<body class="hold-transition skin-blue sidebar-mini"> 
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="2"/>
			<jsp:param name="msi" value="21"/>
		</jsp:include>
		<div class="content-wrapper text-left">
					<div class="panel panel-success">
				<div class="panel-heading">
					<strong><span class="glyphicon glyphicon-file"></span>&nbsp;出差申请单</strong>
				</div>
				<div class="panel-body">
					<form class="form-horizontal" action="<%=TRAVEL_ADD_URL%>" id="myform" method="post">
						<fieldset>
							<!-- 定义输入表单样式，其中id主要用于设置颜色样式 -->
							<div class="form-group" id="titleDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="title">申请标题：</label>
								<div class="col-md-5">
									<!-- 定义表单输入组件 -->
									<input type="text" id="title" name="title" class="form-control"
										placeholder="请输入出差申请标题">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="titleMsg"></div>
							</div>
							<div class="form-group" id="iidDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="iid">出差类型：</label>
								<div class="col-md-5">
									<select id="iid" name="iid" class="form-control">
										<option value="">====== 请选择外出类型 ======</option>
										<option value="1">测试</option>
										<c:forEach items="${allItems}" var="item">
											<option value="${item.iid}">${item.title}</option>
										</c:forEach>
									</select>
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="iidMsg"></div>
							</div>
							<div class="form-group" id="sdateDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="sdate">出差开始日期：</label>
								<div class="col-md-5">
									<!-- 定义表单输入组件 -->
									<input type="text" id="sdate" name="sdate" class="form-control"
										placeholder="请选择出差开始时间" readonly>
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="destinationMsg"></div>
							</div>
							<div class="form-group" id="edateDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="edate">出差开始日期：</label>
								<div class="col-md-5">
									<!-- 定义表单输入组件 -->
									<input type="text" id="edate" name="edate" class="form-control"
										placeholder="请选择出差结束时间" readonly>
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="edateMsg"></div>
							</div>
							<div class="form-group" id="destinationDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="destination">出差目的地：</label>
								<div class="col-md-5">
									<!-- 定义表单输入组件 -->
									<input type="text" id="destination" name="destination" class="form-control"
										placeholder="请填写本次出差的目的地">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="destinationMsg"></div>
							</div>
							<!-- 定义输入表单样式，其中id主要用于设置颜色样式 -->
							<div class="form-group" id="noteDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="note">出差事由：</label>
								<div class="col-md-5">
									<!-- 定义表单输入组件 -->
									<textarea id="note" name="note"
										class="form-control" placeholder="请输入本次出差要处理的业务详情" rows="10"></textarea>
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="noteMsg"></div>
							</div> 
							<div class="form-group">
								<div class="col-md-5 col-md-offset-3">
									<button type="submit" class="btn btn-primary">增加</button>
									<button type="reset" class="btn btn-warning">重置</button>
								</div>
							</div>
						</fieldset>
					</form>
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
	<jsp:include page="/WEB-INF/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/WEB-INF/pages/plugins/back/back_footer.jsp"/>
