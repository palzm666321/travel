$(function(){
	$("button[id^=edit-]").each(function(){
		$(this).on("click",function(){
			did = this.id.split("-")[1] ;
			console.log("部门编号：" +  did) ;
			dname = $("#dname-" + did).val() ;
			if (dname == "") { 
				operateAlert(false,"","部门名称不允许为空，请确认后再提交更新！") ;
			} else {
				$.post("pages/back/admin/dept/edit.action",{"did":did,"dname":dname,"eid":eid},function(data){
					operateAlert(data.trim()=="true","部门名称更新成功！","部门名称更新失败！") ;
				},"text");
			}
		}) ;
	}) ;
	$("span[id^=eid-]").each(function(){
		$(this).on("click",function(){
			eid = this.id.substring(4);
			did=$(this).attr("alt");
			console.log("雇员编号：" + eid) ;
			$.post("pages/back/admin/emp/get.action",{"eid":eid},function(data){
				$("#info-photo").attr("src","upload/member/"+data.emp.photo);
				$("#info-ename").text(data.emp.ename);
				$("#info-level").text(data.level.title);
				$("#info-dname").text(data.dept.dname);
				$("#info-phone").text(data.emp.phone);
				$("#info-hiredate").text(new Date(data.emp.hiredate.time).format("yyyy-MM-dd"));
				$("#info-note").text(data.dept.note);
				$("#levelBtn").attr("alt",did);
				$("#userInfo").modal("toggle") ;
			},"json")
		}) ;
	}) ;
	
	$("#levelBtn").on("click",function(){
		did=$(this).attr("alt");
		$.post("pages/back/admin/dept/mgr.action",{"did":did},function(data){
			$("#mgr-"+did).empty();
			operateAlert(data.trim()=="true","部门领导更新成功！","部门名称领导失败！") ;
			$("#userInfo").modal("toggle") ;
		},"text")
	});
}) ;