$(function(){
	$(selall).on("click",function(){
		$("input[id^=eid-]").each(function(){
			$(this).prop("checked",true) ;
		}) ;
	}) ;
})