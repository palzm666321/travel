var myform ;
function clearCostModal() {
	$(title).val("") ;
	$(price).val("") ;
	$("#tid option").each(function(){
		$(this).prop("selected",false) ;
	}) ;
	myform.resetForm() ; 
}
$(function(){
	$(addBtn).on("click",function(){
		clearCostModal() ;
		// Ajax异步读取用户信息
		// 将异步加载信息填充到模态窗口的组件之中
		$("#costInfo").modal("toggle") ;	// 显示模态窗口
	}) ;
	myform = $("#myform").validate({
		debug : true, // 取消表单的提交操作
		submitHandler : function(form) {
			// form.submit(); // 提交表单
			operateAlert(true,"支出项追加失败！" , "支出项追加成功！") ;
			$("#costInfo").modal("toggle") ;	// 显示模态窗口
		},
		errorPlacement : function(error, element) {
			$("#" + $(element).attr("id").replace(".", "\\.") + "Msg").append(error);
		},
		highlight : function(element, errorClass) {
			$(element).fadeOut(1,function() {
				$(element).fadeIn(1, function() {
					$("#" + $(element).attr("id").replace(".","\\.") + "Div").attr("class","form-group has-error");
				});

			})
		},
		unhighlight : function(element, errorClass) {
			$(element).fadeOut(1,function() {
				$(element).fadeIn(1,function() {
						$("#" + $(element).attr("id").replace(".","\\.") + "Div").attr("class","form-group has-success");
				});
			})
		},
		errorClass : "text-danger",
		rules : {
			"title" : {
				required : true,
				//remote : {
//									url : "check.jsp", // 后台处理程序
//									type : "post", // 数据发送方式
//									dataType : "html", // 接受数据格式
//									data : { // 要传递的数据
//										code : function() {
//											return $("#code").val();
//										}
//									},
//									dataFilter : function(data, type) {
//										if (data.trim() == "true")
//											return true;
//										else
//											return false;
//									}
				//}
			},
			"tid" : {
				required : true
			} ,
			"price" : {
				required : true ,
				number : true
			}
		}
	});
})