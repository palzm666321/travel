<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="userInfo"  tabindex="-1" aria-labelledby="modalTitle" aria-hidden="true" data-keyboard="true">
	<div class="modal-dialog" style="width: 1000px">
		<div class="modal-content">
			<div class="modal-header">
				<button class="close" type="button" data-dismiss="modal" aria-hidden="true">&times;</button>
				<div class="form-group" id="didDiv">
					<strong><span class="glyphicon glyphicon-eye-open"></span>&nbsp;查看部门领导信息</strong></h3>
				</div>
			</div>
			<div class="modal-body">
				<div id="costBasicInfo">
					<div class="row">
						<div class="col-xs-3">
							<img src="upload/member/nophoto.png" style="width:200px;" name="info-photo">
						</div>
						<div class="col-xs-8">
							<table class="table table-condensed" style="width:700px;">
								<tr>
									<td style="width:30%;"><strong>雇员姓名：</strong></td>
									<td id="info-ename"></td>
								</tr>
								<tr>
									<td><strong>雇员职务：</strong></td>
									<td id="info-level"></td>
								</tr>
								<tr>
									<td><strong>所属部门：</strong></td>
									<td id="info-dname"></td>
								</tr>
								<tr>
									<td><strong>联系电话：</strong></td>
									<td id="info-phone"></td>
								</tr>
								<tr>
									<td><strong>雇佣日期：</strong></td>
									<td id="info-hiredate"></td>
								</tr>
								<tr>
									<td><strong>备注信息：</strong></td>
									<td><pre class="pre-scrollable" style="width:400px;height:210px;" id="info-note"></pre></td>
								</tr>
							</table>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭窗口</button>
			</div>
		</div>
	</div>
</div>
