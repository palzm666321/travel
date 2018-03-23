$(function(){
	$("span[id^=showBtn-]").each(function(){
		$(this).on("click",function(){
			tid = this.id.split("-")[1] ;
			console.log("差旅编号：" + tid) ;
			$("#travelInfo").modal("toggle") ;
		}) ;
	}) ;
	$("span[id^=eid-]").each(function(){
		$(this).on("click",function(){
			eid = this.id.split("-")[1] ;
			console.log("雇员编号：" + eid) ;
			$("#userInfo").modal("toggle") ;
		}) ;
	}) ;
})