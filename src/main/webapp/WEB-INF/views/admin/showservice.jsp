
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<c:url value="/resources" var="cssroot" />

<div class="row">
    <div class="col-sm-12">
        <div class="card mt-3">
            <div class="card-header">
                <h3 class="card-title">Dịch vụ</h3>
            </div>
            <!-- /.card-header -->
            <div class="card-body">
               
                <div id="example2_wrapper" class="dataTables_wrapper dt-bootstrap4">
                    <div class="row">
                        
                        <div class="col-sm-12 col-md-8"></div>
                        <div class="col-sm-12 col-md-4">  
                        <form action="/admin/service/getall" method="GET">
                            <div class="card-tools">
                                <div class="input-group input-group-sm">
                                  <input type="text"  class="form-control" name="id" placeholder="Search Service">
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
                                            aria-sort="ascending"> Mã Dịch Vụ</th>
                                      
                                        <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                                            colspan="1" aria-label="CSS grade: activate to sort column ascending">
                                            Tên Dịch Vụ</th>
                                         <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                                            colspan="1" aria-label="CSS grade: activate to sort column ascending">
                                            Tình Trạng</th>
                                         
                                            <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                              <c:forEach var="x" items="${listService}">
                                    <tr role="row" class="odd">
                                        <td tabindex="0" class="sorting_1"><c:out value="${x.id}"/></td>
                                     
                                        <td><c:out value="${x.name}"/></td>
                                         <td>
                                         <c:choose>
                                         	<c:when test="${x.status == 1}">
                                         		
                                         		Tạm Dừng
                                         	
                                         	</c:when>
                                         	<c:when test="${x.status == 2 }">
                                         	
                                         		Hoạt Động
                                         	</c:when>
                                         	
                                         
                                         
                                         </c:choose>
                                         </td>
                                   
                                        <td>
                                        <%--   <c:choose>
                                          	<c:when test="${x.banned == false }">
                                          	  <a  href="/admin/service/action/${x.id}" class="btn"><i class="fas fa-ban"></i> Disable </a>
                                          	</c:when>
                                          	<c:when test="${x.banned == true }">
                                          	 <a href="/admin/service/action/${x.id}" class="btn"> <i class="fas fa-toggle-on"></i> Enable </a>
                                          	</c:when>
                                          </c:choose> --%>
                                           <a href="/admin/service/viewdetail/<c:out value="${x.id}"/>" class="btn"><i class="fas fa-info-circle"></i> View Details </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                                <tr role="row">
                                        <th class="sorting_asc" tabindex="0" aria-controls="example2" rowspan="1"
                                            colspan="1"
                                            aria-label="Rendering engine: activate to sort column descending"
                                            aria-sort="ascending">Mã Dịch Vụ</th>
                                     
                                        <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                                            colspan="1" aria-label="CSS grade: activate to sort column ascending">
                                            Tên Dịch Vụ</th>
                                            <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                                            colspan="1" aria-label="CSS grade: activate to sort column ascending">
                                            Tình Trạng</th>
                                            <th></th>
                                    </tr>
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
</script>