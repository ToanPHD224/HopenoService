<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:url value="/resources" var="cssroot" />
<c:url var="firstUrl" value="/admin/feedback/getall?date=${currentdate}&pageNumber=1" />
<c:url var="lastUrl" value="/admin/feedback/getall?date=${currentdate}&pageNumber=${totalPages}" />
<c:url var="prevUrl" value="/admin/feedback/getall?date=${currentdate}&pageNumber=${currentPageNumber - 1}" />
<c:url var="nextUrl" value="/admin/feedback/getall?date=${currentdate}&pageNumber=${currentPageNumber + 1}" /> 
<div class="row">
   <div class="col-sm-12">
    <div class="card card-primary card-outline mt-3">
        <div class="card-header">
          <h3 class="card-title">Feedback</h3>

          <div class="card-tools">
            <div class="input-group input-group-sm">
              <input type="date" id="date" class="form-control" placeholder="Search Message">
            </div>
          </div>
          <!-- /.card-tools -->
        </div>
        <!-- /.card-header -->
        <div class="card-body p-0">
          <div class="mailbox-controls">
            <!-- Check all button -->
            <button type="button" class="btn btn-default btn-sm checkbox-toggle"><i class="far fa-square"></i>
            </button>
            <div class="btn-group">
              <button type="button" class="btn btn-default btn-sm"><i class="far fa-trash-alt"></i></button>
              <button type="button" class="btn btn-default btn-sm"><i class="fas fa-reply"></i></button>
              <button type="button" class="btn btn-default btn-sm"><i class="fas fa-share"></i></button>
            </div>
            <!-- /.btn-group -->
            <button type="button" class="btn btn-default btn-sm"><i class="fas fa-sync-alt"></i></button>
            <div class="float-right">
              <nav aria-label="Page navigation example ">
                <ul class="pagination justify-content-sm-center" id="pagination" >
                  <c:choose>
                          <c:when test="${currentPageNumber == 1}">
                              <li class="disabled page-item"><a class="page-link" href="#">&lt;&lt;</a></li>
                              <li class="disabled page-item"><a class="page-link" href="#">&lt;</a></li>
                          </c:when>
                          <c:otherwise>
                              <li class="page-item"><a class="page-link" href="${firstUrl}">&lt;&lt;</a></li>
                              <li class="page-item"><a class="page-link" href="${prevUrl}">&lt;</a></li>
                          </c:otherwise>
                      </c:choose>
                      <c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
                          <c:url var="pageUrl" value="/admin/feedback/getall?date=${currentdate}&pageNumber=${i}" />
                          <c:choose>
                              <c:when test="${i == currentPageNumber}">
                                  <li class="page-item active"><a class="page-link" href="${pageUrl}"><c:out value="${i}" /></a></li>
                              </c:when>
                              <c:otherwise>
                                  <li class="page-item"><a class="page-link" href="${pageUrl}"><c:out value="${i}" /></a></li>
                              </c:otherwise>
                          </c:choose>
                      </c:forEach>
                      <c:choose>
                          <c:when test="${currentPageNumber == totalPages}">
                              <li class="disabled page-item"><a class="page-link" href="#">&gt;</a></li>
                              <li class="disabled page-item"><a class="page-link" href="#">&gt;&gt;</a></li>
                          </c:when>
                          <c:otherwise>
                              <li class="page-item"><a class="page-link" href="${nextUrl}">&gt;</a></li>
                              <li class="page-item"><a class="page-link" href="${lastUrl}">&gt;&gt;</a></li>
                          </c:otherwise>
                      </c:choose>
      
                </ul>
              </nav>
              <!-- /.btn-group -->
            </div>
            <!-- /.float-right -->
          </div>
          <div class="table-responsive mailbox-messages">
            <table class="table table-hover table-striped">
              <thead>
                <th></th>
                <th>Email</th>
                <th>Content</th>
                <th>Rating</th>
                <th>Service</th>
               
              </thead>
              <tbody>
             <c:forEach  var="x" items="${listFeedBack}">
              <tr>
                <td>
                  <div class="icheck-primary">
                    <input type="checkbox" value="abc" id="check1">
                    <label for="check1"></label>
                  </div>
                </td>
                <td style="width: 10%"><a href="/admin/users/getall?mail=${x.account.mail}">${x.account.mail}</a></td>
                <td class="mailbox-subject"> <a href="/admin/feedback/detail?id=${x.id}">${x.detailsfeedback.content}</a>
                </td>
                <td class="mailbox-attachment">${x.rating} <i class="fas fa-star" style="color: yellow;"></i></td>
                <td class="mailbox-date"><a href="/admin/service/viewdetail/${x.service.id}">${x.service.name}</a> </td>
              </tr>
             
             
             </c:forEach>

              </tbody>
            </table>
            <!-- /.table -->
          </div>
          <!-- /.mail-box-messages -->
        </div>
        <!-- /.card-body -->
        <div class="card-footer p-0">
          <div class="mailbox-controls">
            <!-- Check all button -->
            <button type="button" class="btn btn-default btn-sm checkbox-toggle"><i class="far fa-square"></i>
            </button>
            <div class="btn-group">
              <button type="button" class="btn btn-default btn-sm"><i class="far fa-trash-alt"></i></button>
              <button type="button" class="btn btn-default btn-sm"><i class="fas fa-reply"></i></button>
              <button type="button" class="btn btn-default btn-sm"><i class="fas fa-share"></i></button>
            </div>
            <!-- /.btn-group -->
            <button type="button" class="btn btn-default btn-sm"><i class="fas fa-sync-alt"></i></button>
            <div class="float-right">
            <nav aria-label="Page navigation example ">
					<ul class="pagination justify-content-sm-center" id="pagination" >
						<c:choose>
				            <c:when test="${currentPageNumber == 1}">
				                <li class="disabled page-item"><a class="page-link" href="#">&lt;&lt;</a></li>
				                <li class="disabled page-item"><a class="page-link" href="#">&lt;</a></li>
				            </c:when>
				            <c:otherwise>
				                <li class="page-item"><a class="page-link" href="${firstUrl}">&lt;&lt;</a></li>
				                <li class="page-item"><a class="page-link" href="${prevUrl}">&lt;</a></li>
				            </c:otherwise>
				        </c:choose>
				        <c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
				            <c:url var="pageUrl" value="/admin/feedback/getall?date=${currentdate}&pageNumber=${i}" />
				            <c:choose>
				                <c:when test="${i == currentPageNumber}">
				                    <li class="page-item active"><a class="page-link" href="${pageUrl}"><c:out value="${i}" /></a></li>
				                </c:when>
				                <c:otherwise>
				                    <li class="page-item"><a class="page-link" href="${pageUrl}"><c:out value="${i}" /></a></li>
				                </c:otherwise>
				            </c:choose>
				        </c:forEach>
				        <c:choose>
				            <c:when test="${currentPageNumber == totalPages}">
				                <li class="disabled page-item"><a class="page-link" href="#">&gt;</a></li>
				                <li class="disabled page-item"><a class="page-link" href="#">&gt;&gt;</a></li>
				            </c:when>
				            <c:otherwise>
				                <li class="page-item"><a class="page-link" href="${nextUrl}">&gt;</a></li>
				                <li class="page-item"><a class="page-link" href="${lastUrl}">&gt;&gt;</a></li>
				            </c:otherwise>
				        </c:choose>

					</ul>
				</nav>
              <!-- /.btn-group -->
            </div>
            <!-- /.float-right -->
          </div>
        </div>
      </div>
   </div>
</div>
<script>
  
    $("#date").change(function () {
      var xDate = $("#date").val();
      var url = "http://localhost:8090/admin/feedback/getall?date=" + xDate + "&pageNumber=1";
      window.location.href = url;

    });
	

    $(function () {
      //Enable check and uncheck all functionality
      $('.checkbox-toggle').click(function () {
        var clicks = $(this).data('clicks')
        if (clicks) {
          //Uncheck all checkboxes
          $('.mailbox-messages input[type=\'checkbox\']').prop('checked', false)
          $('.checkbox-toggle .far.fa-check-square').removeClass('fa-check-square').addClass('fa-square')
        } else {
          //Check all checkboxes
          $('.mailbox-messages input[type=\'checkbox\']').prop('checked', true)
          $('.checkbox-toggle .far.fa-square').removeClass('fa-square').addClass('fa-check-square')
        }
        $(this).data('clicks', !clicks)
      })
    })  
      //Handle starring for glyphicon and font awesome
     
  </script>