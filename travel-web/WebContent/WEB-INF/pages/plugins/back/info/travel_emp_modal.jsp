<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="travelEmpInfo"  tabindex="-1" aria-labelledby="modalTitle" aria-hidden="true" data-keyboard="true">
	<div class="modal-dialog" style="width: 1000px">
		<div class="modal-content">
			<div class="modal-header">
				<button class="close" type="button" data-dismiss="modal" aria-hidden="true">&times;</button>
				<div class="form-group" id="didDiv">
					<strong><span class="glyphicon glyphicon-eye-open"></span>&nbsp;查看出差人员安排</strong></h3>
				</div>
			</div>
			<div class="modal-body"> 
				<div>
					<table class="table table-condensed">
						<thead>
							<tr>
								<th class="text-center"><strong>照片</strong></th>
								<th class="text-center"><strong>姓名</strong></th>
								<th class="text-center"><strong>联系电话</strong></th>
								<th class="text-center"><strong>级别</strong></th>
								<th class="text-center"><strong>部门</strong></th>
							</tr>
						</thead>
						<tbody>
							<tr id="travel-1">
								<td class="text-center">
									<img src="upload/member/nophoto.png" style="width:20px;"/> 
								</td>
								<td class="text-center"><span id="eid-7369" style="cursor:pointer;">老李</span></td>
								<td class="text-center">3298239832</td>
								<td class="text-center">一级员工</td>
								<td class="text-center">开发部</td>
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
