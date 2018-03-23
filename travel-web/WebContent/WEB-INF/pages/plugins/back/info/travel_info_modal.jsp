<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="travelInfo"  tabindex="-1" aria-labelledby="modalTitle" aria-hidden="true" data-keyboard="true">
	<div class="modal-dialog" style="width: 1000px">
		<div class="modal-content">
			<div class="modal-header">
				<button class="close" type="button" data-dismiss="modal" aria-hidden="true">&times;</button>
				<div class="form-group" id="didDiv">
					<strong><span class="glyphicon glyphicon-eye-open"></span>&nbsp;查看出差详情</strong></h3>
				</div>
			</div>
			<div class="modal-body">
				<div>
					<table class="table table-striped table-bordered table-hover">
						<tr> 
							<td style="width:150px;"><strong>申请标题：</strong></td>
							<td>XX公司CRM项目</td>
						</tr>
						<tr>
							<td><strong>出差类型：</strong></td>
							<td>驻外开发</td>
						</tr>
						<tr>
							<td><strong>总费用：</strong></td>
							<td>￥8282923.23</td>
						</tr>
						<tr>
							<td><strong>总人数：</strong></td>
							<td>30人</td>
						</tr>
						<tr>
							<td><strong>申请日期：</strong></td>
							<td>2019-10-10</td>
						</tr>
						<tr>
							<td><strong>出发日期：</strong></td>
							<td>2019-10-10</td>
						</tr>
						<tr>
							<td><strong>返回日期：</strong></td>
							<td>2019-10-10</td>
						</tr>
						<tr>
							<td><strong>目的地：</strong></td>
							<td>北京市xxxxxx</td>
						</tr>
					</table>
				</div>
				<div class="panel-group" id="news">
					<div class="panel panel-info">
						<div class="panel-heading">
							<h4 class="panel-title"> 
								<a data-toggle="collapse" data-parent="news" href="#contentOne">
									<strong><span class="glyphicon glyphicon-user"></span>&nbsp;出差人员安排（总人数：）</strong>
								</a>
							</h4>
						</div>
						<div id="contentOne" class="panel-collapse collapse">
							<div class="panel-body">
								<table class="table table-condensed">
									<thead>
										<tr>
											<th class="text-center"><strong>照片</strong></th>
											<th class="text-center"><strong>姓名</strong></th>
											<th class="text-center"><strong>联系电话</strong></th>
											<th class="text-center"><strong>工资</strong></th>
											<th class="text-center"><strong>级别</strong></th>
											<th class="text-center"><strong>雇佣日期</strong></th>
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
											<td class="text-center">￥8923.23</td>
											<td class="text-center">一级员工</td>
											<td class="text-center">2019-10-10</td>
											<td class="text-center">开发部</td>
										</tr> 
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="news" href="#contentTwo">
									<strong><span class="glyphicon glyphicon-list-alt"></span>&nbsp;出差费用支出项（总费用￥<span id="allPrice" class="text-danger h2"></span>）</strong>
								</a>
							</h4>
						</div>
						<div id="contentTwo" class="panel-collapse collapse">
							<div class="panel-body">
								<table class="table table-condensed">
									<thead>
										<tr>
											<th class="text-center"><strong>支出类型</strong></th>
											<th class="text-center"><strong>费用</strong></th>
											<th class="text-center"><strong>用途</strong></th>
										</tr>
									</thead>
									<tbody>
										<tr id="travel-1">
											<td class="text-center">房费</td>
											<td class="text-center">￥<span id="price-1">3000</span></td>
											<td class="text-center">三间房屋十天费用</td>
										</tr> 
									</tbody>
								</table>
							</div>
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
