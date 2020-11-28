<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/resources" var="cssroot" />
<c:url var="firstUrl" value="/admin/users/getall/1" />
<c:url var="lastUrl" value="/admin//users/getall?pageNumber=${totalPages}" />
<c:url var="prevUrl" value="/admin/users/getall?pageNumber=${currentPageNumber - 1}" />
<c:url var="nextUrl" value="/admin/users/getall?pageNumber=${currentPageNumber + 1}" />

<div class="row">
  <div class="card card-solid mt-3 " style="width: 100%">
    
         
         
        <div class="container">
          <div class="row" >
            <div class="col-sm-3">
              <h3 class="ml-3 mt-3">
                Contact
              </h3>
            </div>
            <div class="col-sm-9">
              <div class="card-tools float-right mr-3 mt-3">
                <form action="/admin/users/getall">
                <div class="input-group input-group-sm">
              
                  <input type="text"  class="form-control" name="mail" placeholder="Search By Mail">
                  
                  <div class="input-group-append">
                    <button type="submit" class="btn btn-primary"  id="users">
                      <i class="fas fa-search"></i> 
                   	</button>
                  </div>
                
                </div>
                 </form> 
              </div>
          </div>
          </div>
        </div>
    <div class="card-body pb-0">
      <div class="row">
      <c:if test="${empty listUser }">
     
      	
      		<div class="row">

						<div class="col-sm-12">

							<div>

								<p class="card-title "> Not Founded ! </p>

							</div>

						</div>

					</div>
      
      
      </c:if>
      <c:if test="${not empty listUser }">
    	<c:forEach var="x" items="${listUser}">
        <div class="col-md-<c:choose><c:when test="${size >= 3}">4</c:when><c:when test="${size == 2}">6</c:when><c:otherwise>12</c:otherwise></c:choose>"> 
          <div class="card bg-light">
            <div class="card-header text-muted border-bottom-0">
           			<c:choose>
           			
           			<c:when test="${x.role.id ==1 }">
           					
           				Admin
           			</c:when>
				    <c:when test="${x.role.id ==2 }">
           				
           				User
           			</c:when> 
           			<c:otherwise>
           			
           				Customer
           			
           			</c:otherwise>          			
           			</c:choose>
            </div>
            <div class="card-body pt-0">
              <div class="row">
                <div class="col-7">
                  <h2 class="lead"><b>Name : ${x.name}</b></h2>
                  <p class="text-muted text-sm"><b>Email: </b> <p> ${x.mail} </p>
                  <ul class="ml-4 mb-0 fa-ul text-muted">
                    <li class="small"><span class="fa-li"><i class="fas fa-lg fa-building"></i></span> Address: ${x.address} </li>
                    <li class="small"><span class="fa-li"><i class="fas fa-lg fa-phone"></i></span> Phone #: ${x.phone}</li>
                    <li class="small"><span class="fa-li"><i class="fas fa-battery-full"></i></span> Status #: ${x.status}</li>
                    <li class="small"><span class="fa-li"><i class="fas fa-user-slash"></i></span> Banned #: ${x.banned}</li>
                  </ul>
                </div>
                <div class="col-5 text-center">
                  <img src="${cssroot}/image/admin/${x.image}" alt="" class="img-circle img-fluid">
                </div>
              </div>
            </div>
            <div class="card-footer">
              <div class="text-right">
                 
                <c:choose>
                	<c:when test="${x.banned == false }">
                		<a href="/admin/users/action/${x.id}" class="btn  btn-sm btn-danger">
                		  <i class="fas fa-power-off"></i> Disable
                		</a>
                	
                	</c:when>
                	<c:when test="${x.banned == true }">
                		<a href="/admin/users/action/${x.id}" class="btn  btn-sm btn-success">
                		 <i class="fas fa-toggle-on"></i> Enable
                		</a>
                	
                	</c:when>
                </c:choose>
                  <a href="#" class="btn  btn-sm btn-success">
                  <i class="fas fa-info-circle"></i> View Detail
                </a>
              </div>
            </div>
          </div>
        </div>
	</c:forEach>
	</c:if>

      </div>
     
    </div>
    <!-- /.card-body -->
    <div class="card-footer">
      <nav aria-label="Contacts Page Navigation">
      <c:if test="${not empty listUser }">
       <ul class="pagination justify-content-sm-center" id="pagination">
						<c:choose>
							<c:when test="${currentPageNumber == 1}">
								<li class="disabled page-item"><a class="page-link"
									href="#">&lt;&lt;</a></li>
								<li class="disabled page-item"><a class="page-link"
									href="#">&lt;</a></li>
							</c:when>
							<c:otherwise>
								<li class="page-item"><a class="page-link"
									href="${firstUrl}">&lt;&lt;</a></li>
								<li class="page-item"><a class="page-link"
									href="${prevUrl}">&lt;</a></li>
							</c:otherwise>
						</c:choose>
						<c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
							<c:url var="pageUrl" value="/admin/users/getall?pageNumber=${i}" />
							<c:choose>
								<c:when test="${i == currentPageNumber}">
									<li class="page-item active"><a class="page-link"
										href="${pageUrl}"><c:out value="${i}" /></a></li>
								</c:when>
								<c:otherwise>
									<li class="page-item"><a class="page-link"
										href="${pageUrl}"><c:out value="${i}" /></a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:choose>
							<c:when test="${currentPageNumber == totalPages}">
								<li class="disabled page-item"><a class="page-link"
									href="#">&gt;</a></li>
								<li class="disabled page-item"><a class="page-link"
									href="#">&gt;&gt;</a></li>
							</c:when>
							<c:otherwise>
								<li class="page-item"><a class="page-link"
									href="${nextUrl}">&gt;</a></li>
								<li class="page-item"><a class="page-link"
									href="${lastUrl}">&gt;&gt;</a></li>
							</c:otherwise>
						</c:choose>

					</ul>
					</c:if>
      </nav>
    </div>
    <!-- /.card-footer -->
  </div>
</div>
<script>
    $("#users").click(function () {
		var users = $("#values").val();
		$.ajax({
			url: "http://localhost:8090/admin/registerform",
			data: {
				users: users
			}

		});

	});
</script>