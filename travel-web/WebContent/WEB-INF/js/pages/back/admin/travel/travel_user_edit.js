did = 1 ;
function loadData() {	// 该函数名称一定要固定，不许修改
	// 如果要想进行分页的处理列表前首先查询出部门编号
	did = $("#did").val() ;	// 取得指定组件的value
	console.log("部门编号：" + did) ;
	$.post("pages/back/admin/travel/emp_dept.action", {
		"did" : did,
		"cp" : jsCommonCp, 
		"ls" : jsCommonLs
	}, function(data) {
		console.log(data);
		$("#empTable tr:gt(0)").remove() ;
		for (var x = 0 ; x < data.allEmps.length ; x ++) {
			addTableRow(data.allEmps[x].photo,data.allEmps[x].eid,data.allEmps[x].ename,data.allEmps[x].sal,data.allEmps[x].lid) ;
		}
		createSplitBar(data.allRecorders) ;	// 创建分页控制项
	}, "json");
}
function addTableRow(photo,eid,ename,sal,lid) {
	level = "普通员工" ;
	if (lid == "manager") {
		level = "部门经理" ;
	} else if (lid == "chief") {
		level = "总监" ;
	}
	row = 	"	<tr id='travel-1'>" + 
			"		<td class='text-center'>" +
			"			<img src='upload/member/"+photo+"' style='width:20px;'/> " +
			"		</td>" +
			"		<td class='text-center'>"+eid+"</td>" +
			"		<td class='text-center'>"+ename+"</td>" +
			"		<td class='text-center'>￥"+sal+"</td>" +
			"		<td class='text-center'>"+level+"</td>" +
			"		<td class='text-center'>" +
			"			<button class='btn btn-danger btn-xs' id='addEmp-"+eid+"'>" +
			"				<span class='glyphicon glyphicon-plus-sign'></span>&nbsp;增加</button>" +
			"		</td>" + 
			"	</tr> " ;
	console.log(row);
	$("#empTable").append(row) ;
}
$(function(){
	$("#did").on("change",function(){
		did = $(this).val() ;
		loadData() ;
	}) ;
	$(addBtn).on("click",function(){
		// Ajax异步读取用户信息
		// 将异步加载信息填充到模态窗口的组件之中
		loadData() ;
		$("#userInfo").modal("toggle") ;	// 显示模态窗口
	}) ;
})
