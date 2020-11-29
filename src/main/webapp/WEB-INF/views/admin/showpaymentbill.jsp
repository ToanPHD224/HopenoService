<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<c:url value="/resources" var="cssroot" />
<div class="row">
    <div class="col-sm-12">
        <div class="card mt-3">
            <div class="card-header">
                <h3 class="card-title">Thanh Toán</h3>
            </div>
            <!-- /.card-header -->
            <div class="card-body">
               
                <div id="example2_wrapper" class="dataTables_wrapper dt-bootstrap4">
                    <div class="row">
                        
                        <div class="col-sm-12 col-md-8">
                         <div class="row"> <a href="/admin/service/payment/sendpayment" class="btn"><i class="fas fa-bell"></i> Gửi hóa đơn </a> </div>
                          <div class="row">
                     		<div class="col-sm-12">
                     			<p class="ml-3"> ${message} </p>
                     		</div>
                     	</div>
                          </div>
                          
                        
                     	<div class="col-sm-12 col-md-4">
                     	
                     		 <div class="card-tools ">
                                <div class="input-group input-group-sm">
									  <select class="form-control" id="month" name="month">
									    <option value="1">1</option>
									    <option value="2">2</option>
									    <option value="3">3</option>
									    <option value="4">4</option>
									    <option value="5">5</option>
									    <option value="6">6</option>
									    <option value="7">7</option>
									    <option value="8">8</option>
									    <option value="9">9</option>
									    <option value="10">10</option>
									    <option value="11">11</option>
									    <option value="12">12</option>
									  </select>
                                  <div class="input-group-append">
                                    <button type="submit" class="btn btn-primary" id="send">
                                      <i class="fas fa-search"></i>
                                    </button>
                                  </div>
                                </div>
                              </div>
                     	</div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12">
                            <table id="example2" class="table table-bordered table-hover dataTable dtr-inline"
                                role="grid" aria-describedby="example2_info">
                                <thead>
                                    <tr role="row">
                                        <th class="sorting_asc" tabindex="0" aria-controls="example2" rowspan="1"
                                            colspan="1"
                                            aria-label="Rendering engine: activate to sort column descending"
                                            aria-sort="ascending">Tên Dịch Vụ</th>
                                        <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                                            colspan="1" aria-label="Browser: activate to sort column ascending">Tên dịch vụ
                                        </th>
                                        <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                                            colspan="1" aria-label="Platform(s): activate to sort column ascending">
                                            Tổng lượt đặt</th>
                                        <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                                            colspan="1" aria-label="Engine version: activate to sort column ascending">
                                            Tổng tiền nhận</th>
                                        <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                                            colspan="1" aria-label="CSS grade: activate to sort column ascending">
                                            Tổng tiền phải trả</th>
                                        <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                                            colspan="1" aria-label="CSS grade: activate to sort column ascending">
                                            Ngày gửi</th>
                                            <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                                            colspan="1" aria-label="CSS grade: activate to sort column ascending">
                                            Tình Trạng</th>
                                            <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                	<c:forEach var="x"  items="${listPayment}">
                                    <tr role="row" class="odd">
                                        <td tabindex="0" class="sorting_1"><a href="/admin/service/viewdetail/${x.service.id}">${x.service.name} </a> </td>
                                        <td>${x.service.servicefee.name}</td>
                                        <td>${x.totalBook}</td>
                                        <td>${x.totalPay}</td>
                                        <td>${x.totalFee}</td>
                                        <td>${x.paymentDate}</td>
                                        <td>
                                        <c:choose>
                                        	<c:when test="${x.status == true}">
                                        	Đã Thanh Toán
                                        	</c:when>
                                        	
                                        	<c:when test="${x.status == false}">
                                        	Chưa Thanh toán
                                        		
                                        	</c:when>
                                        </c:choose>
                                        	
                                        
                                        
                                        </td>
                                        <td>
                                            <button class="btn"><i class="fas fa-bell"></i></button>
                                        </td>
                                    </tr>
                                  </c:forEach> 
                                </tbody>
                                <tfoot>
                                    <tr>
                                        <th rowspan="1" colspan="1">Tên Dịch Vụ</th>
                                        <th rowspan="1" colspan="1">Tên dịch vụ</th>
                                        <th rowspan="1" colspan="1">Tổng lượt đặt</th>
                                        <th rowspan="1" colspan="1">Tổng tiền nhận</th>
                                        <th rowspan="1" colspan="1">Tổng tiền phải trả</th>
                                        <th rowspan="1" colspan="1">Ngày gửi</th>
                                        <th rowspan="1" colspan="1">Tình Trạng</th>
                                        <th rowspan="1" colspan="1"></th>
                                    </tr>
                                </tfoot>
                            </table>
                        </div>
                    </div>
                  
                </div>
            </div>
            <!-- /.card-body -->
        </div>
    </div>
</div>
<script>
    $(function () {
        $("#example1").DataTable({
            "responsive": true,
            "autoWidth": false,
        });
        $('#example2').DataTable({
            "paging": true,
            "lengthChange": false,
            "searching": false,
            "ordering": true,
            "info": true,
            "autoWidth": false,
            "responsive": true,
        });
    });
    $("#send").click(function () {
		var xDate = $("#month").val();
		var url= "http://localhost:8090/admin/service/payment/getbill?month="+xDate;
		window.location.href = url;

	

	});
</script>