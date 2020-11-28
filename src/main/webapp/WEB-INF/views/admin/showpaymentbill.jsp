<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:url value="/resources" var="cssroot" />
<div class="row">
    <div class="col-sm-12">
        <div class="card mt-3">
            <div class="card-header">
                <h3 class="card-title">Service Payment</h3>
            </div>
            <!-- /.card-header -->
            <div class="card-body">
               
                <div id="example2_wrapper" class="dataTables_wrapper dt-bootstrap4">
                    <div class="row">
                        
                        <div class="col-sm-12 col-md-8">
                         <div class="row"> <a href="/admin/service/payment/sendpayment" class="btn"><i class="fas fa-bell"></i> SendBill </a> </div>
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
                                            aria-sort="ascending">Service Name</th>
                                        <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                                            colspan="1" aria-label="Browser: activate to sort column ascending">Service Type
                                        </th>
                                        <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                                            colspan="1" aria-label="Platform(s): activate to sort column ascending">
                                            Total Book</th>
                                        <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                                            colspan="1" aria-label="Engine version: activate to sort column ascending">
                                            TotalPay</th>
                                        <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                                            colspan="1" aria-label="CSS grade: activate to sort column ascending">
                                            Total Fee</th>
                                        <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                                            colspan="1" aria-label="CSS grade: activate to sort column ascending">
                                            Payment Send At</th>
                                            <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                                            colspan="1" aria-label="CSS grade: activate to sort column ascending">
                                            Status</th>
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
                                        <td>${x.status}</td>
                                        <td>
                                            <button class="btn"><i class="fas fa-bell"></i></button>
                                        </td>
                                    </tr>
                                  </c:forEach> 
                                </tbody>
                                <tfoot>
                                    <tr>
                                        <th rowspan="1" colspan="1">Service Name</th>
                                        <th rowspan="1" colspan="1">Service Type</th>
                                        <th rowspan="1" colspan="1">Total Book</th>
                                        <th rowspan="1" colspan="1">Toltal Pay</th>
                                        <th rowspan="1" colspan="1">Total Fee</th>
                                        <th rowspan="1" colspan="1">Payment Send At</th>
                                        <th rowspan="1" colspan="1">Status</th>
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