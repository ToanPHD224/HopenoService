
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:url value="/resources" var="cssroot" />

<div class="row">
    <div class="col-sm-12">
        <div class="card mt-3">
            <div class="card-header">
                <h3 class="card-title">Service</h3>
            </div>
            <!-- /.card-header -->
            <div class="card-body">
               
                <div id="example2_wrapper" class="dataTables_wrapper dt-bootstrap4">
                    <div class="row">
                        
                        <div class="col-sm-12 col-md-8"></div>
                        <div class="col-sm-12 col-md-4">  
                        <form action="/admin/showservice" method="GET">
                            <div class="card-tools">
                                <div class="input-group input-group-sm">
                                  <input type="text"  class="form-control" name="mail" placeholder="Search Service">
                                  <div class="input-group-append">
                                    <button type="submit" class="btn btn-primary" id="service">
                                      <i class="fas fa-search"></i>
                                    </button>
                                  </div>
                                </div>
                              </div>
                           </form>   
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
                                            colspan="1" aria-label="Browser: activate to sort column ascending">Address
                                        </th>
                                        <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                                            colspan="1" aria-label="Platform(s): activate to sort column ascending">
                                            Districs</th>
                                        <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                                            colspan="1" aria-label="Engine version: activate to sort column ascending">
                                            Account id</th>
                                        <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                                            colspan="1" aria-label="CSS grade: activate to sort column ascending">
                                            Createdat</th>
                                        <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                                            colspan="1" aria-label="CSS grade: activate to sort column ascending">
                                            Image</th>
                                            <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                                            colspan="1" aria-label="CSS grade: activate to sort column ascending">
                                            Banned</th>
                                            <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                              <c:forEach var="x" items="${listService}">
                                    <tr role="row" class="odd">
                                        <td tabindex="0" class="sorting_1">${x.name}</td>
                                        <td>${x.address}</td>
                                        <td>${x.ward.name}</td>
                                        <td>${x.account.name}</td>
                                        <td>${x.createdAt}</td>
                                        <td>
                                        <img alt="" width="20%" src="${cssroot}/image/admin/${x.image}">
                                        </td>
                                        <td>${x.banned}</td>
                                        <td>
                                          <c:choose>
                                          	<c:when test="${x.banned == false }">
                                          	  <a  href="/admin/serviceAction/${x.id}" class="btn"><i class="fas fa-ban"></i> Disable </a>
                                          	</c:when>
                                          	<c:when test="${x.banned == true }">
                                          	 <a href="/admin/serviceAction/${x.id}" class="btn"> <i class="fas fa-toggle-on"></i> Enable </a>
                                          	</c:when>
                                          </c:choose>
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
                                        <th rowspan="1" colspan="1">Month</th>
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
    $("#service").click(function () {
		var service = $("#values").val();
		$.ajax({
			url: "http://localhost:8090/admin/registerform",
			data: {
				name: service
			}

		});

	});
</script>